package main;

import java.awt.*;
import java.io.*;
import java.util.*;

public class UserInterface{
    GamePanel gamePanel;
    Font uiFont;
    int playSecond = 0;
    int playMinute = 0;

    public UserInterface(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        try{
            uiFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/PixelMplus12-Regular.ttf")).deriveFont(24f);
            GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            environment.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/PixelMplus12-Regular.ttf")));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics){
        graphics.setFont(uiFont);
        graphics.setColor(Color.WHITE);
        graphics.drawString("Pellet Count: " + gamePanel.player.pelletCount, 50, 60);

        long startTime = System.currentTimeMillis();
        long elapsedTime = 0L;

        while(elapsedTime < 1000){
            elapsedTime = (new Date()).getTime() - startTime;
        }
        
        if(playSecond == 60){
            playSecond -= 60;
            playMinute++;
        }

        graphics.drawString("Time: " + playMinute + "m " + playSecond + "s", 980, 60);
    }
}
