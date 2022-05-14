package main;

import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

public class SplashScreen{
    GamePanel gamePanel;

    Color barColor = Color.decode("#D44E52");

    BufferedImage backgroundImage;
    Font splashFont;

    double percent;

    public SplashScreen(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        try{
            splashFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/PixelMplus10-Regular.ttf")).deriveFont(24f);
            GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            environment.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/PixelMplus10-Regular.ttf")));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        getBackgroundImage();
    }

    public void getBackgroundImage(){
        try{
            backgroundImage = ImageIO.read(getClass().getResourceAsStream("/images/splash_screen/splash_screen.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics){
        if(gamePanel.keyEvents.exitSplash == false){
            if(gamePanel.splashAlpha < 1){
                graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,gamePanel.splashAlpha));
                gamePanel.splashAlpha += 0.01f;
            }

            graphics.drawImage(backgroundImage, 0, 0, gamePanel.screenWidth, gamePanel.screenHeight, null);
            graphics.setColor(barColor);
    
            if(gamePanel.iterator < gamePanel.screenWidth){
                graphics.fillRect(0, 743, gamePanel.iterator, 25);
    
                if(gamePanel.iterator < 200){
                    gamePanel.iterator += 1;
                }
                else if(gamePanel.iterator < 600){
                    gamePanel.iterator += 4;
                }
                else if(gamePanel.iterator < 800){
                    gamePanel.iterator += 3;
                }
                else if(gamePanel.iterator < 1100){
                    gamePanel.iterator += 2;
                }
                else if(gamePanel.iterator < 1152){
                    gamePanel.iterator += 1;
                }
            }
            else{
                graphics.fillRect(0, 743, 1152, 25);
            }
    
            graphics.setFont(splashFont);
            graphics.setColor(Color.WHITE);
    
            percent = ((double) gamePanel.iterator / 1152) * 100;
    
            if(gamePanel.iterator <= 232){
                
                graphics.drawString("Loading Map: " + String.format("%.0f", percent) + "%", 485, 727);
            }
            else if(gamePanel.iterator <= 464){
                graphics.drawString("Loading Entities: " + String.format("%.0f", percent) + "%", 450, 727);
            }
            else if(gamePanel.iterator <= 696){
                graphics.drawString("Loading Character: " + String.format("%.0f", percent) + "%", 445, 727);
            }
            else if(gamePanel.iterator <= 928){
                graphics.drawString("Loading Database: " + String.format("%.0f", percent) + "%", 450, 727);
            }
            else if(gamePanel.iterator < 1152){
                graphics.drawString("Loading Game: " + String.format("%.0f", percent) + "%", 480, 727);
            }
            else if (gamePanel.iterator == 1152){
                graphics.drawString("Press any key to continue", 433, 727);
            }
        }
        else{
            gamePanel.gameState = "Main Menu";
        }
    }
}