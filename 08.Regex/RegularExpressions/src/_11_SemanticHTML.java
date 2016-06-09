import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _11_SemanticHTML {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder htmlText = new StringBuilder();

        while (true){

            String line = reader.readLine();
            if (line.equals("END")) {
                break;
            }

            String idStartPattern = "\\s*<\\s*div.*(id\\s*=\\s*\"\\s*(\\w+)\\s*\")";
            String classStartPattern = "\\s*<\\s*div.*(class\\s*=\\s*\"\\s*(\\w+)\\s*\")";
            String endPattern = "\\s*<\\s*\\/div.*<\\s*!--\\s*(\\w+)\\s*--\\s*>";

            Pattern pattern = Pattern.compile(idStartPattern);
            Matcher matcher = pattern.matcher(line);
            boolean foundMatch = matcher.find();

            String found = "";
            String htmlAttribute = "";

            if (foundMatch){
                found = matcher.group(1);
                htmlAttribute = matcher.group(2);
            }

            if (!found.equals("") && !htmlAttribute.equals("")) {

                int leftSpaces = line.indexOf('<');
                line = processOpenTags(line, found, htmlAttribute, leftSpaces);
            } else if (found.equals("") && htmlAttribute.equals("")) {

                pattern = Pattern.compile(classStartPattern);
                matcher = pattern.matcher(line);
                foundMatch = matcher.find();

                if (foundMatch) {
                    found = matcher.group(1);
                    htmlAttribute = matcher.group(2);
                }

                if (!found.equals("") && !htmlAttribute.equals("")) {

                    int leftSpaces = line.indexOf('<');
                    line = processOpenTags(line, found, htmlAttribute, leftSpaces);
                } else if (found.equals("") && htmlAttribute.equals("")) {

                    pattern = Pattern.compile(endPattern);
                    matcher = pattern.matcher(line);
                    foundMatch = matcher.find();

                    if (foundMatch) {
                        found = matcher.group(1);
                        int leftSpaces = line.indexOf('<');
                        String spasesInLeft = padLeftWithSpaces(leftSpaces);

                        switch (found){

                            case "main":
                                line = spasesInLeft + "</main>";
                                break;
                            case "header":
                                line = spasesInLeft + "</header>";
                                break;
                            case "nav":
                                line = spasesInLeft + "</nav>";
                                break;
                            case "article":
                                line = spasesInLeft + "</article>";
                                break;
                            case "section":
                                line = spasesInLeft + "</section>";
                                break;
                            case "aside":
                                line = spasesInLeft + "</aside>";
                                break;
                            case "footer":
                                line = spasesInLeft + "</footer>";
                                break;
                        }
                    }
                }
            }

            htmlText.append(line + "\n");
        }

        System.out.println(htmlText);
    }

    private static String processOpenTags(String line, String found, String htmlAttribute, int leftSpaces) {

        if (htmlAttribute.equals("main") || htmlAttribute.equals("header") || htmlAttribute.equals("nav") | htmlAttribute.equals("article") |
                htmlAttribute.equals("section") | htmlAttribute.equals("aside") | htmlAttribute.equals("footer")) {

            String spasesInLeft = padLeftWithSpaces(leftSpaces);


            line = line.replaceFirst(found, "");
            line = line.replaceAll("\\s+", " ");
            line = line.replaceFirst("\\s*<\\s*div", spasesInLeft + "<" + htmlAttribute);
            line = line.replaceFirst("\\s*>", ">");
        }

        return line;
    }

    private static String padLeftWithSpaces(int leftSpaces){

        StringBuilder spaces = new StringBuilder();

        for (int i = 0; i < leftSpaces; i++) {
            spaces.append(" ");
        }

        return spaces.toString();
    }
}
