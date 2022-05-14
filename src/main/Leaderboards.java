package main;

import java.io.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;

public class Leaderboards{
    GamePanel gamePanel;
    BufferedImage backgroundImage, dialogueBox, leaderboardSelection, cursorImage;
    BufferedImage firstPlace, secondPlace, thirdPlace, belowThirdPlace;
    Font pixelFont36;

    String temp0, temp1, temp2;

    public Leaderboards(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        try{
            pixelFont36 = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/PixelMplus10-Regular.ttf")).deriveFont(36f);
            GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            environment.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/PixelMplus10-Regular.ttf")));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        getImage();
    }

    public void getImage(){
        try{
            backgroundImage = ImageIO.read(getClass().getResourceAsStream("/images/leaderboards/leaderboards.png"));
            dialogueBox = ImageIO.read(getClass().getResourceAsStream("/images/leaderboards/leaderboards_dialogue_box.png"));
            leaderboardSelection = ImageIO.read(getClass().getResourceAsStream("/images/leaderboards/leaderboards_selection.png"));
            firstPlace = ImageIO.read(getClass().getResourceAsStream("/images/leaderboards/first_place_icon.png"));
            secondPlace = ImageIO.read(getClass().getResourceAsStream("/images/leaderboards/second_place_icon.png"));
            thirdPlace = ImageIO.read(getClass().getResourceAsStream("/images/leaderboards/third_place_icon.png"));
            belowThirdPlace = ImageIO.read(getClass().getResourceAsStream("/images/leaderboards/below_third_place_icon.png"));
            cursorImage = ImageIO.read(getClass().getResourceAsStream("/images/main_menu/menu_cursor.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void getRanking(){
        for(int i = 0; i < gamePanel.level1Easy.length; i++){
            for(int j = i + 1; j < gamePanel.level1Easy.length; j++){
                if(gamePanel.level1Easy[j][1] != null)
                {
                    if(Integer.parseInt(gamePanel.level1Easy[i][1]) < Integer.parseInt(gamePanel.level1Easy[j][1])){
                        temp0 = gamePanel.level1Easy[i][0];
                        temp1 = gamePanel.level1Easy[i][1];
                        temp2 = gamePanel.level1Easy[i][2];
    
                        gamePanel.level1Easy[i][0] = gamePanel.level1Easy[j][0];
                        gamePanel.level1Easy[i][1] = gamePanel.level1Easy[j][1];
                        gamePanel.level1Easy[i][2] = gamePanel.level1Easy[j][2];
    
                        gamePanel.level1Easy[j][0] = temp0;
                        gamePanel.level1Easy[j][1] = temp1;
                        gamePanel.level1Easy[j][2] = temp2;
                    }
                }     
            }
        }

        for(int i = 0; i < gamePanel.level2Easy.length; i++){
            for(int j = i + 1; j < gamePanel.level2Easy.length; j++){
                if(gamePanel.level2Easy[j][1] != null)
                {
                    if(Integer.parseInt(gamePanel.level2Easy[i][1]) < Integer.parseInt(gamePanel.level2Easy[j][1])){
                        temp0 = gamePanel.level2Easy[i][0];
                        temp1 = gamePanel.level2Easy[i][1];
                        temp2 = gamePanel.level2Easy[i][2];
    
                        gamePanel.level2Easy[i][0] = gamePanel.level2Easy[j][0];
                        gamePanel.level2Easy[i][1] = gamePanel.level2Easy[j][1];
                        gamePanel.level2Easy[i][2] = gamePanel.level2Easy[j][2];
    
                        gamePanel.level2Easy[j][0] = temp0;
                        gamePanel.level2Easy[j][1] = temp1;
                        gamePanel.level2Easy[j][2] = temp2;
                    }
                }     
            }
        }

        for(int i = 0; i < gamePanel.level3Easy.length; i++){
            for(int j = i + 1; j < gamePanel.level3Easy.length; j++){
                if(gamePanel.level3Easy[j][1] != null)
                {
                    if(Integer.parseInt(gamePanel.level3Easy[i][1]) < Integer.parseInt(gamePanel.level3Easy[j][1])){
                        temp0 = gamePanel.level3Easy[i][0];
                        temp1 = gamePanel.level3Easy[i][1];
                        temp2 = gamePanel.level3Easy[i][2];
    
                        gamePanel.level3Easy[i][0] = gamePanel.level3Easy[j][0];
                        gamePanel.level3Easy[i][1] = gamePanel.level3Easy[j][1];
                        gamePanel.level3Easy[i][2] = gamePanel.level3Easy[j][2];
    
                        gamePanel.level3Easy[j][0] = temp0;
                        gamePanel.level3Easy[j][1] = temp1;
                        gamePanel.level3Easy[j][2] = temp2;
                    }
                }     
            }
        }

        for(int i = 0; i < gamePanel.level1Hard.length; i++){
            for(int j = i + 1; j < gamePanel.level1Hard.length; j++){
                if(gamePanel.level1Hard[j][1] != null)
                {
                    if(Integer.parseInt(gamePanel.level1Hard[i][1]) < Integer.parseInt(gamePanel.level1Hard[j][1])){
                        temp0 = gamePanel.level1Hard[i][0];
                        temp1 = gamePanel.level1Hard[i][1];
                        temp2 = gamePanel.level1Hard[i][2];
    
                        gamePanel.level1Hard[i][0] = gamePanel.level1Hard[j][0];
                        gamePanel.level1Hard[i][1] = gamePanel.level1Hard[j][1];
                        gamePanel.level1Hard[i][2] = gamePanel.level1Hard[j][2];
    
                        gamePanel.level1Hard[j][0] = temp0;
                        gamePanel.level1Hard[j][1] = temp1;
                        gamePanel.level1Hard[j][2] = temp2;
                    }
                }     
            }
        }

        for(int i = 0; i < gamePanel.level2Hard.length; i++){
            for(int j = i + 1; j < gamePanel.level2Hard.length; j++){
                if(gamePanel.level2Hard[j][1] != null)
                {
                    if(Integer.parseInt(gamePanel.level2Hard[i][1]) < Integer.parseInt(gamePanel.level2Hard[j][1])){
                        temp0 = gamePanel.level2Hard[i][0];
                        temp1 = gamePanel.level2Hard[i][1];
                        temp2 = gamePanel.level2Hard[i][2];
    
                        gamePanel.level2Hard[i][0] = gamePanel.level2Hard[j][0];
                        gamePanel.level2Hard[i][1] = gamePanel.level2Hard[j][1];
                        gamePanel.level2Hard[i][2] = gamePanel.level2Hard[j][2];
    
                        gamePanel.level2Hard[j][0] = temp0;
                        gamePanel.level2Hard[j][1] = temp1;
                        gamePanel.level2Hard[j][2] = temp2;
                    }
                }     
            }
        }

        for(int i = 0; i < gamePanel.level3Hard.length; i++){
            for(int j = i + 1; j < gamePanel.level3Hard.length; j++){
                if(gamePanel.level3Hard[j][1] != null)
                {
                    if(Integer.parseInt(gamePanel.level3Hard[i][1]) < Integer.parseInt(gamePanel.level3Hard[j][1])){
                        temp0 = gamePanel.level3Hard[i][0];
                        temp1 = gamePanel.level3Hard[i][1];
                        temp2 = gamePanel.level3Hard[i][2];
    
                        gamePanel.level3Hard[i][0] = gamePanel.level3Hard[j][0];
                        gamePanel.level3Hard[i][1] = gamePanel.level3Hard[j][1];
                        gamePanel.level3Hard[i][2] = gamePanel.level3Hard[j][2];
    
                        gamePanel.level3Hard[j][0] = temp0;
                        gamePanel.level3Hard[j][1] = temp1;
                        gamePanel.level3Hard[j][2] = temp2;
                    }
                }     
            }
        }
    }

    public void draw(Graphics2D graphics){
        if(gamePanel.hasSelected == false){
            graphics.drawImage(leaderboardSelection, 0, 0, gamePanel.screenWidth, gamePanel.screenHeight, null);

            if(gamePanel.leaderboardDifficulty == 0){
                if(gamePanel.leaderboardLevel == 0){
                    graphics.drawImage(cursorImage, 144, 300, 60, 60, null);
                }
                else if(gamePanel.leaderboardLevel == 1){
                    graphics.drawImage(cursorImage, 440, 300, 60, 60, null);
                }
                else if(gamePanel.leaderboardLevel == 2){
                    graphics.drawImage(cursorImage, 736, 300, 60, 60, null);
                }
            }
            else if(gamePanel.leaderboardDifficulty == 1){
                if(gamePanel.leaderboardLevel == 0){
                    graphics.drawImage(cursorImage, 144, 614, 60, 60, null);
                }
                else if(gamePanel.leaderboardLevel == 1){
                    graphics.drawImage(cursorImage, 440, 614, 60, 60, null);
                }
                else if(gamePanel.leaderboardLevel == 2){
                    graphics.drawImage(cursorImage, 736, 614, 60, 60, null);
                }
            }
        }
        if(gamePanel.hasSelected == true){
            graphics.drawImage(backgroundImage, 0, 0, gamePanel.screenWidth, gamePanel.screenHeight, null);
            graphics.drawImage(dialogueBox, 225, 120, 700, 620, null);

            graphics.setFont(pixelFont36);
            graphics.setColor(Color.WHITE);

            graphics.drawString("Username", 350, 230);
            graphics.drawString("Score", 550, 230);
            graphics.drawString("Time", 700, 230);

            graphics.setColor(Color.BLACK);

            graphics.drawImage(firstPlace, 250, 255, 70, 70, null);
            graphics.drawImage(secondPlace, 250, 348, 70, 70, null);
            graphics.drawImage(thirdPlace, 250, 441, 70, 70, null);
            graphics.drawImage(belowThirdPlace, 261, 540, 50, 70, null);
            graphics.drawImage(belowThirdPlace, 261, 633, 50, 70, null);

            if(gamePanel.leaderboardDifficulty == 0){
                if(gamePanel.leaderboardLevel == 0){
                    if(gamePanel.level1Easy[0][0] != null){
                        graphics.drawString(gamePanel.level1Easy[0][0], 350, 305);
                        graphics.drawString(gamePanel.level1Easy[0][1], 550, 305);
                        graphics.drawString(gamePanel.level1Easy[0][2], 700, 305);
                    }
                    else{
                        graphics.drawString("No Record", 350, 305);
                    }

                    if(gamePanel.level1Easy[1][0] != null){
                        graphics.drawString(gamePanel.level1Easy[1][0], 350, 398);
                        graphics.drawString(gamePanel.level1Easy[1][1], 550, 398);
                        graphics.drawString(gamePanel.level1Easy[1][2], 700, 398);
                    }
                    else{
                        graphics.drawString("No Record", 350, 398);
                    }

                    if(gamePanel.level1Easy[2][0] != null){
                        graphics.drawString(gamePanel.level1Easy[2][0], 350, 491);
                        graphics.drawString(gamePanel.level1Easy[2][1], 550, 491);
                        graphics.drawString(gamePanel.level1Easy[2][2], 700, 491);
                    }
                    else{
                        graphics.drawString("No Record", 350, 491);
                    }

                    if(gamePanel.level1Easy[3][0] != null){
                        graphics.drawString(gamePanel.level1Easy[3][0], 350, 584);
                        graphics.drawString(gamePanel.level1Easy[3][1], 550, 584);
                        graphics.drawString(gamePanel.level1Easy[3][2], 700, 584);
                    }
                    else{
                        graphics.drawString("No Record", 350, 584);
                    }

                    if(gamePanel.level1Easy[4][0] != null){
                        graphics.drawString(gamePanel.level1Easy[4][0], 350, 677);
                        graphics.drawString(gamePanel.level1Easy[4][1], 550, 677);
                        graphics.drawString(gamePanel.level1Easy[4][2], 700, 677);
                    }
                    else{
                        graphics.drawString("No Record", 350, 677);
                    }
                }
                else if(gamePanel.leaderboardLevel == 1){
                    if(gamePanel.level2Easy[0][0] != null){
                        graphics.drawString(gamePanel.level2Easy[0][0], 350, 305);
                        graphics.drawString(gamePanel.level2Easy[0][1], 550, 305);
                        graphics.drawString(gamePanel.level2Easy[0][2], 700, 305);
                    }
                    else{
                        graphics.drawString("No Record", 350, 305);
                    }

                    if(gamePanel.level2Easy[1][0] != null){
                        graphics.drawString(gamePanel.level2Easy[1][0], 350, 398);
                        graphics.drawString(gamePanel.level2Easy[1][1], 550, 398);
                        graphics.drawString(gamePanel.level2Easy[1][2], 700, 398);
                    }
                    else{
                        graphics.drawString("No Record", 350, 398);
                    }

                    if(gamePanel.level2Easy[2][0] != null){
                        graphics.drawString(gamePanel.level2Easy[2][0], 350, 491);
                        graphics.drawString(gamePanel.level2Easy[2][1], 550, 491);
                        graphics.drawString(gamePanel.level2Easy[2][2], 700, 491);
                    }
                    else{
                        graphics.drawString("No Record", 350, 491);
                    }

                    if(gamePanel.level2Easy[3][0] != null){
                        graphics.drawString(gamePanel.level2Easy[3][0], 350, 584);
                        graphics.drawString(gamePanel.level2Easy[3][1], 550, 584);
                        graphics.drawString(gamePanel.level2Easy[3][2], 700, 584);
                    }
                    else{
                        graphics.drawString("No Record", 350, 584);
                    }

                    if(gamePanel.level2Easy[4][0] != null){
                        graphics.drawString(gamePanel.level2Easy[4][0], 350, 677);
                        graphics.drawString(gamePanel.level2Easy[4][1], 550, 677);
                        graphics.drawString(gamePanel.level2Easy[4][2], 700, 677);
                    }
                    else{
                        graphics.drawString("No Record", 350, 677);
                    }
                }
                else if(gamePanel.leaderboardLevel == 2){
                    if(gamePanel.level3Easy[0][0] != null){
                        graphics.drawString(gamePanel.level3Easy[0][0], 350, 305);
                        graphics.drawString(gamePanel.level3Easy[0][1], 550, 305);
                        graphics.drawString(gamePanel.level3Easy[0][2], 700, 305);
                    }
                    else{
                        graphics.drawString("No Record", 350, 305);
                    }

                    if(gamePanel.level3Easy[1][0] != null){
                        graphics.drawString(gamePanel.level3Easy[1][0], 350, 398);
                        graphics.drawString(gamePanel.level3Easy[1][1], 550, 398);
                        graphics.drawString(gamePanel.level3Easy[1][2], 700, 398);
                    }
                    else{
                        graphics.drawString("No Record", 350, 398);
                    }

                    if(gamePanel.level3Easy[2][0] != null){
                        graphics.drawString(gamePanel.level3Easy[2][0], 350, 491);
                        graphics.drawString(gamePanel.level3Easy[2][1], 550, 491);
                        graphics.drawString(gamePanel.level3Easy[2][2], 700, 491);
                    }
                    else{
                        graphics.drawString("No Record", 350, 491);
                    }

                    if(gamePanel.level3Easy[3][0] != null){
                        graphics.drawString(gamePanel.level3Easy[3][0], 350, 584);
                        graphics.drawString(gamePanel.level3Easy[3][1], 550, 584);
                        graphics.drawString(gamePanel.level3Easy[3][2], 700, 584);
                    }
                    else{
                        graphics.drawString("No Record", 350, 584);
                    }

                    if(gamePanel.level3Easy[4][0] != null){
                        graphics.drawString(gamePanel.level3Easy[4][0], 350, 677);
                        graphics.drawString(gamePanel.level3Easy[4][1], 550, 677);
                        graphics.drawString(gamePanel.level3Easy[4][2], 700, 677);
                    }
                    else{
                        graphics.drawString("No Record", 350, 677);
                    }
                }
            }
            else if(gamePanel.leaderboardDifficulty == 1){
                if(gamePanel.leaderboardLevel == 0){
                    if(gamePanel.level1Hard[0][0] != null){
                        graphics.drawString(gamePanel.level1Hard[0][0], 350, 305);
                        graphics.drawString(gamePanel.level1Hard[0][1], 550, 305);
                        graphics.drawString(gamePanel.level1Hard[0][2], 700, 305);
                    }
                    else{
                        graphics.drawString("No Record", 350, 305);
                    }

                    if(gamePanel.level1Hard[1][0] != null){
                        graphics.drawString(gamePanel.level1Hard[1][0], 350, 398);
                        graphics.drawString(gamePanel.level1Hard[1][1], 550, 398);
                        graphics.drawString(gamePanel.level1Hard[1][2], 700, 398);
                    }
                    else{
                        graphics.drawString("No Record", 350, 398);
                    }

                    if(gamePanel.level1Hard[2][0] != null){
                        graphics.drawString(gamePanel.level1Hard[2][0], 350, 491);
                        graphics.drawString(gamePanel.level1Hard[2][1], 550, 491);
                        graphics.drawString(gamePanel.level1Hard[2][2], 700, 491);
                    }
                    else{
                        graphics.drawString("No Record", 350, 491);
                    }

                    if(gamePanel.level1Hard[3][0] != null){
                        graphics.drawString(gamePanel.level1Hard[3][0], 350, 584);
                        graphics.drawString(gamePanel.level1Hard[3][1], 550, 584);
                        graphics.drawString(gamePanel.level1Hard[3][2], 700, 584);
                    }
                    else{
                        graphics.drawString("No Record", 350, 584);
                    }

                    if(gamePanel.level1Hard[4][0] != null){
                        graphics.drawString(gamePanel.level1Hard[4][0], 350, 677);
                        graphics.drawString(gamePanel.level1Hard[4][1], 550, 677);
                        graphics.drawString(gamePanel.level1Hard[4][2], 700, 677);
                    }
                    else{
                        graphics.drawString("No Record", 350, 677);
                    }
                }
                else if(gamePanel.leaderboardLevel == 1){
                    if(gamePanel.level2Hard[0][0] != null){
                        graphics.drawString(gamePanel.level2Hard[0][0], 350, 305);
                        graphics.drawString(gamePanel.level2Hard[0][1], 550, 305);
                        graphics.drawString(gamePanel.level2Hard[0][2], 700, 305);
                    }
                    else{
                        graphics.drawString("No Record", 350, 305);
                    }

                    if(gamePanel.level2Hard[1][0] != null){
                        graphics.drawString(gamePanel.level2Hard[1][0], 350, 398);
                        graphics.drawString(gamePanel.level2Hard[1][1], 550, 398);
                        graphics.drawString(gamePanel.level2Hard[1][2], 700, 398);
                    }
                    else{
                        graphics.drawString("No Record", 350, 398);
                    }

                    if(gamePanel.level2Hard[2][0] != null){
                        graphics.drawString(gamePanel.level2Hard[2][0], 350, 491);
                        graphics.drawString(gamePanel.level2Hard[2][1], 550, 491);
                        graphics.drawString(gamePanel.level2Hard[2][2], 700, 491);
                    }
                    else{
                        graphics.drawString("No Record", 350, 491);
                    }

                    if(gamePanel.level2Hard[3][0] != null){
                        graphics.drawString(gamePanel.level2Hard[3][0], 350, 584);
                        graphics.drawString(gamePanel.level2Hard[3][1], 550, 584);
                        graphics.drawString(gamePanel.level2Hard[3][2], 700, 584);
                    }
                    else{
                        graphics.drawString("No Record", 350, 584);
                    }

                    if(gamePanel.level2Hard[4][0] != null){
                        graphics.drawString(gamePanel.level2Hard[4][0], 350, 677);
                        graphics.drawString(gamePanel.level2Hard[4][1], 550, 677);
                        graphics.drawString(gamePanel.level2Hard[4][2], 700, 677);
                    }
                    else{
                        graphics.drawString("No Record", 350, 677);
                    }
                }
                else if(gamePanel.leaderboardLevel == 2){
                    if(gamePanel.level3Hard[0][0] != null){
                        graphics.drawString(gamePanel.level3Hard[0][0], 350, 305);
                        graphics.drawString(gamePanel.level3Hard[0][1], 550, 305);
                        graphics.drawString(gamePanel.level3Hard[0][2], 700, 305);
                    }
                    else{
                        graphics.drawString("No Record", 350, 305);
                    }

                    if(gamePanel.level3Hard[1][0] != null){
                        graphics.drawString(gamePanel.level3Hard[1][0], 350, 398);
                        graphics.drawString(gamePanel.level3Hard[1][1], 550, 398);
                        graphics.drawString(gamePanel.level3Hard[1][2], 700, 398);
                    }
                    else{
                        graphics.drawString("No Record", 350, 398);
                    }

                    if(gamePanel.level3Hard[2][0] != null){
                        graphics.drawString(gamePanel.level3Hard[2][0], 350, 491);
                        graphics.drawString(gamePanel.level3Hard[2][1], 550, 491);
                        graphics.drawString(gamePanel.level3Hard[2][2], 700, 491);
                    }
                    else{
                        graphics.drawString("No Record", 350, 491);
                    }

                    if(gamePanel.level3Hard[3][0] != null){
                        graphics.drawString(gamePanel.level3Hard[3][0], 350, 584);
                        graphics.drawString(gamePanel.level3Hard[3][1], 550, 584);
                        graphics.drawString(gamePanel.level3Hard[3][2], 700, 584);
                    }
                    else{
                        graphics.drawString("No Record", 350, 584);
                    }

                    if(gamePanel.level3Hard[4][0] != null){
                        graphics.drawString(gamePanel.level3Hard[4][0], 350, 677);
                        graphics.drawString(gamePanel.level3Hard[4][1], 550, 677);
                        graphics.drawString(gamePanel.level3Hard[4][2], 700, 677);
                    }
                    else{
                        graphics.drawString("No Record", 350, 677);
                    }
                }
            }
        }
    }
}
