package com.hivestore.inter;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.HiveMetaStoreClient;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.springframework.stereotype.Component;

@Component
public class MyHiveMetaStoreClient extends HiveMetaStoreClient {
    public MyHiveMetaStoreClient() throws MetaException {
        super(new HiveConf());
    }
}
