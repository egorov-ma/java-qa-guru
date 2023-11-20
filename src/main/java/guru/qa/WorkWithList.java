package guru.qa;

import java.util.ArrayList;
import java.util.List;

public class WorkWithList {
    List<String> list = new ArrayList<>();

    public WorkWithList() {
        this.list = list;
    }

    public void addInList(int i, String element) {
        this.list.add(i, element);
    }
    public void addInList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            this.list.add(list.get(i));
        }
    }

    @Override
    public String toString() {
        return "WorkWithList{" +
                "list=" + list +
                '}';
    }

    public void searchInList() {
    }

    public void deleteInList() {
    }
}
