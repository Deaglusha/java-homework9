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
    private int size = 0;

    // Добавляет элемент в конец.
    public void add(String value) {
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
            System.out.println("Ошибка! Очередь пустая!");
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

    // Очищает очередь.
    public void clear() {
        if (isEmpty()) {
            System.out.println("Очередь итак пустая!");
            return;
        }

        array = new String[CAPACITY];
        size = 0;
        System.out.println("Очередь успешно очищена!");
    }

    // Возвращает размер очереди.
    public String size() {
        if (isEmpty()) {
            return "Очередь пустая!";
        }

        return "Размер очереди: " + size;
    }

    // Возвращает первый элемент в очереди (FIFO).
    public String peek() {
        if (isEmpty()) {
            return "Ошибка! Очередь пустая!";
        }

        return "Первый элемент в очереди: " + array[0];
    }

    // Возвращает первый элемент в очереди и удаляет его из коллекции.
    public String pop() {
        if (isEmpty()) {
            return "Ошибка! Очередь пустая!";
        }

        String result = array[0];

        for (int i = 0; i < size; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null;
        size--;

        // Если количество элементов стало в 4 раза меньше размера массива - уменьшаем его в 2 раза.
        if (array.length > CAPACITY && size < array.length / 4) {
            resize(array.length / 2);
        }

        return "Первый элемент в очереди: " + result + " - успешно удалён!";
    }

    /*----- Дополнительные методы -----*/
    // Проверяем, пустая ли очередь.
    public Boolean isEmpty() {
        return size == -1;
    }

    // Увеличиваем или уменьшаем (для экономии памяти) размер массива.
    private void resize(int newLength) {
        String[] newArray = new String[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
