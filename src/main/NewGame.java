package main;

import java.io.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;

public class NewGame{
    GamePanel gamePanel;
    BufferedImage backgroundImage, nameDialog, userTaken;
    Font pixelFont36;

    public NewGame(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        try{
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
            backgroundImage = ImageIO.read(getClass().getResourceAsStream("/images/new_game/new_game.png"));
            nameDialog = ImageIO.read(getClass().getResourceAsStream("/images/new_game/enter_name.png"));
            userTaken = ImageIO.read(getClass().getResourceAsStream("/images/new_game/user_taken.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics){
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.2f));
        graphics.drawImage(backgroundImage, 0, 0, gamePanel.screenWidth, gamePanel.screenHeight, null);

        if(gamePanel.isTaken == false){
            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
            graphics.drawImage(nameDialog, 326, 210, 500, 300, null);
    
            graphics.setColor(Color.decode("#1F1F30"));
            
            int horizontalCoordinate = 481;
            for(int i = 0; i < 3; i++){
                horizontalCoordinate += 25;
                graphics.fillRect(horizontalCoordinate, 382, 40, 5);
                horizontalCoordinate += 25;
            }
    
            graphics.setFont(pixelFont36);
    
            int xCoordinate = 518;
            for(int i = 0; i < 3; i++){
                graphics.drawString(Character.toString(gamePanel.playerName[i]), xCoordinate, 375);
                xCoordinate += 50;
            }
    
            gamePanel.highlightIterator++;
    
            if(gamePanel.hasEntered == false){
                if(gamePanel.highlightIterator >= 30){
                    graphics.setColor(Color.WHITE);
                    if(gamePanel.highlightIterator > 50){
                        gamePanel.highlightIterator = 0;
                    }
                }
                graphics.drawString(Character.toString(gamePanel.playerName[gamePanel.nameFieldNumber]), gamePanel.nameFieldX, 375);  
            }
        }
        else if(gamePanel.isTaken == true && gamePanel.showAlert == true){
            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
            graphics.drawImage(userTaken, 326, 290, 500, 200, null);
        }
    }
}
