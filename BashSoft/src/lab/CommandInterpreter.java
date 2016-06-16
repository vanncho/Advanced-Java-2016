package lab;

import lab.IO.IOManager;
import lab.IO.OutputWriter;
import lab.Judge.Tester;
import lab.Network.DownloadManager;
import lab.Repository.StudentsRepository;
import lab.StaticData.SessionData;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CommandInterpreter {

    public static void interpretCommand(String input) throws IOException {
        String[] data = input.split("\\s+");
        String command = data[0];

        switch (command){
            case "open":
                tryOpenFile(input, data);
                break;
            case "mkdir":
                tryCreateDirectory(input, data);
                break;
            case "ls":
                tryTraverseFolders(input, data);
                break;
            case "cmp":
                tryCompareFiles(input, data);
                break;
            case "changeDirRel":
                tryChangeRelativePath(input, data);
                break;
            case "changeDirAbs":
                tryChangeAbsolutePath(input, data);
                break;
            case "readDb":
                tryReadDatabaseFromFile(input, data);
                break;
            case "filter":
                tryPrintFilteredStudents(input, data);
                break;
            case "order":
                tryPrintOrderedStudents(input, data);
                break;
            case "download":
                tryDownloadFile(input, data);
                break;
            case "downloadAsynch":
                tryDownloadFileOnNewThread(input, data);
                break;
            case "help":
                // TODO:
                break;
            case "show":
                tryShowWantedCourse(input, data);
                break;
            default:
                displayInvalidCommandMessage(input);
                break;
        }
    }

    public static void displayInvalidCommandMessage(String input){

        String output = String.format("The command '%s' is invalid", input);
        OutputWriter.writeMessage(output);
    }

    private static void tryOpenFile(String input, String[] data) throws IOException {
        if (data.length != 2){
            displayInvalidCommandMessage(input);
            return;
        }

        String fileName = data[1];
        String filePath = SessionData.currentPath + "\\" + fileName;
        File file = new File(filePath);
        Desktop.getDesktop().open(file);
    }

    private static void tryCreateDirectory(String input, String[] data) {
        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }

        String folderName = data[1];
        IOManager.createDirectoryInCurrentFolder(folderName);
    }

    private static void tryTraverseFolders(String input, String[] data){

        if (data.length != 1 && data.length != 2){
            displayInvalidCommandMessage(input);
            return;
        }

        if (data.length == 1){
            IOManager.traverseDirectory(0);
        }

        if (data.length == 2){
            IOManager.traverseDirectory(1);   /// !!!
        }
    }

    private static void tryCompareFiles(String input, String[] data) {
        if (data.length != 3){
            displayInvalidCommandMessage(input);
            return;
        }

        String firstPath = data[1];
        String secondPath = data[2];
        Tester.compareContent(firstPath, secondPath);
    }

    private static void tryChangeRelativePath(String input, String[] data){

        if (data.length != 2){
            displayInvalidCommandMessage(input);
            return;
        }

        String relativePath = data[1];
        IOManager.changeCurrentDirRelativePath(relativePath);
    }

    private static void tryChangeAbsolutePath(String input, String[] data){

        if (data.length != 2){
            displayInvalidCommandMessage(input);
            return;
        }

        String absolutePath = data[1];
        IOManager.changeCurrentDirAbsolute(absolutePath);
    }

    private static void tryReadDatabaseFromFile(String input, String[] data) throws IOException {

        if (data.length != 2){
            displayInvalidCommandMessage(input);
            return;
        }

        String fileName = data[1];
        StudentsRepository.initializeData(fileName);
    }

    private static void tryShowWantedCourse(String input, String[] data){

        if (data.length != 2 && data.length != 3){
            displayInvalidCommandMessage(input);
            return;
        }

        if (data.length == 2){
            String courseName = data[1];
            StudentsRepository.getStudentsByCourse(courseName);
        }

        if (data.length == 3){
            String courseName = data[1];
            String userName = data[2];
            StudentsRepository.getStudentMarksInCourse(courseName, userName);
        }
    }

    private static void tryPrintOrderedStudents(String input, String[] data) {
        if (data.length != 3 && data.length != 4){
            displayInvalidCommandMessage(input);
            return;
        }

        String course = data[1];
        String comparisonType = data[2];
        Integer numberOfStudents = null;
        if (data.length == 4){
            numberOfStudents = Integer.parseInt(data[3]);
        }

        StudentsRepository.printOrderedStudents(course, comparisonType, numberOfStudents);
    }

    private static void tryPrintFilteredStudents(String input, String[] data) {
        if (data.length != 3 && data.length != 4){
            displayInvalidCommandMessage(input);
            return;
        }

        String course = data[1];
        String filter = data[2];
        Integer numberOfStudents = null;
        if (data.length == 4){
            numberOfStudents = Integer.parseInt(data[3]);
        }

        StudentsRepository.printFilteredStudents(course, filter, numberOfStudents);
    }

    private static void tryDownloadFileOnNewThread(String input, String[] data) {
        if (data.length != 2){
            displayInvalidCommandMessage(input);
            return;
        }
        String fileUrl = data[1];
        DownloadManager.downloadOnNewThread(fileUrl);
    }

    private static void tryDownloadFile(String input, String[] data) {
        if (data.length != 2){
            displayInvalidCommandMessage(input);
            return;
        }

        String fileUrl = data[1];
        DownloadManager.download(fileUrl);
    }
}
