package top.lovezhangli.mbp.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 2020/2/28 10:06
 * @author zhangtao
 */
@Data
public class ResponseBean<T> implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1429245478117553692L;
	private boolean success;
    private T data;
    private Integer code;
    private String msg;

    public ResponseBean(){}

    public ResponseBean(boolean success, T data) {
        super();
        this.success = success;
        this.data = data;
    }

    public ResponseBean(boolean success, T data, Integer code, String msg) {
        super();
        this.success = success;
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public ResponseBean(boolean success, Integer code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }
    public ResponseBean(boolean success,ResponseCode enums){
        this.success=success;
        this.code=enums.getCode();
        this.msg=enums.getMsg();
    }
    public ResponseBean(boolean success,T data,ResponseCode enums){
        this.success=success;
        this.data=data;
        this.code=enums.getCode();
        this.msg=enums.getMsg();
    }

}