package main;

import java.awt.event.*;

public class KeyEvents implements KeyListener{
    GamePanel gamePanel;
    public boolean upKey, leftKey, downKey, rightKey;
    public boolean showMap = false;
    public boolean exitSplash = false;

    public KeyEvents(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP){
            if(gamePanel.gameState.equals("Main Menu")){
                if(gamePanel.mainMenu.menuCursor <= 0){
                    gamePanel.mainMenu.menuCursor = 3;
                    gamePanel.playSound(1);
                }
                else{
                    gamePanel.mainMenu.menuCursor--;
                    gamePanel.playSound(1);
                }
            }
            else if(gamePanel.gameState.equals("Settings")){
                if(gamePanel.settingOption == 0){
                    gamePanel.settingOption = 1;
                    gamePanel.playSound(1);
                }
                else if(gamePanel.settingOption == 1){
                    gamePanel.settingOption = 0;
                    gamePanel.playSound(1);
                }
            }
            else if(gamePanel.gameState.equals("In Game")){
                if(gamePanel.isCompleted == false){
                    upKey = true;
                }       
            }
            else if(gamePanel.gameState.equals("Leaderboards")){
                if(gamePanel.hasSelected == false){
                    if(gamePanel.leaderboardDifficulty == 1){
                        gamePanel.leaderboardDifficulty = 0;
                        gamePanel.playSound(1);
                    }
                }
            }
            else if(gamePanel.gameState.equals("Load Game")){
                if(gamePanel.loadRow > 0){
                    gamePanel.loadRow--;
                    gamePanel.playSound(1);
                }
            }
        }
        if(keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT){
            if(gamePanel.gameState.equals("New Game")){
                if(keyCode != KeyEvent.VK_A){
                    if(gamePanel.nameFieldNumber > 0){
                        gamePanel.nameFieldNumber--;
                        gamePanel.nameFieldX -= 50;
                        gamePanel.playSound(1);
                    }
                }
            }
            else if(gamePanel.gameState.equals("Difficulty Select")){
                gamePanel.difficulty = "Easy";
                gamePanel.playSound(1);
            }
            else if(gamePanel.gameState.equals("Level Select")){
                if(gamePanel.level > 0){
                    gamePanel.level--;
                    gamePanel.playSound(1);
                }
            }
            else if(gamePanel.gameState.equals("In Game")){
                if(gamePanel.isCompleted == false){
                    leftKey = true;
                }
                else if(gamePanel.isCompleted == true){
                    if(gamePanel.level != 2){
                        gamePanel.levelCompleteOption = 0;
                        gamePanel.playSound(1);
                    }
                }
            }
            else if(gamePanel.gameState.equals("Settings")){
                if(gamePanel.settingOption == 0 && gamePanel.isMuted == false){
                    if(gamePanel.volumeLevel >= 0){
                        if(gamePanel.volumeLevel > 1){
                            gamePanel.volume -= 0.25f;
                            gamePanel.volumeValue -= 70;
                            gamePanel.sliderPosition -= 70;
                            gamePanel.volumeLevel--;

                            gamePanel.playSound(1);
                            gamePanel.stopMusic();
                            gamePanel.playMusic(2);
                        }
                        else if(gamePanel.volumeLevel == 1){
                            gamePanel.volume = 0.0f;
                            gamePanel.volumeValue = 0;
                            gamePanel.sliderPosition = 467;
                            gamePanel.volumeLevel--;

                            gamePanel.playSound(1);
                            gamePanel.stopMusic();
                            gamePanel.playMusic(2);
                        }
                    }
                }
            }
            else if(gamePanel.gameState.equals("Exit Menu")){
                gamePanel.exitOption = false;
                gamePanel.playSound(1);
            }
            else if(gamePanel.gameState.equals("Leaderboards")){
                if(gamePanel.hasSelected == false){
                    if(gamePanel.leaderboardLevel > 0){
                        gamePanel.leaderboardLevel--;
                        gamePanel.playSound(1);
                    }
                }
            }
            else if(gamePanel.gameState.equals("Load Game")){
                if(gamePanel.loadColumn > 0){
                    gamePanel.loadColumn--;
                    gamePanel.playSound(1);
                }
            }
        }
        if(keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN){
            if(gamePanel.gameState.equals("Main Menu")){
                if(gamePanel.mainMenu.menuCursor >= 3){
                    gamePanel.mainMenu.menuCursor = 0;
                    gamePanel.playSound(1);
                }
                else{
                    gamePanel.mainMenu.menuCursor++;
                    gamePanel.playSound(1);
                }
            }
            else if(gamePanel.gameState.equals("Settings")){
                if(gamePanel.settingOption == 1){
                    gamePanel.settingOption = 0;
                    gamePanel.playSound(1);
                }
                else if(gamePanel.settingOption == 0){
                    gamePanel.settingOption = 1;
                    gamePanel.playSound(1);
                }
            }
            else if(gamePanel.gameState.equals("In Game")){
                if(gamePanel.isCompleted == false){
                    downKey = true;
                }    
            }
            else if(gamePanel.gameState.equals("Leaderboards")){
                if(gamePanel.hasSelected == false){
                    if(gamePanel.leaderboardDifficulty == 0){
                        gamePanel.leaderboardDifficulty = 1;
                        gamePanel.playSound(1);
                    }
                }
            }
            else if(gamePanel.gameState.equals("Load Game")){
                if(gamePanel.loadRow < 2){
                    gamePanel.loadRow++;
                    gamePanel.playSound(1);
                }
            }
        }
        if(keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT){
            if(gamePanel.gameState.equals("New Game")){
                if(keyCode != KeyEvent.VK_D){
                    if(gamePanel.nameFieldNumber < 2){
                        gamePanel.nameFieldNumber++;
                        gamePanel.nameFieldX += 50;
                        gamePanel.playSound(1);
                    }
                }
            }
            else if(gamePanel.gameState.equals("Difficulty Select")){
                gamePanel.difficulty = "Hard";
                gamePanel.playSound(1);
            }
            else if(gamePanel.gameState.equals("Level Select")){
                if(gamePanel.difficulty == "Easy"){
                    if(gamePanel.level < 2 && gamePanel.level < gamePanel.easyProgress){
                        gamePanel.level++;
                        gamePanel.playSound(1);
                    }
                }
                else if(gamePanel.difficulty.equals("Hard")){
                    if(gamePanel.level < 2 && gamePanel.level < gamePanel.hardProgress){
                        gamePanel.level++;
                        gamePanel.playSound(1);
                    }
                }
            }
            else if(gamePanel.gameState.equals("In Game")){
                if(gamePanel.isCompleted == false){
                    rightKey = true;
                }
                else if(gamePanel.isCompleted == true){
                    if(gamePanel.level != 2){
                        gamePanel.levelCompleteOption = 1;
                        gamePanel.playSound(1);
                    }
                }
            }
            else if(gamePanel.gameState.equals("Settings")){
                if(gamePanel.settingOption == 0 && gamePanel.isMuted == false){
                    if(gamePanel.volumeLevel <= 4){
                        if(gamePanel.volumeLevel < 3){
                            gamePanel.volume += 0.25f;
                            gamePanel.volumeValue += 70;
                            gamePanel.sliderPosition += 70;
                            gamePanel.volumeLevel++;
    
                            gamePanel.playSound(1);
                            gamePanel.stopMusic();
                            gamePanel.playMusic(2);
                        }
                        else if(gamePanel.volumeLevel == 3){
                            gamePanel.volume = 1.0f;
                            gamePanel.volumeValue = 281;
                            gamePanel.sliderPosition = 748;
                            gamePanel.volumeLevel++;
    
                            gamePanel.playSound(1);
                            gamePanel.stopMusic();
                            gamePanel.playMusic(2);
                        }
                    }
                }
            }
            else if(gamePanel.gameState.equals("Exit Menu")){
                gamePanel.exitOption = true;
                gamePanel.playSound(1);
            }
            else if(gamePanel.gameState.equals("Leaderboards")){
                if(gamePanel.hasSelected == false){
                    if(gamePanel.leaderboardLevel < 2){
                        gamePanel.leaderboardLevel++;
                        gamePanel.playSound(1);
                    }
                }
            }
            else if(gamePanel.gameState.equals("Load Game")){
                if(gamePanel.loadColumn < 01){
                    gamePanel.loadColumn++;
                    gamePanel.playSound(1);
                }
            }
        }
        if(keyCode == KeyEvent.VK_M){
            if(gamePanel.gameState.equals("In Game")){
                if(showMap == true){
                    showMap = false;
                    gamePanel.playSound(1);
                }
                else{
                    showMap = true;
                    gamePanel.playSound(1);
                }
            }
        }
        if(keyCode == KeyEvent.VK_ENTER){
            if(gamePanel.gameState.equals("Main Menu")){
                if(gamePanel.mainMenu.menuCursor == 0){
                    gamePanel.gameState = "New Game";
                    gamePanel.playSound(1);
                }
                else if(gamePanel.mainMenu.menuCursor == 1){
                    gamePanel.gameState = "Load Game";
                    gamePanel.playSound(1);
                }
                else if(gamePanel.mainMenu.menuCursor == 2){
                    gamePanel.gameState = "Leaderboards";
                    gamePanel.playSound(1);
                }
                else if(gamePanel.mainMenu.menuCursor == 3){
                    gamePanel.gameState = "Exit Menu";
                    gamePanel.hasExited = true;
                    gamePanel.playSound(1);
                }
            }
            else if(gamePanel.gameState.equals("New Game")){
                gamePanel.userChecker.checkUser();

                if(gamePanel.isTaken == false){
                    gamePanel.hasEntered = true;
                    gamePanel.gameState = "Difficulty Select";

                    gamePanel.easyProgress = 0;
                    gamePanel.hardProgress = 0;
                }
                else if(gamePanel.isTaken == true && gamePanel.showAlert == true){
                    gamePanel.isTaken = false;
                    gamePanel.showAlert = false;
                }
                else if(gamePanel.showAlert == false){
                    gamePanel.showAlert = true;
                }
                
                gamePanel.playSound(1);
            }
            else if(gamePanel.gameState.equals("Difficulty Select")){
                gamePanel.gameState = "Level Select";
                gamePanel.playSound(1);
            }
            else if(gamePanel.gameState.equals("Level Select")){
                gamePanel.stopMusic();
                gamePanel.playMusic(3);      

                if(gamePanel.difficulty.equals("Easy")){
                    if(gamePanel.level == 0){
                        gamePanel.gameState = "In Game";
                        gamePanel.tileManager.loadMap(gamePanel.easyMap1);

                        for(int i = 0; i < gamePanel.pellets.length; i++){
                            gamePanel.pellets[i] = null;
                        }

                        gamePanel.pelletManager.loadPellets(gamePanel.pelletMapEasy1);
                        gamePanel.player.setDefaultValues();
                        gamePanel.pelletSetter.setPellets();
                        gamePanel.playSound(1);
                    }
                    else if(gamePanel.level == 1){
                        gamePanel.gameState = "In Game";
                        gamePanel.tileManager.loadMap(gamePanel.easyMap2);

                        for(int i = 0; i < gamePanel.pellets.length; i++){
                            gamePanel.pellets[i] = null;
                        }

                        gamePanel.pelletManager.loadPellets(gamePanel.pelletMapEasy2);
                        gamePanel.player.setDefaultValues();
                        gamePanel.pelletSetter.setPellets();
                        gamePanel.playSound(1);
                    }
                    else if(gamePanel.level == 2){
                        gamePanel.gameState = "In Game";
                        gamePanel.tileManager.loadMap(gamePanel.easyMap3);

                        for(int i = 0; i < gamePanel.pellets.length; i++){
                            gamePanel.pellets[i] = null;
                        }

                        gamePanel.pelletManager.loadPellets(gamePanel.pelletMapEasy3);
                        gamePanel.player.setDefaultValues();
                        gamePanel.pelletSetter.setPellets();
                        gamePanel.playSound(1);
                    }
                }
                else if(gamePanel.difficulty.equals("Hard")){
                    if(gamePanel.level == 0){
                        gamePanel.gameState = "In Game";
                        gamePanel.tileManager.loadMap(gamePanel.hardMap1);

                        for(int i = 0; i < gamePanel.pellets.length; i++){
                            gamePanel.pellets[i] = null;
                        }

                        gamePanel.pelletManager.loadPellets(gamePanel.pelletMapHard1);
                        gamePanel.player.setDefaultValues();
                        gamePanel.pelletSetter.setPellets();
                        gamePanel.playSound(1);
                    }
                    else if(gamePanel.level == 1){
                        gamePanel.gameState = "In Game";
                        gamePanel.tileManager.loadMap(gamePanel.hardMap2);

                        for(int i = 0; i < gamePanel.pellets.length; i++){
                            gamePanel.pellets[i] = null;
                        }

                        gamePanel.pelletManager.loadPellets(gamePanel.pelletMapHard2);
                        gamePanel.player.setDefaultValues();
                        gamePanel.pelletSetter.setPellets();
                        gamePanel.playSound(1);
                    }
                    else if(gamePanel.level == 2){
                        gamePanel.gameState = "In Game";
                        gamePanel.tileManager.loadMap(gamePanel.hardMap3);

                        for(int i = 0; i < gamePanel.pellets.length; i++){
                            gamePanel.pellets[i] = null;
                        }
                        
                        gamePanel.pelletManager.loadPellets(gamePanel.pelletMapHard3);
                        gamePanel.player.setDefaultValues();
                        gamePanel.pelletSetter.setPellets();
                        gamePanel.playSound(1);
                    }
                }
            }
            else if(gamePanel.gameState.equals("Settings")){
                if(gamePanel.settingOption == 1){
                    if(gamePanel.isMuted == true){
                        gamePanel.isMuted = false;
                        gamePanel.playMusic(2);
                        gamePanel.playSound(1);
                    }
                    else{
                        gamePanel.isMuted = true;
                        gamePanel.stopMusic();
                        gamePanel.playSound(1);
                    }
                }
            }
            else if(gamePanel.gameState.equals("Exit Menu")){
                if(gamePanel.exitOption){
                    gamePanel.playSound(1);
                    System.exit(0);
                }
                else if(gamePanel.exitOption == false){
                    gamePanel.gameState = "Main Menu";
                    gamePanel.hasExited = false;
                    gamePanel.playSound(1);
                }
            }
            else if(gamePanel.gameState.equals("In Game")){
                if(gamePanel.showTrivia == true){
                    gamePanel.showTrivia = false;
                }
                if(gamePanel.isCompleted == true){
                    if(gamePanel.difficulty.equals("Easy")){
                        if(gamePanel.easyProgress < 2){
                            gamePanel.easyProgress++;
                        } 
                    }
                    else if(gamePanel.difficulty.equals("Hard")){
                        if(gamePanel.hardProgress < 2){
                            gamePanel.hardProgress++;
                        }
                    }

                    gamePanel.saveRecords.saveAccount();

                    if(gamePanel.levelCompleteOption == 0){
                        gamePanel.gameState = "Main Menu";
                        gamePanel.isCompleted = false;
                        gamePanel.hasPlayed = false;
                        gamePanel.playSecond = 0;
                        gamePanel.playMinute = 0;
                        gamePanel.levelCompleteOption = 0;

                        gamePanel.stopSound();
                        gamePanel.stopMusic();
                        gamePanel.stopLevelComplete();
                        gamePanel.playMusic(2);
                    }
                    else if(gamePanel.levelCompleteOption == 1){
                        if(gamePanel.level < 2){
                            gamePanel.level++;
                            gamePanel.isCompleted = false;
                            gamePanel.hasPlayed = false;
                            gamePanel.playSecond = 0;
                            gamePanel.playMinute = 0;
                            gamePanel.levelCompleteOption = 0;

                            gamePanel.stopSound();
                            gamePanel.stopMusic();
                            gamePanel.stopLevelComplete();
                            gamePanel.playMusic(3); 

                            if(gamePanel.difficulty.equals("Easy")){
                                if(gamePanel.level == 0){
                                    gamePanel.tileManager.loadMap(gamePanel.easyMap1);

                                    for(int i = 0; i < gamePanel.pellets.length; i++){
                                        gamePanel.pellets[i] = null;
                                    }

                                    gamePanel.pelletManager.loadPellets(gamePanel.pelletMapEasy1);
                                    gamePanel.player.setDefaultValues();
                                    gamePanel.pelletSetter.setPellets();
                                }
                                else if(gamePanel.level == 1){
                                    gamePanel.tileManager.loadMap(gamePanel.easyMap2);

                                    for(int i = 0; i < gamePanel.pellets.length; i++){
                                        gamePanel.pellets[i] = null;
                                    }

                                    gamePanel.pelletManager.loadPellets(gamePanel.pelletMapEasy2);
                                    gamePanel.player.setDefaultValues();
                                    gamePanel.pelletSetter.setPellets();
                                }
                                else if(gamePanel.level == 2){
                                    gamePanel.tileManager.loadMap(gamePanel.easyMap3);

                                    for(int i = 0; i < gamePanel.pellets.length; i++){
                                        gamePanel.pellets[i] = null;
                                    }

                                    gamePanel.pelletManager.loadPellets(gamePanel.pelletMapEasy3);
                                    gamePanel.player.setDefaultValues();
                                    gamePanel.pelletSetter.setPellets();
                                }
                            }
                            else if(gamePanel.difficulty.equals("Hard")){
                                if(gamePanel.level == 0){
                                    gamePanel.gameState = "In Game";
                                    gamePanel.tileManager.loadMap(gamePanel.hardMap1);

                                    for(int i = 0; i < gamePanel.pellets.length; i++){
                                        gamePanel.pellets[i] = null;
                                    }

                                    gamePanel.pelletManager.loadPellets(gamePanel.pelletMapHard1);
                                    gamePanel.player.setDefaultValues();
                                    gamePanel.pelletSetter.setPellets();
                                    gamePanel.playSound(1);
                                }
                                else if(gamePanel.level == 1){
                                    gamePanel.gameState = "In Game";
                                    gamePanel.tileManager.loadMap(gamePanel.hardMap2);

                                    for(int i = 0; i < gamePanel.pellets.length; i++){
                                        gamePanel.pellets[i] = null;
                                    }

                                    gamePanel.pelletManager.loadPellets(gamePanel.pelletMapHard2);
                                    gamePanel.player.setDefaultValues();
                                    gamePanel.pelletSetter.setPellets();
                                    gamePanel.playSound(1);
                                }
                                else if(gamePanel.level == 2){
                                    gamePanel.gameState = "In Game";
                                    gamePanel.tileManager.loadMap(gamePanel.hardMap3);

                                    for(int i = 0; i < gamePanel.pellets.length; i++){
                                        gamePanel.pellets[i] = null;
                                    }
                                    
                                    gamePanel.pelletManager.loadPellets(gamePanel.pelletMapHard3);
                                    gamePanel.player.setDefaultValues();
                                    gamePanel.pelletSetter.setPellets();
                                    gamePanel.playSound(1);
                                }
                            }
                        }
                    }
                }
            }
            else if(gamePanel.gameState.equals("Leaderboards")){
                gamePanel.hasSelected = true;
                
                gamePanel.loadRecords.loadRecords();
                gamePanel.leaderboards.getRanking();
                gamePanel.playSound(1);
            }
            else if(gamePanel.gameState.equals("Load Game")){
                gamePanel.gameState = "Difficulty Select";

                gamePanel.playerName[0] = gamePanel.loadedAccounts[gamePanel.loadedAccount][0].charAt(0);
                gamePanel.playerName[1] = gamePanel.loadedAccounts[gamePanel.loadedAccount][0].charAt(1);
                gamePanel.playerName[2] = gamePanel.loadedAccounts[gamePanel.loadedAccount][0].charAt(2);

                gamePanel.easyProgress = Integer.parseInt(gamePanel.loadedAccounts[gamePanel.loadedAccount][1]);
                gamePanel.hardProgress = Integer.parseInt(gamePanel.loadedAccounts[gamePanel.loadedAccount][2]);

                gamePanel.playSound(1);
            }
        }
        if(keyCode == KeyEvent.VK_ESCAPE){
            if(gamePanel.gameState.equals("Main Menu")){
                gamePanel.gameState = "Settings";
                gamePanel.hasExited = true;
                gamePanel.playSound(1);
            }
            else if(gamePanel.gameState.equals("Settings")){
                gamePanel.gameState = "Main Menu";
                gamePanel.hasExited = false;
                gamePanel.playSound(1);
            }
            else if(gamePanel.gameState.equals("New Game")){
                gamePanel.gameState = "Main Menu";
                gamePanel.hasEntered = false;
                gamePanel.playSound(1);
            }
            else if(gamePanel.gameState.equals("Difficulty Select")){
                gamePanel.gameState = "New Game";
                gamePanel.hasEntered = false;
                gamePanel.playSound(1);
            }
            else if(gamePanel.gameState.equals("Level Select")){
                gamePanel.gameState = "Difficulty Select";
                gamePanel.level = 0;
                gamePanel.playSound(1);
            }
            else if(gamePanel.gameState.equals("In Game")){
                gamePanel.gameState = "Level Select";
                gamePanel.stopMusic();
                gamePanel.stopSound();
                gamePanel.playMusic(2);
                gamePanel.playSound(1);
            }
            else if(gamePanel.gameState.equals("Leaderboards")){
                if(gamePanel.hasSelected == true){
                    gamePanel.hasSelected = false;
                }
                else{
                    gamePanel.gameState = "Main Menu";
                    gamePanel.leaderboardDifficulty = 0;
                    gamePanel.leaderboardLevel = 0;
                }
                gamePanel.playSound(1);
            }
            else if(gamePanel.gameState.equals("Load Game")){
                gamePanel.gameState = "Main Menu";

                gamePanel.playSound(1);
            }
        }
        if(keyCode != KeyEvent.VK_ALL_CANDIDATES){
            if(gamePanel.gameState.equals("Splash Screen")){
                if(exitSplash == false && gamePanel.iterator == 1152){
                    exitSplash = true;
                    gamePanel.playMusic(2);
                }
            }
            else if(gamePanel.gameState.equals("New Game")){
                if((keyCode >= 65 && keyCode <= 90) ||
                   (keyCode >= 96 && keyCode <= 105) ||
                   (keyCode >= 48 && keyCode <= 57)){
                    gamePanel.playerName[gamePanel.nameFieldNumber] = e.getKeyChar();
                    gamePanel.playSound(1);
                } 
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP){
            if(gamePanel.gameState.equals("In Game")){
                upKey = false;
            }
        }
        if(keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT){
            if(gamePanel.gameState.equals("In Game")){
                leftKey = false;
            }
        }
        if(keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN){
            if(gamePanel.gameState.equals("In Game")){
                downKey = false;
            }
        }
        if(keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT){
            if(gamePanel.gameState.equals("In Game")){
                rightKey = false;
            }
        }
    }
}
