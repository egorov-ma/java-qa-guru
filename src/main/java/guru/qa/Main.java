package guru.qa;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Main {

    static WorkWithMap map = new WorkWithMap();
    static WorkWithSet set = new WorkWithSet();

    // Практика: реализовать 4 класса, использующих разные коллекции внутри.
    // Каждый класс должен использовать один из существующих в Java видов циклов.
    // Реализовать поиск элементов, добавление, удаление в отдельных методах.
    public static void main(String[] args) {

        WorkWithList list = new WorkWithList();
        List<String> car = new ArrayList<>(List.of("Kamaz", "Gaz", "Uaz"));
        list.addListToList(car);
        list.addToListByIndex(2, "Ferrari");
        list.addToList("Volga");
        System.out.println("added: " + list);
        list.deleteFromListByElement("Ferrari");
        list.deleteFromListByIndex(1);
        System.out.println("delete: " + list);
        System.out.println("Search in list by element: " + list.searchInListByElement("Kamaz"));
        System.out.println("Search in list by index: " + list.searchInListByIndex(2));
        System.out.println();

        WorkWithQuery query = new WorkWithQuery();
        Queue<String> color = new ArrayDeque<>();
        color.add("Red");
        color.add("Orange");
        color.add("Yellow");
        query.addQueryToQuery(color);
        query.addToQuery("Green");
        System.out.println("added: " + query);
        query.deleteFromQueryByElement("Orange");
        System.out.println("delete: " + query);
        System.out.println("Search in query: " + query.searchToQuery("Green"));
        System.out.println();

        WorkWithMap map = new WorkWithMap();
        HashMap books = new HashMap();
        map.addElement("The Wonderful Wizard of Oz");
        map.addElement("Alice's Adventures in Wonderland");
        map.addElement("123", "Ray Bradbury: Short Stories");
        map.addElement("321", "Test");
        System.out.println(map);
        map.searchByKey("123");
        map.searchByValue("Test");
        map.displayElements();
        map.deleteElementByKey("123");
        map.deleteElementByValue("Test");
        map.displayElements();




    }
}
