import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;

public class Craft {

    private int dx;
    private int dy;
    private int x;
    private int y;
    private int lastx,lasty;
    private Image image;

    public Craft() {
        
        initCraft();
    }
    
    private void initCraft() {
        
        ImageIcon ii = new ImageIcon("monster.png");
        image = ii.getImage();
        x = 0;
        y = 0;        
    }


    public void move() {
    	if(x + (dx * 64) >= 0 && (x + (dx * 64) <= 13 * 64) && y + (dy * 64) >= 0 && (y + (dy * 64) <= 10 * 64) ){
        lastx = x;
        lasty = y;
    	x += (dx * 64);
        y += (dy * 64);
        try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      } 
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void breakpaint() {
        x = lastx;
        y = lasty;
    }
 
    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}