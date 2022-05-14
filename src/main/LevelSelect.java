package main;

import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;

public class LevelSelect{
    GamePanel gamePanel;
    BufferedImage backgroundImage, level1, level2, level3, lock;

    public LevelSelect(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        getImage();
    }

    public void getImage(){
        try{
            backgroundImage = ImageIO.read(getClass().getResourceAsStream("/images/level_select/level_select.png"));
            level1 = ImageIO.read(getClass().getResourceAsStream("/images/level_select/level_1_icon.png"));
            level2 = ImageIO.read(getClass().getResourceAsStream("/images/level_select/level_2_icon.png"));
            level3 = ImageIO.read(getClass().getResourceAsStream("/images/level_select/level_3_icon.png"));
            lock = ImageIO.read(getClass().getResourceAsStream("/images/level_select/lock_icon.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics){
        graphics.drawImage(backgroundImage, 0, 0, gamePanel.screenWidth, gamePanel.screenHeight, null);

        if(gamePanel.level == 0){
            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
            graphics.drawImage(level1, 130, 350, 160, 160, null);

            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
            graphics.drawImage(level2, 490, 350, 160, 160, null);
            graphics.drawImage(level3, 850, 350, 160, 160, null);
        }
        else if(gamePanel.level == 1){
            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
            graphics.drawImage(level1, 130, 350, 160, 160, null);

            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
            graphics.drawImage(level2, 490, 350, 160, 160, null);

            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
            graphics.drawImage(level3, 850, 350, 160, 160, null);
        }
        else if (gamePanel.level == 2){
            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
            graphics.drawImage(level1, 130, 350, 160, 160, null);
            graphics.drawImage(level2, 490, 350, 160, 160, null);

            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
            graphics.drawImage(level3, 850, 350, 160, 160, null);
        }

        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

        if(gamePanel.difficulty.equals("Easy")){
            if(gamePanel.easyProgress == 0){
                graphics.drawImage(lock, 490, 350, 160, 160, null);
                graphics.drawImage(lock, 850, 350, 160, 160, null);
            }
            else if(gamePanel.easyProgress == 1){
                graphics.drawImage(lock, 850, 350, 160, 160, null);
            }
        }
        else if(gamePanel.difficulty.equals("Hard")){
            if(gamePanel.hardProgress == 0){
                graphics.drawImage(lock, 490, 350, 160, 160, null);
                graphics.drawImage(lock, 850, 350, 160, 160, null);
            }
            else if(gamePanel.hardProgress == 1){
                graphics.drawImage(lock, 850, 350, 160, 160, null);
            }
        }
    }
}
