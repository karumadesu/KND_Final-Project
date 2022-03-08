package tiles;

import main.GamePanel;
import java.awt.*;
import java.io.*;
import javax.imageio.*;

public class TileManager{
    GamePanel gamePanel;
    public GameTile[] tile;

    public int tileNumber[][];

    public TileManager(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        tile = new GameTile[6];
        tileNumber = new int[gamePanel.worldColumn][gamePanel.worldRow];

        getTileImage();
        loadMap("/maps/map1.txt");
    }

    public void getTileImage(){
        try{
            tile[0] = new GameTile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/images/tile/grass1.png"));
            
            tile[1] = new GameTile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/images/tile/grass2.png"));

            tile[2] = new GameTile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/images/tile/grass3.png"));

            tile[3] = new GameTile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/images/tile/grass4.png"));

            tile[4] = new GameTile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/images/tile/wall1.png"));
            tile[4].isColliding = true;

            tile[5] = new GameTile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/images/tile/wall2.png"));
            tile[5].isColliding = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void loadMap(String path){
        try{
            InputStream in = getClass().getResourceAsStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            int column = 0;
            int row = 0;

            while(column < gamePanel.worldColumn&& row < gamePanel.worldRow){
                String line = reader.readLine();

                while(column < gamePanel.worldColumn){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[column]);

                    tileNumber[column][row] = num;
                    column++;
                }
                if(column == gamePanel.worldColumn){
                    column = 0;
                    row++;
                }
            }
            reader.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics){
        int column = 0;
        int row = 0;

        while(column < gamePanel.worldColumn && row < gamePanel.worldRow){
            int mapTile = tileNumber[column][row];

            int worldX = column * gamePanel.tileSize;
            int worldY = row * gamePanel.tileSize;
            int screenX = worldX - gamePanel.player.x + gamePanel.player.screenWidth;
            int screenY = worldY - gamePanel.player.y + gamePanel.player.screenHeight;

            if(gamePanel.player.screenWidth > gamePanel.player.x){
                screenX = worldX;
            }
            if(gamePanel.player.screenHeight > gamePanel.player.y){
                screenY = worldY;
            }

            int rightOffset = gamePanel.screenWidth - gamePanel.player.screenWidth;
            if(rightOffset > gamePanel.worldWidth - gamePanel.player.x){
                screenX = gamePanel.screenWidth - (gamePanel.worldWidth - worldX);
            }

            int bottomOffset = gamePanel.screenHeight - gamePanel.player.screenHeight;
            if(bottomOffset > gamePanel.worldHeight - gamePanel.player.y){
                screenY = gamePanel.screenHeight - (gamePanel.worldHeight - worldY);
            }

            if(worldX + gamePanel.tileSize > gamePanel.player.x - gamePanel.player.screenWidth && 
               worldX - gamePanel.tileSize < gamePanel.player.x + gamePanel.player.screenWidth && 
               worldY + gamePanel.tileSize > gamePanel.player.y - gamePanel.player.screenHeight && 
               worldY - gamePanel.tileSize < gamePanel.player.y + gamePanel.player.screenHeight){
                    graphics.drawImage(tile[mapTile].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
                }
            else if(gamePanel.player.screenWidth > gamePanel.player.x || 
                    gamePanel.player.screenHeight > gamePanel.player.y || 
                    rightOffset > gamePanel.worldWidth - gamePanel.player.x || 
                    bottomOffset > gamePanel.worldHeight - gamePanel.player.y){
                        graphics.drawImage(tile[mapTile].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
                    }
            column++;

            if(column == gamePanel.worldColumn){
                column = 0;
                row++;
            }
        }
    }
}

