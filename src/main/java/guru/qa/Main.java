package guru.qa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static WorkWithList list = new WorkWithList();
    static WorkWithQuery query = new WorkWithQuery();
    static WorkWithMap map = new WorkWithMap();
    static WorkWithSet set = new WorkWithSet();

    public static void main(String[] args) {

        List<String> car = new ArrayList<>(List.of("Kamaz", "Gaz", "Uaz"));




        // Практика: реализовать 4 класса, использующих разные коллекции внутри.
        // Каждый класс должен использовать один из существующих в Java видов циклов.
        // Реализовать поиск элементов, добавление, удаление в отдельных методах.


        list.addInList(car);
        list.addInList(2, "Ferrari");
        list.addInList(1, "Volga");
        list.addInList(car);


        System.out.println(list);
        list.searchInList();
        list.deleteInList();

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
