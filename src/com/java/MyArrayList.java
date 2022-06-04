package com.java;

        /*Написать свой класс MyArrayList как аналог классу ArrayList.
        Можно использовать 1 массив для хранения данных.

        Методы
        add(Object value) добавляет элемент в конец
        remove(int index) удаляет элемент под индексом
        clear() очищает коллекцию
        size() возвращает размер коллекции
        get(int index) возвращает элемент под индексом*/

public class MyArrayList {
    private final int CAPACITY = 16;
    private final int CUT_RATE = 4;
    private String[] array = new String[CAPACITY];
    private int size = 0;

    public void add(String value) {
        if (size == array.length - 1)
            resize(array.length * 2);
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

    public String get(int index) {
        return array[index];
    }

    private void resize(int newLength) {
        String[] newArray = new String[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
