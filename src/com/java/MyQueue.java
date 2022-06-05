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
    private long[] array;
    private int size;// Размер массива
    private int nIteams;// Фактический объем хранилища: записываем, сколько значений в очереди, удаляем - добавляем ++
    private int front;// Заголовок: в основном записывается при удалении, где же удаление
    private int rear;// Конец: в основном записывать, когда он добавляется, где он добавляется

    public MyQueue(int maxSize) {
        this.size = maxSize;
        array = new long[size];
        front = 0;
        nIteams = 0;
        rear = -1;
    }

    //добавить одну
    public void add(long value) {
        if (isFull()) {
            System.out.println("Очередь заполнена");
            return;
        }
        rear = ++rear % size;//
        array[rear] = value;// Когда хвостовой указатель заполнен, он возвращается к нулю. Это предложение эквивалентно следующему содержанию комментария
        nIteams++;
    }

    // Удаляем один
    public long remove() {
        if (isEmpty()) {
            System.out.println("Очередь пуста");
            return 0;
        }
        nIteams--;
        front = front % size;
        return array[front++];// Если вы выйдете на голову, уменьшите ее и прибавьте 1 к голове
    }

    // Просмотр первого
    public long peek() {
        if (isEmpty()) {
            System.out.println("Очередь пуста");
            return 0;
        }
        return array[front];
    }

    public void display() {
        /*if(isEmpty()){
                         System.out.println («Очередь пуста»);
            return;
        }*/
        System.out.print("[");
        int item = front;
        for (int i = 0; i < nIteams; i++) {
            System.out.print(array[item++ % size]);
            if (i != nIteams - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }


    // Полон ли он?
    public boolean isFull() {
        return (nIteams == size);
    }

    // Пусто
    public boolean isEmpty() {
        return (nIteams == 0);
    }

    // Размер очереди
    public int size() {
        return nIteams;
    }
}
