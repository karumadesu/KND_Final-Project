package main;

import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;

public class MainMenu {
    GamePanel gamePanel;
    KeyEvents keyEvents;

    BufferedImage cursorImage;
    Image backgroundImage;
    Font pixelFont54;
    Font pixelFont16;

    public int menuCursor = 0;

    public MainMenu(GamePanel gamePanel, KeyEvents keyEvents) {
        this.gamePanel = gamePanel;
        this.keyEvents = keyEvents;

        try{
            pixelFont54 = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/PixelMplus10-Regular.ttf")).deriveFont(54f);
            pixelFont16 = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/PixelMplus10-Regular.ttf")).deriveFont(16f);
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
            cursorImage = ImageIO.read(getClass().getResourceAsStream("/images/main_menu/menu_cursor.png"));
            backgroundImage = new ImageIcon(getClass().getResource("/images/main_menu/main_menu.gif")).getImage();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics){
        if(gamePanel.hasExited == false){
            graphics.drawImage(backgroundImage, 0, 0, gamePanel.screenWidth, gamePanel.screenHeight, null);

            if(menuCursor == 0){
                graphics.drawImage(cursorImage, 40, 182, 40, 40, null);
            }
            else if(menuCursor == 1){
                graphics.drawImage(cursorImage, 40, 272, 40, 40, null);
            }
            else if(menuCursor == 2){
                graphics.drawImage(cursorImage, 40, 362, 40, 40, null);
            }
            else if(menuCursor == 3){
                graphics.drawImage(cursorImage, 40, 452, 40, 40, null);
            }

            graphics.setFont(pixelFont54);
            graphics.setColor(Color.WHITE);
            graphics.drawString("New Game", 90, 220);
            graphics.drawString("Load Game", 90, 310);
            graphics.drawString("Leaderboards", 90, 400);
            graphics.drawString("Exit", 90, 490);

            graphics.setFont(pixelFont16);
            graphics.drawString("Press the \"Esc\" key for Settings", 10, 755);
        }
        else if(gamePanel.hasExited == true){
            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.2f));
            graphics.drawImage(backgroundImage, 0, 0, gamePanel.screenWidth, gamePanel.screenHeight, null);

            if(menuCursor == 0){
                graphics.drawImage(cursorImage, 40, 182, 40, 40, null);
            }
            else if(menuCursor == 1){
                graphics.drawImage(cursorImage, 40, 272, 40, 40, null);
            }
            else if(menuCursor == 2){
                graphics.drawImage(cursorImage, 40, 362, 40, 40, null);
            }
            else if(menuCursor == 3){
                graphics.drawImage(cursorImage, 40, 452, 40, 40, null);
            }

            graphics.setFont(pixelFont54);
            graphics.setColor(Color.WHITE);
            graphics.drawString("New Game", 90, 220);
            graphics.drawString("Load Game", 90, 310);
            graphics.drawString("Leaderboards", 90, 400);
            graphics.drawString("Exit", 90, 490);

            graphics.setFont(pixelFont16);
            graphics.drawString("Press the \"Esc\" key for Settings", 10, 755);
        }
    }
}
