import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _14_LegoBlocks {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        List<int[]> first = new ArrayList<>();
        List<int[]> second = new ArrayList<>();
        List<Integer> rowLength = new ArrayList<>();

        int firstCount = 0;
        int secondCount = 0;
        input.nextLine();

        for (int i = 0; i < 2 * n; i++)
        {
            String line = input.nextLine().trim();
            String[] tokens = line.split("\\s+");
            int[] normalNumbers = new int[tokens.length];

            for (int j = 0; j < normalNumbers.length; j++) {
                int currNum = Integer.parseInt(tokens[j]);
                normalNumbers[j] = currNum;
            }

            int currentRowSum = 0;

            if (i < n)
            {
                first.add(normalNumbers);
                firstCount += normalNumbers.length;
                currentRowSum += normalNumbers.length;
            }
            else
            {
                int[] reversedNumbers = reverseArray(normalNumbers);
                second.add(reversedNumbers);
                secondCount += reversedNumbers.length;
                currentRowSum += reversedNumbers.length;
            }
        }

        // sum rows length
        boolean equal = true;

        for (int i = 0; i < first.size(); i++)
        {
            rowLength.add(first.get(i).length + second.get(i).length);
        }

        // check rows lenghts
        int length = first.get(0).length + second.get(0).length;
        for (int i = 0; i < rowLength.size(); i++)
        {
            if (length != first.get(i).length + second.get(i).length)
            {
                equal = false;
            }
        }

        if (equal)
        {
            for (int i = 0; i < first.size(); i++)
            {
                int ind = 0;
                System.out.printf("[");
                for (int j = 0; j < first.get(i).length + second.get(i).length; j++)
                {
                    if (j < first.get(i).length)
                    {
                        System.out.printf("%d, ", first.get(i)[j]);
                    }
                    else
                    {
                        if (ind < second.get(i).length - 1)
                        {
                            System.out.printf("%d, ", second.get(i)[ind]);
                        }
                        else
                        {
                            System.out.printf("%d", second.get(i)[ind]);
                        }

                        ind++;
                    }
                }
                System.out.println("]");
            }
        }
        else
        {
            System.out.printf("The total number of cells is: %d", firstCount + secondCount);
        }
    }

    private static int[] reverseArray(int[] normalNumbers) {
        int[] arrayToreturn = new int[normalNumbers.length];

        for (int i = 0; i < arrayToreturn.length; i++) {
            arrayToreturn[i] = normalNumbers[normalNumbers.length - 1 - i];
        }

        return arrayToreturn;
    }
}
