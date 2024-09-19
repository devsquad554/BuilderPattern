import java.util.Collections;
import java.util.List;

// Immutable PaymentOptions class with Builder
public class PaymentOptions {
    private final String paymentMethod;
    private final List<String> paymentDetails;

    private PaymentOptions(PaymentOptionsBuilder builder) {
        this.paymentMethod = builder.paymentMethod;
        this.paymentDetails = Collections.unmodifiableList(builder.paymentDetails);
    }

    public static class PaymentOptionsBuilder {
        private String paymentMethod;
        private List<String> paymentDetails;

        public PaymentOptionsBuilder(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public PaymentOptionsBuilder paymentDetails(List<String> details) {
            this.paymentDetails = List.copyOf(details); // Defensive copy
            return this;
        }

        public PaymentOptions build() {
            return new PaymentOptions(this);
        }
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public List<String> getPaymentDetails() {
        return paymentDetails;
    }

    @Override
    public String toString() {
        return "PaymentOptions{" +
                "paymentMethod='" + paymentMethod + '\'' +
                ", paymentDetails=" + paymentDetails +
                '}';
    }
}
