package com.hale.response;

public class CommonReturnType {
    private String status;
    private Object data;

    public String getStatus() {
        return status;
    }


    public static CommonReturnType create(Object result){
        return CommonReturnType.create(result,"success");
    }

    public static CommonReturnType create(Object result, String success) {
        CommonReturnType type=new CommonReturnType();
        type.setStatus(success);
        type.setData(result);
        return type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
