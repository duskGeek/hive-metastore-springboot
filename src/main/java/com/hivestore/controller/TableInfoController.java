package com.hivestore.controller;


import com.alibaba.fastjson.JSONObject;
import com.hivestore.module.dis.Databases;
import com.hivestore.module.dis.Result;
import com.hivestore.module.dis.TableInfo;
import com.hivestore.service.TableInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TableInfoController {
    private final static Logger logger = LoggerFactory.getLogger(TableInfoController.class);

    @Autowired
    TableInfoService tableInfoService;

    @GetMapping("/tableInfo/query")
    public String query(String dbId) {
        Result rs;
        try {
            List<TableInfo> tableList=tableInfoService.listTables(dbId);
            rs=new Result("200","10","查询成功",tableList);
        } catch (Exception e){
            e.printStackTrace();
            rs=new Result("500","20","查询异常",null);
        }
        //接收数据库id  查询数据库信息及数据库下的所有表集合  List<tableInfo>
        return JSONObject.toJSONString(rs);
    }

    @GetMapping("/tableInfo/queryTableColumn")
    public String queryTableColumn(String dbId,String tableId) {
        Result rs;
        try {
            List<TableInfo> tableList=new ArrayList<TableInfo>();
            TableInfo tableInfo=tableInfoService.queryColsByTableName(dbId,tableId);
            tableList.add(tableInfo);
            rs=new Result("200","10","查询成功",tableList);
        } catch (Exception e){
            e.printStackTrace();
            rs=new Result("500","20","查询异常",null);
        }
        //通过dbid、tableId查询查询列集合 List<ColumnInfo>
        return JSONObject.toJSONString(rs);
    }
}
