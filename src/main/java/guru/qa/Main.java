package guru.qa;

import static guru.qa.DataTypes.*;

public class Main {
    public static void main(String[] args) {
        javaDataTypes();
    }

    public static void javaDataTypes() {
        System.out.println("### Математические операторы ###");
        System.out.println("Сложение " + (aByte + aShort));
        System.out.println("Вычитание " + (aShort - aInt));
        System.out.println("Умножение " + (aInt * aLong));
        System.out.println("Деление " + (aFloat / aDouble));
        System.out.println("Остаток от деления " + (aByte % aShort));
        System.out.println("###");
        System.out.println("### Логические операторы ###");
        System.out.println("Меньше " + (aByte < aShort));
        System.out.println("Больше " + (aShort > aInt));
        System.out.println("Меньше или равно " + (aInt <= aLong));
        System.out.println("Больше или равно " + (aFloat >= aDouble));
        System.out.println("Равно " + (aByte == aShort));
        System.out.println("Не равно " + (aShort != aInt));
        System.out.println("И " + ((aShort != aInt) && (aByte == aShort)));
        System.out.println("Или " + ((aShort != aInt) || (aByte == aShort)));
        System.out.println("###");
        System.out.println("### Переполнение ###");
        byte myByte = (byte) (127 + 1);
        System.out.println("Переполнение byte " + (myByte));
        short myShort = (short) (32767 + 1);
        System.out.println("Переполнение short " + (myShort));
        int myInt = Integer.MAX_VALUE + 1;
        System.out.println("Переполнение int " + (myInt));
        long myLong = Long.MAX_VALUE + 1;
        System.out.println("Переполнение long " + (myLong));
        char myChar = (char) (Character.MAX_VALUE + 1);
        System.out.println("Переполнение char " + (myChar));
        float myFloat = Float.MAX_VALUE + 1;
        System.out.println("Переполнение float " + (myFloat));
        double myDouble = Double.MAX_VALUE + 1;
        System.out.println("Переполнение double " + (myDouble));
        System.out.println("###");
        System.out.println("### Комбинации типов данных (int и double) ###");
        System.out.println("Сложение в double = " + (1 + 1.5));
        System.out.println("Сложение в int = " + (int) (1 + 1.5));
        System.out.println("Вычитание в double = " + (1 - 1.5));
        System.out.println("Вычитание в int = " + (int) (1 - 1.5));
        System.out.println("Умножение в double = " + (1 * 1.5));
        System.out.println("Умножение в int = " + (int) (1 * 1.5));
        System.out.println("Деление в double = " + (1 / 1.5));
        System.out.println("Деление в int = " + (int) (1 / 1.5));
        System.out.println("Остаток от деления в double = " + (1 % 1.5));
        System.out.println("Остаток от деления в int = " + (int) (1 % 1.5));
    }
}
