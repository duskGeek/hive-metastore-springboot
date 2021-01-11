package com.hivestore.service;


import com.hivestore.DAO.HiveMetaStoreDAO;
import com.hivestore.module.dis.Databases;
import org.apache.hadoop.hive.metastore.api.Database;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatabasesService {

    @Autowired
    HiveMetaStoreDAO hiveMetaStoreDAO;

    public List<Databases> getDataBases() throws TException {
        List<Database> list=hiveMetaStoreDAO.getDataBases();
        List<Databases> DatabasesList=new ArrayList<Databases>();
        for (Database database:list) {
            Databases db=new Databases("",database.getName(),database.getLocationUri().toString(),
                    null);
            DatabasesList.add(db);
        }
        return DatabasesList;
    }

    public void createDataBases(String databasesName) throws TException {
        hiveMetaStoreDAO.createDataBases(databasesName);
    }

    public void dropDatabases(String dbName) throws TException {
        hiveMetaStoreDAO.dropDatabases();
    }

}
