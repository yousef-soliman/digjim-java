import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ABOUT extends JFrame {

	private JFrame frame;

	public ABOUT() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 643, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame.setResizable(false);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Curlz MT", Font.BOLD, 27));
		btnBack.setBackground(Color.magenta);
		btnBack.setBounds(0, 370, 156, 60);
		frame.getContentPane().add(btnBack);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Home app = new Home();
				//Home.setVisible(true);
			}
		});
		
		JLabel label = new JLabel("");
		ImageIcon ii = new ImageIcon("about.jpg");
		Image  img1 = ii.getImage();
		label.setIcon(new ImageIcon(img1));
		label.setBounds(0, 0, 627, 431);
		frame.getContentPane().add(label);
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
