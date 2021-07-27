package com.tasoft.syb.test;

import java.util.Arrays;

public class MyStack<E> {
    //存储元素的数组
    private Object[] values;
    //元素数量
    private int count;
    //元素初始容量默认为8
    private int capacity;
    //增长因子
    private static final int grop=2;

    public MyStack() {
        count = 0;
        capacity = 8;
        values = new Object[capacity];
    }

    public MyStack(int initCapacity) {
        if (initCapacity < 1) {
            throw new IllegalArgumentException("初始容量不能小于1");
        }
        capacity = initCapacity;
        count = 0;
        values = new Object[initCapacity];
    }

    //入栈
    public void push(E val) {
        if (count == capacity) {
            ensureCapacity();
        }
        values[count++] = val;
    }

    //扩容
    public void ensureCapacity() {
        int newCapacity = capacity * grop;
        //返回新建的扩容数组里面包含元素组的值
        values = Arrays.copyOf(values,newCapacity);
        capacity = newCapacity;
    }

    //出栈
    public E pop() {
        if (count == 0) {
            throw new IllegalArgumentException("MyStack is empty.");
        }
        count--;
        E obj = (E) values[count];
        values[count] = 0;
        return obj;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count > 0 ? false : true;
    }
}
