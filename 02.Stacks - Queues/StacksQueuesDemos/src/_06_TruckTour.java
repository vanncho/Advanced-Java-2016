import java.util.ArrayDeque;
import java.util.Scanner;

public class _06_TruckTour {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        ArrayDeque<Station> queue = new ArrayDeque<>();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            int gas = Integer.valueOf(tokens[0]);
            int distance = Integer.valueOf(tokens[1]);

            Station station = new Station();
            station.gasGiven = gas;
            station.distanceNext = distance;

            queue.addLast(station);
        }

        Integer gasInTank = 0;
        boolean foundFirst = false;
        Integer index = 0;

        while (true) {
            Station current = queue.removeFirst();
            gasInTank += current.gasGiven;
            queue.addLast(current);

            Station first = current;
            Integer indexAddUp = 1;

            while (gasInTank >= current.distanceNext){
                gasInTank -= current.distanceNext;
                current = queue.removeFirst();
                queue.addLast(current);
                gasInTank += current.gasGiven;
                indexAddUp++;

                if (current == first){
                    foundFirst = true;
                    break;
                }
            }

            if (foundFirst){
                break;
            }

            index += indexAddUp;
            gasInTank = 0;
        }

        System.out.println(index);
    }
}

class Station {
    int gasGiven;
    int distanceNext;
}
