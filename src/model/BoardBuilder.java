package model;

import data.ConfigHandler;
import data.FileManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * BoardBuilder class is responsible for building the board in the customization screen with changed values
 * of properties and board configurations
 */
public class BoardBuilder {
    private ConfigHandler configHandler = new ConfigHandler();

    JSONObject configTemplate = configHandler.getConfigTemplate();

    /**
     * Getter for the configurations template that board builder is working on/changing on
     * @return JSONObject of the configuration of board builder
     */
    public JSONObject getConfigTemplate() {
        return configTemplate;
    }

    /**
     * Setter for the configurations template that board builder is working on/changing on
     * @param configTemplate to give to board builder
     */
    public void setConfigTemplate(JSONObject configTemplate) {
        this.configTemplate = configTemplate;
    }

    /**
     * Method for changing a modified property's values from board builder
     * @param tileIndex is tile index of changed property
     * @param tileName is tile name of the property
     * @param level0rent is the base rent of property
     * @param level1rent is the rent level1 value
     * @param level2rent is the rent level 2 value
     * @param level3rent is the rent level 3 value
     * @param level4rent is the rent level 4 value
     * @param level5rent is the rent level 5 value
     * @param upgradeCost is the upgrade cost of property
     * @param propertyValue property value
     * @param mortgageValue mortgage value
     */
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

    /**
     * Method changes the board configurations in board builder
     * @param salary is the board salary
     * @param boardName of board
     */
    public void changeBoardValues(int salary, String boardName) {
        JSONObject boardConfigs = (JSONObject) configTemplate.get("boardConfig");
        boardConfigs.put("salary", salary);
        boardConfigs.put("boardName", boardName);
    }

    /**
     * Method saves the new board configuration as a file to be used in the game in selection
     * customized board creation
     */
    public void saveBoard() {
        String fileName = configHandler.createConfig(configTemplate);
        FileManager.addBoardConfigName( fileName);
    }
}
