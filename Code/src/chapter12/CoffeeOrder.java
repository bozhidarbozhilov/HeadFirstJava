package chapter12;

import java.util.List;
import java.util.stream.Collectors;

public class CoffeeOrder {
    public static void main(String[] args) {
        List<String> coffees = List.of("Cappuccino", "Americano", "Espresso", "Cortado", "Mocha", "Cappuccino",
                "Flat white", "Latte");
        List<String> coffeeEndingInO = coffees.stream()
                                              .filter(s -> s.endsWith("o"))
                                              .sorted()
                                              .distinct()
                                              .collect(Collectors.toList());
        System.out.println(coffeeEndingInO);

    }
}
