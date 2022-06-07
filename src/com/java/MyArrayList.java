package com.java;

        /*Написать свой класс MyArrayList как аналог классу ArrayList.
        Можно использовать 1 массив для хранения данных.

        Методы:
        +add(Object value) добавляет элемент в конец
        +remove(int index) удаляет элемент под индексом
        clear() очищает коллекцию
        +size() возвращает размер коллекции
        +get(int index) возвращает элемент под индексом*/

public class MyArrayList {
    private final int CAPACITY = 16;
    private Object[] array = new Object[CAPACITY];
    private int size = 0;

    // Добавляет элемент в конец.
    public boolean add(Object value) {
        // Если количество элементов достигло размера массива - увеличиваем его в 2 раза.
        if (size == array.length - 1) {
            resize(array.length * 2);
        }
        if (value == null) {
            return false;
        }

        array[size] = value;
        size++;

        return true;
    }

    // Удаляет элемент под индексом.
    public boolean remove(int index) {
        if (isEmpty() || index >= size) {
            return false;
        }
        if (size - index >= 0) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }

        array[--size] = null;

        // Если количество элементов стало в 4 раза меньше размера массива - уменьшаем его в 2 раза.
        if (array.length > CAPACITY && size < array.length / 4) {
            resize(array.length / 2);
        }

        return true;
    }

    // Очищает коллекцию.
    public boolean clear() {
        array = new Object[CAPACITY];
        size = 0;

        return true;
    }

    // Возвращает размер коллекции.
    public int size() {
        return size;
    }

    // Возвращает элемент под индексом.
    public Object get(int index) {
        if (isEmpty() || index >= size) {
            return false;
        }

        return array[index];
    }

    /*----- Дополнительные методы -----*/
    // Проверяем, пустая ли коллекция.
    public Boolean isEmpty() {
        return size == 0;
    }

    // Увеличиваем или уменьшаем (для экономии памяти) размер массива.
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
