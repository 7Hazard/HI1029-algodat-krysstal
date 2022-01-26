package f4;

import java.util.*;

class nb7_2 {
    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Enter an infix expression to evaluate");
            line = in.nextLine();
            if (!line.equals("")) {
                try {
                    var postfix = new InfixConverter().infixToPostfix(line);
                    System.out.println("Value is " + new PostfixEval().eval(postfix));
                } catch (Error ex) {
                    System.out.println("Syntax error " + ex.getMessage());
                }
            } else {
                break;
            }
        }
    }

    private static final String OPERATORS = "+-*/()";
    private static boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    public static class PostfixEval {

        private Stack<Integer> operandStack = new Stack<>();

        private void evalOp(char op) {
            var right = operandStack.pop();
            var left = operandStack.pop();
            if (op == '+') operandStack.push(left + right);
            else if (op == '-') operandStack.push(left - right);
            else if (op == '*') operandStack.push(left * right);
            else if (op == '/') operandStack.push(left / right);
        }

        public int eval(String postfix) {
            String[] tokens = postfix.split(" +");
            try {
                for (String token : tokens) {
                    var firstChar = token.charAt(0);
                    if (Character.isDigit(firstChar)) {
                        operandStack.push(Integer.parseInt(token));
                    } else if (isOperator(firstChar)) {
                        evalOp(firstChar);
                    } else {
                        throw new Error("Invalid character encountered");
                    }
                }

                var val = operandStack.pop();
                if (!operandStack.empty()) throw new Error("Invalid character encountered");
                return val;
            } catch (EmptyStackException ex) {
                throw new Error("Syntax Error: The stack is empty");
            }
        }
    }
    public static class InfixConverter {
        static int precedence(char op) {
            return switch (op) {
                case '+', '-' -> 1;
                case '*', '/' -> 2;
                case '(', ')' -> -1;
                default -> 0;
            };
        }

        Stack<Character> opstack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        public String infixToPostfix(String expression) {
            try {
                Scanner scan = new Scanner(expression);
                String nextToken;
                while ((nextToken = scan.findInLine("[]\\p{L}\\p{N}]+|[-+/\\*()]")) != null) {
                    char firstChar = nextToken.charAt(0);
                    if (Character.isJavaIdentifierStart(firstChar) || Character.isDigit(firstChar)) {
                        postfix.append(nextToken);
                        postfix.append(' ');
                    } else if (isOperator(firstChar)) {
                        processOperator(firstChar);
                    } else {
                        throw new Error("Unexpected Character Encountered:" + firstChar);
                    }
                }

                while (!opstack.empty()) {
                    char op = opstack.pop();
                    if (op == '(') throw new Error("Unmatched opening parenthesis");
                    postfix.append(op);
                    postfix.append(' ');
                }

                return postfix.toString();

            } catch (EmptyStackException ex) {
                throw new Error("Syntax Error: the stack is empty");
            }
        }

        private void processOperator(char op) {
            if (opstack.empty() || op == '(') {
                opstack.push(op);
            } else {
                char topOp = opstack.peek();
                if (precedence(op) > precedence(topOp)) {
                    opstack.push(op);
                } else {
                    while (!opstack.empty() && precedence(op) <= precedence(topOp)) {
                        opstack.pop();
                        if (topOp == '(') {
                            break;
                        }
                        postfix.append(topOp);
                        postfix.append(' ');
                        if (!opstack.empty()) {
                            topOp = opstack.peek();
                        }
                    }
                    if (op != ')') {
                        opstack.push(op);
                    }
                }
            }
        }
    }
}
