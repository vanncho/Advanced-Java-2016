import java.util.*;

public class _09_UserLogs_Live {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> info = new TreeMap<>();

        while (true){
            String line = input.nextLine().trim();
            if (line.equals("end")){
                break;
            }

            String[] tokens = line.split("[= ]");
            String ipAddress = tokens[1];
            String userName = tokens[5];

            if (!info.containsKey(userName)){
                info.put(userName, new LinkedHashMap<String, Integer>());
                info.get(userName).put(ipAddress, 1);
            } else {
                int count = 0;
                if (info.get(userName).containsKey(ipAddress)){
                    count = info.get(userName).get(ipAddress);
                }

                info.get(userName).put(ipAddress, count + 1);
            }
        }

        for (String user : info.keySet()) {
            StringBuilder output = new StringBuilder();
            output.append(user + ": ");
            output.append("\n");

            LinkedHashMap<String, Integer> ipInfo = info.get(user);

            for (String ip : ipInfo.keySet()) {
                output.append(ip + " => " + ipInfo.get(ip) + ", ");
            }
            output.setLength(output.length() - 2);
            output.append(".");
            System.out.println(output);
        }
    }
}
