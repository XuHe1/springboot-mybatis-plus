package top.lovezhangli.mbp.vo;

/**
 * @author zhangtao
 * @date 2018/4/17
 */
public enum ResponseCode {
    SUCCESS(1,"成功"),
    BAD_PARAM(9,"非法参数"),
    FAILED(10,"失败"),
    UNKNOWN_ERROR(500, "系统错误");
    private final  Integer code;
    private final String msg;
    /**
     * 根据返回码获取枚举信息
     *
     * @param code
     * @return
     */
    public static ResponseCode getRespCode(Integer code) {
        for (ResponseCode responseCode : ResponseCode.values()) {
            if (responseCode.getCode().equals(code)) {
                return responseCode;
            }
        }
        return null;
    }
    ResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}