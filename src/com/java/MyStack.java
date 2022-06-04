package com.java;

        /*Написать свой класс MyStack как аналог классу Stack, который работает
        по принципу LIFO (last-in-first-out).
        Можно делать либо с помощью Node либо с помощью массива.

        Методы
        push(Object value) добавляет элемент в конец
        remove(int index) удаляет элемент под индексом
        clear() очищает коллекцию
        size() возвращает размер коллекции
        peek() возвращает первый элемент в стеке (LIFO)
        pop() возвращает первый элемент в стеке и удаляет его из коллекции*/

public class MyStack {
    private final int CAPACITY;
    private String array[];
    private int top;

    MyStack(int size) {
        array = new String[size];
        CAPACITY = size;
        top = -1;
    }

    public void push(String value) {
        if (isFull()) {
            System.out.println("Стек заполнен");
            System.exit(1);
        }

        array[++top] = value;
    }

    public void remove(int index) {
        for (int i = index; i < top; i++)
            array[i] = array[i + 1];
        array[top] = null;
        top--;
    }

    public void clear() {
        array = new String[0];
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Стек пуст");
            System.exit(1);
        }

        return array[top];
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Стек пуст");
            System.exit(1);
        }
        top--;

        return array[top];
    }



    // Проверяем, пуст ли стек
    public Boolean isEmpty() {
        return top == -1;
    }
    // Проверяем, не заполнен ли стек
    public Boolean isFull() {
        return top == CAPACITY - 1;
    }
}
