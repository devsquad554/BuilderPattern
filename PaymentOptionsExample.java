import java.util.Arrays;

public class PaymentOptionsExample {
    public static void main(String[] args) {
        PaymentOptions paymentOptions = new PaymentOptions.PaymentOptionsBuilder("UPI")
                .paymentDetails(Arrays.asList("PhonePe", "Google Pay"))
                .build();

        System.out.println(paymentOptions);
    }
}
