package main;

import java.io.*;

public class UserChecker{
    GamePanel gamePanel;
    BufferedReader reader;

    String username;
    String line;
    int lineCount = 0;

    UserChecker(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void checkUser(){
        username = String.valueOf(gamePanel.playerName[0]) + String.valueOf(gamePanel.playerName[1]) + 
        String.valueOf(gamePanel.playerName[2]);

        try{
            reader = new BufferedReader(new FileReader("./src/records/accountRecords.txt"));
            line = reader.readLine();

            while(line != null){
                if(username.equals(line.trim())){
                    gamePanel.isTaken = true;
                }

                line = reader.readLine();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
