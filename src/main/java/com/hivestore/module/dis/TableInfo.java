package com.hivestore.module.dis;

import java.util.List;

public class TableInfo {
    String tableName;
    String tableId;
    String tableType;
    List<ColumnInfo> colList;

    public TableInfo(String tableName, String tableId, String tableType, List<ColumnInfo> colList) {
        this.tableName = tableName;
        this.tableId = tableId;
        this.tableType = tableType;
        this.colList = colList;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public List<ColumnInfo> getColList() {
        return colList;
    }

    public void setColList(List<ColumnInfo> colList) {
        this.colList = colList;
    }
}
