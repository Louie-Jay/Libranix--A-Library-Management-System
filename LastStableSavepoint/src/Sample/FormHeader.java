package Sample;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FormHeader extends JPanel{
	
	JButton btnBack;
	JLabel headertitle;

	public FormHeader() {
		this(null,"Untitled");
	}
	
	public FormHeader(JPanel parentPnl, String title) {
		btnBack = new JButton("<");
		btnBack.setPreferredSize(new Dimension(100,60)); // button size here
		btnBack.setFont(new Font("Arial", Font.BOLD, 50)); // set font here
		btnBack.setContentAreaFilled(false);
		headertitle = new JLabel(title);
		headertitle.setFont(new Font("Arial", Font.BOLD, 30));
		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		this.add(btnBack);
		this.add(Box.createRigidArea(new Dimension(50,0)));
		this.add(headertitle);
		// add this incase Box.createRigidArea(new Dimension(0,20)
		
	}
}
