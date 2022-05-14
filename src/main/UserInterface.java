package main;

import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;

public class UserInterface{
    GamePanel gamePanel;

    BufferedImage normalPellet;
    BufferedImage levelComplete, triviaBox;
    BufferedImage mainMenuButton, selectedMainMenuButton, nextLevelButton, selectedNextLevelButton;
    Image growthPellet, informationPellet;
    Font pixelFont24, pixelFont36;

    boolean hasReset = false;

    public UserInterface(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        try{
            pixelFont24 = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/PixelMplus10-Regular.ttf")).deriveFont(24f);
            pixelFont36 = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/PixelMplus10-Regular.ttf")).deriveFont(36f);
            GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            environment.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/PixelMplus10-Regular.ttf")));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        getImage();
    }

    public void getImage(){
        try{
            normalPellet = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/pellet_assets/normal_pellet.png"));
            growthPellet = new ImageIcon(getClass().getResource("/images/game_assets/pellet_assets/growth_pellet.gif")).getImage();
            informationPellet = new ImageIcon(getClass().getResource("/images/game_assets/pellet_assets/information_pellet.gif")).getImage();

            levelComplete = ImageIO.read(getClass().getResourceAsStream("/images/level_complete/level_complete.png"));
            triviaBox = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/pellet_assets/trivia_box.png"));

            mainMenuButton = ImageIO.read(getClass().getResourceAsStream("/images/level_complete/main_menu_button.png"));
            nextLevelButton = ImageIO.read(getClass().getResourceAsStream("/images/level_complete/next_level_button.png"));
            selectedMainMenuButton = ImageIO.read(getClass().getResourceAsStream("/images/level_complete/selected_main_menu_button.png"));
            selectedNextLevelButton = ImageIO.read(getClass().getResourceAsStream("/images/level_complete/selected_next_level_button.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics){
        graphics.setFont(pixelFont24);
        graphics.setColor(Color.WHITE);

        graphics.drawString("Player Score: " + gamePanel.player.playerScore, 50, 60);
        graphics.drawImage(growthPellet, 40, 65, 30, 30, null);
        graphics.drawString(": " + gamePanel.player.playerSize, 70,  90);
        graphics.drawImage(informationPellet, 40, 100, 30, 30, null);
        graphics.drawString(": " + gamePanel.player.playerInfo + " / " + gamePanel.infoCount, 70,  120);

        if(gamePanel.isCompleted == false){
            gamePanel.playSecond += (double) 1 / 60;

            if(gamePanel.playSecond > 59.49){
                gamePanel.playMinute++;
                gamePanel.playSecond = 0;
                hasReset = false;
            }
            else if(hasReset == false && gamePanel.playSecond > 0.49){
                gamePanel.playSecond = 0;
                hasReset = true;
            }
        }
        
        graphics.drawString("Time: " + gamePanel.playMinute + "m " + String.format("%.0f", gamePanel.playSecond) + "s", 960, 60);

        if(gamePanel.keyEvents.showMap == true){
            if(gamePanel.difficulty.equals("Easy")){
                int row = 0;
                int column = 0;
                int x = 304;
                int y = 203;
                
                while (column < gamePanel.screenColumn && row < gamePanel.screenRow){
                    int mapTile = gamePanel.tileManager.tileNumberEasy[column][row];
                    
                    if(mapTile == 4 || mapTile == 5){
                        mapTile = 7;
                    }
                    else if (mapTile == 0 || mapTile == 1 || mapTile == 2 || mapTile == 3){
                        mapTile = 6;
                    }
                    
                    graphics.drawImage(gamePanel.tileManager.tile[mapTile].image, x, y, 30, 30, null);

                    column++;
                    x += 30;

                    if(column == gamePanel.screenColumn){
                        column = 0;
                        x = 304;
                        row++;
                        y += 30;
                    }
                }

                for(int i = 0; i < gamePanel.pellets.length; i++){
                    if(gamePanel.pellets[i] != null){
                        if(gamePanel.pellets[i].image != null){
                            graphics.drawImage(gamePanel.pellets[i].image, ((gamePanel.pellets[i].xCoordinate / 64) * 30) + 304, 
                            ((gamePanel.pellets[i].yCoordinate / 64) * 30) + 203, 30, 30, null);
                        }
                        else{
                            graphics.drawImage(gamePanel.pellets[i].animatedImage, ((gamePanel.pellets[i].xCoordinate / 64) * 30) + 304, 
                            ((gamePanel.pellets[i].yCoordinate / 64) * 30) + 203, 30, 30, null);
                        }
                    }
                }
            } 
            else if(gamePanel.difficulty.equals("Hard")){
                int row = 0;
                int column = 0;
                int x = 326;
                int y = 134;
                
                while (column < gamePanel.hardColumn && row < gamePanel.hardRow){
                    int mapTile = gamePanel.tileManager.tileNumberHard[column][row];
                    
                    if(mapTile == 4 || mapTile == 5){
                        mapTile = 7;
                    }
                    else if (mapTile == 0 || mapTile == 1 || mapTile == 2 || mapTile == 3){
                        mapTile = 6;
                    }
                    
                    graphics.drawImage(gamePanel.tileManager.tile[mapTile].image, x, y, 10, 10, null);
                    column++;
                    x += 10;

                    if(column == gamePanel.hardColumn){
                        column = 0;
                        x = 326;
                        row++;
                        y += 10;
                    }
                }
                for(int i = 0; i < gamePanel.pellets.length; i++){
                    if(gamePanel.pellets[i] != null){
                        if(gamePanel.pellets[i].image != null){
                            graphics.drawImage(gamePanel.pellets[i].image, ((gamePanel.pellets[i].xCoordinate / 64) * 10) + 326, 
                            ((gamePanel.pellets[i].yCoordinate / 64) * 10) + 134, 10, 10, null);
                        }
                        else{
                            graphics.drawImage(gamePanel.pellets[i].animatedImage, ((gamePanel.pellets[i].xCoordinate / 64) * 10) + 326, 
                            ((gamePanel.pellets[i].yCoordinate / 64) * 10) + 134, 10, 10, null);
                        }
                    }
                }
            }   
        } 

        graphics.setColor(Color.BLACK);

        if(gamePanel.showTrivia == true){
            if(gamePanel.player.playerInfo <= 7){
                graphics.setFont(pixelFont36);

                graphics.drawImage(triviaBox, 226, 200, 700, 400, null);
                graphics.drawString(gamePanel.factsTrivia[gamePanel.player.playerInfo - 1][0], 260, 400);
                graphics.drawString(gamePanel.factsTrivia[gamePanel.player.playerInfo  - 1][1], 260, 450);
            }
            else if(gamePanel.player.playerInfo >= 8){
                graphics.setFont(pixelFont24);

                graphics.drawImage(triviaBox, 226, 200, 700, 400, null);
                graphics.drawString(gamePanel.fightsTrivia[gamePanel.player.playerInfo  - 8][0], 260, 360);
                graphics.drawString(gamePanel.fightsTrivia[gamePanel.player.playerInfo  - 8][1], 260, 410);
                graphics.drawString(gamePanel.fightsTrivia[gamePanel.player.playerInfo  - 8][2], 260, 440);
                graphics.drawString(gamePanel.fightsTrivia[gamePanel.player.playerInfo  - 8][3], 260, 470);
                graphics.drawString(gamePanel.fightsTrivia[gamePanel.player.playerInfo  - 8][4], 260, 500);
            }
        }
        
        if(gamePanel.infoCount == gamePanel.player.playerInfo){
            gamePanel.isCompleted = true;
        }

        graphics.setFont(pixelFont36);
        graphics.setColor(Color.BLACK);

        if(gamePanel.isCompleted){
            graphics.drawImage(levelComplete, 228, 190, 700, 400, null);

            graphics.drawString("Usernam", 270, 380);
            graphics.drawString("e: " + gamePanel.playerName[0] + gamePanel.playerName[1] + gamePanel.playerName[2], 402, 380);
            graphics.drawString("Level " + (gamePanel.level + 1) + " " + gamePanel.difficulty, 270, 420);
            graphics.drawString("Final Score: " + gamePanel.player.playerScore, 270, 460);
            graphics.drawString("Time Taken: " + gamePanel.playMinute + "m " + String.format("%.0f", gamePanel.playSecond) + "s", 270, 500);

            if(gamePanel.level == 2){
                graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
                graphics.drawImage(selectedMainMenuButton, 466, 550, 220, 60, null);
            }
            else{
                if(gamePanel.levelCompleteOption == 0){
                    graphics.drawImage(selectedMainMenuButton, 320, 550, 220, 60, null);
                    graphics.drawImage(nextLevelButton, 610, 550, 220, 60, null);
                }
                else if(gamePanel.levelCompleteOption == 1){
                    graphics.drawImage(mainMenuButton, 320, 550, 220, 60, null);
                    graphics.drawImage(selectedNextLevelButton, 610, 550, 220, 60, null);
                }
            }
            gamePanel.stopMusic();

            if(gamePanel.hasPlayed == false){
                gamePanel.saveRecords.saveRecords();
                gamePanel.playLevelComplete();
            }
    
            gamePanel.hasPlayed = true;
        }
    }
}
