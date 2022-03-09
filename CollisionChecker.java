package main;

import entities.Entities;

public class CollisionChecker {
    GamePanel gamePanel;

    public CollisionChecker(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void checkTile(Entities entity){
        int leftX = entity.x + entity.collisionBounds.x;
        int rightX = entity.x + entity.collisionBounds.x + entity.collisionBounds.width;
        int topY = entity.y + entity.collisionBounds.y;
        int bottomY = entity.y + entity.collisionBounds.y + entity.collisionBounds.height;

        int leftColumn = leftX / gamePanel.tileSize;
        int rightColumn = rightX / gamePanel.tileSize;
        int topRow = topY / gamePanel.tileSize;
        int bottomRow = bottomY / gamePanel.tileSize;

        int firstTile, secondTile;

        switch(entity.direction){
            case "up":
                topRow = (topY - entity.v) / gamePanel.tileSize;
                firstTile = gamePanel.tile.tileNumber[leftColumn][topRow];
                secondTile = gamePanel.tile.tileNumber[rightColumn][topRow];

                if(gamePanel.tile.tile[firstTile].isColliding == true || gamePanel.tile.tile[secondTile].isColliding == true){
                    entity.collisionOn = true;
                }
                break;
            case "left":
                leftColumn = (leftX - entity.v) / gamePanel.tileSize;
                firstTile = gamePanel.tile.tileNumber[leftColumn][topRow];
                secondTile = gamePanel.tile.tileNumber[leftColumn][bottomRow];

                if(gamePanel.tile.tile[firstTile].isColliding == true || gamePanel.tile.tile[secondTile].isColliding == true){
                    entity.collisionOn = true;
                }
                break;
            case "down":
                bottomRow = (bottomY + entity.v) / gamePanel.tileSize;
                firstTile = gamePanel.tile.tileNumber[leftColumn][bottomRow];
                secondTile = gamePanel.tile.tileNumber[rightColumn][bottomRow];

                if(gamePanel.tile.tile[firstTile].isColliding == true || gamePanel.tile.tile[secondTile].isColliding == true){
                    entity.collisionOn = true;
                }
                break;
            case "right":
                rightColumn = (rightX + entity.v) / gamePanel.tileSize;
                firstTile = gamePanel.tile.tileNumber[rightColumn][topRow];
                secondTile = gamePanel.tile.tileNumber[rightColumn][bottomRow];

                if(gamePanel.tile.tile[firstTile].isColliding == true || gamePanel.tile.tile[secondTile].isColliding == true){
                    entity.collisionOn = true;
                }
                break;
        }
    }
}
