package tiles;

import java.io.*;
import java.awt.*;
import javax.imageio.*;

import main.GamePanel;

public class TileManager{
    GamePanel gamePanel;

    public GameTile[] tile;
    public int tileNumberEasy[][];
    public int tileNumberHard[][];

    public TileManager(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        tile = new GameTile[8];
        tileNumberEasy = new int[gamePanel.screenColumn][gamePanel.screenRow];
        tileNumberHard = new int[gamePanel.hardColumn][gamePanel.hardRow];
        
        getTileImage();
    }

    public void getTileImage(){
        try{
            tile[0] = new GameTile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/tile_assets/grass_1.png"));
            
            tile[1] = new GameTile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/tile_assets/grass_2.png"));

            tile[2] = new GameTile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/tile_assets/grass_3.png"));

            tile[3] = new GameTile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/tile_assets/grass_4.png"));

            tile[4] = new GameTile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/tile_assets/wall_1.png"));
            tile[4].isColliding = true;
            
            tile[5] = new GameTile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/tile_assets/wall_2.png"));
            tile[5].isColliding = true;

            tile[6] = new GameTile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/tile_assets/grass_0.png"));

            tile[7] = new GameTile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/tile_assets/wall_0.png"));
            tile[7].isColliding = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void loadMap(String path){
        try{
            InputStream in = getClass().getResourceAsStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            int row = 0;
            int column = 0;

            if(gamePanel.difficulty.equals("Easy")){
                while(column < gamePanel.screenColumn && row < gamePanel.screenRow){
                    String line = reader.readLine();
    
                    while(column < gamePanel.screenColumn){
                        String numbers[] = line.split(" ");
    
                        int num = Integer.parseInt(numbers[column]);
    
                        tileNumberEasy[column][row] = num;
                        column++;
                    }
                    if(column == gamePanel.screenColumn){
                        column = 0;
                        row++;
                    }
                }
            }
            else if(gamePanel.difficulty.equals("Hard")){
                while(column < gamePanel.hardColumn && row < gamePanel.hardRow){
                    String line = reader.readLine();
    
                    while(column < gamePanel.hardColumn){
                        String numbers[] = line.split(" ");
    
                        int num = Integer.parseInt(numbers[column]);
    
                        tileNumberHard[column][row] = num;
                        column++;
                    }
                    if(column == gamePanel.hardColumn){
                        column = 0;
                        row++;
                    }
                }
            }
            
            reader.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics){
        int row = 0;
        int column = 0;

        if(gamePanel.difficulty.equals("Easy")){
            while(column < gamePanel.screenColumn && row < gamePanel.screenRow){
                int mapTile = tileNumberEasy[column][row];

                int mapX = column * gamePanel.tileSize;
                int mapY = row * gamePanel.tileSize;
                int screenX = mapX - gamePanel.player.xCoordinate + gamePanel.player.screenX;
                int screenY = mapY - gamePanel.player.yCoordinate + gamePanel.player.screenY;

                graphics.drawImage(tile[mapTile].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
                column++;

                if(column ==  gamePanel.screenColumn){
                    column = 0;
                    row++;
                }
            }
        }
        else if(gamePanel.difficulty.equals("Hard")){
            while(column < gamePanel.hardColumn && row < gamePanel.hardRow){
                int mapTile = tileNumberHard[column][row];

                int mapX = column * gamePanel.tileSize;
                int mapY = row * gamePanel.tileSize;
                int screenX = mapX - gamePanel.player.xCoordinate + gamePanel.player.screenX;
                int screenY = mapY - gamePanel.player.yCoordinate + gamePanel.player.screenY;
                
                graphics.drawImage(tile[mapTile].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
                column++;

                if(column ==  gamePanel.hardColumn){
                    column = 0;
                    row++;
                }
            }
        }
    }
}
