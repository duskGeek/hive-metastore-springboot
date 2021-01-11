package com.hivestore.module.dis;

public class ColumnInfo {
    String colId;
    String colName;
    String colType;
    String colIndex;

    public ColumnInfo(String colId, String colName, String colType, String colIndex) {
        this.colId = colId;
        this.colName = colName;
        this.colType = colType;
        this.colIndex = colIndex;
    }

    public String getColId() {
        return colId;
    }

    public void setColId(String colId) {
        this.colId = colId;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getColType() {
        return colType;
    }

    public void setColType(String colType) {
        this.colType = colType;
    }

    public String getColIndex() {
        return colIndex;
    }

    public void setColIndex(String colIndex) {
        this.colIndex = colIndex;
    }
}
