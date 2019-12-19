package com.lab5.util;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Counting {
    private String currentString;
    Counting() {}

    ArrayList array = new ArrayList();

    public String count(String string)
    {
        if (string.contains(", "))
        {
            String strArr[] = string.split(", ");
            for (int i = 0; i < strArr.length; i++)
            {
                array.add(Integer.parseInt(strArr[i]));
            }
        }
        else
        {
            array.add(Integer.parseInt(string));
        }

        this.currentString = string;
        String result = getResult();
        array = new ArrayList();
        return result;
    }

    private int countEven()
    {
        int counter = 0;
        for (int i = 0; i < array.size(); i++)
        {
            if ((Integer)array.get(i) % 2 == 0)
            {
                counter++;
            }
        }
        return counter;
    }
    private int countUneven()
    {
        int counter = 0;
        for (int i = 0; i < array.size(); i++)
        {
            if ((Integer)array.get(i) % 2 == 1)
            {
                counter++;
            }
        }
        return counter;
    }

    private String getResult()
    {
        return "Количество чётных - "
                + countEven()
                + "\n"
                + "Количество нечётных - "
                + countUneven();
    }
}
