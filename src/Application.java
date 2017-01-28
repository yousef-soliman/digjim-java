import java.awt.EventQueue;

import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Application extends JFrame {
    
    public Application() {

        initUI();
    }

    private void initUI() {

        Board bd = new Board();
    	add(bd);
        setSize(18*64, 12*64);
        
        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }    
    
}