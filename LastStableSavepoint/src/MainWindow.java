import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class MainWindow extends JFrame{

	JPanel mainPane;
	CardLayout mainLayout;
	
	
	JSplitPane mainSpltPane;
	
	JPanel leftBtnPane;
	R_DashboardPanel dshBoardPane;
	R_BookCatalogPanel bookCatalogPane;
	R_MemberMgmtPanel memMgmtPane;
	R_ReportsPanel reportsPane;

	AddBkFormPopUp addBookPane;
	EditViewBkFormPopUp editViewBookPane;
	EditBkFormPopUp editBookPane;
	DeleteBkFormPopUp deleteBookPane;
	InfoDeleteBkFormPopUp infoDeleteBookPane;
	InfoSearchBkFormPopUp infoSrchBookPane;
	SearchBkFormPopUp srchBookPane;
	InfoBorrowBkFormPopUp infoBorrowBookPane;
	BorrowBkFormPopUp borrowBookPane;
	ReturnBkFormPopUp returnBookPane;
	ViewBkFormPopUp viewBookPane;
	InfoViewBkFormPopUp infoBookPane;
	
	BorrowBkTransactPopUp borrowBookTransactPane;
	ReturnBkTransactFormPopUp returnBookTransactPane;
	
	AddMemFormPopUp addMemberPane;
	EditViewMemFormPopUp editViewMemberPane;
	EditMemFormPopUp editMemberPane;
	DeleteViewMemFormPopUp deleteViewMemberPane;
	DeleteMemFormPopUp deleteMemberPane;
	InfoSearchMemFormPopUp infoSrchMemberPane;
	SearchMemFormPopUp srchMemberPane;
	RemindViewMemFormPopUp remindViewMemberPane;
	RemindMemFormPopUp remindMemberPane;
	
	ViewMemFormPopUp viewMemberPane;
	InfoViewMemFormPopUp infoViewMemberPane;
	
	
	public MainWindow() {
		
		super("Library Management System");
		this.initializePane();
		this.setSize(1020,735);
		this.setContentPane(mainPane);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	private void initializePane(){
		mainLayout = new CardLayout();
		mainPane = new JPanel(mainLayout);
		
		mainSpltPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		leftBtnPane = new JPanel();
		leftBtnPane.setLayout(new BoxLayout((JPanel) leftBtnPane,BoxLayout.Y_AXIS));
		init_sideBtnsPaneComponents();
		mainSpltPane.setLeftComponent(leftBtnPane);
		
		dshBoardPane = new R_DashboardPanel(mainPane);
		dshBoardPane.setBackground(Color.BLUE);
		mainSpltPane.setRightComponent(dshBoardPane);
		
		bookCatalogPane = new R_BookCatalogPanel(mainPane);
		
		memMgmtPane = new R_MemberMgmtPanel(mainPane);
		
		reportsPane = new R_ReportsPanel();
		
		addBookPane = new AddBkFormPopUp(mainPane);
		editViewBookPane = new EditViewBkFormPopUp(mainPane);
		editBookPane = new EditBkFormPopUp(mainPane);
		deleteBookPane = new DeleteBkFormPopUp(mainPane);
		infoDeleteBookPane = new InfoDeleteBkFormPopUp(mainPane);
		infoSrchBookPane = new InfoSearchBkFormPopUp(mainPane);
		srchBookPane = new SearchBkFormPopUp(mainPane);
		infoBorrowBookPane = new InfoBorrowBkFormPopUp(mainPane);
		borrowBookPane = new BorrowBkFormPopUp(mainPane);
		returnBookPane = new ReturnBkFormPopUp(mainPane);
		viewBookPane = new ViewBkFormPopUp(mainPane);
		infoBookPane = new InfoViewBkFormPopUp(mainPane);
		
		borrowBookTransactPane = new BorrowBkTransactPopUp(mainPane);
		returnBookTransactPane = new ReturnBkTransactFormPopUp(mainPane);
		
		addMemberPane = new AddMemFormPopUp(mainPane);
		editViewMemberPane = new EditViewMemFormPopUp(mainPane);
		editMemberPane = new EditMemFormPopUp(mainPane);
		deleteViewMemberPane = new DeleteViewMemFormPopUp(mainPane);
		deleteMemberPane = new DeleteMemFormPopUp(mainPane);
		infoSrchMemberPane = new InfoSearchMemFormPopUp(mainPane);
		srchMemberPane = new SearchMemFormPopUp(mainPane);
		viewMemberPane = new ViewMemFormPopUp(mainPane);
		infoViewMemberPane = new InfoViewMemFormPopUp(mainPane);
		remindViewMemberPane = new RemindViewMemFormPopUp(mainPane);
		remindMemberPane = new RemindMemFormPopUp(mainPane);
		
		mainPane.add(mainSpltPane, "MAIN");
		
		mainPane.add(addBookPane, "ADDBOOK");
		mainPane.add(infoSrchBookPane,"INFOSEARCHBOOK");
		mainPane.add(srchBookPane, "SEARCHBOOK");
		mainPane.add(editViewBookPane, "EDITVIEWBOOK");
		mainPane.add(editBookPane, "EDITBOOK");
		mainPane.add(deleteBookPane, "DELETEBOOK");
		mainPane.add(infoDeleteBookPane, "INFODELETEBOOK");
		mainPane.add(infoBorrowBookPane, "INFOBORROWBOOK");
		mainPane.add(borrowBookPane, "BORROWBOOK");
		mainPane.add(returnBookPane, "RETURNBOOK");
		mainPane.add(viewBookPane, "VIEWBOOK");
		mainPane.add(infoBookPane, "INFOBOOK");
		
		mainPane.add(borrowBookTransactPane, "BOOKTRANSACT");
		mainPane.add(returnBookTransactPane, "RETURNTRANSACT");
		
		mainPane.add(addMemberPane, "ADDMEMBER");
		mainPane.add(editViewMemberPane, "EDITVIEWMEMBER");
		mainPane.add(editMemberPane, "EDITMEMBER");
		mainPane.add(deleteViewMemberPane, "DELETEVIEWMEMBER");
		mainPane.add(deleteMemberPane, "DELETEMEMBER");
		mainPane.add(infoSrchMemberPane, "INFOSEARCHMEMBER");
		mainPane.add(srchMemberPane, "SEARCHMEMBER");
		mainPane.add(viewMemberPane, "VIEWMEMBER");
		mainPane.add(infoViewMemberPane, "INFOVIEWMEMBER");
		mainPane.add(remindViewMemberPane, "REMINDVIEWMEMBER");
		mainPane.add(remindMemberPane, "REMINDMEMBER");
		
		
	}
	
	private void init_sideBtnsPaneComponents() {
		JLabel logoLbl = new JLabel("LogoHere");
		logoLbl.setFont(new Font("Arial",1,40));
		logoLbl.setBackground(Color.GREEN);
		leftBtnPane.add(Box.createRigidArea(new Dimension(0,20)));
		leftBtnPane.add(logoLbl);
		leftBtnPane.add(Box.createRigidArea(new Dimension(0,20)));
		
		JButton btnDshBoard = new JButton("Dashboard");
		btnDshBoard.setMaximumSize(new Dimension(185,50));
		//btnDshBoard.setContentAreaFilled(false); // set button to transparent
		//btnDshBoard.setOpaque(true);
		btnDshBoard.addActionListener(new L_ActionHandler());
		leftBtnPane.add(btnDshBoard);
		
		JButton btnBookCatalog = new JButton("Book Catalog");
		btnBookCatalog.setMaximumSize(new Dimension(185,50));
		btnBookCatalog.addActionListener(new L_ActionHandler());
		leftBtnPane.add(btnBookCatalog);
		
		JButton btnMemMgmt = new JButton("Manage Member");
		btnMemMgmt.setMaximumSize(new Dimension(185,50));
		btnMemMgmt.addActionListener(new L_ActionHandler());
		leftBtnPane.add(btnMemMgmt);
		
		JButton btnReports = new JButton("Reports");
		btnReports.setMaximumSize(new Dimension(185,50));
		btnReports.addActionListener(new L_ActionHandler());
		leftBtnPane.add(btnReports);
	}
	
	private class L_ActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evt) {

			switch (evt.getActionCommand()) {
			case "Dashboard":
				mainSpltPane.setRightComponent(dshBoardPane);
				break;
			case "Book Catalog":
				mainSpltPane.setRightComponent(bookCatalogPane);
				break;
			case "Manage Member":
				mainSpltPane.setRightComponent(memMgmtPane);
				break;
			case "Reports":
				mainSpltPane.setRightComponent(reportsPane);
				break;
			default:
				dispose();
				System.exit(0);
				break;
			}
		}
		
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainWindow();
            }
        });
	}
}
