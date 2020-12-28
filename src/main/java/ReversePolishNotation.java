import java.util.Stack;

public class ReversePolishNotation {
    /**
     * @param expr string with reverse polish notation expression.
     * @return the result of expression. If string is empty returns 0.
     */
    public double evaluate(String expr) {

        if (expr.equals("")) {
            return 0;
        }

        Stack<Double> numbersInExpression = new Stack<>();
        String[] expressionArray = expr.split("\\s");
        for (String s : expressionArray) {
            if (isNumericString(s)) {
                numbersInExpression.push(Double.parseDouble(s));
            } else {
                calculate(numbersInExpression, s);
            }
        }
        return numbersInExpression.pop();
    }

    private void calculate(Stack<Double> numbersInExpression, String operator) {
        double firstNumber = numbersInExpression.pop();
        double secondNumber = numbersInExpression.pop();

        switch (operator) {
            case "+":
                numbersInExpression.push(secondNumber + firstNumber);
                break;
            case "-":
                numbersInExpression.push(secondNumber - firstNumber);
                break;
            case "*":
                numbersInExpression.push(secondNumber * firstNumber);
                break;
            case "/":
                numbersInExpression.push(secondNumber / firstNumber);
                break;

        }
    }

    static boolean isNumeric(char c) {
        return (c >= '0' && c <= '9');
    }

    static boolean isNumericString(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (!isNumeric(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
