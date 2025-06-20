package Ex_02;

public class NoDiscountStrategy implements PaymentStrategy{

    @Override
    public double calculateTotal(double valor) {
        return valor;
    }
}
