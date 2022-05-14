package pellets;

import java.awt.*;
import java.awt.image.*;

import main.GamePanel;

public class Pellets{
    public BufferedImage image;
    public Image animatedImage;
    public String name;
    public int xCoordinate, yCoordinate;    
    public Rectangle collisionBounds = new Rectangle(0, 0, 64, 64);
    public int collisionBoundsX = 0;
    public int collisionBoundsY = 0;

    public void draw(Graphics2D graphics, GamePanel gamePanel){
        int screenX = xCoordinate - gamePanel.player.xCoordinate + gamePanel.player.screenX;
        int screenY = yCoordinate - gamePanel.player.yCoordinate + gamePanel.player.screenY;

        if(image != null){
            graphics.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
        }
        else if(image == null){
            graphics.drawImage(animatedImage, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
        }
    }
}
