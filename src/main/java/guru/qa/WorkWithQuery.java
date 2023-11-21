package guru.qa;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class WorkWithQuery {
    private final Queue<String> queue = new ArrayDeque<>();

    @Override
    public String toString() {
        return "WorkWithQuery{" +
                "queue=" + queue +
                '}';
    }

    public void addToQuery(String element) {
        queue.add(element);
    }

    public void addQueryToQuery(Queue<String> otherQuery) {
        queue.addAll(otherQuery);
    }

    public void deleteFromQueryByElement(String element) {
        if (queue.contains(element)) {
            queue.remove(element);
        } else {
            System.out.println("Element not found in the queue.");
        }
    }

    public boolean searchToQuery(String element) {
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(element)) {
                return true;
            }
        }
        return false;
    }
}
