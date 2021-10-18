package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;


public class HeaderPanel extends JPanel{
	
	JPanel headerPanel;
	JButton btnBack;
	JLabel headertitle;
	
	public HeaderPanel(String heading, boolean prmBtn) {
		setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		setBackground(new Color(100, 149, 237));
		
		headerPanel = new JPanel();
		if(prmBtn) {
			btnBack = new JButton("<");
			btnBack.setOpaque(false);
			btnBack.setBorder(new LineBorder(new Color(255, 250, 250)));
			btnBack.setBackground(new Color(255, 250, 250));
			btnBack.setPreferredSize(new Dimension(100,60)); // button size here
			btnBack.setFont(new Font("Lucida Sans", Font.BOLD, 50)); // set font here
			btnBack.setContentAreaFilled(false);
			headertitle = new JLabel(heading); // title here
			headertitle.setFont(new Font("Lucida Sans", Font.BOLD, 30));
			btnBack.addMouseListener(new MouseHandler());
			this.setLayout(new FlowLayout(FlowLayout.LEADING));
			this.add(btnBack);
			this.add(Box.createRigidArea(new Dimension(50,0)));
			this.add(headertitle);
		}else {
			headertitle = new JLabel(heading); // title here
			headertitle.setFont(new Font("Lucida Sans", Font.BOLD, 30));
			this.setLayout(new FlowLayout(FlowLayout.LEADING));
			this.add(Box.createRigidArea(new Dimension(20,60)));
			this.add(headertitle);
		}

	}
	
	public void setBackActionListener(ActionListener listener) {
		btnBack.addActionListener(listener);
	}
	
	private class MouseHandler extends MouseAdapter{
		JButton btnSource;
		
		@Override
		public void mouseEntered(MouseEvent e) {
			btnSource = (JButton) e.getSource();
			btnSource.setBackground(new Color(30, 144, 255));
			btnSource.setOpaque(true);
			btnSource.setForeground(new Color(255, 250, 250));
			btnSource.setBorder(new LineBorder((Color)new Color(255, 250, 250)));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			btnSource = (JButton) e.getSource();
			btnSource.setBackground(new Color(255, 250, 250));
			btnSource.setOpaque(false);
			btnSource.setForeground(new Color(0, 0, 0));
			btnSource.setBorder(new LineBorder(new Color(255, 250, 250)));
		}
	}

}
