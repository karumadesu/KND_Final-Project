package pellets;

import javax.imageio.*;

public class NormalPellet extends Pellets{
    public NormalPellet(){
        name = "Normal Pellet";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/images/game_assets/pellet_assets/normal_pellet.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
