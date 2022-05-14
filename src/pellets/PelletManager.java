package pellets;

import java.io.*;

import main.GamePanel;

public class PelletManager{
    GamePanel gamePanel;

    public int pelletNumberEasy[][];
    public int pelletNumberHard[][];

    public PelletManager(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        pelletNumberEasy = new int[gamePanel.screenColumn][gamePanel.screenRow];
        pelletNumberHard = new int[gamePanel.hardColumn][gamePanel.hardRow];
    }

    public void loadPellets(String path){
        try{
            InputStream in = getClass().getResourceAsStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            int row = 0;
            int column = 0;

            if(gamePanel.difficulty.equals("Easy")){
                while(column < gamePanel.screenColumn && row < gamePanel.screenRow){
                    String line = reader.readLine();
    
                    while(column < gamePanel.screenColumn){
                        String numbers[] = line.split(" ");
    
                        int num = Integer.parseInt(numbers[column]);
    
                        pelletNumberEasy[column][row] = num;
                        column++;
                    }
                    if(column == gamePanel.screenColumn){
                        column = 0;
                        row++;
                    }
                }
            }
            else if(gamePanel.difficulty.equals("Hard")){
                while(column < gamePanel.hardColumn && row < gamePanel.hardRow){
                    String line = reader.readLine();
    
                    while(column < gamePanel.hardColumn){
                        String numbers[] = line.split(" ");
    
                        int num = Integer.parseInt(numbers[column]);
    
                        pelletNumberHard[column][row] = num;
                        column++;
                    }
                    if(column == gamePanel.hardColumn){
                        column = 0;
                        row++;
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
