package org.example;


import RedisExamples.FirstExample;
import redis.clients.jedis.Jedis;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        FirstExample firstExample = new FirstExample();

        //Example 1
        String setBasicKeyValueOutput = firstExample.setBasicKeyValue("Sari","Limon");
        System.out.println(setBasicKeyValueOutput);

        //Example 2
        ArrayList<String> fruits = new ArrayList<String>();
        fruits.add("apple"); fruits.add("pineapple"); fruits.add("orange");
        String setValuesAsList = firstExample.setValuesAsList("fruits",fruits);
        System.out.println(setValuesAsList);


        //Example 3
        Map<String,String> fieldValuePairs = new HashMap<>();
        fieldValuePairs.put("name","musa");
        fieldValuePairs.put("surname","kucuk");
        fieldValuePairs.put("age","24");
        fieldValuePairs.put("gender","male");

        Map<String,String> setHashValues  = firstExample.setHashValues("user:123",fieldValuePairs);
        for (Map.Entry<String,String> entry: setHashValues.entrySet()) {
            System.out.printf("Key: %s, Value: %s \n%n",entry.getKey(),entry.getValue());
        }

        //Example 4
        firstExample.setSortedSetValue("participants",1,"Musa");
        String value = firstExample.getSortedSetValues("participants");
        System.out.println(value);

    }
}