import java.util.HashSet;
import java.util.Scanner;

public class _18_ParkingSystem {
    private static int rows;
    private static int cols;
    final static HashSet<String> takenSlots = new HashSet<>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        rows = input.nextInt();
        cols = input.nextInt();
        input.nextLine();

        while (true){
            String[] line = input.nextLine().split(" ");

            if (line[0].equals("stop")){
                break;
            }

            int entryRow = Integer.parseInt(line[0]);
            int wantedRow = Integer.parseInt(line[1]);
            int wantedCol = Integer.parseInt(line[2]);
            int steps = Math.abs(wantedRow - entryRow) + wantedCol + 1;
            if (wantedCol >= cols || wantedCol <= 0){
                System.out.printf("Row %d full%n", wantedRow);
                continue;
            }
            String wantedSpot = wantedRow + " " + wantedCol;

            if (takenSlots.contains(wantedSpot)){
                int mod = 1;

                while (true){
                    int newColLeft = attemptLeft(mod, wantedCol, wantedRow, steps);
                    if (newColLeft > 0){
                        steps = Math.abs(wantedRow - entryRow) + newColLeft + 1;
                        System.out.println(steps);
                        break;
                    }

                    int newColRight = attemptRight(mod, wantedCol, wantedRow, steps);
                    if (newColRight > 0){
                        steps = Math.abs(wantedRow - entryRow) + newColRight + 1;
                        System.out.println(steps);
                        break;
                    }

                    if (newColLeft == -2 && newColRight == -2){
                        System.out.printf("Row %d full%n", wantedRow);
                        break;
                    }
                    mod++;
                }
            } else {
                takenSlots.add(wantedSpot);
                System.out.println(steps);
            }
        }
    }

    private static int attemptRight(int mod, int wantedCol, int wantedRow, int steps) {
        int newCol = wantedCol + mod;
        if (newCol >= cols){
            return -2;
        }
        String newSpot = wantedRow + " " + newCol;

        if (takenSlots.contains(newSpot)){
            return -1;
        } else{
            takenSlots.add(newSpot);
            return newCol;
        }
    }

    private static int attemptLeft(int mod, int wantedCol, int wantedRow, int steps) {
        int newCol = wantedCol - mod;
        if (newCol <= 0){
            return -2;
        }
        String newSpot = wantedRow + " " + newCol;

        if (takenSlots.contains(newSpot)){
            return -1;
        } else{
            takenSlots.add(newSpot);
            return newCol;
        }
    }
}
