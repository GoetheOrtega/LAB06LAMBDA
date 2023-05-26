import java.util.function.Function;

public class Point3 {
    public static void main(String[] args) {
        // a)
        double rootA = findRoot(x -> x * Math.sin(x) - 0.5, 0, Math.PI);
        if (rootA != Double.NaN) {
            System.out.println("Root of the equation x * sin(x) - 0.5 = 0: " + rootA);
        }

        // b)
        double rootB = findRoot(x -> Math.log(x * x - 3 * x + 2), 0, 0.9);
        if (rootB != Double.NaN) {
            System.out.println("Root of the equation log(x^2 - 3x + 2) = 0: " + rootB);
        }

        // c)
        double rootC = findRoot(x -> Math.log(x * x - 3 * x + 2), 2.1, 5);
        if (rootC != Double.NaN) {
            System.out.println("Root of the equation log(x^2 - 3x + 2) = 0: " + rootC);
        }

        // d)
        double rootD = findRoot(x -> 0.5 * Math.tan(2.0 / 3.0 * (x + Math.PI / 4)) - 1, Math.PI, 2 * Math.PI);
        if (rootD != Double.NaN) {
            System.out.println("Root of the equation 0.5 * tan(2/3(x + pi/4)) - 1 = 0: " + rootD);
        }
    }

    public static double findRoot(Function<Double, Double> function, double a, double b) {
        double epsilon = 0.0001;
        double root = Double.NaN;

        if (Math.signum(function.apply(a)) == Math.signum(function.apply(b))) {
            System.out.println("The function does not have opposite signs at the endpoints of the interval.");
            return root;
        }

        while ((b - a) >= epsilon) {
            root = (a + b) / 2;
            double rootValue = function.apply(root);

            if (Math.abs(rootValue) < epsilon) {
                break;
            } else if (Math.signum(rootValue) == Math.signum(function.apply(a))) {
                a = root;
            } else {
                b = root;
            }
        }

        return root;
    }
}
