package main;

import java.awt.event.*;

public class KeyEvents implements KeyListener{
    public boolean w, a, s, d;

    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_W){ // Test if W key is pressed
            w = true;
        }
        if(keyCode == KeyEvent.VK_A){ // Test if A key is pressed
            a = true;
        }
        if(keyCode == KeyEvent.VK_S){ // Test if S key is pressed
            s = true;
        }
        if(keyCode == KeyEvent.VK_D){ // Test if D key is pressed
            d = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_W){ // Test if W key is released
            w = false;
        }
        if(keyCode == KeyEvent.VK_A){ // Test if A key is pressed
            a = false;
        }
        if(keyCode == KeyEvent.VK_S){ // Test if S key is pressed
            s = false;
        }
        if(keyCode == KeyEvent.VK_D){ // Test if D key is pressed
            d = false;
        }
    }
}
