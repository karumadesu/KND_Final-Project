package main;

import java.io.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;

public class LoadGame{
    GamePanel gamePanel;
    BufferedImage backgroundImage, userProfile, cursorImage;
    Font pixelFont36, pixelFont24;

    public LoadGame(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        try{
            pixelFont36 = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/PixelMplus10-Regular.ttf")).deriveFont(36f);
            pixelFont24 = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/PixelMplus10-Regular.ttf")).deriveFont(24f);
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
            backgroundImage = ImageIO.read(getClass().getResourceAsStream("/images/load_game/load_game.png"));
            userProfile = ImageIO.read(getClass().getResourceAsStream("/images/load_game/user_profile.png"));
            cursorImage = ImageIO.read(getClass().getResourceAsStream("/images/main_menu/menu_cursor.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics){
        graphics.drawImage(backgroundImage, 0, 0, gamePanel.screenWidth, gamePanel.screenHeight, null);

        graphics.drawImage(userProfile, 207, 240, 300, 150, null);
        graphics.drawImage(userProfile, 649, 240, 300, 150, null);
        graphics.drawImage(userProfile, 207, 410, 300, 150, null);
        graphics.drawImage(userProfile, 649, 410, 300, 150, null);
        graphics.drawImage(userProfile, 207, 580, 300, 150, null);
        graphics.drawImage(userProfile, 649, 580, 300, 150, null);

        graphics.setColor(Color.BLACK);
         
        if(gamePanel.loadedAccounts[0][0] != null){
            graphics.setFont(pixelFont36);
            graphics.drawString(gamePanel.loadedAccounts[0][0], 380, 289);

            graphics.setFont(pixelFont24);
            graphics.drawString("Level " + Integer.toString(Integer.parseInt(gamePanel.loadedAccounts[0][1]) + 1), 365, 323);
            graphics.drawString("Level " + Integer.toString(Integer.parseInt(gamePanel.loadedAccounts[0][2]) + 1), 365, 362);
        }
        else{
            graphics.setFont(pixelFont36);
            graphics.drawString("---", 380, 289);

            graphics.setFont(pixelFont24);
            graphics.drawString("No Record", 365, 323);
            graphics.drawString("No Record", 365, 362);
        }

        if(gamePanel.loadedAccounts[1][0] != null){
            graphics.setFont(pixelFont36);
            graphics.drawString(gamePanel.loadedAccounts[1][0], 825, 289);

            graphics.setFont(pixelFont24);
            graphics.drawString("Level " + Integer.toString(Integer.parseInt(gamePanel.loadedAccounts[1][1]) + 1), 810, 323);
            graphics.drawString("Level " + Integer.toString(Integer.parseInt(gamePanel.loadedAccounts[1][2]) + 1), 810, 362);
        }
        else{
            graphics.setFont(pixelFont36);
            graphics.drawString("---", 825, 289);

            graphics.setFont(pixelFont24);
            graphics.drawString("No Record", 810, 323);
            graphics.drawString("No Record", 810, 362);
        }

        if(gamePanel.loadedAccounts[2][0] != null){
            graphics.setFont(pixelFont36);
            graphics.drawString(gamePanel.loadedAccounts[2][0], 380, 459);
            
            graphics.setFont(pixelFont24);
            graphics.drawString("Level " + Integer.toString(Integer.parseInt(gamePanel.loadedAccounts[2][1]) + 1), 365, 493);
            graphics.drawString("Level " + Integer.toString(Integer.parseInt(gamePanel.loadedAccounts[2][2]) + 1), 365, 532);
        }
        else{
            graphics.setFont(pixelFont36);
            graphics.drawString("---", 380, 459);
            
            graphics.setFont(pixelFont24);
            graphics.drawString("No Record", 365, 493);
            graphics.drawString("No Record", 365, 532);
        }

        if(gamePanel.loadedAccounts[3][0] != null){
            graphics.setFont(pixelFont36);
            graphics.drawString(gamePanel.loadedAccounts[3][0], 825, 459);

            graphics.setFont(pixelFont24);
            graphics.drawString("Level " + Integer.toString(Integer.parseInt(gamePanel.loadedAccounts[3][1]) + 1), 810, 493);
            graphics.drawString("Level " + Integer.toString(Integer.parseInt(gamePanel.loadedAccounts[3][2]) + 1), 810, 532);
        }
        else{
            graphics.setFont(pixelFont36);
            graphics.drawString("---", 825, 459);

            graphics.setFont(pixelFont24);
            graphics.drawString("No Record", 810, 493);
            graphics.drawString("No Record", 810, 532);
        }

        if(gamePanel.loadedAccounts[4][0] != null){
            graphics.setFont(pixelFont36);
            graphics.drawString(gamePanel.loadedAccounts[4][0], 380, 629);

            graphics.setFont(pixelFont24);
            graphics.drawString("Level " + Integer.toString(Integer.parseInt(gamePanel.loadedAccounts[4][1]) + 1), 365, 663);
            graphics.drawString("Level " + Integer.toString(Integer.parseInt(gamePanel.loadedAccounts[4][2]) + 1), 365, 702);
        }
        else{
            graphics.setFont(pixelFont36);
            graphics.drawString("---", 380, 629);

            graphics.setFont(pixelFont24);
            graphics.drawString("No Record", 365, 663);
            graphics.drawString("No Record", 365, 702);
        }

        if(gamePanel.loadedAccounts[5][0] != null){
            graphics.setFont(pixelFont36);
            graphics.drawString(gamePanel.loadedAccounts[5][0], 825, 629);

            graphics.setFont(pixelFont24);
            graphics.drawString("Level " + Integer.toString(Integer.parseInt(gamePanel.loadedAccounts[5][1]) + 1), 810, 663);
            graphics.drawString("Level " + Integer.toString(Integer.parseInt(gamePanel.loadedAccounts[5][2]) + 1), 810, 702);
        }
        else{
            graphics.setFont(pixelFont36);
            graphics.drawString("---", 825, 629);

            graphics.setFont(pixelFont24);
            graphics.drawString("No Record", 810, 663);
            graphics.drawString("No Record", 810, 702);
        }

        if(gamePanel.loadColumn == 0){
            if(gamePanel.loadRow == 0){
                graphics.drawImage(cursorImage, 140, 285, 60, 60, null);
                gamePanel.loadedAccount = 0;
            } 
            else if(gamePanel.loadRow == 1){
                graphics.drawImage(cursorImage, 140, 455, 60, 60, null);
                gamePanel.loadedAccount = 2;
            }
            else if(gamePanel.loadRow == 2){
                graphics.drawImage(cursorImage, 140, 625, 60, 60, null);
                gamePanel.loadedAccount = 4;
            }
        }
        else if(gamePanel.loadColumn == 1){
            if(gamePanel.loadRow == 0){
                graphics.drawImage(cursorImage, 582, 285, 60, 60, null);
                gamePanel.loadedAccount = 1;
            } 
            else if(gamePanel.loadRow == 1){
                graphics.drawImage(cursorImage, 582, 455, 60, 60, null);
                gamePanel.loadedAccount = 3;
            }
            else if(gamePanel.loadRow == 2){
                graphics.drawImage(cursorImage, 582, 625, 60, 60, null);
                gamePanel.loadedAccount = 5;
            }
        }
    }
}
