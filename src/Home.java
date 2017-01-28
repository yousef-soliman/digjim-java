import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.color.*;
import javax.swing.JLabel;

public class Home {
	private JFrame frame;
	
	public static void main(String[] args) {
		
	}

	public Home() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame( );
		frame.setBounds(100, 100, 643, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame.setResizable(false);
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Application app = new Application();
				app.setVisible(true);
			}
		});
		btnPlay.setFont(new Font("Curlz MT", Font.BOLD, 26));
		btnPlay.setBounds(464, 135, 156, 60);
		btnPlay.setBackground(Color.magenta);
		frame.getContentPane().add(btnPlay);
		
		JButton btnAbout = new JButton("ABOUT");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				ABOUT about = new ABOUT();				
			}
		});
		btnAbout.setFont(new Font("Curlz MT", Font.BOLD, 27));
		btnAbout.setBackground(Color.magenta);
		btnAbout.setBounds(464, 223, 156, 60);
		frame.getContentPane().add(btnAbout);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnExit.setFont(new Font("Curlz MT", Font.BOLD, 27));
		btnExit.setBackground(Color.magenta);
		btnExit.setBounds(464, 305, 156, 60);
		frame.getContentPane().add(btnExit);
		
		JLabel lblBackground = new JLabel("");
		ImageIcon ii = new ImageIcon("img/sstart.jpg");
		Image img1 = ii.getImage();
		lblBackground.setIcon(ii);
		lblBackground.setBounds(0, 0,  627, 431);
		frame.getContentPane().add(lblBackground);
		frame.setResizable(false);
		
		EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}
}
