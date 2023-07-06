package com.example.demo;

public class DataClass {
    private String dataDia;
    private String dataSys;
    private String dataHrt;
    private String dataTime;
    private String dataDate;
    private String dataCom;



    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private String key;

    public String getDataDia() {
        return dataDia;
    }

    /**
     * this returns systolic value
     * @return data
     */
    public String getDataSys() {
        return dataSys;
    }

    /**
     * this returns heartrate value
     * @return data
     */
    public String getDataHrt() {
        return dataHrt;
    }

    /**
     * this returns time value
     * @return data
     */
    public String getDataTime() {
        return dataTime;
    }

    /**
     * this returns date value
     * @return date
     */
    public String getDataDate() {
        return dataDate;
    }

    /**
     * this returns comment data
     * @return data
     */
    public String getDataCom() {
        return dataCom;
    }

    public DataClass(String dataDia, String dataSys, String dataHrt, String dataTime, String dataDate, String dataCom) {
        this.dataDia = dataDia;
        this.dataSys = dataSys;
        this.dataHrt = dataHrt;
        this.dataTime = dataTime;
        this.dataDate = dataDate;
        this.dataCom = dataCom;
    }
    public DataClass(){

    }
}

