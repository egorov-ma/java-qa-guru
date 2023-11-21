package guru.qa;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WorkWithSet {
    Set<String> set = new HashSet<>();

    @Override
    public String toString() {
        return "WorkWithSet{" +
                "set=" + set +
                '}';
    }

    // Метод для добавления элемента в коллекцию
    public void addElement(String element) {
        if (set.contains(element)) {
            System.out.println("Element already exists in the set. Not adding.");
        } else {
            set.add(element);
            System.out.println("Element added to the set: " + element);
        }
    }

    // Метод для удаления элемента из коллекции
    public void removeElement(String element) {
        if (set.contains(element)) {
            set.remove(element);
            System.out.println("Element removed from the set: " + element);
        } else {
            System.out.println("Element not found in the set. Cannot remove.");
        }
    }

    public void searchElement(String element) {
        Iterator<String> iterator = set.iterator();
        int index = 0;
        boolean found = false;

        for (; iterator.hasNext(); index++) {
            if (iterator.next().equals(element)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Element found at index " + index + ": " + element);
        } else {
            System.out.println("Element not found in the set.");
        }
    }
}
