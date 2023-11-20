package guru.qa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static WorkWithQuery query = new WorkWithQuery();
    static WorkWithMap map = new WorkWithMap();
    static WorkWithSet set = new WorkWithSet();

    // Практика: реализовать 4 класса, использующих разные коллекции внутри.
    // Каждый класс должен использовать один из существующих в Java видов циклов.
    // Реализовать поиск элементов, добавление, удаление в отдельных методах.
    public static void main(String[] args) {

        WorkWithList list = new WorkWithList();
        List<String> car = new ArrayList<>(List.of("Kamaz", "Gaz", "Uaz"));
        list.addListToList(car);
        list.addToListByElement(2, "Ferrari");
        list.addToList("Volga");
        System.out.println("added: " + list);
        list.deleteFromListByElement("Ferrari");
        list.deleteFromListByIndex(1);
        System.out.println("delete: " + list);
        list.searchInList("Ferrari", list);



        query.searchInQuery();
        query.addInQuery();
        query.deleteInQuery();

        map.searchInMap();
        map.addInMap();
        map.deleteInMap();

        set.searchInSet();
        set.addInSet();
        set.deleteInSet();


    }
}
