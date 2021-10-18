package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JSplitPane;
import javax.swing.border.MatteBorder;

import controller.MainWindowController;

public class MainWindow extends JFrame {
	
	BorderWindow window;
	
	JPanel rootPane;
	BorderLayout rootLayout;
	JPanel mainPane;
	CardLayout mainLayout;

	JSplitPane mainSpltPane;

	JPanel leftBtnPane;
	R_DashboardPanel dshBoardPane;
	R_BookCatalogPanel bookCatalogPane;
	R_MemberMgmtPanel memMgmtPane;
	R_ReportsPanel reportsPane;
	R_SettingsPanel settingsPane;
	
	LoginFrame loginWindow;
	
	MainWindowController controller;

	public MainWindow(LoginFrame prmLoginWindow) {

		super("Library Management System");
		this.initializePane();
		this.setSize(1020, 735);
		this.setContentPane(rootPane);
		
		JPanel footerPane = new JPanel();
		footerPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(100, 149, 237)));
		footerPane.setBackground(new Color(255, 250, 250));
		rootPane.add(footerPane, BorderLayout.SOUTH);
		
		Component verticalStrut = Box.createVerticalStrut(10);
		footerPane.add(verticalStrut);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.loginWindow = prmLoginWindow;
		
	}

	private void initializePane() {
		window = new BorderWindow(MainWindow.this);

		rootLayout = new BorderLayout();
		rootPane = new JPanel(rootLayout);
		rootPane.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 250, 250)));
		
		mainLayout = new CardLayout();
		mainPane = new JPanel(mainLayout);
		mainPane.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(100, 149, 237)));
		mainPane.setBackground(new Color(255, 250, 250));
		
		rootPane.add(window,BorderLayout.NORTH);
		mainSpltPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		mainSpltPane.setAlignmentY(Component.CENTER_ALIGNMENT);
		mainSpltPane.setDividerSize(0);
		mainSpltPane.setEnabled(false);

		leftBtnPane = new JPanel();
		leftBtnPane.setBorder(new MatteBorder(0, 0, 0, 1, (Color) Color.BLACK));
		leftBtnPane.setBackground(new Color(255, 250, 250));
		leftBtnPane.setLayout(new BoxLayout((JPanel) leftBtnPane, BoxLayout.Y_AXIS));
		init_sideBtnsPaneComponents();
		mainSpltPane.setLeftComponent(leftBtnPane);

		dshBoardPane = new R_DashboardPanel(mainPane);
		mainSpltPane.setRightComponent(dshBoardPane);

		bookCatalogPane = new R_BookCatalogPanel(mainPane);
		
		memMgmtPane = new R_MemberMgmtPanel(mainPane);
		
		reportsPane = new R_ReportsPanel(mainPane);
		
		settingsPane = new R_SettingsPanel(mainPane);
		
		rootPane.add(mainPane,BorderLayout.CENTER);
		mainPane.add(mainSpltPane, "MAIN");
		
		controller = new MainWindowController();

	}

	private void init_sideBtnsPaneComponents() {

		JButton btnDshBoard = new JButton("Dashboard");
		btnDshBoard.setFocusPainted(false);
		btnDshBoard.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnDshBoard.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(100, 149, 237)));
		btnDshBoard.setBackground(new Color(255, 250, 250));
		btnDshBoard.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		btnDshBoard.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnDshBoard.setMaximumSize(new Dimension(185, 50));
		btnDshBoard.addMouseListener(new L_ActionHandler());
		
		JPanel logopanel = new JPanel();
		logopanel.setBackground(new Color(100, 149, 237));
		logopanel.setPreferredSize(new Dimension(163, 165));
		logopanel.setMaximumSize(new Dimension(163, 165));
		leftBtnPane.add(logopanel);
		logopanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/res/libranix_fix.png")));
		logopanel.add(lblNewLabel);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		logopanel.add(verticalStrut, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		logopanel.add(verticalStrut_1, BorderLayout.SOUTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(26);
		logopanel.add(horizontalStrut, BorderLayout.WEST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(23);
		logopanel.add(horizontalStrut_1, BorderLayout.EAST);
		leftBtnPane.add(btnDshBoard);

		JButton btnBookCatalog = new JButton("Book Catalog");
		btnBookCatalog.setFocusPainted(false);
		btnBookCatalog.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(100, 149, 237)));
		btnBookCatalog.setBackground(new Color(255, 250, 250));
		btnBookCatalog.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		btnBookCatalog.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBookCatalog.setMaximumSize(new Dimension(185, 50));
		btnBookCatalog.addMouseListener(new L_ActionHandler());
		leftBtnPane.add(btnBookCatalog);

		JButton btnMemMgmt = new JButton("Manage Member");
		btnMemMgmt.setFocusPainted(false);
		btnMemMgmt.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(100, 149, 237)));
		btnMemMgmt.setBackground(new Color(255, 250, 250));
		btnMemMgmt.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		btnMemMgmt.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnMemMgmt.setMaximumSize(new Dimension(185, 50));
		btnMemMgmt.addMouseListener(new L_ActionHandler());
		leftBtnPane.add(btnMemMgmt);

		JButton btnReports = new JButton("Reports");
		btnReports.setFocusPainted(false);
		btnReports.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(100, 149, 237)));
		btnReports.setBackground(new Color(255, 250, 250));
		btnReports.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		btnReports.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnReports.setMaximumSize(new Dimension(185, 50));
		btnReports.addMouseListener(new L_ActionHandler());
		leftBtnPane.add(btnReports);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setFocusPainted(false);
		btnSettings.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(100, 149, 237)));
		btnSettings.setBackground(new Color(255, 250, 250));
		btnSettings.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		btnSettings.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSettings.setMaximumSize(new Dimension(185, 50));
		btnSettings.addMouseListener(new L_ActionHandler());
		leftBtnPane.add(btnSettings);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFocusPainted(false);
		btnLogout.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(100, 149, 237)));
		btnLogout.setBackground(new Color(255, 250, 250));
		btnLogout.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		btnLogout.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnLogout.setMaximumSize(new Dimension(185, 50));
		btnLogout.addMouseListener(new L_ActionHandler());
		leftBtnPane.add(btnLogout);
	}

	private class L_ActionHandler extends MouseAdapter{
		JButton btnSource;
		@Override
		public void mouseClicked(MouseEvent e) {
			btnSource = (JButton) e.getSource();
			switch (btnSource.getActionCommand()) {
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
				reportsPane = new R_ReportsPanel(mainPane);
				mainSpltPane.setRightComponent(reportsPane);
				break;
			case "Settings":

				Object input = PasswordDialog.getPassword(loginWindow, "Input Password.");
				if (input instanceof char[]) {
					char[] pwdInput = (char[]) input;
					if (controller.verifyPassword(pwdInput)) {
						settingsPane = new R_SettingsPanel(mainPane);
						mainSpltPane.setRightComponent(settingsPane);
					}
					else { ErrorDialog.showErrorDialog(loginWindow, "Wrong Password!"); }
				}
				break;
			case "Logout":
				if(ConfirmDialog.getResult(MainWindow.this, "Are you sure you want to log out?")) {
					MainWindow.this.dispose();
					MainWindow.this.loginWindow.setVisible(true);
				}
				break;
			default:
				dispose();
				System.exit(0);
				break;
			}
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			btnSource = (JButton) e.getSource();
			btnSource.setBackground(new Color(100, 149, 237));
			btnSource.setForeground(new Color(255, 250, 250));
			btnSource.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(255, 250, 250)));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			btnSource = (JButton) e.getSource();
			btnSource.setBackground(new Color(255, 250, 250));
			btnSource.setForeground(new Color(0, 0, 0));
			btnSource.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(100, 149, 237)));
		}
		
	}
}
