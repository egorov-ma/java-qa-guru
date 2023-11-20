package guru.qa;

import java.util.ArrayList;
import java.util.List;

public class WorkWithList {
    private final List<String> list = new ArrayList<>();

    @Override
    public String toString() {
        return "WorkWithList{" +
                "list=" + list +
                '}';
    }

    public void addToList(String element) {
        this.list.add(element);
    }

    public void addToListByElement(int index, String element) {
        this.list.add(index, element);
    }

    public void addListToList(List<String> list) {
        this.list.addAll(list);
    }

    public void deleteFromListByElement(String element) {
        this.list.remove(element);
    }

    public void deleteFromListByIndex(int index) {
        this.list.remove(index);
    }
}
