package entities;

import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;

import main.GamePanel;
import main.KeyEvents;

public class Player extends Entities{
    GamePanel gamePanel;
    KeyEvents keyEvents;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gamePanel, KeyEvents keyEvents){
        this.gamePanel = gamePanel;
        this.keyEvents = keyEvents;

        screenX = (gamePanel.screenWidth / 2) - (gamePanel.tileSize / 2);
        screenY = (gamePanel.screenHeight / 2) - (gamePanel.tileSize / 2);

        collisionBounds = new Rectangle();
        collisionBounds.x = 25;
        collisionBounds.y = 22;
        collisionBounds.width = 18;
        collisionBounds.height = 41;

        collisionBoundsX = collisionBounds.x;
        collisionBoundsY = collisionBounds.y;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        xCoordinate = gamePanel.tileSize * 1;
        yCoordinate = gamePanel.tileSize * 1;
        velocity = 6;
        direction = "down";

        playerScore = 0;
        playerSize = 0;
        playerInfo = 0;
    }

    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/character_assets/pacman_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/character_assets/pacman_up_2.png"));
            upIdle = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/character_assets/pacman_up_idle.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/character_assets/pacman_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/character_assets/pacman_down_2.png"));
            downIdle = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/character_assets/pacman_down_idle.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/character_assets/pacman_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/character_assets/pacman_left_2.png"));
            leftIdle = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/character_assets/pacman_left_idle.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/character_assets/pacman_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/character_assets/pacman_right_2.png"));
            rightIdle = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/character_assets/pacman_right_idle.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(keyEvents.upKey == true || keyEvents.downKey == true || keyEvents.leftKey == true || keyEvents.rightKey == true){
            if(keyEvents.upKey == true){
                direction = "up";
            }
            else if(keyEvents.downKey == true){
                direction = "down";
            }
            else if(keyEvents.leftKey == true){
                direction = "left";
            }
            else if(keyEvents.rightKey == true){
                direction = "right";
            }

            collisionOn = false;

            gamePanel.collisionChecker.CheckTile(this);
            int pelletIndex = gamePanel.collisionChecker.checkPellet(this);
            pickPellet(pelletIndex);
            
            if(collisionOn == false){
                switch(direction){
                    case "up":
                        yCoordinate -= velocity;
                        break;
                    case "down":
                        yCoordinate += velocity;  
                        break;
                    case "left":
                        xCoordinate -= velocity;
                        break;
                    case "right":
                        xCoordinate += velocity;
                        break;
                }
            }
            
            spriteCounter++;
            if(spriteCounter > gamePanel.framePerSecond / 6){
                if(spriteNumber == 1){
                    spriteNumber = 2;
                }
                else if(spriteNumber == 2 || spriteNumber == 3){
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        }
        else{
            standCounter++;

            if(standCounter > 20){
                spriteNumber = 3;
                standCounter = 0;
            }
        }
    }

    public void pickPellet(int index){
        if(index != 9999){
            String pelletName = gamePanel.pellets[index].name;

            if(gamePanel.difficulty.equals("Easy")){
                switch(pelletName){
                    case "Normal Pellet":
                        playerScore += 1;
                        gamePanel.pellets[index] = null;
                        gamePanel.playSound(4);
                        break;
                    case "Growth Pellet":
                        playerScore += 3;
                        playerSize++;
                        gamePanel.pellets[index] = null;
                        gamePanel.playSound(5);
                        break;
                    case "Information Pellet":
                        if(playerSize > playerInfo){
                            playerScore += 5;
                            playerInfo++;
                            gamePanel.pellets[index] = null;
                            gamePanel.showTrivia = true;
                            gamePanel.playSound(6);
                        }
                        else{
                            gamePanel.playSound(7);
                        }
                        break;
                }
            }
            else if(gamePanel.difficulty.equals("Hard")){
                switch(pelletName){
                    case "Normal Pellet":
                        playerScore += 2;
                        gamePanel.pellets[index] = null;
                        gamePanel.playSound(4);
                        break;
                    case "Growth Pellet":
                        playerScore += 6;
                        playerSize++;
                        gamePanel.pellets[index] = null;
                        gamePanel.playSound(5);
                        break;
                    case "Information Pellet":
                        if(playerSize > playerInfo){
                            playerScore += 10;
                            playerInfo++;
                            gamePanel.pellets[index] = null;
                            gamePanel.showTrivia = true;
                            gamePanel.playSound(6);
                        }
                        else{
                            gamePanel.playSound(7);
                        }
                        break;
                }
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
                    image = upIdle;
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
                    image = leftIdle;
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
                    image = downIdle;
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
                    image = rightIdle;
                }
                break;
        }

        graphics.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
