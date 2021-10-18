package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Dimension;

public class R_MemberMgmtPanel extends JPanel{
	
	HeaderPanel header;
	
	GridBagLayout gridbag;
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
	
	AddMbrFormCard addMemberPane;
	EditMbrTableCard editMemberTablePane;
	DeleteMbrTableCard deleteMemberTablePane;
	ViewMbrTableCard viewMemberTablePane;
	RemindMbrTableCard remindMemberTablePane;
	SearchMbrTableCard srchMemberTablePane;
	
	
	public R_MemberMgmtPanel(JPanel parentPnl){
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.setLayout(new BorderLayout());
		initializeHeader();
		
		initializeContent();
		
		
	}
	
	private void initializeHeader() {
		header = new HeaderPanel("Member Management",false);
		this.add(header, BorderLayout.PAGE_START);
	}
	
	private void initializeContent() {
		gridbag = new GridBagLayout();
		contentButtons = new JPanel(gridbag);
		contentButtons.setBackground(new Color(255, 250, 250));
		c = new GridBagConstraints();
		
		btnAddMem = new JButton("Add Member");
		btnAddMem.setPreferredSize(new Dimension(0, 0));
		btnAddMem.setMinimumSize(new Dimension(0, 0));
		btnAddMem.setMaximumSize(new Dimension(0, 0));
		btnAddMem.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnAddMem.setIcon(new ImageIcon(R_MemberMgmtPanel.class.getResource("/res/addmembers_fix1.png")));
		btnAddMem.setFocusPainted(false);
		btnAddMem.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnAddMem.setOpaque(false);
		btnAddMem.setBackground(new Color(255, 250, 250));
		btnEditMem = new JButton("Edit Member");
		btnEditMem.setPreferredSize(new Dimension(0, 0));
		btnEditMem.setMinimumSize(new Dimension(0, 0));
		btnEditMem.setMaximumSize(new Dimension(0, 0));
		btnEditMem.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnEditMem.setIcon(new ImageIcon(R_MemberMgmtPanel.class.getResource("/res/editmember_fix.png")));
		btnEditMem.setFocusPainted(false);
		btnEditMem.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnEditMem.setOpaque(false);
		btnEditMem.setBackground(new Color(255, 250, 250));
		btnDeleteMem = new JButton("Delete Member");
		btnDeleteMem.setMinimumSize(new Dimension(0, 0));
		btnDeleteMem.setMaximumSize(new Dimension(0, 0));
		btnDeleteMem.setPreferredSize(new Dimension(0, 0));
		btnDeleteMem.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnDeleteMem.setIcon(new ImageIcon(R_MemberMgmtPanel.class.getResource("/res/deletemembers_fix.png")));
		btnDeleteMem.setFocusPainted(false);
		btnDeleteMem.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnDeleteMem.setOpaque(false);
		btnDeleteMem.setBackground(new Color(255, 250, 250));
		btnSearchMem = new JButton("Search Member");
		btnSearchMem.setMinimumSize(new Dimension(0, 0));
		btnSearchMem.setMaximumSize(new Dimension(0, 0));
		btnSearchMem.setPreferredSize(new Dimension(0, 0));
		btnSearchMem.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnSearchMem.setIcon(new ImageIcon(R_MemberMgmtPanel.class.getResource("/res/searchmember_fix.png")));
		btnSearchMem.setFocusPainted(false);
		btnSearchMem.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnSearchMem.setOpaque(false);
		btnSearchMem.setBackground(new Color(255, 250, 250));
		btnRemindMem = new JButton("Remind Member");
		btnRemindMem.setMinimumSize(new Dimension(0, 0));
		btnRemindMem.setMaximumSize(new Dimension(0, 0));
		btnRemindMem.setPreferredSize(new Dimension(0, 0));
		btnRemindMem.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnRemindMem.setIcon(new ImageIcon(R_MemberMgmtPanel.class.getResource("/res/remindmember_fix1.png")));
		btnRemindMem.setFocusPainted(false);
		btnRemindMem.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnRemindMem.setOpaque(false);
		btnRemindMem.setBackground(new Color(255, 250, 250));
		btnViewMem = new JButton("View Member");
		btnViewMem.setMinimumSize(new Dimension(0, 0));
		btnViewMem.setMaximumSize(new Dimension(0, 0));
		btnViewMem.setPreferredSize(new Dimension(0, 0));
		btnViewMem.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnViewMem.setIcon(new ImageIcon(R_MemberMgmtPanel.class.getResource("/res/viewmembers_fix.png")));
		btnViewMem.setFocusPainted(false);
		btnViewMem.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnViewMem.setOpaque(false);
		btnViewMem.setBackground(new Color(255, 250, 250));
		
		btnAddMem.addMouseListener(new R_MemberMgmtPanelHandler());
		btnEditMem.addMouseListener(new R_MemberMgmtPanelHandler());
		btnDeleteMem.addMouseListener(new R_MemberMgmtPanelHandler());
		btnSearchMem.addMouseListener(new R_MemberMgmtPanelHandler());
		btnRemindMem.addMouseListener(new R_MemberMgmtPanelHandler());
		btnViewMem.addMouseListener(new R_MemberMgmtPanelHandler());
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0; // column
		c.gridy = 0; // row
		c.weighty = 0.5;
		c.weightx = 0.5;
		c.insets = new Insets(20,20,10,10);
		gridbag.setConstraints(btnAddMem, c);
		contentButtons.add(btnAddMem);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1; // column
		c.gridy = 0; // row
		//c.insets = new Insets(10,10,10,10);
		gridbag.setConstraints(btnEditMem, c);
		contentButtons.add(btnEditMem);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0; // column
		c.gridy = 1; // row
		//c.insets = new Insets(10,10,10,10);
		gridbag.setConstraints(btnDeleteMem, c);
		contentButtons.add(btnDeleteMem);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1; // column
		c.gridy = 1; // row
		//c.insets = new Insets(10,10,10,10);
		gridbag.setConstraints(btnSearchMem, c);
		contentButtons.add(btnSearchMem);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0; // column
		c.gridy = 2; // row
		//c.insets = new Insets(10,10,10,10);
		gridbag.setConstraints(btnRemindMem, c);
		contentButtons.add(btnRemindMem);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1; // column
		c.gridy = 2; // row
		//c.insets = new Insets(10,10,10,10);
		gridbag.setConstraints(btnViewMem, c);
		contentButtons.add(btnViewMem);
		
		
		this.add(contentButtons, BorderLayout.CENTER);
	}
	
	private class R_MemberMgmtPanelHandler extends MouseAdapter{
		JButton btnSource;

		@Override
		public void mouseClicked(MouseEvent e) {
			btnSource = (JButton)e.getSource();
			
			switch (btnSource.getActionCommand()) {
			case "Add Member":
				addMemberPane = new AddMbrFormCard(parentPanel);
				parentPanel.add(addMemberPane, "ADDMEMBER");
				parentLayout.show(parentPanel,"ADDMEMBER");
				break;
			case "Edit Member":
				editMemberTablePane = new EditMbrTableCard(parentPanel);
				parentPanel.add(editMemberTablePane, "EDITVIEWMEMBER");
				parentLayout.show(parentPanel,"EDITVIEWMEMBER");
				break;
			case "Delete Member":
				deleteMemberTablePane = new DeleteMbrTableCard(parentPanel);
				parentPanel.add(deleteMemberTablePane, "DELETEVIEWMEMBER");
				parentLayout.show(parentPanel, "DELETEVIEWMEMBER");
				break;
			case "Search Member":
				srchMemberTablePane = new SearchMbrTableCard(parentPanel);
				parentPanel.add(srchMemberTablePane, "SEARCHMEMBER");
				parentLayout.show(parentPanel, "SEARCHMEMBER");
				break;
			case "Remind Member":
				remindMemberTablePane = new RemindMbrTableCard(parentPanel);
				parentPanel.add(remindMemberTablePane, "REMINDVIEWMEMBER");
				parentLayout.show(parentPanel, "REMINDVIEWMEMBER");
				break;
			case "View Member":
				viewMemberTablePane = new ViewMbrTableCard(parentPanel);
				parentPanel.add(viewMemberTablePane, "VIEWMEMBER");
				parentLayout.show(parentPanel, "VIEWMEMBER");
				break;

			default:
				break;
			}
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			btnSource = (JButton) e.getSource();
			btnSource.setBackground(new Color(100, 149, 237));
			btnSource.setOpaque(true);
			btnSource.setForeground(new Color(255, 250, 250));
			//btnSource.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(255, 250, 250)));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			btnSource = (JButton) e.getSource();
			btnSource.setBackground(new Color(100, 149, 237));
			btnSource.setOpaque(false);
			btnSource.setForeground(new Color(0, 0, 0));
			//btnSource.setBorder(new LineBorder(new Color(100, 149, 237)));
		}
		
	}

}
