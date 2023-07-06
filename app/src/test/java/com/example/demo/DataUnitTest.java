package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;



public class DataUnitTest {

    /**
     * test for saveData
     */
    @Test
    public void testAddData() {
        Date date = Calendar.getInstance().getTime();

        DataTest dataList = new DataTest();
        DataClass data1 = new DataClass("150","80","70","1:00","12/12/2000","High");
        dataList.saveData(data1);
        assertEquals(1, dataList.getData().size());

        DataClass data2 = new DataClass("160","80","70","1:00","12/12/2000","High");
        dataList.saveData(data2);
        assertEquals(2, dataList.getData().size());

        assertTrue(dataList.getData().contains(data1));
        assertTrue(dataList.getData().contains(data2));
    }

    /**
     * test for deleteData
     */
    @Test
    public void testDeleteData() {
        Date date = Calendar.getInstance().getTime();

        DataTest dataList = new DataTest();
        DataClass data1 = new DataClass("150","80","70","1:00","12/12/2000","High");
        dataList.saveData(data1);
        assertEquals(1, dataList.getData().size());

        DataClass data2 = new DataClass("120","80","65","10:00","2/2/2222","Normal");
        dataList.saveData(data2);
        assertEquals(2, dataList.getData().size());

        assertTrue(dataList.getData().contains(data1));
        assertTrue(dataList.getData().contains(data2));

        dataList.deleteData(data1);
        assertEquals(1, dataList.getData().size());
        assertFalse(dataList.getData().contains(data1));

        dataList.deleteData(data2);
        assertEquals(0, dataList.getData().size());
        assertFalse(dataList.getData().contains(data2));
    }

    /**
     * test for saveData exceptions
     */
    @Test
    public void testAddRecordException() {
        Date date = Calendar.getInstance().getTime();

        DataTest dataList = new DataTest();
        DataClass data1 = new DataClass("120","80","75","12:00","12/12/2023","Normal");
        dataList.saveData(data1);

        assertThrows(IllegalArgumentException.class, () -> dataList.saveData(data1));
    }

    /**
     * test for deleteData exceptions
     */
    @Test
    public void testDeleteRecordException() {
        Date date = Calendar.getInstance().getTime();

        DataTest dataList = new DataTest();
        DataClass data1 = new DataClass("120","90","80","2:00","02/02/2020","Low");
        dataList.saveData(data1);

        dataList.deleteData(data1);

        assertThrows(IllegalArgumentException.class, () -> dataList.deleteData(data1));
    }
}