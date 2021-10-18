package sample;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LoginWindowSample extends JFrame{
	JPanel panelLogin;
	
	JLabel lblHeader;
	JLabel lblUser;
	JLabel lblPass;
	
	private JTextField txtUser;
	private JPasswordField txtPass;
	LoginListener loginListener;
	
	JRadioButton rbtnAdmin;
	JRadioButton rbtnLibrarian;
	
	JButton btnLogin;
	JButton btnExit;
	GridBagConstraints c;
	
	LoginWindowSample(){
		panelLogin = new JPanel();
		initComponents();
		initPanel();
		
		this.add(panelLogin);
		this.setSize(780, 700); // width, height
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void initComponents() {
		
		lblHeader = new JLabel("Library Management");
		lblHeader.setFont(new Font("Arial Bold", Font.ITALIC, 60));
		
		lblUser = new JLabel("Username:");
		txtUser = new JTextField();
		txtUser.setPreferredSize(new Dimension(200,20));
		
		lblPass = new JLabel("Password:");
		txtPass = new JPasswordField();
		
		btnLogin = new JButton("Login");
		btnExit = new JButton("Exit");
		c = new GridBagConstraints();
		
	}
	
	public void initPanel() {
		Border line = BorderFactory.createLineBorder(Color.blue);
		//lblHeader.setBorder(line);
		this.setLayout(new GridBagLayout());
		
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		//c.anchor = GridBagConstraints.PAGE_START;
		c.ipady = 20;
		c.gridwidth = 4;
		this.add(lblHeader, c);
		c.ipady = 0;
		
		c.gridwidth = 1;
		c.gridx = 1; // column
		c.gridy = 1; // row
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(20, 10, 0, 0);
		this.add(lblUser,c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(5, 10, 0, 0);
		this.add(lblPass,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
		c.gridy = 1;
		c.insets = new Insets(20, 10, 0, 0);
		this.add(txtUser,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
		c.gridy = 2;
		c.insets = new Insets(5, 10, 0, 0);
		this.add(txtPass,c);
		c.fill = GridBagConstraints.NONE;
		
		c.gridx = 1;
		c.gridy = 3;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		this.add(btnLogin,c);
		
		c.gridx = 2;
		c.gridy = 3;
		c.anchor = GridBagConstraints.LAST_LINE_END;
		this.add(btnExit,c);
		
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loginListener.login();
			}
		});
		
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loginListener.exit();
			}
		});
		
		//System.out.println(this.getContentPane().getSize().width +" / "+ this.getContentPane().getSize().height);
		
	}
	
	public String getUsername() {
		return this.txtUser.getText();
	}
	
	public char[] getPassword() {
		return this.txtPass.getPassword();
	}
	
	public void clearLogin() {
		txtUser.setText("");
		txtPass.setText("");
	}
	
	public void increaseDisplay() {
		this.setSize(this.getSize().width+1, this.getSize().height+1);
	}
	
	public void test() {
		//System.out.println("repainting.");
		//this.repaint();
		//System.out.println("changing...");
		this.setContentPane(cp);
		//this.repaint();
		//System.out.println("changed.");
		
		
	}
	
	public void creak() {
		//this.setContentPane(cp);
		//this.getContentPane().setSize(this.getContentPane().getSize().width+5, this.getContentPane().getSize().height+5);
		
	}
	
	Container cp;
	public void addPanel() {
		JPanel pan = new JPanel();
		JButton btntest = new JButton("Test");
		btntest.setBackground(Color.decode("#F3B8B1"));
		JButton btncreak = new JButton("Creak");
		btncreak.setBackground(Color.decode("#7DC8CA"));
		JButton btnX = new JButton("X");
		JButton btnY = new JButton("Y");
		pan.setSize(200, 200);
		pan.setBorder(BorderFactory.createLineBorder(Color.decode("#F3B8B1")));
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//pan.setLocation(300, 300);
		//pan.setX()
		//pan.setAlignmentY(CENTER_ALIGNMENT);
		//this.getContentPane().get
		
		
		pan.setBackground(Color.decode("#CECBD6"));
		pan.add(btncreak);
		pan.add(btntest);
		pan.add(btnX);
		pan.add(btnY);
		cp = this.getContentPane();
		this.setContentPane(pan);
		System.out.println(this.getContentPane().getLocation().x + " / " + this.getContentPane().getLocation().y);
		btntest.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loginListener.test();
				
			}
			
		});
		
		btncreak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loginListener.creak();
				
			}
			
		});
		
		btnX.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loginListener.x();
				
			}
			
		});
		
		btnY.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loginListener.y();
				
			}
			
		});
	}
	
	public void increaseX() {
		
		System.out.println(this.getContentPane().getLocation().x +" / "+ this.getContentPane().getLocation().y);
		this.getContentPane().setLocation(this.getContentPane().getLocation().x + 5, this.getContentPane().getLocation().y);
		
	}
	
	public void increaseY() {
		System.out.println(this.getContentPane().getLocation().x +" / "+ this.getContentPane().getLocation().y);
		this.getContentPane().setLocation(this.getContentPane().getLocation().x, this.getContentPane().getLocation().y + 5);
	}
	
	
	
	public void setListener(LoginListener l) {
		this.loginListener = l;
	}

}
