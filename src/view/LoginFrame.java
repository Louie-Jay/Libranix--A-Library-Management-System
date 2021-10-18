package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import controller.LoginController;

public class LoginFrame extends JFrame {

	private BorderWindow windowBorder;
	private JPanel contentPane;
	private JTextField txtLibrarian;
	private JPasswordField txtPassword;
	private LoginController controller;
	private JButton btnLogin;

	public LoginFrame() {
		setTitle("Libranix - Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 480);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel centerContentPane = new JPanel();
		contentPane.add(centerContentPane, BorderLayout.CENTER);
		GridLayout gl_centerContentPane = new GridLayout();
		gl_centerContentPane.setColumns(2);
		centerContentPane.setLayout(gl_centerContentPane);
		
		windowBorder = new BorderWindow(LoginFrame.this);
		contentPane.add(windowBorder, BorderLayout.NORTH);
		
		JPanel left_panel_logo = new JPanel();
		left_panel_logo.setBackground(new Color(30, 144, 255));
		centerContentPane.add(left_panel_logo);
		left_panel_logo.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(30, 144, 255));
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/res/libranix_fix.png")));
		lblNewLabel.setAlignmentX(0.5f);
		left_panel_logo.add(lblNewLabel);
		
		Component verticalStrut = Box.createVerticalStrut(156);
		left_panel_logo.add(verticalStrut, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(164);
		left_panel_logo.add(verticalStrut_1, BorderLayout.SOUTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(133);
		left_panel_logo.add(horizontalStrut, BorderLayout.WEST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(130);
		left_panel_logo.add(horizontalStrut_1, BorderLayout.EAST);
		
		JPanel right_panel_root = new JPanel();
		right_panel_root.setBorder(new MatteBorder(1, 1, 5, 5, (Color) new Color(30, 144, 255)));
		right_panel_root.setBackground(new Color(240, 255, 240));
		centerContentPane.add(right_panel_root);
		right_panel_root.setLayout(new CardLayout(0, 0));
		
		JPanel login_panel = new JPanel();
		login_panel.setBackground(new Color(255, 255, 255));
		right_panel_root.add(login_panel, "name_8207899855869");
		login_panel.setLayout(new GridLayout(3, 1, 0, 5));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		login_panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Lucida Sans", Font.BOLD, 25));
		panel_2.add(lblNewLabel_1);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(155);
		panel_2.add(horizontalStrut_2, BorderLayout.WEST);
		
		Component horizontalStrut_2_1 = Box.createHorizontalStrut(128);
		panel_2.add(horizontalStrut_2_1, BorderLayout.EAST);
		
		Component verticalStrut_4 = Box.createVerticalStrut(48);
		panel_2.add(verticalStrut_4, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		login_panel.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setPreferredSize(new Dimension(50, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(LoginFrame.class.getResource("/res/user_fix.png")));
		panel_5.add(lblNewLabel_2, BorderLayout.WEST);
		
		txtLibrarian = new JTextField();
		txtLibrarian.addActionListener(new ClickLoginHandler());
		txtLibrarian.setHorizontalAlignment(SwingConstants.CENTER);
		txtLibrarian.setText("Librarian");
		txtLibrarian.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		panel_5.add(txtLibrarian, BorderLayout.CENTER);
		txtLibrarian.setColumns(10);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut_2, BorderLayout.NORTH);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut_3, BorderLayout.SOUTH);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setPreferredSize(new Dimension(50, 0));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(LoginFrame.class.getResource("/res/password_fix.png")));
		panel_4.add(lblNewLabel_3, BorderLayout.WEST);
		
		txtPassword = new JPasswordField();
		txtPassword.addActionListener(new ClickLoginHandler());
		txtPassword.setColumns(10);
		txtPassword.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(txtPassword, BorderLayout.CENTER);
		
		Component verticalStrut_2_1 = Box.createVerticalStrut(20);
		panel_4.add(verticalStrut_2_1, BorderLayout.NORTH);
		
		Component verticalStrut_3_1 = Box.createVerticalStrut(20);
		panel_4.add(verticalStrut_3_1, BorderLayout.SOUTH);
		
		Component horizontalStrut_3_1 = Box.createHorizontalStrut(20);
		panel_4.add(horizontalStrut_3_1, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setHgap(10);
		flowLayout_1.setAlignment(FlowLayout.TRAILING);
		login_panel.add(panel);
		
		JLabel lbForgotPwd = new JLabel("Forgot Password?");
		lbForgotPwd.addMouseListener(new MouseAdapter() {
			
			
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lbForgotPwd.setForeground(new Color(30, 144, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbForgotPwd.setForeground(new Color(0, 0, 0));
				removeUnderline();
			}
			
			private void setUnderline() {
				Font font = lbForgotPwd.getFont();
				Map attributes = font.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				lbForgotPwd.setFont(font.deriveFont(attributes));
			}
			
			private void removeUnderline() {
				Font font = lbForgotPwd.getFont();
				Map attributes = font.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, -1);
				lbForgotPwd.setFont(font.deriveFont(attributes));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				setUnderline();
				
				controller = new LoginController();
				
				
				if(ConfirmDialog.getResult(LoginFrame.this, "A password recovery will be sent.<br> Confirm operation?")) {
					controller.sendCode();
					
					boolean pwdRecovery = true;
					while(pwdRecovery) {
						Object inputCode = InputDialog.getInput(LoginFrame.this, "Input the security code:");
						String securityCode = "";
						if(inputCode instanceof String) {
							securityCode = (String) inputCode;
							if(controller.validCode(securityCode.toCharArray())) {
								boolean undecided = true;
								while(undecided) {
									Object newPassword = PasswordDialog.getPassword(LoginFrame.this, "Input your new password:");
									if(newPassword instanceof char[]) {
										if(ConfirmDialog.getResult(LoginFrame.this, "Confirm new password?")) {
											if(controller.changePassword(((char[])newPassword))) {
												MessageDialog.showDialog(LoginFrame.this, "Password changed successfully!", "Success");
												undecided = false;
												pwdRecovery = false;
											}else {
												ErrorDialog.showErrorDialog(LoginFrame.this, "Password change failed.");
											}
										}
									}else {
										undecided = false;
										pwdRecovery = false;
									}
								}
							}else {
								ErrorDialog.showErrorDialog(LoginFrame.this, "Invalid security code.");
							}
						}else {
							pwdRecovery = false;
						}
					}
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				removeUnderline();
			}
		});
		
		lbForgotPwd.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 13));
		panel.add(lbForgotPwd);
		
		btnLogin = new JButton("");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller = new LoginController(txtLibrarian, txtPassword);
				
				if(controller.login()) {
					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							new MainWindow(LoginFrame.this);
							LoginFrame.this.setVisible(false);
							txtPassword.setText("");
							
						}
					});
				}else {
					txtPassword.setText("");
					ErrorDialog.showErrorDialog(LoginFrame.this, controller.getErrorMsg());
				}
			}
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(255,255,255,255));
				btnLogin.setIcon(new ImageIcon(LoginFrame.class.getResource("/res/login2_fix.png")));
				btnLogin.setBorder(new LineBorder(new Color(30, 144, 255), 1, false));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(new Color(30, 144, 255));
				btnLogin.setIcon(new ImageIcon(LoginFrame.class.getResource("/res/login_fix.png")));
			}
		});
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setPreferredSize(new Dimension(50, 35));
		btnLogin.setBackground(new Color(30, 144, 255));
		btnLogin.setFocusPainted(false);
		btnLogin.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		btnLogin.setIcon(new ImageIcon(LoginFrame.class.getResource("/res/login_fix.png")));
		panel.add(btnLogin);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(1);
		panel.add(horizontalStrut_4);

	}
	
	private class ClickLoginHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			btnLogin.doClick();
		}
		
	}
	

}
