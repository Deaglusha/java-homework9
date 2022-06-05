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
    private String[] array = new String[CAPACITY];
    private int size = 0;

    // Добавляет элемент в конец.
    public void push(String value) {
        // Если количество элементов достигло размера массива - увеличиваем его в 2 раза.
        if (size == array.length - 1) {
            resize(array.length * 2);
        }

        System.out.println("Элемент: " + value + " - успешно добавлен! Индекс: " + size);
        array[size] = value;
        size++;
    }

    // Удаляет элемент под индексом.
    public void remove(int index) {
        if (isEmpty()) {
            System.out.println("Ошибка! Стек пустой!");
            return;
        } else if (index >= size) {
            System.out.println("Ошибка! Элемента под индексом: " + index + " - не существует!");
            return;
        }

        System.out.println("Элемент: " + array[index] + ", под индексом: " + index + " - успешно удалён!");

        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null;
        size--;

        // Если количество элементов стало в 4 раза меньше размера массива - уменьшаем его в 2 раза.
        if (array.length > CAPACITY && size < array.length / 4) {
            resize(array.length / 2);
        }
    }

    // Очищает стек.
    public void clear() {
        if (isEmpty()) {
            System.out.println("Стек итак пустой!");
            return;
        }

        array = new String[CAPACITY];
        size = 0;
        System.out.println("Стек успешно очищен!");
    }

    // Возвращает размер стека.
    public String size() {
        if (isEmpty()) {
            return "Стек пустой!";
        }

        return "Размер стека: " + size;
    }

    // Возвращает первый элемент в стеке (LIFO).
    public String peek() {
        if (isEmpty()) {
            return "Ошибка! Стек пустой!";
        }

        return "Первый элемент в стеке: " + array[size - 1];
    }

    // Возвращает первый элемент в стеке и удаляет его из коллекции.
    public String pop() {
        if (isEmpty()) {
            return "Ошибка! Стек пустой!";
        }

        String result = array[size - 1];
        array[size - 1] = null;
        size--;

        // Если количество элементов стало в 4 раза меньше размера массива - уменьшаем его в 2 раза.
        if (array.length > CAPACITY && size < array.length / 4) {
            resize(array.length / 2);
        }

        return "Первый элемент в стеке: " + result + " - успешно удалён!";
    }

    /*----- Дополнительные методы -----*/
    // Проверяем, пустой ли стек.
    public Boolean isEmpty() {
        return size == 0;
    }

    // Увеличиваем или уменьшаем (для экономии памяти) размер массива.
    private void resize(int newLength) {
        String[] newArray = new String[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
