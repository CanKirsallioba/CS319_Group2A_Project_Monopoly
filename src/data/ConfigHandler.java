package data;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfigHandler {

    /**
     * This method gets the configuration JSON file name
     * and generates a JSON object (read method) from file
     * the configuration file has board configurations (custom or default)
     * @param configName name of JSON configuration file
     * @return the JSONObject read/parsed from the file
     */
    public JSONObject getConfig( String configName){
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        JSONObject config = new JSONObject();

        try (FileReader reader = new FileReader(configName))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            config = (JSONObject) obj;

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return config;
    }

    /**
     * This method creates the JSON configuration file
     * with the given JSON object
     * @param config the JSONObject to be written to a .json file
     * @return the filename of the configuration file that is created to pass to file manager
     */
    public String createConfig(  JSONObject config){
        String fileName;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = df.format(new Date());
        JSONObject boardConfig = (JSONObject) config.get("boardConfig");
        fileName = "board_" + boardConfig.get("boardName") + "_" + formatted + ".json";

        //Write JSON file with given configurations
        try (FileWriter file = new FileWriter(fileName)) {

            file.write(config.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    /**
     * This method returns the JSONObject read from the default board configurations (classic game board)
     * @return the JSONObject of board configurations of classic board
     */
    public JSONObject getConfigTemplate(){
        return getConfig("board_template.json");
    }
}

