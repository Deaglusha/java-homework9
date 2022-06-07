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
    private Object[] array = new Object[CAPACITY];
    private int size = 0;

    // Добавляет элемент в конец.
    public boolean push(Object value) {
        // Если количество элементов достигло размера массива - увеличиваем его в 2 раза.
        if (size == array.length - 1) {
            resize(array.length * 2);
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

    // Очищает стек.
    public boolean clear() {
        array = new Object[CAPACITY];
        size = 0;

        return true;
    }

    // Возвращает размер стека.
    public int size() {
        return size;
    }

    // Возвращает первый элемент в стеке (LIFO).
    public Object peek() {
        if (isEmpty()) {
            return false;
        }

        return array[size - 1];
    }

    // Возвращает первый элемент в стеке и удаляет его из коллекции.
    public Object pop() {
        if (isEmpty()) {
            return false;
        }

        Object result = array[size - 1];
        array[--size] = null;

        // Если количество элементов стало в 4 раза меньше размера массива - уменьшаем его в 2 раза.
        if (array.length > CAPACITY && size < array.length / 4) {
            resize(array.length / 2);
        }

        return result;
    }

    /*----- Дополнительные методы -----*/
    // Проверяем, пустой ли стек.
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
