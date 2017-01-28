
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{

    private Image im;
    private Image img;
    private Image dim;
    private Image gameover;
    private Image stone;
    private Image sc;
    private Timer timer;
    
    
    public int stonePosX[] = {2,9,12,  0,4,6,8,  1,8,12,  5,7,11,   1,  0,  6,  3,6  ,1,10};
    public int stonePosY[] = {1,1,1 ,  2,2,2,2,  4,4,4,   5,5,5 ,   6,  7,  8,  9,9  ,10,10};

    public int dimPosX[] = {13, 13, 3,11, 12, 4,9  ,4,10  ,3};
    public int dimPosY[] = {1,  2,  4,4, 6,  7,7,  9,9  ,10};
    public int block;
    public boolean[][] path = new boolean[32][32];
    private Character character;
    private final int DELAY = 10;
    public int indx = 0;
    JButton jb = new JButton("");
    int score = 0;
    ArrayList stones = new ArrayList();
    public boolean game = true;
    
    public Board() {
    	for(int i = 0; i < stonePosX.length; i++) {
    		stones.add(new Stone(stonePosX[i]*64,stonePosY[i]*64));
    	}
    	//add(jb);
    	addKeyListener(new TAdapter());
        setFocusable(true);
        requestFocusInWindow();
        loadimg();
        character = new Character();
        timer = new Timer(DELAY, this);
        timer.start();
        
    }
    
    public boolean isStone(int posX,int posY) {
        
        block = im.getWidth(null);
        for (Object m1 : stones) {
        	if(((Stone) m1).getX() == posX && ((Stone) m1).getY() == posY) {
        		return  true;
        	}
        }
        return (false);
    }

    public boolean isDim(int posX , int posY) {
        int block = im.getWidth(null);
        for (int i = 0; i < dimPosX.length; i++) {
            if ((posX == (dimPosX[i] * block)) && (posY == (dimPosY[i]*block))){                
            	return (true);
            }

        }
        return (false);
    }
       
    public int Search(int k,int l, int a[], int arr[]) {//this function return the index of a value in arr
        for (int i = 0; i < arr.length; i++) {
            if (a[i] == k && arr[i] == l) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
    	int xpos;
        int ypos;
        int block = im.getWidth(null);
        path[(int)character.getX()/64][(int)character.getY()/64] = true;
        for (int i = 0; i <= 20*64; i += im.getWidth(null)) {

            for (int j = 0; j <= 11*64; j += im.getHeight(null)) {
            	
                if ((character.getX() == i) && (character.getY() == j)) {
                    if (isDim(i, j)) {
                        xpos = Search(i / block, j/block, dimPosX,dimPosY);
                        dimPosX[xpos] = -1;
                        dimPosY[xpos] = -1;
                        score++;
                        jb.setText(""+score);
                    }

                }
                g.drawImage(im, i, j, null);
                if (isDim(i, j)) {
                    g.drawImage(dim, i, j,block,block, null);
                } 
                if(path[i/64][j/64] == true){
                	g.drawImage(img, i, j,block,block, null);
                }
            }
        }
        for (Object m1 : stones) {
            Stone m = (Stone) m1;
            path[m.getX()/64][m.getY()/64] = true;
            g.drawImage(stone, m.getX(),
                    m.getY(),block,block, null);
        }
        	
        doDrawing(g);
        if(game == false){
        	g.drawImage(gameover,180,200,500,500,null);	
        	
        }
        g.drawImage(sc, (14*64), 0,260,700, null);
        JLabel label = new JLabel("");
        label.setBounds(0, 0, 260, 431);
        add(jb);
        jb.setBounds(900, 160, 156, 60);
        jb.setBackground(Color.magenta);
        jb.setFont(new Font("Curlz MT", Font.BOLD, 35));
        Toolkit.getDefaultToolkit().sync();
        
    }

    private void doDrawing(Graphics g) {
        Image i = character.getImage();
        g.drawImage(i, character.getX(), character.getY(), im.getWidth(null), im.getHeight(null), null);
    }

    private void loadimg() {
    	
    	ImageIcon ii = new ImageIcon("sand.jpg");   //l swr bta3t l game l blockat
        im = ii.getImage();
        ii = new ImageIcon("wall.jpg");   // a5leha black img
        img = ii.getImage();
        ii = new ImageIcon("gemBlueStroked.png");
        dim = ii.getImage();
        ii = new ImageIcon("stone.png");
        stone = ii.getImage();
        ii = new ImageIcon("thought-bubble-2400px.png");
        gameover = ii.getImage();

        ii = new ImageIcon("black-background.jpg");
        sc = ii.getImage();
    }

    private void delete(Graphics g, int x, int y) {
        g.drawImage(img, x, y, null);
    }
    @Override
    
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    	
        
    	character.move();
        if(isStone(character.getX(),character.getY())) {
        	character.breakpaint();
        	return;
        }
        new Thread(){
        	public void run(){
        		fall();
        	}
        }.start();
        repaint();
    }
    
    boolean t = true;
    private void fall(){
    	for (Object m1 : stones) {
    		if(((Stone) m1).getStdy()+64 == character.getY() && ((Stone) m1).getStdx() == character.getX() && ((Stone) m1).isMm()){
    			game = false;
    			
    		}
    		else ((Stone) m1).setMm(false);
            if((path[((Stone) m1).getX()/64][(((Stone) m1).getY()+64) / 64] == true)
            		&&  (((Stone) m1).getStdy()+64 != character.getY() || ((Stone) m1).getStdx() != character.getX())
            		 && isStone(((Stone) m1).getStdx(),((Stone) m1).getStdy()+64)==false){
            	((Stone) m1).setMm(true);
            	if(((Stone) m1).getY() == ((Stone) m1).getStdy()+ 48 ){
            		((Stone) m1).setStdy(((Stone) m1).getY()+16);
            	}
            	
            	((Stone) m1).move();
            }
        }
    }
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
             character.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            character.keyPressed(e);
        }

    }
}
