public class OrderBuilderExample {
    public static void main(String[] args) {
        Order order = new Order.OrderBuilder("Laptop")
                            .deliveryAddress("123 Amazon St")
                            .shippingMethod("Express")
                            .paymentType("PhonePe")
                            .giftWrapped(true)
                            .quantities(List.of(1, 2))
                            .build();

        System.out.println(order);
    }
}
