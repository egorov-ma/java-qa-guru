package guru.qa;

public class Main {
    public static void main(String[] srgs) {
        String str = "Привет, мир!";

        // ПРИМИТИВНЫЕ ТИПЫ ДАННЫХ
        // Целочисленные типы данных. Отличаются размером выделяемой памяти
        byte aByte = 100; // 8бит
        short aShort = 100; // 16бит
        int aInt = 100; // 32бит
        long aLong = 100; // 64бит
        // Типы с плавающий точкой. Отличаются размером выделяемой памяти
        float aFloat = 1.1f; // 32бит
        double aDouble = 1.2; // 64бит
        // Символьный тип данных
        char aChar = '\u0000'; // 16бит. Символы в кодировке UNICODE
        // Логический тип
        boolean aBoolean = false;

        //ССЫЛОЧНЫЕ ТИПЫ ДАННЫХ
        Integer aInteger = null;
        Character aCharacter = null;





        System.out.println(str);
    }
}
