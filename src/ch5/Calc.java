package ch5;

/*
Write a programme that can perform the basic arithmetic operations of addition, subtraction, multiplication and division for floating point numbers.
The programme run should be called with three parameters,
 */
// TESTS:
// java ch5.Calc 2.3 + 3.1 => 5.3999996
// java ch5.Calc 2.3 + 0.0 => 2.3
// java ch5.Calc 2.3 x 10.0 => 23.0
// java ch5.Calc 2.3 x 0.0 => 0.0
// java ch5.Calc 2.3 / 10.0 => 0.22999999
// java ch5.Calc 2.3 - 10.0 => -7.7
public class Calc {
    /**
     * Run on the CLI, takes 3 parameters: num1, operatorm, num2
     */
    public static void main(String[] args) {
        // Ensure proper number of inputs
        if (args.length != 3) {
            System.err.println("Usage: java Calc num1 [+, -, x, /] num2");
            return; // ToDo: what is return? You have to throw an exception to show that something was wrong.
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
