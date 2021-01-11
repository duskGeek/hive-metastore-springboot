package com.yqdata.sb;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.HiveMetaStore;
import org.apache.hadoop.hive.metastore.HiveMetaStoreClient;
import org.apache.hadoop.hive.metastore.api.*;
import org.apache.thrift.TException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MetaStoreTest {
    HiveMetaStoreClient client;

    @Before
    public void setUp() throws MetaException {

        HiveConf hiveConf=new HiveConf();
        client=new HiveMetaStoreClient(hiveConf);
    }

    @Test
    public void showDatabases() throws TException {

        List<String> list=client.getAllDatabases();
        for (String database:list) {
            System.out.println("basename:"+database);

            List<String> tables=client.getTables(database,"*");
            for (String table:tables) {
                System.out.println("table:"+table);

                Table t=client.getTable(database,table);
                for (FieldSchema fieldSchema: t.getPartitionKeys()) {
                    System.out.println("PartitionKey:"+fieldSchema.getName());
                };

                StorageDescriptor sd=(StorageDescriptor)t.getFieldValue(Table._Fields.SD);
                System.out.print("fields:");
                for (FieldSchema fieldSchema:sd.getCols()) {
                    System.out.print(fieldSchema.getName()+" ");
                }

                System.out.println("");
            }
        }
    }

    @Test
    public void createDatabases() throws TException {
        Database db=new Database();
        db.setName("geek");
        client.createDatabase(db);

    }

    @Test
    public void dropDatabases() throws TException {
        client.dropDatabase("geek");
    }

}
