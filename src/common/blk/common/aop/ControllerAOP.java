package blk.common.aop;

import blk.common.bean.PageResultBean;
import blk.common.bean.ResultBean;
import blk.common.util.Constants;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理和包装异常
 * @author Mark
 * @date 2018/1/17
 */
public class ControllerAOP {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAOP.class);

    public Object handlerControllerResultMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();

        ResultBean result;

        try {
            result = (ResultBean) pjp.proceed();
            Object[] args = pjp.getArgs();

            logger.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            result = new ResultBean();
            // 已知异常
            // 校验出错，参数非法
            if (e instanceof ConstraintViolationException) {
                List<Map<String, String>> list = handleConstraintViolationException((ConstraintViolationException) e);
                result.setResultType(false);
                result.setData(Constants.EMPTY_MAP);
                result.setError(list);
                result.setTimeStamp(System.currentTimeMillis());
            }else if (e instanceof DataAccessException) {
                result.setResultType(false);
                result.setData(Constants.EMPTY_MAP);
                result.setError("数据库操作异常");
                result.setTimeStamp(System.currentTimeMillis());
                logger.warn(pjp.getSignature() + " 数据库操作异常 ", e);
            } else {
                logger.error(pjp.getSignature() + " error ", e);
                // TODO 未知的异常，应该格外注意，可以发送邮件通知等
            }

        }
        return result;
    }

    public Object handlerControllerPageResultMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();

        PageResultBean pageResult;

        try {
            pageResult = (PageResultBean) pjp.proceed();
            Object[] args = pjp.getArgs();

            logger.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            pageResult = new PageResultBean();
            // 已知异常
            // 校验出错，参数非法
            if (e instanceof ConstraintViolationException) {
                List<Map<String, String>> list = handleConstraintViolationException((ConstraintViolationException) e);
                pageResult.setResultType(false);
                pageResult.setData(Constants.EMPTY_MAP);
                pageResult.setError(list);
                pageResult.setTimeStamp(System.currentTimeMillis());
            } else if (e instanceof DataAccessException) {
                pageResult.setResultType(false);
                pageResult.setData(Constants.EMPTY_MAP);
                pageResult.setError("数据库操作异常");
                pageResult.setTimeStamp(System.currentTimeMillis());
                logger.warn(pjp.getSignature() + " 数据库操作异常 ", e);
            } else {
                logger.error(pjp.getSignature() + " error ", e);
                // TODO 未知的异常，应该格外注意，可以发送邮件通知等
            }
        }
        return pageResult;
    }

    private List<Map<String, String>> handleConstraintViolationException(ConstraintViolationException e) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            logger.warn(constraintViolation.getLeafBean().getClass().getName() + "-" +
                    constraintViolation.getPropertyPath().toString() + "-" + constraintViolation.getMessage()
                    + ", 实际输入为" + constraintViolation.getInvalidValue());
            String errorCode = StringUtils.substringBetween(constraintViolation.getMessageTemplate(),
                    "{", "}");
            String errorMsg = constraintViolation.getMessage();

            Map<String, String> map = new HashMap<String, String>();
            map.put("errorCode", errorCode);
            map.put("errorMsg", errorMsg);
            list.add(map);
        }
        return list;
    }
}
