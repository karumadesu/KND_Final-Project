package main;

import java.io.*;

public class SaveRecords{
    GamePanel gamePanel;
    
    FileWriter writer;
    String username;
    boolean hasSaved = false;

    public SaveRecords(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void saveRecords(){
        if(gamePanel.difficulty.equals("Easy")){
            if(gamePanel.level == 0){
                try{
                    writer = new FileWriter("./src/records/level_1_easy.txt", true);
                    writer.write(String.valueOf(gamePanel.playerName[0]) + String.valueOf(gamePanel.playerName[1]) + 
                                String.valueOf(gamePanel.playerName[2]) + "\n");
                    writer.write(gamePanel.player.playerScore + "\n");
                    writer.write(gamePanel.playMinute + "m " + String.format("%.0f", gamePanel.playSecond) + "s" + "\n");
                    writer.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            else if(gamePanel.level == 1){
                try{
                    writer = new FileWriter("./src/records/level_2_easy.txt", true);
                    writer.write(String.valueOf(gamePanel.playerName[0]) + String.valueOf(gamePanel.playerName[1]) + 
                                String.valueOf(gamePanel.playerName[2]) + "\n");
                    writer.write(gamePanel.player.playerScore + "\n");
                    writer.write(gamePanel.playMinute + "m " + String.format("%.0f", gamePanel.playSecond) + "s" + "\n");
                    writer.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            else if(gamePanel.level == 2){
                try{
                    writer = new FileWriter("./src/records/level_3_easy.txt", true);
                    writer.write(String.valueOf(gamePanel.playerName[0]) + String.valueOf(gamePanel.playerName[1]) + 
                                String.valueOf(gamePanel.playerName[2]) + "\n");
                    writer.write(gamePanel.player.playerScore + "\n");
                    writer.write(gamePanel.playMinute + "m " + String.format("%.0f", gamePanel.playSecond) + "s" + "\n");
                    writer.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        else if(gamePanel.difficulty.equals("Hard")){
            if(gamePanel.level == 0){
                try{
                    writer = new FileWriter("./src/records/level_1_hard.txt", true);
                    writer.write(String.valueOf(gamePanel.playerName[0]) + String.valueOf(gamePanel.playerName[1]) + 
                                String.valueOf(gamePanel.playerName[2]) + "\n");
                    writer.write(gamePanel.player.playerScore + "\n");
                    writer.write(gamePanel.playMinute + "m " + String.format("%.0f", gamePanel.playSecond) + "s" + "\n");
                    writer.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            else if(gamePanel.level == 1){
                try{
                    writer = new FileWriter("./src/records/level_2_hard.txt", true);
                    writer.write(String.valueOf(gamePanel.playerName[0]) + String.valueOf(gamePanel.playerName[1]) + 
                                String.valueOf(gamePanel.playerName[2]) + "\n");
                    writer.write(gamePanel.player.playerScore + "\n");
                    writer.write(gamePanel.playMinute + "m " + String.format("%.0f", gamePanel.playSecond) + "s" + "\n");
                    writer.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            else if(gamePanel.level == 2){
                try{
                    writer = new FileWriter("./src/records/level_3_hard.txt", true);
                    writer.write(String.valueOf(gamePanel.playerName[0]) + String.valueOf(gamePanel.playerName[1]) + 
                                String.valueOf(gamePanel.playerName[2]) + "\n");
                    writer.write(gamePanel.player.playerScore + "\n");
                    writer.write(gamePanel.playMinute + "m " + String.format("%.0f", gamePanel.playSecond) + "s" + "\n");
                    writer.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void saveAccount(){
        hasSaved = false;
        username = String.valueOf(gamePanel.playerName[0]) + String.valueOf(gamePanel.playerName[1]) + 
        String.valueOf(gamePanel.playerName[2]);

        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 3; j++){
                if(gamePanel.loadedAccounts[i][0] != null){
                    if(gamePanel.loadedAccounts[i][0].trim().equals(username))
                    {
                        gamePanel.loadedAccounts[i][1] = Integer.toString(gamePanel.easyProgress);
                        gamePanel.loadedAccounts[i][2] = Integer.toString(gamePanel.hardProgress);
                        hasSaved = true;
                    }
                }
            }
        }

        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 3; j++){
                if(hasSaved == false){
                    if(gamePanel.loadedAccounts[i][0] == null)
                    {
                        gamePanel.loadedAccounts[i][0] = username;
                        gamePanel.loadedAccounts[i][1] = Integer.toString(gamePanel.easyProgress);
                        gamePanel.loadedAccounts[i][2] = Integer.toString(gamePanel.hardProgress);

                        hasSaved = true;
                    }
                }   
            }
        }

        try{
            writer = new FileWriter("./src/records/accountRecords.txt");

            for(int i = 0; i < 6; i++){
                for(int j = 0; j < 3; j++){
                    if(gamePanel.loadedAccounts[i][j] != null){
                        writer.write(gamePanel.loadedAccounts[i][j] + "\n");
                    }
                }
            }

            writer.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
