package com.no1worker.common.retrofit.response;

/**
 * 错误Code
 * Created by yuzhiyong on 2019/5/22.
 */

public enum ErrorInfo {

    /**
     * 正常，没有错误
     */
    NORMAL("0", "正常"),
    //app本地异常取值区间为 [1 - 100]
    /**
     * 异常值
     */
    UNKNOWN("1", "未知错误"),
    /**
     * json转RetMsg时发生错误
     */
    JSON_PARSE_ERROR("2", "数据转换失败"),
    /**
     * 网络连接失败
     */
    NETWORK_CONNECT_ERROR("3", "网络不稳定,请检查网络");

    private final String val;
    private final String sval;

    ErrorInfo(String value, String description) {
        val = value;
        sval = description;
    }

    public String getValue() {
        return this.val;
    }

    public String getStrValue() {
        return this.sval;
    }

    public static ErrorInfo getEnumForId(String type) {
        for (ErrorInfo enumType : values()) {
            if (enumType.getValue().equals(type)) {
                return enumType;
            }
        }
        return UNKNOWN;
    }

    public static boolean in(String val, ErrorInfo... infos) {
        for(ErrorInfo info : infos) {
            if(info.getValue().equals(val)) {
                return true;
            }
        }
        return false;

    }
    public static ErrorInfo getEnumForString(String type) {
        for (ErrorInfo enumType : values()) {
            if (enumType.getStrValue().equals(type)) {
                return enumType;
            }
        }
        return UNKNOWN;
    }
}
