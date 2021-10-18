package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controller.SettingsController;

public class R_SettingsPanel extends JPanel {
	
	private SettingsController controller;
	private HeaderPanel header;
	private EmailTextField txtEmail;
	private JPasswordField txtPassword;
	private JButton btnChangeEmail;
	private EmailTextField txtMailer;
	private HostTextField txtHost;
	private PortTextField txtPort;
	private JTextField txtSID;
	private ContactTextField txtPhoneNumber;
	private JPanel parent;
	private JPasswordField txtMailerPassword;
	private JTextField txtAuthToken;

	public R_SettingsPanel(JPanel prmParent) {
		setLayout(new BorderLayout(0, 0));
		parent = prmParent;
		controller = new SettingsController(prmParent);
		header = new HeaderPanel("Settings",false);
		this.add(header, BorderLayout.PAGE_START);
		
		JPanel mainPanel = new JPanel();
		add(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel contentPanel = new JPanel();
		mainPanel.add(contentPanel);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setMaximumSize(new Dimension(32767, 2500));
		panel.setMinimumSize(new Dimension(10, 100));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Security Settings", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		TitledBorder border1 = (TitledBorder) panel.getBorder();
		border1.setTitleFont(new Font("Lucida Sans", Font.BOLD, 13));
		contentPanel.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 3;
		gbc_verticalStrut.gridy = 0;
		panel.add(verticalStrut, gbc_verticalStrut);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 4;
		gbc_verticalStrut_1.gridy = 0;
		panel.add(verticalStrut_1, gbc_verticalStrut_1);
		
		Component horizontalStrut_10 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_10 = new GridBagConstraints();
		gbc_horizontalStrut_10.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_10.gridx = 0;
		gbc_horizontalStrut_10.gridy = 1;
		panel.add(horizontalStrut_10, gbc_horizontalStrut_10);
		
		Component horizontalStrut_11 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_11 = new GridBagConstraints();
		gbc_horizontalStrut_11.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_11.gridx = 1;
		gbc_horizontalStrut_11.gridy = 1;
		panel.add(horizontalStrut_11, gbc_horizontalStrut_11);
		
		Component horizontalStrut_12 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_12 = new GridBagConstraints();
		gbc_horizontalStrut_12.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_12.gridx = 2;
		gbc_horizontalStrut_12.gridy = 1;
		panel.add(horizontalStrut_12, gbc_horizontalStrut_12);
		
		txtEmail = new EmailTextField((String) null, 0);
		txtEmail.setPreferredSize(new Dimension(7, 25));
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setText("Test@gmail.com");
		txtEmail.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		txtEmail.setBorder(new LineBorder(new Color(100, 149, 237)));
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.fill = GridBagConstraints.BOTH;
		gbc_txtEmail.gridx = 3;
		gbc_txtEmail.gridy = 1;
		panel.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		btnChangeEmail = new JButton("Change Email");
		btnChangeEmail.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		btnChangeEmail.setBackground(new Color(255, 250, 250));
		btnChangeEmail.setPreferredSize(new Dimension(99, 25));
		btnChangeEmail.setOpaque(false);
		btnChangeEmail.setBorder(new LineBorder(new Color(100, 149, 237)));
		GridBagConstraints gbc_btnChangeEmail = new GridBagConstraints();
		gbc_btnChangeEmail.fill = GridBagConstraints.BOTH;
		gbc_btnChangeEmail.insets = new Insets(0, 0, 5, 5);
		gbc_btnChangeEmail.gridx = 4;
		gbc_btnChangeEmail.gridy = 1;
		btnChangeEmail.addMouseListener(new MouseHandler());
		btnChangeEmail.addActionListener(new ActionHandler());
		panel.add(btnChangeEmail, gbc_btnChangeEmail);
		
		Component horizontalStrut_16 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_16 = new GridBagConstraints();
		gbc_horizontalStrut_16.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_16.gridx = 5;
		gbc_horizontalStrut_16.gridy = 1;
		panel.add(horizontalStrut_16, gbc_horizontalStrut_16);
		
		Component horizontalStrut_17 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_17 = new GridBagConstraints();
		gbc_horizontalStrut_17.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_17.gridx = 6;
		gbc_horizontalStrut_17.gridy = 1;
		panel.add(horizontalStrut_17, gbc_horizontalStrut_17);
		
		Component horizontalStrut_18 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_18 = new GridBagConstraints();
		gbc_horizontalStrut_18.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_18.gridx = 7;
		gbc_horizontalStrut_18.gridy = 1;
		panel.add(horizontalStrut_18, gbc_horizontalStrut_18);
		
		Component horizontalStrut_13 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_13 = new GridBagConstraints();
		gbc_horizontalStrut_13.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_13.gridx = 0;
		gbc_horizontalStrut_13.gridy = 2;
		panel.add(horizontalStrut_13, gbc_horizontalStrut_13);
		
		Component horizontalStrut_14 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_14 = new GridBagConstraints();
		gbc_horizontalStrut_14.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_14.gridx = 1;
		gbc_horizontalStrut_14.gridy = 2;
		panel.add(horizontalStrut_14, gbc_horizontalStrut_14);
		
		Component horizontalStrut_15 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_15 = new GridBagConstraints();
		gbc_horizontalStrut_15.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_15.gridx = 2;
		gbc_horizontalStrut_15.gridy = 2;
		panel.add(horizontalStrut_15, gbc_horizontalStrut_15);
		
		txtPassword = new JPasswordField();
		txtPassword.setPreferredSize(new Dimension(7, 5));
		txtPassword.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setBorder(new LineBorder(new Color(100, 149, 237)));
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
		gbc_txtPassword.fill = GridBagConstraints.BOTH;
		gbc_txtPassword.gridx = 3;
		gbc_txtPassword.gridy = 2;
		panel.add(txtPassword, gbc_txtPassword);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBackground(new Color(255, 250, 250));
		btnChangePassword.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		btnChangePassword.setPreferredSize(new Dimension(121, 25));
		btnChangePassword.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnChangePassword.setOpaque(false);
		GridBagConstraints gbc_btnChangePassword = new GridBagConstraints();
		gbc_btnChangePassword.fill = GridBagConstraints.BOTH;
		gbc_btnChangePassword.insets = new Insets(0, 0, 5, 5);
		gbc_btnChangePassword.gridx = 4;
		gbc_btnChangePassword.gridy = 2;
		btnChangePassword.addMouseListener(new MouseHandler());
		btnChangePassword.addActionListener(new ActionHandler());
		panel.add(btnChangePassword, gbc_btnChangePassword);
		
		Component horizontalStrut_19 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_19 = new GridBagConstraints();
		gbc_horizontalStrut_19.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_19.gridx = 5;
		gbc_horizontalStrut_19.gridy = 2;
		panel.add(horizontalStrut_19, gbc_horizontalStrut_19);
		
		Component horizontalStrut_20 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_20 = new GridBagConstraints();
		gbc_horizontalStrut_20.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_20.gridx = 6;
		gbc_horizontalStrut_20.gridy = 2;
		panel.add(horizontalStrut_20, gbc_horizontalStrut_20);
		
		Component horizontalStrut_21 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_21 = new GridBagConstraints();
		gbc_horizontalStrut_21.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_21.gridx = 7;
		gbc_horizontalStrut_21.gridy = 2;
		panel.add(horizontalStrut_21, gbc_horizontalStrut_21);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_2.gridx = 3;
		gbc_verticalStrut_2.gridy = 3;
		panel.add(verticalStrut_2, gbc_verticalStrut_2);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_3.gridx = 4;
		gbc_verticalStrut_3.gridy = 3;
		panel.add(verticalStrut_3, gbc_verticalStrut_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 250));
		panel_1.setMaximumSize(new Dimension(32767, 5000));
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Mailing Settings", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		TitledBorder border2 = (TitledBorder) panel_1.getBorder();
		border2.setTitleFont(new Font("Lucida Sans", Font.BOLD, 13));
		contentPanel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 27, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 2;
		gbc_verticalStrut_4.gridy = 0;
		panel_1.add(verticalStrut_4, gbc_verticalStrut_4);
		
		Component horizontalStrut = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 1;
		panel_1.add(horizontalStrut, gbc_horizontalStrut);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		txtMailer = new EmailTextField((String) null, 0);
		lblNewLabel.setLabelFor(txtMailer);
		txtMailer.setHorizontalAlignment(SwingConstants.CENTER);
		txtMailer.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		txtMailer.setBorder(new LineBorder(new Color(100, 149, 237)));
		txtMailer.setPreferredSize(new Dimension(7, 25));
		GridBagConstraints gbc_txtMailer = new GridBagConstraints();
		gbc_txtMailer.insets = new Insets(0, 0, 5, 5);
		gbc_txtMailer.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMailer.gridx = 2;
		gbc_txtMailer.gridy = 1;
		panel_1.add(txtMailer, gbc_txtMailer);
		txtMailer.setColumns(10);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_3.gridx = 3;
		gbc_horizontalStrut_3.gridy = 1;
		panel_1.add(horizontalStrut_3, gbc_horizontalStrut_3);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 0;
		gbc_horizontalStrut_1.gridy = 2;
		panel_1.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		JLabel lblNewLabel_1 = new JLabel("Host:");
		lblNewLabel_1.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtHost = new HostTextField((String) null, 0);
		lblNewLabel_1.setLabelFor(txtHost);
		txtHost.setHorizontalAlignment(SwingConstants.CENTER);
		txtHost.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		txtHost.setBorder(new LineBorder(new Color(100, 149, 237)));
		txtHost.setPreferredSize(new Dimension(7, 25));
		GridBagConstraints gbc_txtHost = new GridBagConstraints();
		gbc_txtHost.insets = new Insets(0, 0, 5, 5);
		gbc_txtHost.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHost.gridx = 2;
		gbc_txtHost.gridy = 2;
		panel_1.add(txtHost, gbc_txtHost);
		txtHost.setColumns(10);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_4.gridx = 3;
		gbc_horizontalStrut_4.gridy = 2;
		panel_1.add(horizontalStrut_4, gbc_horizontalStrut_4);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 0;
		gbc_horizontalStrut_2.gridy = 3;
		panel_1.add(horizontalStrut_2, gbc_horizontalStrut_2);
		
		JLabel lblNewLabel_2 = new JLabel("Port:");
		lblNewLabel_2.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtPort = new PortTextField((String) null, 0);
		txtPort.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		lblNewLabel_2.setLabelFor(txtPort);
		txtPort.setHorizontalAlignment(SwingConstants.CENTER);
		txtPort.setBorder(new LineBorder(new Color(100, 149, 237)));
		txtPort.setPreferredSize(new Dimension(7, 25));
		GridBagConstraints gbc_txtPort = new GridBagConstraints();
		gbc_txtPort.insets = new Insets(0, 0, 5, 5);
		gbc_txtPort.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPort.gridx = 2;
		gbc_txtPort.gridy = 3;
		panel_1.add(txtPort, gbc_txtPort);
		txtPort.setColumns(10);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
		gbc_horizontalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_5.gridx = 3;
		gbc_horizontalStrut_5.gridy = 3;
		panel_1.add(horizontalStrut_5, gbc_horizontalStrut_5);
		
		txtMailerPassword = new JPasswordField();
		txtMailerPassword.setPreferredSize(new Dimension(7, 25));
		txtMailerPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtMailerPassword.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		txtMailerPassword.setBorder(new LineBorder(new Color(100, 149, 237)));
		GridBagConstraints gbc_txtMailerPassword = new GridBagConstraints();
		gbc_txtMailerPassword.insets = new Insets(0, 0, 5, 5);
		gbc_txtMailerPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMailerPassword.gridx = 2;
		gbc_txtMailerPassword.gridy = 4;
		panel_1.add(txtMailerPassword, gbc_txtMailerPassword);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password:");
		lblNewLabel_2_1.setLabelFor(txtMailerPassword);
		lblNewLabel_2_1.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1.gridx = 1;
		gbc_lblNewLabel_2_1.gridy = 4;
		panel_1.add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_6 = new GridBagConstraints();
		gbc_horizontalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_6.gridx = 0;
		gbc_horizontalStrut_6.gridy = 5;
		panel_1.add(horizontalStrut_6, gbc_horizontalStrut_6);
		
		Component horizontalStrut_22 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_22 = new GridBagConstraints();
		gbc_horizontalStrut_22.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_22.gridx = 1;
		gbc_horizontalStrut_22.gridy = 5;
		panel_1.add(horizontalStrut_22, gbc_horizontalStrut_22);
		
		JButton btnApplyMailer = new JButton("Apply Mailer");
		btnApplyMailer.setBackground(new Color(255, 250, 250));
		btnApplyMailer.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		btnApplyMailer.setOpaque(false);
		btnApplyMailer.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnApplyMailer.setPreferredSize(new Dimension(93, 25));
		GridBagConstraints gbc_btnApplyMailer = new GridBagConstraints();
		gbc_btnApplyMailer.insets = new Insets(0, 0, 5, 5);
		gbc_btnApplyMailer.gridx = 2;
		gbc_btnApplyMailer.gridy = 5;
		btnApplyMailer.addMouseListener(new MouseHandler());
		btnApplyMailer.addActionListener(new ActionHandler());
		panel_1.add(btnApplyMailer, gbc_btnApplyMailer);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_8 = new GridBagConstraints();
		gbc_horizontalStrut_8.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_8.gridx = 3;
		gbc_horizontalStrut_8.gridy = 5;
		panel_1.add(horizontalStrut_8, gbc_horizontalStrut_8);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_7 = new GridBagConstraints();
		gbc_horizontalStrut_7.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_7.gridx = 0;
		gbc_horizontalStrut_7.gridy = 6;
		panel_1.add(horizontalStrut_7, gbc_horizontalStrut_7);
		
		Component horizontalStrut_23 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_23 = new GridBagConstraints();
		gbc_horizontalStrut_23.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_23.gridx = 1;
		gbc_horizontalStrut_23.gridy = 6;
		panel_1.add(horizontalStrut_23, gbc_horizontalStrut_23);
		
		JLabel lblNewLabel_3 = new JLabel("<html>Note: Changing this settings could break the mailing feature.<br>Ask your local administrator for a working SMTP setup.</html>");
		lblNewLabel_3.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 6;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_9 = new GridBagConstraints();
		gbc_horizontalStrut_9.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_9.gridx = 3;
		gbc_horizontalStrut_9.gridy = 6;
		panel_1.add(horizontalStrut_9, gbc_horizontalStrut_9);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 250, 250));
		panel_2.setMaximumSize(new Dimension(32767, 10000));
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Twilio SMS Settings", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		TitledBorder border3 = (TitledBorder) panel_2.getBorder();
		border3.setTitleFont(new Font("Lucida Sans", Font.BOLD, 13));
		contentPanel.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_5.gridx = 2;
		gbc_verticalStrut_5.gridy = 0;
		panel_2.add(verticalStrut_5, gbc_verticalStrut_5);
		
		Component horizontalStrut_24 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_24 = new GridBagConstraints();
		gbc_horizontalStrut_24.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_24.gridx = 0;
		gbc_horizontalStrut_24.gridy = 1;
		panel_2.add(horizontalStrut_24, gbc_horizontalStrut_24);
		
		JLabel lblNewLabel_4 = new JLabel("SID:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_4.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 1;
		panel_2.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		txtSID = new JTextField();
		txtSID.setHorizontalAlignment(SwingConstants.CENTER);
		txtSID.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		txtSID.setBorder(new LineBorder(new Color(100, 149, 237)));
		txtSID.setPreferredSize(new Dimension(7, 25));
		lblNewLabel_4.setLabelFor(txtSID);
		GridBagConstraints gbc_txtSID = new GridBagConstraints();
		gbc_txtSID.insets = new Insets(0, 0, 5, 5);
		gbc_txtSID.fill = GridBagConstraints.BOTH;
		gbc_txtSID.gridx = 2;
		gbc_txtSID.gridy = 1;
		panel_2.add(txtSID, gbc_txtSID);
		txtSID.setColumns(30);
		
		Component horizontalStrut_26 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_26 = new GridBagConstraints();
		gbc_horizontalStrut_26.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_26.gridx = 3;
		gbc_horizontalStrut_26.gridy = 1;
		panel_2.add(horizontalStrut_26, gbc_horizontalStrut_26);
		
		Component horizontalStrut_33 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_33 = new GridBagConstraints();
		gbc_horizontalStrut_33.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_33.gridx = 4;
		gbc_horizontalStrut_33.gridy = 1;
		panel_2.add(horizontalStrut_33, gbc_horizontalStrut_33);
		
		JLabel lblNewLabel_4_1 = new JLabel("Auth Token:");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_4_1.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_4_1 = new GridBagConstraints();
		gbc_lblNewLabel_4_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4_1.gridx = 1;
		gbc_lblNewLabel_4_1.gridy = 2;
		panel_2.add(lblNewLabel_4_1, gbc_lblNewLabel_4_1);
		
		txtAuthToken = new JTextField();
		lblNewLabel_4_1.setLabelFor(txtAuthToken);
		txtAuthToken.setPreferredSize(new Dimension(7, 25));
		txtAuthToken.setHorizontalAlignment(SwingConstants.CENTER);
		txtAuthToken.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		txtAuthToken.setColumns(30);
		txtAuthToken.setBorder(new LineBorder(new Color(100, 149, 237)));
		GridBagConstraints gbc_txtAuthToken = new GridBagConstraints();
		gbc_txtAuthToken.insets = new Insets(0, 0, 5, 5);
		gbc_txtAuthToken.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAuthToken.gridx = 2;
		gbc_txtAuthToken.gridy = 2;
		panel_2.add(txtAuthToken, gbc_txtAuthToken);
		
		Component horizontalStrut_25 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_25 = new GridBagConstraints();
		gbc_horizontalStrut_25.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_25.gridx = 0;
		gbc_horizontalStrut_25.gridy = 3;
		panel_2.add(horizontalStrut_25, gbc_horizontalStrut_25);
		
		JLabel lblNewLabel_5 = new JLabel("Phone Number:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 3;
		panel_2.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		txtPhoneNumber = new ContactTextField((String) null, 0);
		txtPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhoneNumber.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		txtPhoneNumber.setBorder(new LineBorder(new Color(100, 149, 237)));
		txtPhoneNumber.setPreferredSize(new Dimension(7, 25));
		lblNewLabel_5.setLabelFor(txtPhoneNumber);
		GridBagConstraints gbc_txtPhoneNumber = new GridBagConstraints();
		gbc_txtPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_txtPhoneNumber.fill = GridBagConstraints.BOTH;
		gbc_txtPhoneNumber.gridx = 2;
		gbc_txtPhoneNumber.gridy = 3;
		panel_2.add(txtPhoneNumber, gbc_txtPhoneNumber);
		txtPhoneNumber.setColumns(10);
		
		Component horizontalStrut_27 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_27 = new GridBagConstraints();
		gbc_horizontalStrut_27.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_27.gridx = 3;
		gbc_horizontalStrut_27.gridy = 3;
		panel_2.add(horizontalStrut_27, gbc_horizontalStrut_27);
		
		Component horizontalStrut_32 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_32 = new GridBagConstraints();
		gbc_horizontalStrut_32.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_32.gridx = 4;
		gbc_horizontalStrut_32.gridy = 3;
		panel_2.add(horizontalStrut_32, gbc_horizontalStrut_32);
		
		Component horizontalStrut_30 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_30 = new GridBagConstraints();
		gbc_horizontalStrut_30.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_30.gridx = 0;
		gbc_horizontalStrut_30.gridy = 4;
		panel_2.add(horizontalStrut_30, gbc_horizontalStrut_30);
		
		Component horizontalStrut_29 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_29 = new GridBagConstraints();
		gbc_horizontalStrut_29.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_29.gridx = 1;
		gbc_horizontalStrut_29.gridy = 4;
		panel_2.add(horizontalStrut_29, gbc_horizontalStrut_29);
		
		JButton btnApplySender = new JButton("Apply Sender");
		btnApplySender.setBackground(new Color(255, 250, 250));
		btnApplySender.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		btnApplySender.setOpaque(false);
		btnApplySender.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnApplySender.setPreferredSize(new Dimension(93, 25));
		GridBagConstraints gbc_btnApplySender = new GridBagConstraints();
		gbc_btnApplySender.fill = GridBagConstraints.BOTH;
		gbc_btnApplySender.insets = new Insets(0, 0, 5, 5);
		gbc_btnApplySender.gridx = 2;
		gbc_btnApplySender.gridy = 4;
		btnApplySender.addMouseListener(new MouseHandler());
		btnApplySender.addActionListener(new ActionHandler());
		panel_2.add(btnApplySender, gbc_btnApplySender);
		
		Component horizontalStrut_28 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_28 = new GridBagConstraints();
		gbc_horizontalStrut_28.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_28.gridx = 3;
		gbc_horizontalStrut_28.gridy = 4;
		panel_2.add(horizontalStrut_28, gbc_horizontalStrut_28);
		
		Component horizontalStrut_31 = Box.createHorizontalStrut(30);
		GridBagConstraints gbc_horizontalStrut_31 = new GridBagConstraints();
		gbc_horizontalStrut_31.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_31.gridx = 4;
		gbc_horizontalStrut_31.gridy = 4;
		panel_2.add(horizontalStrut_31, gbc_horizontalStrut_31);
		
		Component verticalStrut_6 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_6 = new GridBagConstraints();
		gbc_verticalStrut_6.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_6.gridx = 2;
		gbc_verticalStrut_6.gridy = 5;
		panel_2.add(verticalStrut_6, gbc_verticalStrut_6);
		
		this.initializeSettings();

	}
	
	private void initializeSettings() {
		HashMap<String, JComponent> components = new HashMap<String, JComponent>();
		
		components.put("Email", txtEmail);
		components.put("MailerEmail", txtMailer);
		components.put("MailerHost", txtHost);
		components.put("MailerPort", txtPort);
		
		components.put("SenderSID", txtSID);
		components.put("SenderAuthToken", txtAuthToken);
		components.put("SenderPhoneNumber", txtPhoneNumber);
		
		controller.initializeSettings(components);
	}
	
	private class ActionHandler implements ActionListener{
		JButton btnSource;
		JFrame parentSource = (JFrame) SwingUtilities.getWindowAncestor(parent);
		@Override
		public void actionPerformed(ActionEvent e) {
			btnSource = (JButton) e.getSource();
			
			switch (btnSource.getActionCommand()) {
			case "Change Email":
				if(txtEmail.valid()) {
					if (ConfirmDialog.getResult(parentSource,
							"Change admin email to:<br>" + txtEmail.getText() + "<br>Confirm changes?")) {
						Object passwordInput = PasswordDialog.getPassword(parentSource, "Input password to confirm.");
						if (passwordInput instanceof char[]) {
							char[] input = (char[]) passwordInput;
							if (controller.changeEmail(txtEmail,input)) {
								MessageDialog.showDialog(parentSource, "Email change success!", "Success");
							}else {
								ErrorDialog.showErrorDialog(parentSource, controller.getErrorMsg());
							}
						}
					}
				}else {
					ErrorDialog.showErrorDialog(parentSource, "Invalid Email!");
				}
				break;
			case "Change Password":
				
				if (controller.validPassword(txtPassword)) {
					if (ConfirmDialog.getResult(parentSource, "Apply new password?")) {
						MessageDialog.showDialog(parentSource, "A security code will be sent<br>to admin email", "Info");
						if(controller.sendSecurityCode()) {
							Object secInput = InputDialog.getInput(parentSource, "Input security code");
							if (secInput instanceof String) {
								String securityCode = (String) secInput;
								if (controller.isValidSecurityCode(securityCode)) {
									Object currentPassword = PasswordDialog.getPassword(parentSource,"Input current password:");
									if (currentPassword instanceof char[]) {
										char[] curPassword = (char[]) currentPassword;
										if (controller.changePassword(txtPassword, curPassword)) {
											MessageDialog.showDialog(parentSource,
													"Password changed successfully!<br>New password applied!", "Success");
										} else { ErrorDialog.showErrorDialog(parentSource, controller.getErrorMsg()); }
									}
								} else { ErrorDialog.showErrorDialog(parentSource, "Invalid security code!"); }
							}
						} else { ErrorDialog.showErrorDialog(parentSource, "Critical Error:"+controller.getErrorMsg()); }
					}
				}else { 
					ErrorDialog.showErrorDialog(parentSource, "Password length invalid."); 
					MessageDialog.showDialog(parentSource, "Password must be at least up-to 8 characters", "Info");
				}

				break;
			case "Apply Mailer":
				
				if (txtHost.valid() && txtPort.valid()) {
					if (ConfirmDialog.getResult(parentSource, "Are you sure you want to apply these changes?")) {
						Object input = PasswordDialog.getPassword(parentSource, "Please input password.");
						if (input instanceof char[]) {
							char[] passwordInput = (char[]) input;
							if (controller.applyMailer(txtMailer,txtHost,txtPort,txtMailerPassword,passwordInput)) {
								MessageDialog.showDialog(parentSource, "New host settings applied!", "Success");
							}else {
								ErrorDialog.showErrorDialog(parentSource, controller.getErrorMsg());
							}
						}
					}
				}else {
					ErrorDialog.showErrorDialog(parentSource, "Invalid inputs.");
				}
				break;
			case "Apply Sender":
				if((txtSID.getText() != "") && (txtAuthToken.getText() != "") && txtPhoneNumber.valid()) {
					if(ConfirmDialog.getResult(parentSource, "Are you sure you want to apply these changes?")) {
						Object input = PasswordDialog.getPassword(parentSource, "Please input password.");
						if(input instanceof char[]) {
							char[] passwordInput = (char[]) input;
							if (controller.applySender(txtSID,txtAuthToken,txtPhoneNumber,passwordInput)) {
								MessageDialog.showDialog(parentSource, "New twilio settings applied!", "Success");
							}else {
								ErrorDialog.showErrorDialog(parentSource, controller.getErrorMsg());
							}
						}
					}
				}else{
					ErrorDialog.showErrorDialog(parentSource, "Invalid inputs.");
				}
				break;

			default:
				break;
			}
		}
		
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
			btnSource.setOpaque(true);
			btnSource.setForeground(new Color(0, 0, 0));
			btnSource.setBorder(new LineBorder(new Color(30, 144, 255)));
		}
		
	}

}
