package pellets;

import javax.swing.*;

public class InformationPellet extends Pellets{
    public InformationPellet(){
        name = "Information Pellet";
        try{
            animatedImage = new ImageIcon(getClass().getResource("/images/game_assets/pellet_assets/information_pellet.gif")).getImage();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
