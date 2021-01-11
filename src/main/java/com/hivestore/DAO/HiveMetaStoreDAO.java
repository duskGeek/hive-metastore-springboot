package com.hivestore.DAO;

import com.hivestore.inter.MyHiveMetaStoreClient;
import org.apache.hadoop.hive.metastore.HiveMetaStoreClient;
import org.apache.hadoop.hive.metastore.api.*;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HiveMetaStoreDAO {

    @Autowired
    MyHiveMetaStoreClient client;

    public List<Database> getDataBases() throws TException {
        List<Database> resultList=new ArrayList<Database>();
        List<String> list=client.getAllDatabases();
        for (String database:list) {
            resultList.add(client.getDatabase(database));
        }
        return resultList;
    }

    public void createDataBases(String databasesName) throws TException {
        Database db=new Database();
        db.setName(databasesName);
        client.createDatabase(db);
    }

    public void dropDatabases() throws TException {
        client.dropDatabase("geek");
    }

    public List<Table> listTables(String dbName) throws TException {
        List<Table> resultList=new ArrayList<Table>();
        for (String tableName:client.getTables(dbName,"*")) {
            resultList.add(client.getTable(dbName,tableName));
        }
        return resultList;
    }

    public Map<String,Object> queryColsByTableName(String dbName,String tableName) throws TException {
        Map<String,Object> result=new HashMap<String,Object>();
        Table table=client.getTable(dbName,tableName);
        result.put("table",table);
        StorageDescriptor sd=(StorageDescriptor)table.getFieldValue(Table._Fields.SD);
        result.put("cols",sd.getCols());
        return result;
    }
}
