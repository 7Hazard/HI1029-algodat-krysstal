package f3;

public class nb4 {
    public static void main(String[] args) {
        System.out.println(isBalanced("(w * (x + y) I z - (p I (r - q))) "));
    }

    private static boolean isBalanced(String expression) {
        int paraCount = 0, squareCount = 0, curlyCount = 0;
        for (int i = 0; i < expression.length(); i++) {
            var c = expression.charAt(i);

            // todo direkt se ifall en dålig parantes läggs till
            if(c == '(') paraCount++;
            else if(c == ')') paraCount--;
            else if(c == '[') squareCount++;
            else if(c == ']') squareCount--;
            else if (c == '{') curlyCount++;
            else if (c == '}') curlyCount--;
        }

        return paraCount == 0
                && squareCount == 0
                && curlyCount == 0;
    }


}
