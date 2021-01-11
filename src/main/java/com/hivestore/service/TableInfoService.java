package com.hivestore.service;


import com.hivestore.DAO.HiveMetaStoreDAO;
import com.hivestore.module.dis.ColumnInfo;
import com.hivestore.module.dis.TableInfo;
import org.apache.hadoop.hive.metastore.api.FieldSchema;
import org.apache.hadoop.hive.metastore.api.StorageDescriptor;
import org.apache.hadoop.hive.metastore.api.Table;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TableInfoService {
    @Autowired
    HiveMetaStoreDAO hiveMetaStoreDAO;

    public List<TableInfo> listTables(String dbName) throws TException {
        List<Table> list=hiveMetaStoreDAO.listTables(dbName);
        List<TableInfo> tableInfoList=new ArrayList<TableInfo>();
        for (Table table: list) {
            TableInfo tableInfo = new TableInfo(table.getTableName(),
                    "", table.getTableType(),
                    null);
            tableInfoList.add(tableInfo);
        }
        return tableInfoList;
    }

    public TableInfo queryColsByTableName(String dbName,String tableName) throws TException {
        Map<String,Object> map=hiveMetaStoreDAO.queryColsByTableName(dbName,tableName);
        Table table= (Table) map.get("table");
        List<FieldSchema> colList= (List<FieldSchema>) map.get("cols");
        List<ColumnInfo> colInfoList=new ArrayList<ColumnInfo>();
        int i=1;
        for (FieldSchema fieldSchema: colList) {
            ColumnInfo columnInfo = new ColumnInfo("", fieldSchema.getName(), fieldSchema.getType(), (i++)+"");
            colInfoList.add(columnInfo);
        }
        TableInfo tableInfo = new TableInfo(table.getTableName(),
                "", table.getTableType(),
                colInfoList);
        return tableInfo;
    }


}
