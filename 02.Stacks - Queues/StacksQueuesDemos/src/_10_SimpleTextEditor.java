import java.util.Scanner;
import java.util.Stack;

public class _10_SimpleTextEditor {
    static Stack<Character> textFile = new Stack<>();
    static Stack<String> undoOperations = new Stack<>();
    static Stack<String> undos = new Stack<>();

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        console.nextLine();

        for (int i = 0; i < n; i++) {
            String[] line = console.nextLine().split("\\s+");
            int command = Integer.parseInt(line[0]);
            String text = "";

            switch (command){
                case 1:
                    text = line[1];
                    append(text);
                    break;
                case 2:
                    int count = Integer.parseInt(line[1]);
                    erases(count);
                    break;
                case 3:
                    int index = Integer.parseInt(line[1]);
                    returns(index);
                    break;
                case 4:
                    undoes();
                    break;
            }
        }
    }

    private static void undoes() {
        if (undoOperations.size() > 0){
            String one = undoOperations.pop();
            undos.add(one);

            if (undoOperations.size() > 0){
                textFile.clear();

                if (undos.size() > 0){
                    undoOperations.add(undos.pop());

                    for (String s : undoOperations) {
                        for (int i = 0; i < s.length(); i++) {
                            textFile.add(s.charAt(i));
                        }
                    }
                } else{
                    for (String s : undoOperations) {
                        for (int i = 0; i < s.length(); i++) {
                            textFile.add(s.charAt(i));
                        }
                    }
                    undoOperations.add(one);
                }
            }
        }

    }

    private static void returns(int index) {

        if (textFile.size() >= index - 1){
            System.out.println(textFile.get(index - 1));
        }
    }

    private static void erases(int count) {

        StringBuilder sb = new StringBuilder(undoOperations.peek());

        if (sb.length() >= count){

            while (count > 0){

                if (sb.length() <= 0){
                    break;
                }
                sb.deleteCharAt(sb.length() - 1);
                textFile.pop();

                count--;
            }

            undoOperations.add(sb.toString());
        }
    }

    private static void append(String text) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            textFile.add(text.charAt(i));
            sb.append(text.charAt(i));
        }

        undoOperations.add(sb.toString());
    }
}
