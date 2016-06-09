import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _08_ExtractHyperlinks {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder text = new StringBuilder();

        while (true){
            String line = br.readLine();

            if (line.equals("END")){
                break;
            }
            text.append(line);
        }

        String regex = "<a\\s+([^>]+\\s+)?href\\s*=\\s*('([^']*)'|\"([^\"]*)|([^\\s>]+))[^>]*>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text.toString());

        while (matcher.find()){

            String match = matcher.group(3);
            if (match == null){
                match = matcher.group(4);

                if (match == null){
                    match = matcher.group(5);
                    System.out.println(match);
                } else {
                    System.out.println(match);
                }
            } else {
                System.out.println(match);
            }
        }
    }
}
