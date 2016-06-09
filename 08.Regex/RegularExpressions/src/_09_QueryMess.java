import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _09_QueryMess {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){

            String line = reader.readLine();
            if (line.equals("END") || line.equals("")){
                break;
            }

            String[] tokens = line.split("&|\\?");

            LinkedHashMap<String, List<String>> logs = new LinkedHashMap<>();
            for (int i = 0; i < tokens.length; i++) {

                String regex = "(.*)=(.*)";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(tokens[i]);

                if (matcher.find()) {

                    String keyForLogs = matcher.group(1);
                    keyForLogs = keyForLogs.replaceAll("%20", " ");
                    keyForLogs = keyForLogs.replaceAll("\\+", " ");
                    keyForLogs = keyForLogs.replaceAll("\\s+", " ");
                    keyForLogs = keyForLogs.trim();

                    String valueForLogs = matcher.group(2);
                    valueForLogs = valueForLogs.replaceAll("%20", " ");
                    valueForLogs = valueForLogs.replaceAll("\\+", " ");
                    valueForLogs = valueForLogs.replaceAll("\\s+", " ");
                    valueForLogs = valueForLogs.trim();

                    if (!logs.containsKey(keyForLogs)){
                        logs.put(keyForLogs, new ArrayList<>());
                    }

                    logs.get(keyForLogs).add(valueForLogs.trim());
                }
            }

            StringBuilder sb = new StringBuilder();
            for (String s : logs.keySet()) {

                sb.append(s + "=" + "[");

                List<String> vals = logs.get(s);
                for (String val : vals) {
                    sb.append(val + ", ");
                }

                sb.setLength(sb.length() - 2);
                sb.append("]");
            }

            System.out.println(sb.toString());
        }
    }
}
