package lab.IO;

import lab.StaticData.ExceptionMessages;
import lab.StaticData.SessionData;

import java.util.LinkedList;
import java.io.File;

public class IOManager {

    public static void traverseFolder(String path){
        LinkedList<File> subFolders = new LinkedList<>();
        File root = new File(path);

        subFolders.add(root);

        while (subFolders.size() != 0){
            File currentFolder = subFolders.removeFirst();

            if (currentFolder.listFiles() != null){
                try{
                    for (File file : currentFolder.listFiles()) {

                        subFolders.add(file);
                    }
                } catch (Exception ex){
                    System.out.println("Access denied");
                }

            }

            System.out.println(currentFolder.toString());
        }
    }

    public static void traverseDirectory(int depth){
        LinkedList<File> subFolders = new LinkedList<>();

        String path = SessionData.currentPath;

        int initialIndentation = path.split("\\\\").length;
        //int initialIndentation = path.split("/").length; // under linux

        File root = new File(path);

        subFolders.add(root);

        while (subFolders.size() != 0){
            File currentFolder = subFolders.removeFirst();

            int currentIndentation = currentFolder.toString().split("\\\\").length - initialIndentation;
            //int currentIndentation = currentFolder.toString().split("/").length - initialIndentation; // under linux

            if (depth - currentIndentation < 0){
                break;
            }

            OutputWriter.writeMessageOnNewLine(currentFolder.toString());

            if (currentFolder.listFiles() != null){
                for (File file : currentFolder.listFiles()) {
                    if (file.isDirectory()){
                        subFolders.add(file);
                    } else{
                        int indexOfLastSlash = file.toString().lastIndexOf("\\");
                        //int indexOfLastSlash = file.toString().lastIndexOf("/"); // under linux

                        for (int i = 0; i < indexOfLastSlash; i++) {
                            OutputWriter.writeMessage("-");
                        }

                        OutputWriter.writeMessageOnNewLine(file.getName());
                    }
                }
            }
        }
    }

    public static void createDirectoryInCurrentFolder(String name){
        String path = getCurrentDirectoryPath() + "\\" + name;
        //String path = getCurrentDirectoryPath() + "/" + name; // under linux

        File file = new File(path);
        file.mkdir();
    }

    public static String getCurrentDirectoryPath(){
        String currentPath = SessionData.currentPath;
        return  currentPath;
    }

    public static void changeCurrentDirRelativePath(String relativePath){

        if (relativePath.equals("..")) {

            // go one directory up
            try {
                String currentPath = SessionData.currentPath;

                int indexOfLastSlash = currentPath.lastIndexOf("\\");
                //int indexOfLastSlash = currentPath.lastIndexOf("/"); // under linux

                String newPath = currentPath.substring(0, indexOfLastSlash);
                SessionData.currentPath = newPath;
            } catch (StringIndexOutOfBoundsException sioobe){
                OutputWriter.displayException(ExceptionMessages.INVALID_DESTINATION);
            }
        } else {

            // go to a given directory
            String currentPath = SessionData.currentPath;

            currentPath += "\\" + relativePath;
            //currentPath += "/" + relativePath; // under linux

            changeCurrentDirAbsolute(currentPath);
        }
    }

    public static void changeCurrentDirAbsolute(String absolutePath){

        File file = new File(absolutePath);
        if (!file.exists()){
            OutputWriter.displayException(ExceptionMessages.INVALID_PATH);
            return;
        }

        SessionData.currentPath = absolutePath;
    }
}