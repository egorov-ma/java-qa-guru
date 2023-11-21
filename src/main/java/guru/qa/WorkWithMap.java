package guru.qa;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class WorkWithMap {
    private final Map<String, String> map = new HashMap<>();

    @Override
    public String toString() {
        return "WorkWithMap{" +
                "map=" + map +
                '}';
    }

    public void displayElements() {
        System.out.println("HashMap elements:");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println();
    }

    public void addElement(String value) {
        String key = UUID.randomUUID().toString();
        map.put(key, value);
    }

    public void addElement(String key, String value) {
        map.put(key, value);
    }

    public void deleteElementByKey(String key) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else {
            System.out.println("Element with key " + key + " not found.");
        }
    }

    public void deleteElementByValue(String value) {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (entry.getValue().equals(value)) {
                iterator.remove();
            }
        }
    }

    public void searchByKey(String key) {
        if (map.containsKey(key)) {
            String value = map.get(key);
            System.out.println("searchByKey -- Key: " + key + ", Value: " + value);
        } else {
            System.out.println("Element with key " + key + " not found.");
        }
    }

    public void searchByValue(String value) {
        boolean found = false;
        do {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getValue().equals(value)) {
                    System.out.println("searchByKey -- Key: " + entry.getKey() + ", Value: " + entry.getValue());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Element with value " + value + " not found. Please enter a new value:");
                // Введите новое значение или измените условие завершения цикла, например, found = true;
            }
        } while (!found);
    }
}
