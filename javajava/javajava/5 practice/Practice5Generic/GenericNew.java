package Practice5Generic;
import java.util.ArrayList;
//вариант через наследование inhertance
public class GenericNew<T> extends ArrayList<T> {

    public void push(T value) {
        add(value);
    }

    public T pop() {
        return remove(size() - 1);
    }

    public T peek() {
        return get(size() - 1);
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }
}

//        | ArrayList<Object>|
//        +------------------+
//        ^
//        |
//        +------------------+
//        |   MyStack        |
//        +------------------+
//        | +isEmpty():boolean |
//        | +getSize():int     |
//        | +peek():Object     |
//        | +pop():Object      |
//        | +push(o:Object):void |