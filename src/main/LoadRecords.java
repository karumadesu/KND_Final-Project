package main;

import java.io.*;

public class LoadRecords{
    GamePanel gamePanel;
    BufferedReader reader;

    String line;
    int lineCount = 0;

    public LoadRecords(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void loadRecords(){
        try{
            reader = new BufferedReader(new FileReader("./src/records/level_1_easy.txt"));
            while(reader.readLine() != null){
                lineCount++;
            }
            reader.close();

            reader = new BufferedReader(new FileReader("./src/records/level_1_easy.txt"));
            line = reader.readLine();
            for(int i = 0; i < lineCount / 3; i++){
                for(int j = 0; j < 3; j++){
                    if(line != null){
                        gamePanel.level1Easy[i][j] = line;
                        line = reader.readLine();
                    }
                    else{
                        break;
                    }
                }
            }
            reader.close();

            lineCount = 0;

            reader = new BufferedReader(new FileReader("./src/records/level_2_easy.txt"));
            while(reader.readLine() != null){
                lineCount++;
            }
            reader.close();

            reader = new BufferedReader(new FileReader("./src/records/level_2_easy.txt"));
            line = reader.readLine();
            for(int i = 0; i < lineCount / 3; i++){
                for(int j = 0; j < 3; j++){
                    if(line != null){
                        gamePanel.level2Easy[i][j] = line;
                        line = reader.readLine();
                    }
                    else{
                        break;
                    }
                }
            }
            reader.close();

            lineCount = 0;

            reader = new BufferedReader(new FileReader("./src/records/level_3_easy.txt"));
            while(reader.readLine() != null){
                lineCount++;
            }
            reader.close();

            reader = new BufferedReader(new FileReader("./src/records/level_3_easy.txt"));
            line = reader.readLine();
            for(int i = 0; i < lineCount / 3; i++){
                for(int j = 0; j < 3; j++){
                    if(line != null){
                        gamePanel.level3Easy[i][j] = line;
                        line = reader.readLine();
                    }
                    else{
                        break;
                    }
                }
            }
            reader.close();

            lineCount = 0;

            reader = new BufferedReader(new FileReader("./src/records/level_1_hard.txt"));
            while(reader.readLine() != null){
                lineCount++;
            }
            reader.close();

            reader = new BufferedReader(new FileReader("./src/records/level_1_hard.txt"));
            line = reader.readLine();
            for(int i = 0; i < lineCount / 3; i++){
                for(int j = 0; j < 3; j++){
                    if(line != null){
                        gamePanel.level1Hard[i][j] = line;
                        line = reader.readLine();
                    }
                    else{
                        break;
                    }
                }
            }
            reader.close();

            lineCount = 0;

            reader = new BufferedReader(new FileReader("./src/records/level_2_hard.txt"));
            while(reader.readLine() != null){
                lineCount++;
            }
            reader.close();

            reader = new BufferedReader(new FileReader("./src/records/level_2_hard.txt"));
            line = reader.readLine();
            for(int i = 0; i < lineCount / 3; i++){
                for(int j = 0; j < 3; j++){
                    if(line != null){
                        gamePanel.level2Hard[i][j] = line;
                        line = reader.readLine();
                    }
                    else{
                        break;
                    }
                }
            }
            reader.close();

            lineCount = 0;

            reader = new BufferedReader(new FileReader("./src/records/level_3_hard.txt"));
            while(reader.readLine() != null){
                lineCount++;
            }
            reader.close();

            reader = new BufferedReader(new FileReader("./src/records/level_3_hard.txt"));
            line = reader.readLine();
            for(int i = 0; i < lineCount / 3; i++){
                for(int j = 0; j < 3; j++){
                    if(line != null){
                        gamePanel.level3Hard[i][j] = line;
                        line = reader.readLine();
                    }
                    else{
                        break;
                    }
                }
            }
            reader.close();

            lineCount = 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
