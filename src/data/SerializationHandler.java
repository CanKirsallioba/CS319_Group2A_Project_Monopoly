package data;

import model.session.GameSession;

import java.io.*;
import java.util.ArrayList;

public class SerializationHandler {
    public String save(GameSession data) throws IOException {

        try {
            System.out.println( data.getGameSessionName());
            String fileName = data.getGameSessionName() + ".bin";
            File parent = new File(System.getProperty("user.dir"));
            File saveFile = new File(parent, fileName);
            FileOutputStream f = new FileOutputStream(saveFile);
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write gameSession to file
            o.writeObject(data);
            o.close();
            f.close();

            return fileName;

        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        }
    }

    public GameSession load(String gameSessionName) throws IOException, ClassNotFoundException {

        try {
            String fileName = gameSessionName + ".bin";
            FileInputStream fi = new FileInputStream(new File(fileName));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            GameSession game = (GameSession) oi.readObject();
            oi.close();
            fi.close();

            return game;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public ArrayList<String> getSavedGames() {
        return FileManager.getSavedSessionNames();
    }
}
