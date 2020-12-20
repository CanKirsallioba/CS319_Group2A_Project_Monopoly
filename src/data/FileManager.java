package data;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

/**
 * FileManager manages and stores the name of the files for configuration and save data files
 */
public class FileManager {
    final static int MAX_SIZE = 0;
    private static ArrayList<String> configList = new ArrayList<>();
    private static ArrayList<String> sessionNames = new ArrayList<>();

    /**
     * Getter method for max size for files
     * @return max size constant
     */
    public static int getMaxSize() {
        return MAX_SIZE;
    }

    /**
     * This method returns the file names of all saved files
     *  used for load data selection in view
     *  save files all start with saveFile_
     * @return an arraylist of saved session file names
     */
    public static ArrayList<String> getSavedSessionNames(){

        //initialize save files
        if(sessionNames.size() == 0){
            File dir = new File(System.getProperty("user.dir"));
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.startsWith("saveFile_");
                }
            };
            String[] pathnames = dir.list(filter);

            for (String name : pathnames) {
                sessionNames.add( name);
                System.out.println(name);
            }
        }
        return sessionNames;
    }

    /**
     * This method returns the saved configuration file names (different board configs)
     * used for board selection in view
     * config files all start with board_
     * @return an arraylist of file names of the configuration JSON files
     */
    public static ArrayList<String> getBoardConfigNames(){

        //initialize config files
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


    /**
     * This method adds newly created configuration files to file manager
     * @param fileName of new config file
     */
    public static void addBoardConfigName(String fileName) {
        configList.add( fileName);
    }

    /**
     * This method adds newly created save files to file manager
     * @param fileName of new save file
     */
    public static void addGameSaveFile(String fileName) {
        sessionNames.add( fileName);
    }

}