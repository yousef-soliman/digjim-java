import java.awt.Image;

import javax.swing.ImageIcon;

public class Stone {
	public int x,y;
	private int stdx,stdy;
	public Image stone;
	public boolean mm = false;
	
	

	public Stone(int x, int y){
		this.x = x;
		this.y = y;
		stdx = x;
		stdy = y;
		mm =false;
		ImageIcon ii = new ImageIcon("Stone.png");
		stone = ii.getImage();
		
	}
	public boolean isMm() {
		return mm;
	}

	public void setMm(boolean mm) {
		this.mm = mm;
	}
	public int getStdx() {
		return stdx;
	}

	public void setStdx(int stdx) {
		this.stdx = stdx;
	}

	public int getStdy() {
		return stdy;
	}

	public void setStdy(int stdy) {
		this.stdy = stdy;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public Image getStone() {
		return stone;
	}

	public void move() { 
		y += 16;
	}
}
