package main;

import javax.imageio.*;
import java.awt.image.*;
import java.awt.*;

public class ExitMenu{
    GamePanel gamePanel;
    BufferedImage exitDialog, exitCursorLeft, exitCursorRight;

    public ExitMenu(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        getImage();
    }

    public void getImage(){
        try{
            exitDialog = ImageIO.read(getClass().getResourceAsStream("/images/exit_menu/exit.png"));
            exitCursorLeft = ImageIO.read(getClass().getResourceAsStream("/images/exit_menu/menu_cursor_left.png"));
            exitCursorRight = ImageIO.read(getClass().getResourceAsStream("/images/exit_menu/menu_cursor_right.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics){
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        graphics.drawImage(exitDialog, 352, 220, 500, 300, null);
        if(gamePanel.exitOption == false){
            graphics.drawImage(exitCursorLeft, 553, 468, 40, 40, null);
        }
        else if(gamePanel.exitOption){
            graphics.drawImage(exitCursorRight, 553, 468, 40, 40, null);
        }
    }
}
