package com.ruoyi.collection.service.impl;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String str = "历下区分公司(201)";
        System.out.println(str.substring(str.indexOf("(")+1,str.indexOf(")")));
    }
}
