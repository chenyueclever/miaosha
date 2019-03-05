package com.hale.error;

public interface CommonError {
    public int getErrCode();
    String getErrMsg();
    CommonError setErrMsg(String errMsg);
}
