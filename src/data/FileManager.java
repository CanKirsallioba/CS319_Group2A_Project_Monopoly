package data;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class FileManager {
    final static int MAX_SIZE = 0;
    private static ArrayList<String> configList = new ArrayList<>();
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

        if(configList.size() == 0){
            File dir = new File(System.getProperty("user.dir"));
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.startsWith("board_");
                }
            };
            String[] pathnames = dir.list(filter);

            for (String name : pathnames) {
                configList.add( name);
                System.out.println(name);
            }
        }

        return configList;
    }

    public static void addBoardConfigName(String fileName) {
        configList.add( fileName);
    }
}