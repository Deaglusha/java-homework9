package com.java;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        MyHashMap myHashMap = new MyHashMap();
        MyLinkedList myLinkedList = new MyLinkedList();
        MyQueue myQueue = new MyQueue();
        MyStack myStack = new MyStack();

        //---MyArrayList---
        /*Методы:
        add(Object value) добавляет элемент в конец
        remove(int index) удаляет элемент под индексом
        clear() очищает коллекцию
        size() возвращает размер коллекции
        get(int index) возвращает элемент под индексом*/
//        System.out.println(myArrayList.size());
//        myArrayList.clear();
//        System.out.println(myArrayList.get(1));
//        myArrayList.add(null);
//        myArrayList.add("2");
//        myArrayList.add("521");
//        myArrayList.add("sag");
//        myArrayList.add("gdss");
//        myArrayList.add("1");
//        myArrayList.add("2");
//        myArrayList.add("521");
//        myArrayList.add("sag");
//        myArrayList.add("gdss");
//        myArrayList.add("1");
//        myArrayList.add("2");
//        myArrayList.add("521");
//        myArrayList.add("sag");
//        myArrayList.add("gdss");
//        myArrayList.add("1");
//        myArrayList.add("2");
//        myArrayList.add("521");
//        myArrayList.add("sag");
//        myArrayList.add("gdss");
//        System.out.println(myArrayList.size());
//        System.out.println(myArrayList.get(1));
//        System.out.println(myArrayList.get(2));
//        myArrayList.remove(1);
//        System.out.println(myArrayList.get(1));
//        System.out.println(myArrayList.get(2));
//        System.out.println(myArrayList.size());
//        myArrayList.clear();
//        System.out.println(myArrayList.size());

        //---MyStack---
        /*Методы:
        push(Object value) добавляет элемент в конец
        remove(int index) удаляет элемент под индексом
        clear() очищает коллекцию
        size() возвращает размер коллекции
        peek() возвращает первый элемент в стеке (LIFO)
        pop() возвращает первый элемент в стеке и удаляет его из коллекции*/
//        System.out.println(myStack.size());
//        myStack.clear();
//        System.out.println(myStack.peek());
//        System.out.println(myStack.pop());
//        myStack.remove(5);
//        myStack.push("f");
//        myStack.remove(5);
//        myStack.push("fsd");
//        myStack.push("asf");
//        myStack.push("f213");
//        myStack.push("15");
//        myStack.push("1");
//        myStack.push("f2");
//        System.out.println(myStack.peek());
//        System.out.println(myStack.size());
//        System.out.println(myStack.peek());
//        System.out.println(myStack.pop());
//        System.out.println(myStack.size());
//        System.out.println(myStack.peek());

        //---MyQueue---
        /*Методы
        add(Object value) добавляет элемент в конец
        remove(int index) удаляет элемент под индексом
        clear() очищает коллекцию
        size() возвращает размер коллекции
        peek() возвращает первый элемент в очереди (FIFO)
        poll() возвращает первый элемент в очереди и удаляет его из коллекции*/


        //---MyHashMap---
        /*Методы
        put(Object key, Object value) добавляет пару ключ + значение
        remove(Object key) удаляет пару по ключу
        clear() очищает коллекцию
        size() возвращает размер коллекции
        get(Object key) возвращает значение(Object value) по ключу*/


        //---MyLinkedList---
        /*Методы
        add(Object value) добавляет элемент в конец
        remove(int index) удаляет элемент под индексом
        clear() очищает коллекцию
        size() возвращает размер коллекции
        get(int index) возвращает элемент под индексом*/

    }
}
