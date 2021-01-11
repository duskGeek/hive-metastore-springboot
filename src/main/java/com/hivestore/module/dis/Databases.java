package com.hivestore.module.dis;

import java.util.List;

public class Databases {
    String dbId;
    String dbName;
    String location;
    List<TableInfo> tables;

    public Databases(String dbId, String dbName,  String location, List<TableInfo> tables) {
        this.dbId = dbId;
        this.dbName = dbName;
        this.location = location;
        this.tables = tables;
    }

    public String getDbId() {
        return dbId;
    }

    public void setDbId(String dbId) {
        this.dbId = dbId;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public List<TableInfo> getTables() {
        return tables;
    }

    public void setTables(List<TableInfo> tables) {
        this.tables = tables;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
