package ch5;

public class Calc {
    /**
     * Run on the CLI, takes 3 parameters: num1, operatorm, num2
     */
    public static void main(String[] args) {
        // Ensure proper number of inputs
        if (args.length != 3) {
            System.err.println("Usage: java Calc num1 [+, -, x, /] num2");
            return;
        }

        // Parse input
        float num1 = Float.parseFloat(args[0]);
        float num2 = Float.parseFloat(args[2]);
        String operator = args[1];

        // Perform arithmetic operation based on operator
        float result;
        switch (operator) {
            case "+": {
                result = num1 + num2;
                break;
            }
            case "-": {
                result = num1 - num2;
                break;
            }
            case "/": {
                result = num1 / num2;
                break;
            }
            case "x": {
                result = num1 * num2;
                break;
            }
            default: {
                System.err.println("Invalid operator\nList of operators: +, -, x, /");
                return;
            }
        }

        System.out.println(result);
    }
}
