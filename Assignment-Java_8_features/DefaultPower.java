public class DefaultPower {
    public static void main(String[] args) {
        PowerCalculator calc = new PowerCalculatorImpl();
        calc.calculate();   // Abstract method
        calc.showDefault(); // Default method
    }

    interface PowerCalculator {
        void calculate();

        default void showDefault() {
            System.out.println("This is a default power method.");
        }
    }

    static class PowerCalculatorImpl implements PowerCalculator {
        public void calculate() {
            System.out.println("Calculating power");
        }
    }
}
