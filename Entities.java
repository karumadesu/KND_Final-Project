package entities;

import java.awt.image.*;
import java.awt.*;

public class Entities{
    public int x, y, v; // Coordinate of the player in the x and y axis, as well as the player's velocity
    public BufferedImage up1, up2, left1, left2, down1, down2, 
        right1, right2, upidle, leftidle, downidle, rightidle; // Stores the image data for the sprites
    public String direction; // Stores the direction of the player
    public int spriteCounter = 0; // Determines when the character would change sprites
    public int spriteNumber = 1; // Determines which sprite to display
    public int standCounter = 0; // Determines when the character would be idle
    public Rectangle collisionBounds; // Creates the collision bounds for the character
    public boolean collisionOn = false; // Determines whether the character is colliding with an entity
}
