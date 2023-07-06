package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//import userDefinedClass.DataTest;


public class DataTest {
    public List<DataClass> list = new ArrayList<>();

    /**
     * this method is used to insert data
     * @param data
     */
    public void saveData(DataClass data)
    {
        if(list.contains(data))
        {
            throw new IllegalArgumentException();
        }
        list.add(data);
    }

    /**
     * this method is used to show list
     * @return a list of data
     */

    public List<DataClass> getData()
    {
        List<DataClass>dataList = list;
        return dataList;
    }

    public List<DataClass> getData(int x)
    {
        List<DataClass> dataList = list;
        return dataList;
    }

    /**
     * this method is used for deleting any existing data
     * @param data
     */
    public void deleteData(DataClass data)
    {
        List<DataClass> dataList = list;
        if(dataList.contains(data)){
            list.remove(data);
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    /**
     * this method is used to count the size of list
     * @return int
     */
    public int countData()
    {
        return list.size();
    }
}

