package lab.IO;

import lab.CommandInterpreter;
import lab.StaticData.SessionData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {

    private  static final String END_COMMNAD = "quit";

    public static void readCommands() throws IOException {
        OutputWriter.writeMessage(String.format("%s >", SessionData.currentPath));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();

        while (!input.equals(END_COMMNAD)){
            CommandInterpreter.interpretCommand(input);
            OutputWriter.writeMessage(String.format("%s > ", SessionData.currentPath));

            input = reader.readLine().trim();
        }

        Thread[] threads = new Thread[Thread.activeCount()];
        Thread.enumerate(threads);
        for (Thread thread : threads) {
            if(!thread.getName().equals("main") && !thread.isDaemon()){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    OutputWriter.displayException(e.getMessage());
                }
            }
        }
    }
}
