package guru.qa;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

        map.searchInMap();
        map.addInMap();
        map.deleteInMap();

        set.searchInSet();
        set.addInSet();
        set.deleteInSet();


    }
}
