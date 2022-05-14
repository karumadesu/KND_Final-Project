package main;

import javax.imageio.*;
import java.awt.image.*;
import java.awt.*;

public class Settings{
    GamePanel gamePanel;
    BufferedImage settingsPanel, settingsCursor, sliderIcon, checkboxTick;

    public Settings(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        getImage();
    }

    public void getImage(){
        try{
            settingsPanel = ImageIO.read(getClass().getResourceAsStream("/images/settings_menu/settings.png"));
            settingsCursor = ImageIO.read(getClass().getResourceAsStream("/images/settings_menu/menu_cursor_right.png"));
            sliderIcon = ImageIO.read(getClass().getResourceAsStream("/images/settings_menu/slider_icon.png"));
            checkboxTick = ImageIO.read(getClass().getResourceAsStream("/images/settings_menu/tick.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics){
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        graphics.drawImage(settingsPanel, 321, 231, 500, 300, null);

        if(gamePanel.settingOption == 0){
            graphics.drawImage(settingsCursor, 363, 352, 40, 40, null);
        }
        else if(gamePanel.settingOption == 1){
            graphics.drawImage(settingsCursor, 363, 417, 40, 40, null);
        }

        graphics.setColor(Color.decode("#1F1F30"));
        graphics.fillRect(488, 350, gamePanel.volumeValue, 41);
        graphics.drawImage(sliderIcon, gamePanel.sliderPosition, 350, 41, 41, null);

        if(gamePanel.isMuted == true){
            graphics.drawImage(checkboxTick, 419, 413, 45, 45, null);
        }
    }
}
