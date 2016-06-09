import java.util.Scanner;
import java.util.Stack;

public class _07_BalancedParentheses {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String chars = console.nextLine();

        Stack<Character> bracketsList = new Stack<>();
        boolean isCorrect = true;

        for (int i = 0; i < chars.length(); i++) {
            char currChar = chars.charAt(i);

            if (currChar == '{' || currChar == '[' || currChar == '('){
                bracketsList.push(currChar);
            } else {
                if (currChar == '}'){
                    currChar = '{';
                } else if (currChar == ']'){
                    currChar = '[';
                } else if (currChar == ')'){
                    currChar = '(';
                }

                if (bracketsList.empty()){
                    isCorrect = false;
                    break;
                }

                if (currChar == bracketsList.peek()){
                    bracketsList.pop();
                } else {
                    isCorrect = false;
                    break;
                }
            }
        }

        if (!isCorrect){
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
