package main;

import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;

public class DifficultySelect{
    GamePanel gamePanel;
    Image backgroundImage;
    BufferedImage easyButton, hardButton, cursorImage;

    public DifficultySelect(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        getImage();
    }

    public void getImage(){
        try{
            backgroundImage = new ImageIcon(getClass().getResource("/images/difficulty_select/difficulty_select.gif")).getImage();
            easyButton = ImageIO.read(getClass().getResourceAsStream("/images/difficulty_select/easy_button.png"));
            hardButton = ImageIO.read(getClass().getResourceAsStream("/images/difficulty_select/hard_button.png"));
            cursorImage = ImageIO.read(getClass().getResourceAsStream("/images/main_menu/menu_cursor.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics){
        graphics.drawImage(backgroundImage, 0, 0, gamePanel.screenWidth, gamePanel.screenHeight, null);
        graphics.drawImage(easyButton, 235, 570, 148, 64, null);
        graphics.drawImage(hardButton, 763, 570, 148, 64, null);

        if(gamePanel.difficulty.equals("Easy")){
            graphics.drawImage(cursorImage, 190, 583, 40, 40, null);
        }
        else if(gamePanel.difficulty.equals("Hard")){
            graphics.drawImage(cursorImage, 718, 583, 40, 40, null);
        }
    }
}
