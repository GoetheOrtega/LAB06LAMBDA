import java.util.function.Function;

public class Punto4 {
    public static void main(String[] args) {
        double resultA = calculateIntegral(x -> 2 * Math.sin(x) + 1, Math.PI, -Math.PI);
        System.out.println("Result of integral a): " + resultA);

        double resultB = calculateIntegral(x -> -(Math.pow(x / Math.PI, 2)) - 2 * x + 5 * Math.PI, Math.PI, -Math.PI);
        System.out.println("Result of integral b): " + resultB);

        double resultC = calculateIntegral(x -> 0.5 * Math.pow(Math.cos(x), 2) + 1, Math.PI, -Math.PI);
        System.out.println("Result of integral c): " + resultC);
    }

    public static double calculateIntegral(Function<Double, Double> function, double a, double b) {
        int numRectangles = 1000;
        double dx = (b - a) / numRectangles;
        double sumAreas = 0;

        for (int i = 0; i < numRectangles; i++) {
            double xi = a + i * dx;
            double area = function.apply(xi) * dx;
            sumAreas += area;
        }

        return sumAreas;
    }
}
