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

    public void addToListByIndex(int index, String element) {
        if (index >= 0 && index <= list.size()) {
            list.add(index, element);
        } else {
            System.out.println("Invalid index. Element not added to the list.");
        }
    }

    public void addListToList(List<String> otherList) {
        list.addAll(otherList);
    }

    public void deleteFromListByElement(String element) {
        this.list.remove(element);
    }

    public void deleteFromListByIndex(int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
        } else {
            System.out.println("Invalid index. Element not removed from the list.");
        }
    }

    public boolean searchInListByElement(String element) {
        for (String s : list) {
            if (s.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public String searchInListByIndex(int index) {
        if (index >= 0 && index < list.size()) {
            return list.get(index);
        } else {
            System.out.println("Invalid index. Element not found in the list.");
            return null;
        }
    }
}