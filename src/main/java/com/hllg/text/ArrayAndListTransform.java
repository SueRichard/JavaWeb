package com.hllg.text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/04  Thu  12:24
 */
public class ArrayAndListTransform {
    public static void ArrayToList() {
        String[] array = {"晴天", "雨天", "雪天", "阴天"};
        //该转换方法不支持remove、add方法
        //List<String> list = Arrays.asList(array);
        List<String> list = Stream.of(array).collect(Collectors.toList());
        for (String s : list) {
            System.out.println(s);
        }
        list.remove("晴天");
        System.out.println("------移除后-----");
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void ListToArray() {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");
        //无参toArray方法返回Object类型
        String[] arrays = list.toArray(new String[list.size()]);
        for (String s : arrays) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        System.out.println("---------数组转集合---------");
        ArrayToList();
        System.out.println("---------集合转数组---------");
        ListToArray();
    }
}
