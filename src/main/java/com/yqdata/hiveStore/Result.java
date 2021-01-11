package com.yqdata.hiveStore;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Result<T> {

    public String resultCode;
    public String resultStatus;
    public String resultMsg;

    public List<T> obj;

    public Result(String resultCode, String resultStatus, String resultMsg, List<T> obj) {
        this.resultCode = resultCode;
        this.resultStatus = resultStatus;
        this.resultMsg = resultMsg;
        this.obj = obj;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }


    public List<T> getObj() {
        return obj;
    }

    public void setObj(List<T> obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        User u=new User("1","yq");
        User u2=new User("2","yq2");
        ArrayList<User> users = new ArrayList<>();
        users.add(u);
        users.add(u2);
        Result<User> sucess = new Result<>("200", "sucess","空指针异常", users);
        System.out.println(JSONObject.toJSONString(sucess));

    }
}
