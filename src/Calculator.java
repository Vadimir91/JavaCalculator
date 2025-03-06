import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Enter operation (+, -, *, /) or 'exit' to quit:");
            String operation = scanner.next();

            if (operation.equalsIgnoreCase("exit")) {
                running = false;
                break;
            }

            if (operation.equals("+") || operation.equals("-")) {
                System.out.println("Enter numbers separated by space:");
                scanner.nextLine(); // Consume newline
                String[] numbers = scanner.nextLine().split(" ");
                double result = Double.parseDouble(numbers[0]);

                for (int i = 1; i < numbers.length; i++) {
                    if (operation.equals("+")) {
                        result += Double.parseDouble(numbers[i]);
                    } else {
                        result -= Double.parseDouble(numbers[i]);
                    }
                }

                System.out.println("Result: " + result);
            } else {
                System.out.println("Enter first number:");
                double num1 = scanner.nextDouble();
                System.out.println("Enter second number:");
                double num2 = scanner.nextDouble();
                double result = 0;

                switch (operation) {
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            System.out.println("Error: Division by zero is not allowed.");
                            continue;
                        }
                        result = num1 / num2;
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        continue;
                }

                System.out.println("Result: " + result);
            }
        }

        System.out.println("Calculator closed.");
        scanner.close();
    }
}