package com.java;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        MyHashMap myHashMap = new MyHashMap();
        MyLinkedList myLinkedList = new MyLinkedList();
        MyQueue myQueue = new MyQueue();
        MyStack myStack = new MyStack();

        System.out.println("myArrayList.size() = " + myArrayList.size());
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("521");
        myArrayList.add("sag");
        myArrayList.add("gdss");
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("521");
        myArrayList.add("sag");
        myArrayList.add("gdss");
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("521");
        myArrayList.add("sag");
        myArrayList.add("gdss");
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("521");
        myArrayList.add("sag");
        myArrayList.add("gdss");
        System.out.println("myArrayList.size() = " + myArrayList.size());
        System.out.println("myArrayList.get(5) = " + myArrayList.get(5));
        myArrayList.remove(5);
        System.out.println("myArrayList.get(5) = " + myArrayList.get(5));
        System.out.println("myArrayList.size() = " + myArrayList.size());
        myArrayList.clear();
        System.out.println("myArrayList.size() = " + myArrayList.size());


    }
}
