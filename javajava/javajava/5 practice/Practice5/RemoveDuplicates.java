package Practice5;
import java.util.ArrayList;

public class RemoveDuplicates {
    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
        ArrayList<T> result = new ArrayList<>();
        for (T element : list) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }
    public static <T> int LinearSearch(ArrayList<T> list, T elem){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == elem){return i;}
        }
        return -1;
    }
};


