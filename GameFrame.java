package main;

import javax.swing.*;

public class GameFrame extends JFrame{
    GamePanel gamePanel;

    GameFrame(){
        gamePanel = new GamePanel();

        this.add(gamePanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("PacmanPH");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        gamePanel.startGameThread();
    }
}
