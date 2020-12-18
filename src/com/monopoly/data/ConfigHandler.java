package com.monopoly.data;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfigHandler {

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

    public String createConfig(  JSONObject config){
        String fileName;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = df.format(new Date());
        JSONObject boardConfig = (JSONObject) config.get("boardConfig");
        fileName = boardConfig.get("boardName") + "_" + formatted + ".json";

        //Write JSON file with given configurations
        try (FileWriter file = new FileWriter(fileName)) {

            file.write(config.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    public JSONObject getConfigTemplate(){
        return getConfig("templateConfig.json");
    }
}

