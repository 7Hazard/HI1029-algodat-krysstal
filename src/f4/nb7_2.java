package f4;

import java.util.*;

class nb7_2 {
    public static void main(String[] args) {
//        String line;
//        Scanner in = new Scanner(System.in);
//        while (true) {
//            System.out.println("Enter an infix expression to evaluate");
//            line = in.nextLine();
//            if (!line.equals("")) {
//                try {
//                    var evaluator = new PostfixEval.InfixEvaluator(line);
//                    System.out.println("Value is " + evaluator.eval());
//                } catch (Error ex) {
//                    System.out.println("Syntax error " + ex.getMessage());
//                }
//            } else {
//                break;
//            }
//        }
    }

    public static class PostfixEval {
        private static final String OPERATORS = "+-*/";
        private static boolean isOperator(char ch) {
            return OPERATORS.indexOf(ch) != -1;
        }
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

        public static class InfixEvaluator {
            ArrayList<String> expressions = new ArrayList<>();

            InfixEvaluator(String infix) {

            }

            static int precedence(char op) {
                return switch (op) {
                    case '+', '-' -> 1;
                    case '*', '/' -> 2;
                    default -> 0;
                };
            }

            private static String infixToPostfix(String infix) {
                var postfix = new StringBuilder();
                var opstack = new Stack<Character>();
                String[] tokens = infix.split(" +");
                for (String token : tokens) {
                    var firstChar = token.charAt(0);
                    if (isOperator(firstChar)) {
                        if (!opstack.empty()) {
                            var topOp = opstack.peek();
                            while (!opstack.empty() && precedence(firstChar) <= precedence(topOp)) {
                                postfix.append(" ").append(opstack.pop());
                                if (!opstack.empty())
                                    topOp = opstack.peek();
                            }
                        }
                        opstack.push(firstChar);
                    } else if (Character.isDigit(firstChar)){
                        if (!postfix.isEmpty()) postfix.append(" ");
                        postfix.append(Integer.parseInt(token));
                    }
                    else
                        throw new Error("Syntax error");
                }
                while (!opstack.empty())
                    postfix.append(" " + opstack.pop());
                return postfix.toString();
            }
        }
    }
}
