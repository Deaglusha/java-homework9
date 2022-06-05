package com.java;

        /*Написать свой класс MyQueue как аналог классу Queue, который будет работать
        по принципу FIFO (first-in-first-out).
        Можно делать либо с помощью Node либо с помощью массива.

        Методы
        add(Object value) добавляет элемент в конец
        remove(int index) удаляет элемент под индексом
        clear() очищает коллекцию
        size() возвращает размер коллекции
        peek() возвращает первый элемент в очереди (FIFO)
        poll() возвращает первый элемент в очереди и удаляет его из коллекции*/

public class MyQueue {
    private final int CAPACITY = 16;
    private String[] array = new String[CAPACITY];
    private int top = -1;

    // Добавляет элемент в конец.
    public void add(String value) {
        // Если количество элементов достигло размера массива - увеличиваем его в 2 раза.
        if (top == array.length - 1) {
            resize(array.length * 2);
        }

        System.out.println("Элемент: " + value + " - успешно добавлен!");
        array[++top] = value;
    }

    // Удаляет элемент под индексом.
    public void remove(int index) {
        if (isEmpty()) {
            System.out.println("Ошибка! Коллекция пустая!");
            System.exit(1);
        } else if (index >= top) {
            System.out.println("Ошибка! Элемента под индексом: " + index + " - не существует!");
            System.exit(1);
        }

        for (int i = index; i < top; i++) {
            array[i] = array[i + 1];
        }

        array[top] = null;
        top--;

        // Если количество элементов стало в 4 раза меньше размера массива - уменьшаем его в 2 раза.
        if (array.length > CAPACITY && top < array.length / 4) {
            resize(array.length / 2);
        }

        System.out.println("Элемент: " + array[index] + ", под индексом: " + index + " - успешно удалён!");
    }

    // Очищает стек.
    public void clear() {
        array = new String[0];
        top = -1;
        System.out.println("Стек успешно очищен!");
    }

    // Возвращает размер стека.
    public String size() {
        if (isEmpty()) {
            return "Ошибка! Стек пустой!";
        }

        return "Размер стека: " + top + 1;
    }

    // Возвращает первый элемент в стеке (LIFO).
    public String peek() {
        if (isEmpty()) {
            return "Ошибка! Стек пустой!";
        }

        return "Первый элемент в стеке: " + array[0];
    }

    // Возвращает первый элемент в стеке и удаляет его из коллекции.
    public String pop() {
        if (isEmpty()) {
            return "Ошибка! Стек пустой!";
        }

        for (int i = 0; i < top; i++) {
            array[i] = array[i + 1];
        }

        array[top] = null;
        top--;

        // Если количество элементов стало в 4 раза меньше размера массива - уменьшаем его в 2 раза.
        if (array.length > CAPACITY && top < array.length / 4) {
            resize(array.length / 2);
        }

        return "Первый элемент в стеке: " + array[0] + " - успешно удалён!";
    }

    /*----- Дополнительные методы -----*/
    // Проверяем, пустой ли стек.
    public Boolean isEmpty() {
        return top == -1;
    }

    // Увеличиваем или уменьшаем (для экономии памяти) размер массива.
    private void resize(int newLength) {
        String[] newArray = new String[newLength];
        System.arraycopy(array, 0, newArray, 0, top);
        array = newArray;
    }
}
