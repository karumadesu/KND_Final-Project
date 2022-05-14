package main;

import java.io.*;

public class LoadTrivia{
    GamePanel gamePanel;
    BufferedReader reader;

    String line;
    int lineCount = 0;

    public LoadTrivia(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void loadTrivia(){
        try{
            reader = new BufferedReader(new FileReader("./src/records/trivia.txt"));
            line = reader.readLine();

            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 2; j++){
                    gamePanel.factsTrivia[i][j] = line;
                    line = reader.readLine();
                }
            }

            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 5; j++){
                    gamePanel.fightsTrivia[i][j] = line;
                    line = reader.readLine();
                }
            }
            
            reader.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
