package lab.IO;

import lab.StaticData.SessionData;
import lab.StaticData.CommandInterpreter;

import java.io.IOException;
import java.util.Scanner;

public class InputReader {

    private  static final String endCommand = "quit";

    public static void readCommands() throws IOException {

        OutputWriter.writeMessage(String.format("%s >", SessionData.currentPath));

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

        while (!input.equals(endCommand)){
            CommandInterpreter.interpretCommand(input);
            OutputWriter.writeMessage(String.format("%s > ", SessionData.currentPath));

            input = sc.nextLine().trim();
        }
    }
}
