import java.util.Scanner;

public class _15_MelrahShake {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String string = console.nextLine();
        String pattern = console.nextLine();

        if (string.length() > 0 || pattern.length() < 1 && !string.equals("")){
            StringBuilder shaker = new StringBuilder();
            shaker.append(string);
            StringBuilder patternSb = new StringBuilder();
            patternSb.append(pattern);

            int firstMatch = string.indexOf(pattern);
            int lastMatch = string.lastIndexOf(pattern);

            while (true){

                while (firstMatch > - 1 && lastMatch > -1){

                    shaker.delete(lastMatch, lastMatch + patternSb.length());
                    shaker.delete(firstMatch, firstMatch + patternSb.length());
                    System.out.println("Shaked it.");
                    patternSb.deleteCharAt(patternSb.length() / 2);

                    if (patternSb.length() <= 0){
                        break;
                    }

                    firstMatch = shaker.indexOf(patternSb.toString());
                    lastMatch = shaker.lastIndexOf(patternSb.toString());
                }

                if ((firstMatch > - 1 || lastMatch > -1) || (firstMatch == - 1 || lastMatch == -1)) {
                    System.out.println("No shake.");
                    break;
                }
            }

            System.out.println(shaker);
        }
        else{
            System.out.println("No shake.");
        }
    }
}
