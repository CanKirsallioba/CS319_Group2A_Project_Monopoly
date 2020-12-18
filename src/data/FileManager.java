package data;

import java.util.ArrayList;

public class FileManager {
    final static int MAX_SIZE = 0;
    private static ArrayList<String> configList = new ArrayList<String>() {
        {
            add("templateConfig.json");
        }
    };
    private static ArrayList<String> sessionNames;

    public static int getMaxSize() {

        return -1;
    }

    public static ArrayList<String> getSavedSessionNames(){
        return sessionNames;
    }

    //???
    //public String getSessionLocation( String sessionName){
    //  return;
    //}

    public static ArrayList<String> getBoardConfigNames(){
        return configList;
    }

    public static void addBoardConfigName(String fileName) {
        configList.add( fileName);
    }
}