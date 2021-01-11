package com.hivestore.controller;


import com.alibaba.fastjson.JSONObject;
import com.hivestore.module.dis.Databases;
import com.hivestore.module.dis.Result;
import com.hivestore.service.DatabasesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DatabasesController {
    private final static Logger logger = LoggerFactory.getLogger(DatabasesController.class);

    @Autowired
    DatabasesService databasesService;

    @GetMapping("/databases/list")
    public String list() {
        //返回databases 集合
        Result rs;
        try {
            List<Databases> dbList=databasesService.getDataBases();
            rs=new Result("200","10","查询成功",dbList);
        } catch (Exception e){
            e.printStackTrace();
            rs=new Result("500","20","查询异常",null);
        }
        return JSONObject.toJSONString(rs);
    }

    @GetMapping("/databases/drop")
    public String drop(String databaseId) {
        Result rs;
        try {
           databasesService.dropDatabases(databaseId);
            rs=new Result("200","10","删除成功",null);
        } catch (Exception e){
            e.printStackTrace();
            rs=new Result("500","20","删除异常",null);
        }
        //通过dbid 删除库，返回是否删除成功
        return JSONObject.toJSONString(rs);
    }

    @GetMapping("/databases/create")
    public String create(Databases ds) {
        Result rs;
        try {
            databasesService.createDataBases(ds.getDbName());
            rs=new Result("200","10","创建成功",null);
        } catch (Exception e){
            e.printStackTrace();
            rs=new Result("500","20","创建异常",null);
        }
        //接收name和location创建库 返回插入是否成功
        return JSONObject.toJSONString(rs);
    }


}
