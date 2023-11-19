package guru.qa;

import java.util.ArrayList;
import java.util.List;

public class WorkWithList {
    List<String> list = new ArrayList<>();

    public WorkWithList() {
        this.list = list;
    }

    public boolean addInList(String element) {
        return this.list.add("element");
    }
    public void addInList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            this.list.add(list.get(i));
        }
    }

    public void searchInList() {
    }

    public void deleteInList() {
    }
}
