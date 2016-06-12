import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _12_LittleJohn {
    public static void main(String[] args) throws IOException {

        int bigCount = 0;
        int mediumCount = 0;
        int smallCount = 0;
        StringBuilder lines = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String line = reader.readLine();

            if (!line.equals("")){
                for (int i = 0; i < 4; i++) {
                    lines.append(line);
                    lines.append("\\n");
                    line = reader.readLine();
                }
            }

            String regex = "(>>>----->>)|(>>----->)|(>----->)";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(lines);

            while (matcher.find()){

                if (matcher.group(1) != null){
                    bigCount++;
                }

                if (matcher.group(2) != null){
                    mediumCount++;
                }
                if (matcher.group(3) != null){
                    smallCount++;
                }
            }
        }

        StringBuilder concat = new StringBuilder();
        concat.append(smallCount);
        concat.append(mediumCount);
        concat.append(bigCount);

        String toBin = Integer.toString(Integer.valueOf(concat.toString()), 2);
        StringBuilder reversed = new StringBuilder();

        for (int i = toBin.length() - 1; i >= 0; i--) {
            reversed.append(toBin.charAt(i));
        }

        concat = new StringBuilder();
        concat.append(toBin);
        concat.append(reversed);
        int foo = Integer.parseInt(concat.toString(), 2);
        System.out.println(foo);
    }
}
