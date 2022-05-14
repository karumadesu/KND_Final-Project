package main;

import entities.Entities;

public class CollisionChecker{
    GamePanel gamePanel;

    public CollisionChecker(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void CheckTile(Entities entity){
        int leftX = entity.xCoordinate + entity.collisionBounds.x;
        int rightX = entity.xCoordinate + entity.collisionBounds.x + entity.collisionBounds.width;
        int topY = entity.yCoordinate + entity.collisionBounds.y;
        int bottomY = entity.yCoordinate + entity.collisionBounds.y + entity.collisionBounds.height;

        int leftColumn = leftX / gamePanel.tileSize;
        int rightColumn = rightX / gamePanel.tileSize;
        int topRow = topY / gamePanel.tileSize;
        int bottomRow = bottomY / gamePanel.tileSize;

        int firstTile, secondTile;

        if(gamePanel.difficulty.equals("Easy")){
            switch(entity.direction){
                case "up":
                    topRow = (topY - entity.velocity) / gamePanel.tileSize;
                    firstTile = gamePanel.tileManager.tileNumberEasy[leftColumn][topRow];
                    secondTile = gamePanel.tileManager.tileNumberEasy[rightColumn][topRow];
    
                    if(gamePanel.tileManager.tile[firstTile].isColliding == true || gamePanel.tileManager.tile[secondTile].isColliding == true){
                        entity.collisionOn = true;
                    }
                    break;
                case "left":
                    leftColumn = (leftX - entity.velocity) / gamePanel.tileSize;
                    firstTile = gamePanel.tileManager.tileNumberEasy[leftColumn][topRow];
                    secondTile = gamePanel.tileManager.tileNumberEasy[leftColumn][bottomRow];
    
                    if(gamePanel.tileManager.tile[firstTile].isColliding == true || gamePanel.tileManager.tile[secondTile].isColliding == true){
                        entity.collisionOn = true;
                    }
                    break;
                case "down":
                    bottomRow = (bottomY + entity.velocity) / gamePanel.tileSize;
                    firstTile = gamePanel.tileManager.tileNumberEasy[leftColumn][bottomRow];
                    secondTile = gamePanel.tileManager.tileNumberEasy[rightColumn][bottomRow];
    
                    if(gamePanel.tileManager.tile[firstTile].isColliding == true || gamePanel.tileManager.tile[secondTile].isColliding == true){
                        entity.collisionOn = true;
                    }
                    break;
                case "right":
                    rightColumn = (rightX + entity.velocity) / gamePanel.tileSize;
                    firstTile = gamePanel.tileManager.tileNumberEasy[rightColumn][topRow];
                    secondTile = gamePanel.tileManager.tileNumberEasy[rightColumn][bottomRow];
    
                    if(gamePanel.tileManager.tile[firstTile].isColliding == true || gamePanel.tileManager.tile[secondTile].isColliding == true){
                        entity.collisionOn = true;
                    }
                    break;
            }
        }
        else if(gamePanel.difficulty.equals("Hard")){
            switch(entity.direction){
                case "up":
                    topRow = (topY - entity.velocity) / gamePanel.tileSize;
                    firstTile = gamePanel.tileManager.tileNumberHard[leftColumn][topRow];
                    secondTile = gamePanel.tileManager.tileNumberHard[rightColumn][topRow];
    
                    if(gamePanel.tileManager.tile[firstTile].isColliding == true || gamePanel.tileManager.tile[secondTile].isColliding == true){
                        entity.collisionOn = true;
                    }
                    break;
                case "left":
                    leftColumn = (leftX - entity.velocity) / gamePanel.tileSize;
                    firstTile = gamePanel.tileManager.tileNumberHard[leftColumn][topRow];
                    secondTile = gamePanel.tileManager.tileNumberHard[leftColumn][bottomRow];
    
                    if(gamePanel.tileManager.tile[firstTile].isColliding == true || gamePanel.tileManager.tile[secondTile].isColliding == true){
                        entity.collisionOn = true;
                    }
                    break;
                case "down":
                    bottomRow = (bottomY + entity.velocity) / gamePanel.tileSize;
                    firstTile = gamePanel.tileManager.tileNumberHard[leftColumn][bottomRow];
                    secondTile = gamePanel.tileManager.tileNumberHard[rightColumn][bottomRow];
    
                    if(gamePanel.tileManager.tile[firstTile].isColliding == true || gamePanel.tileManager.tile[secondTile].isColliding == true){
                        entity.collisionOn = true;
                    }
                    break;
                case "right":
                    rightColumn = (rightX + entity.velocity) / gamePanel.tileSize;
                    firstTile = gamePanel.tileManager.tileNumberHard[rightColumn][topRow];
                    secondTile = gamePanel.tileManager.tileNumberHard[rightColumn][bottomRow];
    
                    if(gamePanel.tileManager.tile[firstTile].isColliding == true || gamePanel.tileManager.tile[secondTile].isColliding == true){
                        entity.collisionOn = true;
                    }
                    break;
            }
        }
    }

    public int checkPellet(Entities entity){
        int index = 9999;

        for(int i = 0; i < gamePanel.pellets.length; i++){
            if(gamePanel.pellets[i] != null){
                entity.collisionBounds.x = entity.xCoordinate + entity.collisionBounds.x;
                entity.collisionBounds.y = entity.yCoordinate + entity.collisionBounds.y;

                gamePanel.pellets[i].collisionBounds.x = gamePanel.pellets[i].xCoordinate + gamePanel.pellets[i].collisionBounds.x;
                gamePanel.pellets[i].collisionBounds.y = gamePanel.pellets[i].yCoordinate + gamePanel.pellets[i].collisionBounds.y;

                if(entity.collisionBounds.intersects(gamePanel.pellets[i].collisionBounds)){
                    index = i;
                }

                entity.collisionBounds.x = entity.collisionBoundsX;
                entity.collisionBounds.y = entity.collisionBoundsY;

                gamePanel.pellets[i].collisionBounds.x = gamePanel.pellets[i].collisionBoundsX;
                gamePanel.pellets[i].collisionBounds.y = gamePanel.pellets[i].collisionBoundsY;
            }
        }
        return index;
    }
}
