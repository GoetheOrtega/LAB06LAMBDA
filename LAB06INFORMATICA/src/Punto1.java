import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

public class Punto1 {
    public static void main(String[] args) {
        Function<Double, Double>[] functions = new Function[5];

        functions[0] = Math::cos;

        functions[1] = x -> 2 * Math.sqrt(Math.abs(x - 1)) + 1;

        functions[2] = x -> -(Math.pow(x / Math.PI, 2)) - 2 * x + 5 * Math.PI;

        functions[3] = x -> {
            double result = 0;
            for (int k = 1; k <= 100; k++) {
                result += ((x / (Math.PI * k)) - 1) * ((x / (Math.PI * k)) - 1);
            }
            return result;
        };

        functions[4] = x -> {
            if (x < 0) {
                return (1.0 / 4) * Math.pow(Math.sin(x), 2) + 1;
            } else {
                return (1.0 / 2) * Math.cos(x) - 1;
            }
        };

        Predicate<Double> predicate = value -> value < 0;
        tabulateFunctions(-2 * Math.PI, 2 * Math.PI, Math.PI / 6, functions, predicate);

        int numPoints = 10;
        System.out.println();
        System.out.println("Find minimum and maximum for random points:");
        findMinMaxForRandomPoints(numPoints, functions);
    }

    public static void tabulateFunctions(double a, double b, double dx, Function<Double, Double>[] functions,
                                         Predicate<Double> predicate) {
        int totalNegativeValues = 0;
        int totalValuesInRange = 0;

        for (Function<Double, Double> function : functions) {
            int negativeValues = 0;
            int valuesInRange = 0;

            for (double x = a; x <= b; x += dx) {
                double result = function.apply(x);

                if (predicate.test(result)) {
                    negativeValues++;
                }

                if (result >= -1 && result <= 1) {
                    valuesInRange++;
                }

                System.out.println("f(" + x + ") = " + result);
            }

            System.out.println("Negative values of the function: " + negativeValues);
            System.out.println("Values in the range [-1, 1]: " + valuesInRange);
            System.out.println();

            totalNegativeValues += negativeValues;
            totalValuesInRange += valuesInRange;
        }

        System.out.println("Total negative values of all functions: " + totalNegativeValues);
        System.out.println("Total values in the range [-1, 1] of all functions: " + totalValuesInRange);
    }

    public static void findMinMaxForRandomPoints(int n, Function<Double, Double>[] functions) {
        Random random = new Random();
        double[] pointsX = new double[n];
        double[] pointsY = new double[n];

        for (int i = 0; i < n; i++) {
            pointsX[i] = -10 + (random.nextDouble() * 20);
            pointsY[i] = -10 + (random.nextDouble() * 20);
        }

        for (Function<Double, Double> function : functions) {
            double minimum = Double.MAX_VALUE;
            double maximum = Double.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                double x = pointsX[i];
                double y = pointsY[i];

                double result = function.apply(x);

                if (result < minimum) {
                    minimum = result;
                }

                if (result > maximum) {
                    maximum = result;
                }
            }

            System.out.println("Minimum for the function: " + minimum);
            System.out.println("Maximum for the function: " + maximum);
            System.out.println();
        }
    }
}
