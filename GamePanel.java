package main;

import java.awt.*;
import javax.swing.*;
import entities.Player;
import tiles.TileManager;

public class GamePanel extends JPanel implements Runnable{
    public final int tileSize = 64; // Size of a tile in pixels
    public final int screenColumn = 18; // Number of tiles displayed in the x axis             
    public final int screenRow = 12; // Number of tiles displayed in the y axis
    public final int screenWidth = tileSize * screenColumn; // Size of the width of the screen in pixels
    public final int screenHeight = tileSize * screenRow; // Size of the height of the screen in pixels

    public final int worldColumn = 50; // Number of tiles displayed in the x axis for the hard map
    public final int worldRow = 50; // Number of tiles displayed in the y axis for the hard map
    public final int worldWidth = tileSize * worldColumn; // Size of the width of the hard map in pixels
    public final int worldHeight = tileSize * worldRow; // Size of the height of the hard map in pixels
    
    public final int framePerSecond = 60; // Number of frames generated per second

    public KeyEvents keyboardEvents = new KeyEvents(); // Create Key Event Object
    public Player player = new Player(this, keyboardEvents); // Create Player Object
    public CollisionChecker collision = new CollisionChecker(this); // Create Collision Checker Object
    public UserInterface userInterface = new UserInterface(this); // Create User Interface Object
    TileManager tile = new TileManager(this); // Create Tile Manager Object
    Thread gameThread; // Create Thread Object

    public GamePanel(){ // Constructor for GamePanel Class
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyboardEvents);
        this.setFocusable(true);
    }

    public void startGameThread(){ // Method for starting gameThread
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){ // Override default thread run method
        double interval = 1000000000 / framePerSecond; // Interval in terms of nanoseconds
        double nextInterval = System.nanoTime() + interval; // Next thread interval in nanoseconds

        while(gameThread != null){
            update();
            repaint();

            try{
                double remainingTime = nextInterval - System.nanoTime(); // Remaining time before next interval in nanoseconds
                remainingTime = remainingTime / 1000000; // Remaining time in milliseconds

                if(remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                nextInterval += interval; // Determine next interval
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void update(){ // Method to update player sprite 
        player.update();
    }

    public void paintComponent(Graphics g){ // Method to paint components in window
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        tile.draw(graphics);
        player.draw(graphics);
        userInterface.draw(graphics);
        graphics.dispose();
    }
}
