package Sample;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class AddBkButtonsScrap extends JPanel{
	
	JButton btnAdd;
	JButton btnCancel;
	JPanel parentPanel;
	CardLayout parentLayout;
	
	public AddBkButtonsScrap(JPanel parentPnl) {
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.setLayout(new FlowLayout(FlowLayout.TRAILING));
		//this.setBorder(new LineBorder(Color.BLACK));
		btnAdd = new JButton("Add");
		btnCancel = new JButton("Cancel");
		
		btnAdd.setPreferredSize(new Dimension(80,30)); // button size here
		btnAdd.setFont(new Font("Arial", Font.PLAIN, 15)); // set font here
		btnAdd.setContentAreaFilled(false);
		
		btnCancel.setPreferredSize(new Dimension(80,30)); // button size here
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 15)); // set font here
		btnCancel.setContentAreaFilled(false);
		
		btnCancel.addActionListener(new AddBkHandler());
		
		
		
		this.add(btnAdd);
		this.add(Box.createRigidArea(new Dimension(20,0)));
		this.add(btnCancel);
		this.add(Box.createRigidArea(new Dimension(10,0)));
	}
	
	private class AddBkHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evt) {
			parentLayout.show(parentPanel,"MAIN");
			
		}
		
		
	}

}
