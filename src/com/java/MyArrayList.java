package com.java;

        /*Написать свой класс MyArrayList как аналог классу ArrayList.
        Можно использовать 1 массив для хранения данных.

        Методы:
        add(Object value) добавляет элемент в конец
        remove(int index) удаляет элемент под индексом
        clear() очищает коллекцию
        size() возвращает размер коллекции
        get(int index) возвращает элемент под индексом*/

public class MyArrayList {
    private final int CAPACITY = 16;
    private String[] array = new String[CAPACITY];
    private int size = 0;

    // Добавляет элемент в конец.
    public void add(String value) {
        // Если количество элементов достигло размера массива - увеличиваем его в 2 раза.
        if (size == array.length - 1) {
            resize(array.length * 2);
        }

        array[size++] = value;
        System.out.println("Элемент: " + value + " - успешно добавлен!");
    }

    // Удаляет элемент под индексом.
    public void remove(int index) {
        if (isEmpty()) {
            System.out.println("Ошибка! Коллекция пустая!");
            System.exit(1);
        } else if (index >= size) {
            System.out.println("Ошибка! Элемента под индексом: " + index + " - не существует!");
            System.exit(1);
        }

        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }

        array[size] = null;
        size--;

        // Если количество элементов стало в 4 раза меньше размера массива - уменьшаем его в 2 раза.
        if (array.length > CAPACITY && size < array.length / 4) {
            resize(array.length / 2);
        }

        System.out.println("Элемент: " + array[index] + " | Индекс: " + index + " - успешно удалён!");
    }

    // Очищает коллекцию.
    public void clear() {
        array = new String[CAPACITY];
        size = 0;
        System.out.println("Коллекция успешно очищена!");
    }

    // Возвращает размер коллекции.
    public String size() {
        if (isEmpty()) {
            return "Коллекция пустая!";
        }

        return "Размер коллекции: " + size;
    }

    // Возвращает элемент под индексом.
    public String get(int index) {
        if (isEmpty()) {
            return "Ошибка! Коллекция пустая!";
        } else if (index >= size) {
            return "Ошибка! Индекс элемента больше размера!";
        }

        return "Элемент: " + array[index] + " | Индекс: " + index;
    }

    /*----- Дополнительные методы -----*/
    // Проверяем, пустая ли коллекция.
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
