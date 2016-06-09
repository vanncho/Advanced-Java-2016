import java.util.LinkedHashMap;
import java.util.Scanner;

public class _07_FixEmails {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        LinkedHashMap<String, String> mailList = new LinkedHashMap<>();
        String name = "";
        String mail = "";

        while (true){
            String readLine = console.nextLine();
            if (readLine.equals("stop")){
                break;
            }
            name = readLine;

            readLine = console.nextLine();
            if (readLine.equals("stop")){
                break;
            }
            mail = readLine;

            if (mail.endsWith("uk") || mail.endsWith("us")){
                continue;
            }

            mailList.put(name, mail);
        }

        for (String s : mailList.keySet()) {
            String email = mailList.get(s);
            System.out.printf("%s -> %s", s, email).println();
        }
    }
}
