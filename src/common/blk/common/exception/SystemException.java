package blk.common.exception;

/**
 * 系统异常
 * @author Mark
 * @date 2018/1/24
 */
public class SystemException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public SystemException() {
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemException(Throwable cause) {
        super(cause);
    }
}
