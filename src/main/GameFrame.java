package main;

import javax.swing.*;

public class GameFrame extends JFrame{
    GamePanel gamePanel;

    GameFrame(){
        gamePanel = new GamePanel();

        this.add(gamePanel);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
}