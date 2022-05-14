package pellets;

import javax.swing.*;

public class GrowthPellet extends Pellets{
    public GrowthPellet(){
        name = "Growth Pellet";
        try{
            animatedImage = new ImageIcon(getClass().getResource("/images/game_assets/pellet_assets/growth_pellet.gif")).getImage();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
