import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class R_MemberMgmtPanel extends JPanel{
	
	JPanel headerTitle;
	JLabel title;
	
	JPanel contentButtons;
	GridBagConstraints c;
	
	JButton btnAddMem;
	JButton btnEditMem;
	JButton btnDeleteMem;
	JButton btnSearchMem;
	JButton btnRemindMem;
	JButton btnViewMem;
	JPanel parentPanel;
	CardLayout parentLayout;
	
	public R_MemberMgmtPanel(JPanel parentPnl){
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.setLayout(new BorderLayout());
		
		initializeHeader();
		
		initializeContent();
		
		
	}
	
	private void initializeHeader() {
		headerTitle = new JPanel(new FlowLayout(FlowLayout.LEADING));
		title = new JLabel("Member Management");
		title.setFont(new Font("Arial", 1, 30)); // header title font here
		
		headerTitle.add(Box.createRigidArea(new Dimension(5,75)));
		headerTitle.add(title);
		headerTitle.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.BLACK)); // border color here
		this.add(headerTitle, BorderLayout.PAGE_START);
	}
	
	private void initializeContent() {
		contentButtons = new JPanel(new GridBagLayout());
		c = new GridBagConstraints();
		
		btnAddMem = new JButton("Add Member");
		btnEditMem = new JButton("Edit Member");
		btnDeleteMem = new JButton("Delete Member");
		btnSearchMem = new JButton("Search Member");
		btnRemindMem = new JButton("Remind Member");
		btnViewMem = new JButton("View Member");
		
		btnAddMem.addActionListener(new R_MemberMgmtPanelHandler());
		btnEditMem.addActionListener(new R_MemberMgmtPanelHandler());
		btnDeleteMem.addActionListener(new R_MemberMgmtPanelHandler());
		btnSearchMem.addActionListener(new R_MemberMgmtPanelHandler());
		btnRemindMem.addActionListener(new R_MemberMgmtPanelHandler());
		btnViewMem.addActionListener(new R_MemberMgmtPanelHandler());
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0; // column
		c.gridy = 0; // row
		c.weighty = 0.5;
		c.weightx = 0.5;
		c.insets = new Insets(20,20,10,10);
		contentButtons.add(btnAddMem,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1; // column
		c.gridy = 0; // row
		//c.insets = new Insets(10,10,10,10);
		contentButtons.add(btnEditMem,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0; // column
		c.gridy = 1; // row
		//c.insets = new Insets(10,10,10,10);
		contentButtons.add(btnDeleteMem,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1; // column
		c.gridy = 1; // row
		//c.insets = new Insets(10,10,10,10);
		contentButtons.add(btnSearchMem,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0; // column
		c.gridy = 2; // row
		//c.insets = new Insets(10,10,10,10);
		contentButtons.add(btnRemindMem,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1; // column
		c.gridy = 2; // row
		//c.insets = new Insets(10,10,10,10);
		contentButtons.add(btnViewMem,c);
		
		
		this.add(contentButtons, BorderLayout.CENTER);
	}
	
	private class R_MemberMgmtPanelHandler implements ActionListener{
		JButton source;

		@Override
		public void actionPerformed(ActionEvent evt) {
			source = (JButton)evt.getSource();
			
			switch (source.getActionCommand()) {
			case "Add Member":
				parentLayout.show(parentPanel,"ADDMEMBER");
				break;
			case "Edit Member":
				parentLayout.show(parentPanel,"EDITVIEWMEMBER");
				break;
			case "Delete Member":
				parentLayout.show(parentPanel, "DELETEVIEWMEMBER");
				break;
			case "Search Member":
				parentLayout.show(parentPanel, "SEARCHMEMBER");
				break;
			case "Remind Member":
				parentLayout.show(parentPanel, "REMINDVIEWMEMBER");
				break;
			case "View Member":
				parentLayout.show(parentPanel, "VIEWMEMBER");
				break;

			default:
				break;
			}
			
		}
		
	}

}
