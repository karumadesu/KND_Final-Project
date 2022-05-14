package main;

import pellets.NormalPellet;
import pellets.GrowthPellet;
import pellets.InformationPellet;

public class PelletSetter{
    GamePanel gamePanel;

    public PelletSetter(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void setPellets(){
        gamePanel.infoCount = 0;
        
        if(gamePanel.difficulty.equals("Easy")){
            for(int i = 0; i < 18; i++){
                for(int j = 0; j < 12; j++){
                    if(gamePanel.pelletManager.pelletNumberEasy[i][j] == 1){  
                        gamePanel.pellets[gamePanel.pelletCounter] = new NormalPellet();
                        gamePanel.pellets[gamePanel.pelletCounter].xCoordinate = i * gamePanel.tileSize;
                        gamePanel.pellets[gamePanel.pelletCounter].yCoordinate = j * gamePanel.tileSize;
                        gamePanel.pelletCounter++;
                    }     
                    else if(gamePanel.pelletManager.pelletNumberEasy[i][j] == 2){  
                        gamePanel.pellets[gamePanel.pelletCounter] = new GrowthPellet();
                        gamePanel.pellets[gamePanel.pelletCounter].xCoordinate = i * gamePanel.tileSize;
                        gamePanel.pellets[gamePanel.pelletCounter].yCoordinate = j * gamePanel.tileSize;
                        gamePanel.pelletCounter++;
                    }   
                    else if(gamePanel.pelletManager.pelletNumberEasy[i][j] == 3){  
                        gamePanel.pellets[gamePanel.pelletCounter] = new InformationPellet();
                        gamePanel.pellets[gamePanel.pelletCounter].xCoordinate = i * gamePanel.tileSize;
                        gamePanel.pellets[gamePanel.pelletCounter].yCoordinate = j * gamePanel.tileSize;
                        gamePanel.pelletCounter++;
                        gamePanel.infoCount++;
                    } 
                }   
            }
        }
        else if(gamePanel.difficulty.equals("Hard")){
            for(int i = 0; i < 50; i++){
                for(int j = 0; j < 50; j++){
                    if(gamePanel.pelletManager.pelletNumberHard[i][j] == 1){  
                        gamePanel.pellets[gamePanel.pelletCounter] = new NormalPellet();
                        gamePanel.pellets[gamePanel.pelletCounter].xCoordinate = i * gamePanel.tileSize;
                        gamePanel.pellets[gamePanel.pelletCounter].yCoordinate = j * gamePanel.tileSize;
                        gamePanel.pelletCounter++;
                    }     
                    else if(gamePanel.pelletManager.pelletNumberHard[i][j] == 2){  
                        gamePanel.pellets[gamePanel.pelletCounter] = new GrowthPellet();
                        gamePanel.pellets[gamePanel.pelletCounter].xCoordinate = i * gamePanel.tileSize;
                        gamePanel.pellets[gamePanel.pelletCounter].yCoordinate = j * gamePanel.tileSize;
                        gamePanel.pelletCounter++;
                    }   
                    else if(gamePanel.pelletManager.pelletNumberHard[i][j] == 3){  
                        gamePanel.pellets[gamePanel.pelletCounter] = new InformationPellet();
                        gamePanel.pellets[gamePanel.pelletCounter].xCoordinate = i * gamePanel.tileSize;
                        gamePanel.pellets[gamePanel.pelletCounter].yCoordinate = j * gamePanel.tileSize;
                        gamePanel.pelletCounter++;
                        gamePanel.infoCount++;
                    } 
                }   
            }
        }
    }
}
