import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class _03_WordCount {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Integer> wordOccurances = new TreeMap<>();

        File fileWithWords = new File("/media/vancho/8C7609A276098E60/TELERIK/Java SoftUni/05.Files-And-Folders/Exercises/04_WordCount/words1.txt");
        File fileWithText = new File("/media/vancho/8C7609A276098E60/TELERIK/Java SoftUni/05.Files-And-Folders/Exercises/04_WordCount/text1.txt");
        File fileOutput = new File("/media/vancho/8C7609A276098E60/TELERIK/Java SoftUni/05.Files-And-Folders/Exercises/04_WordCount/output1.txt");

        String readLine = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileWithWords))){

            readLine = bufferedReader.readLine();
            String[] searchedWords = readLine.split("\\s+");

            for (int i = 0; i < searchedWords.length; i++) {

                String currentWord = searchedWords[i];
                String readLineFromText = null;
                try (BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileWithText))) {

                    while ((readLineFromText = bufferedReader1.readLine()) != null) {
                        String[] allWordsInLine = readLineFromText.split("\\W+");

                        for (int j = 0; j < allWordsInLine.length; j++) {

                            String splittedWord = allWordsInLine[j].toLowerCase();

                            if (currentWord.toLowerCase().equals(splittedWord)){
                                if (!wordOccurances.containsKey(currentWord)) {
                                    wordOccurances.put(currentWord, 1);
                                } else {
                                    wordOccurances.computeIfPresent(currentWord, (k, v) -> v + 1);
                                }
                            }
                        }
                    }
                }
            }
        }

        // sort by value
        LinkedHashMap<String, Integer> sortedWordOccurances = wordOccurances
                .entrySet()
                .stream()
                .sorted((v1, v2) -> v2.getValue().compareTo(v1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (c1, c2) -> c1, LinkedHashMap::new));

        // write result to file
        try (BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(fileOutput, true))){

            for (String s : sortedWordOccurances.keySet()) {
                bufferWriter.write(s + " - " + sortedWordOccurances.get(s));
                bufferWriter.newLine();
            }
        }
    }
}
