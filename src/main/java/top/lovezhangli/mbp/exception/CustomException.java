package top.lovezhangli.mbp.exception;

import top.lovezhangli.mbp.vo.ResponseCode;
import lombok.Data;

/**
 * Desc: CustomException
 * Author: Xu He
 * created: 2021/5/11 15:08
 */
@Data
public class CustomException extends RuntimeException {
    /**
     * 错误编码
     */
    protected Integer errCode;

    /**
     * 错误信息
     */
    protected String errMsg;

    /**
     * 无参构造函数
     */
    public CustomException() {
        super();
    }

    public CustomException(ResponseCode responseCode) {
        this.errCode = responseCode.getCode ();
        this.errMsg = responseCode.getMsg ();
    }

    public CustomException(Throwable e) {
        super(e);
    }

    public CustomException(Integer errorCode) {
        this.errCode = errorCode;
    }

    public CustomException(Integer errorCode, String errMsg) {
        this.errCode = errorCode;
        this.errMsg = errMsg;
    }
}
