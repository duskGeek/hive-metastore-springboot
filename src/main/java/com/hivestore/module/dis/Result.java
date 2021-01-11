package com.hivestore.module.dis;

import com.alibaba.fastjson.JSONObject;
import com.yqdata.hiveStore.User;

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
        List<ColumnInfo> colList=new ArrayList<ColumnInfo>();
        ColumnInfo col1=new ColumnInfo("1","name","string","1");
        ColumnInfo col2=new ColumnInfo("2","code","string","2");
        colList.add(col1);
        colList.add(col2);

        TableInfo tb1=new TableInfo("emp","1","inner",colList);
        List<TableInfo> tbList=new ArrayList<TableInfo>();

       Databases db=new Databases("1","default","hdfs://",tbList);
        List<Databases> dbList=new ArrayList<Databases>();

        Result<Databases> sucess = new Result<Databases>("200", "sucess","空指针异常", dbList);
        System.out.println(JSONObject.toJSONString(sucess));

    }
}
