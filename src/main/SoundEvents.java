package main;

import javax.sound.sampled.Clip;
import javax.sound.sampled.*;
import java.net.URL;

public class SoundEvents{
    GamePanel gamePanel;
    Clip clip;

    URL audio[] = new URL[20];
    
    public SoundEvents(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        audio[0] = getClass().getResource("/audio/splash_sfx.wav");
        audio[1] = getClass().getResource("/audio/option_select_sfx.wav");
        audio[2] = getClass().getResource("/audio/menu_music.wav");
        audio[3] = getClass().getResource("/audio/game_music.wav");
        audio[4] = getClass().getResource("/audio/normal_pellet_sfx.wav");
        audio[5] = getClass().getResource("/audio/growth_pellet_sfx.wav");
        audio[6] = getClass().getResource("/audio/information_pellet_sfx.wav");
        audio[7] = getClass().getResource("/audio/insufficient_size_sfx.wav");
        audio[8] = getClass().getResource("/audio/level_complete_music.wav");
    }

    public void getAudio(int option){
        try{
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(audio[option]);
            clip = AudioSystem.getClip();
            clip.open(audioInput);

            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(20f * (float) Math.log10(gamePanel.volume));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void play(){
        clip.start();
    }

    public void loop(int option){
        if(option == 2){
            clip.setLoopPoints(0, 408000);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        else{
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void stop(){
        clip.stop();
    }
}