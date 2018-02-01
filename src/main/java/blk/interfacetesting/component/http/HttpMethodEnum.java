package blk.interfacetesting.component.http;

/**
 * @author Mark
 * @date 7/18/2017 3:34 PM
 */
public enum HttpMethodEnum {
    GET("GET"), POST("POST"), PUT("PUT"), DELETE("DELETE");

    private String methodType;

    HttpMethodEnum(String methodType) {
        this.methodType = methodType;
    }

    public String getMethodType() {
        return methodType;
    }

    public static HttpMethodEnum fromMethodType(String method) {
        for (HttpMethodEnum methodEnum: HttpMethodEnum.values()) {
            if (methodEnum.getMethodType().equalsIgnoreCase(method)) {
                return methodEnum;
            }
        }
        return null;
    }
}
