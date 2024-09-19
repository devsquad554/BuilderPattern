import java.util.List;
import java.util.Collections;

// Immutable Order class
public class Order {
    private final String itemName;
    private final String deliveryAddress;
    private final String shippingMethod;
    private final String paymentType;
    private final boolean giftWrapped;
    private final List<Integer> quantities;

    private Order(OrderBuilder builder) {
        this.itemName = builder.itemName;
        this.deliveryAddress = builder.deliveryAddress;
        this.shippingMethod = builder.shippingMethod;
        this.paymentType = builder.paymentType;
        this.giftWrapped = builder.giftWrapped;
        this.quantities = Collections.unmodifiableList(builder.quantities);
    }

    public static class OrderBuilder {
        private final String itemName; // mandatory
        private String deliveryAddress = "";
        private String shippingMethod = "Standard";
        private String paymentType = "Credit Card";
        private boolean giftWrapped = false;
        private List<Integer> quantities = Collections.emptyList(); // Default empty list

        public OrderBuilder(String itemName) {
            this.itemName = itemName;
        }

        public OrderBuilder deliveryAddress(String address) {
            this.deliveryAddress = address;
            return this;
        }

        public OrderBuilder shippingMethod(String method) {
            this.shippingMethod = method;
            return this;
        }

        public OrderBuilder paymentType(String type) {
            this.paymentType = type;
            return this;
        }

        public OrderBuilder giftWrapped(boolean wrapped) {
            this.giftWrapped = wrapped;
            return this;
        }

        public OrderBuilder quantities(List<Integer> quantities) {
            this.quantities = List.copyOf(quantities); // Defensive copy
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "itemName='" + itemName + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", shippingMethod='" + shippingMethod + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", giftWrapped=" + giftWrapped +
                ", quantities=" + quantities +
                '}';
    }
}
