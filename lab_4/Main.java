package Lab4;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1, 2, 3, 97, 98, 99);
        System.out.println("1. Cреднее значение списка целых чисел: " + getAverage(list1));

        List<String> list2 = Arrays.asList("hello my friend", "how are you?", "where is your smile?");
        System.out.println("2. Строки в верхнем регистре: " + upperCaseConvertor(list2));

        List<Integer> list3 = Arrays.asList(1,2,3,4,5,2,5);
        System.out.println("3. Квадраты уникальных элементов: " + singleSquare(list3));

        List<Double> list4 = Arrays.asList(1.7, 2.6, 3.8, 4.77, 5.8, 2.1 , 5.0);
        System.out.println("4. Последний элемент коллекции: " + getLast(list4));

        // List<Integer> list5 = Arrays.asList(1, -2, -3, -97, 98, -99);
        List<Integer> list5 = Arrays.asList(1, -3, -97,-99);
        System.out.println("5. Сумма четных чисел: " + summEven(list5));

        List<String> list6 = Arrays.asList("Accumulator", "Base", "Counter","Data");
        System.out.println("6. Сформированные Map: " + mapConvertor(list6));

    }

    public static double getAverage(List<Integer> list) {
        return list.stream()
                .mapToInt(value -> value)
                .average().orElse(0);
    }

    public static List<String> upperCaseConvertor (List<String> list) {
        return list.stream()
                .map(s -> s.toUpperCase())
                .map(s -> "_new_" + s)
                .collect(toList());
    }

    public static List<Integer> singleSquare(List<Integer> list) {
        Map<Integer, Long> map = list.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        List<Integer> listRes = map.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey()*e.getKey())
                .collect(Collectors.toList());
        return listRes;
    }

    public static <T> T getLast(Collection<T> collection) {
        return collection.stream()
                .reduce((first, second) -> second)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public  static int summEven(List<Integer> list) {
        return list.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(value -> value)
                .sum();
    }

    public static Map<Character, String> mapConvertor (List<String> list) {
        return list.stream()
                .collect(Collectors.toMap(
                        s -> s.charAt(0),
                        s -> s.substring(1)));
    }

}
