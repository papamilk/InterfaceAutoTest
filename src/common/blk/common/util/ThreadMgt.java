package blk.common.util;

import blk.common.exception.SystemException;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 主线程控制类
 */
@Component
public class ThreadMgt {
    private static final Logger logger = LoggerFactory.getLogger(ThreadMgt.class);

    /**
     * 初始化Socket连接池为1
     */
    private BlockingQueue<Object> connection = new ArrayBlockingQueue(NumberUtils.toInt(CommonUtils.getProperties("system.properties", "thread.pool.size")));

    /**
     * 将执行命令放入连接池
     *
     * @param object
     */
    public void putCommander(Object object){
        try {
            connection.offer(object, NumberUtils.toLong(CommonUtils.getProperties("system.properties", "thread.pool.timeout")), TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new SystemException(e);
        }
        logger.info("当前命令已经成功放入线程池,等待执行完毕");
    }

    /**
     * 获取已经在执行的命令
     *
     * @return 命令名称
     */
    public Object getCommands(){
        Object action = null;
        try {
            action = connection.take();//从线程池中拿出一个命令
        } catch (InterruptedException e) {
            throw new SystemException(e);
        }
        if (action != null) {
            logger.info("最后一条命令已经成功取出");
        } else {
            logger.info("命令池没有存放的命令");
        }
        return action;
    }

    public boolean isEmpty() {
        return connection.isEmpty();
    }

    public void testTimeout(){
        for (int i = 0; i < 10; i++) {
             logger.info(String.valueOf(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void sleep(int millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
