package com.yuxiang.file.exception;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/24 14:42
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1;
    protected String _errorCode = "9900";
    protected String _moduleCode = "";
    protected String _moduleName = "";
    protected String _subsystem = "";
    protected Throwable _exception;

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String msg, Throwable e) {
        super(msg, e);
    }

    public BizException(String msg) {
        super(msg);
    }

    public BizException(String errorCode, String msg) {
        super(msg);
        _errorCode = errorCode;
    }

    public BizException(String errorCode, String msg, String moduleCode, String subsystem) {
        super(msg);
        _errorCode = errorCode;
        _moduleCode = moduleCode;
        _subsystem = subsystem;
    }

    public BizException(Throwable exception, String msg) {
        super(msg, exception);
        _exception = exception;
    }

    public BizException(Throwable exception, String errorCode, String msg) {
        super(msg, exception);
        _errorCode = errorCode;
        _exception = exception;
    }

    public BizException(Throwable exception, String errorCode, String msg, String moduleCode, String subsystem) {
        super(msg, exception);
        _errorCode = errorCode;
        _exception = exception;
        _moduleCode = moduleCode;
        _subsystem = subsystem;
    }

    public String getErrorCode() {
        return _errorCode;
    }

    public BizException() {
    }

    public Throwable getRootCause() {
        if (_exception instanceof BizException) {
            return ((BizException) _exception).getRootCause();
        }
        return _exception == null ? this : _exception;
    }

    public String get_moduleCode() {
        return _moduleCode;
    }

    public String get_moduleName() {
        return _moduleName;
    }

    public void set_moduleName(String moduleName) {
        _moduleName = moduleName;
    }

    public String get_subsystem() {
        return _subsystem;
    }
}
