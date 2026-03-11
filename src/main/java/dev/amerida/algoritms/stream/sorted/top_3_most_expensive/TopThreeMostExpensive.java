package dev.amerida.algoritms.stream.sorted.top_3_most_expensive;

import java.util.Comparator;
import java.util.List;

public class TopThreeMostExpensive {

    public static List<Order> getTopThreeMostExpensive(List<Order> orders) {
        return orders.stream()
                .sorted(Comparator.comparing(Order::totalPrice).reversed())
                .limit(3)
                .toList();
    }

    public record Order(int id, double totalPrice) { }

    static void main() {
        List<Order> orders = List.of(
                new Order(1, 200.0),
                new Order(2, 19.0),
                new Order(3, 20.0),
                new Order(4, 14.0),
                new Order(5, 540.10),
                new Order(6, 25.50)
        );

        IO.println("Top three most expensive orders: " + getTopThreeMostExpensive(orders));
    }
}
