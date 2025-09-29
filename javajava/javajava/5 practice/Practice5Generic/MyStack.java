package Practice5Generic;
//вариант через композицию has-a
public class MyStack<T> {
    private static final int Default_Size = 10;
    private int size;
    private T [] elements;

    public MyStack(){
        elements = (T[]) new Object[Default_Size];
    }
    public void push(T value){
        if (size== elements.length){
            grow();
        }
        elements[size++] = value;
    }

    public T pop() {
        T value = elements[--size];
        elements[size] = null;
        return value;
    }

    public T peek() {
        return elements[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    private void grow() {
        int newCapacity = elements.length * 2;
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }
}

//        +------------------+
//        | - list: ArrayList|
//        +------------------+
//        | +isEmpty():boolean |
//        | +getSize():int     |
//        | +peek():Object     |
//        | +pop():Object      |
//        | +push(o:Object):void |
