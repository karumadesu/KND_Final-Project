package main;

import java.io.*;

public class LoadAccount{
    GamePanel gamePanel;
    BufferedReader reader;

    String username;
    String line;

    LoadAccount(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        
        username = String.valueOf(gamePanel.playerName[0]) + String.valueOf(gamePanel.playerName[1]) + 
        String.valueOf(gamePanel.playerName[2]);
    }

    public void loadUsers(){
        try{
            reader = new BufferedReader(new FileReader("./src/records/accountRecords.txt"));
            line = reader.readLine();

            for(int i = 0; i < 6; i++){
                for(int j = 0; j < 3; j++){
                    if(line != null){
                        gamePanel.loadedAccounts[i][j] = line;
                        line = reader.readLine();
                    }
                    else{
                        break;
                    }
                }
            }

            reader.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
