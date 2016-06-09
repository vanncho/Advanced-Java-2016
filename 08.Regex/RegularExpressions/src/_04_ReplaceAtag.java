import java.util.Scanner;

public class _04_ReplaceAtag {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StringBuilder output = new StringBuilder();

        while (true){
            String line = input.nextLine();

            if (line.equals("end")){
                break;
            }

            line = line.replaceAll("<a", "[URL");
            line = line.replaceAll("</a>", "[/URL]");
            output.append(line);
        }

        System.out.println(output);
    }
}
