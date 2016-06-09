import sun.reflect.generics.tree.Tree;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class _06_MinersTask {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        //String readLine = console.nextLine();
        int count = 1;
        String resource = "";
        Integer quantity = 0;
        LinkedHashMap<String, Integer> mine = new LinkedHashMap<>();

        while (true){

            String readLine = console.nextLine();
            if (readLine.equals("stop")){
                break;
            }
            resource = readLine;

            readLine = console.nextLine();
            if (readLine.equals("stop")){
                break;
            }
            quantity = Integer.parseInt(readLine);

            if (!mine.containsKey(resource)){
                mine.put(resource, quantity);
            } else{
                int newQuantity = mine.get(resource) + quantity;
                mine.put(resource, newQuantity);
            }
        }

        for (String s : mine.keySet()) {
            int val = mine.get(s);
            System.out.printf("%s -> %d", s, val).println();
        }
    }
}
