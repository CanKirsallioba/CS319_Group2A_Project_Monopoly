package model;

import data.ConfigHandler;
import data.FileManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class BoardBuilder {
    private ConfigHandler configHandler = new ConfigHandler();

    JSONObject configTemplate = configHandler.getConfigTemplate();

    public void changePropertyValues(int tileIndex, String tileName, int level0rent, int level1rent, int level2rent, int level3rent, int level4rent, int level5rent,
                                     int upgradeCost, int propertyValue, int mortgageValue) {
        JSONArray tileConfigs = (JSONArray) configTemplate.get("tiles");
        for (Object tileConfig : tileConfigs) {
            JSONObject tileObj = (JSONObject) ((JSONObject) tileConfig).get("tile");
            if (((Long) tileObj.get("tileIndex")).intValue() == tileIndex) {
                tileObj.put("tileName", tileName);
                tileObj.put("price", propertyValue);
                tileObj.put("upgradeCost", upgradeCost);
                tileObj.put("rentLevel0", level0rent);
                tileObj.put("rentLevel1", level1rent);
                tileObj.put("rentLevel2", level2rent);
                tileObj.put("rentLevel3", level3rent);
                tileObj.put("rentLevel4", level4rent);
                tileObj.put("rentLevel5", level5rent);
                tileObj.put("mortgageValue", mortgageValue);
            }
        }
    }

    public void changeBoardValues(int salary, String boardName) {
        JSONObject boardConfigs = (JSONObject) configTemplate.get("boardConfig");
        boardConfigs.put("salary", salary);
        boardConfigs.put("boardName", boardName);
    }

    public void saveBoard() {
        String fileName = configHandler.createConfig(configTemplate);
        FileManager.addBoardConfigName( fileName);
    }
}
