package entities;

import java.awt.*;
import java.awt.image.*;

public class Entities{
    public int xCoordinate, yCoordinate, velocity;
    public int playerScore, playerSize, playerInfo;
    public BufferedImage up1, up2, upIdle, down1, down2, downIdle, left1, left2, leftIdle, right1, right2, rightIdle;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNumber = 1;
    public int standCounter = 0;
    public Rectangle collisionBounds;
    public int collisionBoundsX, collisionBoundsY;
    public boolean collisionOn = false;
}
