package entities;

import main.GamePanel;
import main.KeyEvents;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

public class Player extends Entities{
    GamePanel gamePanel;
    KeyEvents keyboardEvents;

    public final int screenWidth;
    public final int screenHeight;

    public int pelletCount = 0;

    public Player(GamePanel gamePanel, KeyEvents keyboardEvents){
        this.gamePanel = gamePanel;
        this.keyboardEvents = keyboardEvents;

        screenWidth = (gamePanel.screenWidth / 2) - (gamePanel.tileSize / 2);
        screenHeight = (gamePanel.screenHeight / 2) - (gamePanel.tileSize / 2);

        collisionBounds = new Rectangle();
        collisionBounds.x = 21;
        collisionBounds.y = 8;
        collisionBounds.width = 25;
        collisionBounds.height = 42;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x = gamePanel.tileSize * 23;
        y = gamePanel.tileSize * 21;
        v = 4;
        direction = "down";
    }

    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/images/player/pacmanup1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/images/player/pacmanup2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/images/player/pacmanleft1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/images/player/pacmanleft2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/images/player/pacmandown1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/images/player/pacmandown2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/images/player/pacmanright1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/images/player/pacmanright2.png"));
            upidle = ImageIO.read(getClass().getResourceAsStream("/images/player/pacmanupidle.png"));
            leftidle = ImageIO.read(getClass().getResourceAsStream("/images/player/pacmanleftidle.png"));
            downidle = ImageIO.read(getClass().getResourceAsStream("/images/player/pacmandownidle.png"));
            rightidle = ImageIO.read(getClass().getResourceAsStream("/images/player/pacmanrightidle.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(keyboardEvents.w == true || keyboardEvents.a == true || keyboardEvents.s == true || keyboardEvents.d == true){
            if(keyboardEvents.w == true){
                direction = "up";
            }
            else if(keyboardEvents.a == true){
                direction = "left";
            }
            else if(keyboardEvents.s == true){
                direction = "down"; 
            }
            else if(keyboardEvents.d == true){
                direction = "right";        
            }
            
            collisionOn = false;
            gamePanel.collision.checkTile(this);

            if(collisionOn == false){
                switch(direction){
                    case "up":
                        y -= v;
                        break;
                    case "left":
                        x -= v;
                        break;
                    case "down":
                        y += v;
                        break;
                    case "right":
                        x += v;
                        break;
                }
            }

            spriteCounter++;
            if(spriteCounter > gamePanel.framePerSecond / 6){
                if(spriteNumber == 1){
                    spriteNumber = 2;
                }
                else if(spriteNumber == 2){
                    spriteNumber = 1;
                }
                else if(spriteNumber == 3){
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        }
        else{
            standCounter ++;

            if(standCounter > 20){
                spriteNumber = 3;
                standCounter = 0;
            }
        }
    }

    public void draw(Graphics2D graphics){
        BufferedImage image = null;
        
        switch(direction){
            case "up":
                if(spriteNumber == 1){
                    image = up1;
                }
                else if (spriteNumber == 2){
                    image = up2;
                }
                else if (spriteNumber == 3){
                    image = upidle;
                }
                break;
            case "left":
                if(spriteNumber == 1){
                    image = left1;
                }
                else if (spriteNumber == 2){
                    image = left2;
                }
                else if (spriteNumber == 3){
                    image = leftidle;
                }
                break;
            case "down":
                if(spriteNumber == 1){
                    image = down1;
                }
                else if (spriteNumber == 2){
                    image = down2;
                }
                else if (spriteNumber == 3){
                    image = downidle;
                }
                break;
            case "right":
                if(spriteNumber == 1){
                    image = right1;
                }
                else if (spriteNumber == 2){
                    image = right2;
                }
                else if (spriteNumber == 3){
                    image = rightidle;
                }
                break;
        }

        int width = screenWidth;
        int height = screenHeight;

        if(screenWidth > x){
            width = x;
        }
        if(screenHeight > y){
            height = y;
        }

        int rightOffset = gamePanel.screenWidth - screenWidth;
        if(rightOffset > gamePanel.worldWidth - x){
            width = gamePanel.screenWidth - (gamePanel.worldWidth - x);
        }

        int bottomOffset = gamePanel.screenHeight - screenHeight;
        if(bottomOffset > gamePanel.worldHeight - y){
            height = gamePanel.screenHeight - (gamePanel.worldHeight - y);
        }

        graphics.drawImage(image, width, height, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}