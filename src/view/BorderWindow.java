package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderWindow extends JPanel{
	
	public BorderWindow(JFrame prmParent) {

		this.setBorder(null);
		FlowLayout flowLayout = (FlowLayout) this.getLayout();
		flowLayout.setAlignment(FlowLayout.TRAILING);
		this.setForeground(Color.BLACK);
		this.setBackground(new Color(30, 144, 255));
		
		this.addMouseMotionListener(new MouseMotionAdapter() {
			Point mouseLoc = null;
			@Override
			public void mouseDragged(MouseEvent e) {
				mouseLoc = MouseInfo.getPointerInfo().getLocation();
				//mouseLoc = e.getPoint();
				prmParent.setLocation(mouseLoc);
				
			}
		});
		
		JButton btnMinimize = new JButton("");
		btnMinimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prmParent.setState(JFrame.ICONIFIED);
			}
		});
		btnMinimize.setIcon(new ImageIcon(LoginFrame.class.getResource("/res/minimize_fix.png")));
		btnMinimize.setOpaque(false);
		btnMinimize.setFocusPainted(false);
		btnMinimize.setBorder(null);
		btnMinimize.setBackground(Color.WHITE);
		this.add(btnMinimize);
		
		JButton btnExit = new JButton("");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setIcon(new ImageIcon(LoginFrame.class.getResource("/res/close_fix.png")));
		btnExit.setOpaque(false);
		btnExit.setFocusPainted(false);
		btnExit.setBorder(null);
		btnExit.setBackground(Color.WHITE);
		this.add(btnExit);
	}
}
