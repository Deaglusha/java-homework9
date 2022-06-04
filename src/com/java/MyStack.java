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
    private final int CAPACITY = 16;
    private final int CUT_RATE = 4;
    private String[] array = new String[CAPACITY];
    private int size = 0;

    public void push(String value) {
        if (size == array.length - 1) {
            resize(array.length * 2);
        }

        array[size++] = value;
    }

    public void remove(int index) {
        for (int i = index; i < size; i++)
            array[i] = array[i + 1];
        array[size] = null;
        size--;

        if (array.length > CAPACITY && size < array.length / CUT_RATE) {
            resize(array.length / 2);
        }
    }

    public void clear() {
        array = new String[0];
        size = 0;
    }

    public int size() {
        return size;
    }

    public String peek() {
        return array[array.length - 1];
    }

    public String pop() {
        String result = array[array.length - 1];
        array[array.length - 1] = null;
        size--;
        return result;
    }

    private void resize(int newLength) {
        String[] newArray = new String[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    //Непонятно, в каком месте его развернуть...
}
