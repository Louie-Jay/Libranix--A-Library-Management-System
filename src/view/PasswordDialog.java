package view;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;


public class PasswordDialog {
	
	private JDialog dialog;
	private JPasswordField txtPassword;
	private JPanel contentPanel;
	private JButton btnEnter;
	private JButton btnCancel;
	private Object password;
	
	public PasswordDialog(JFrame prmParent,String prmMessage) {
		dialog = new JDialog(prmParent, "", true);
		contentPanel = new JPanel();
		dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		init(prmMessage);
		dialog.setLocationRelativeTo(prmParent);
	}
	
	public void setVisible(Boolean flag) {
		dialog.setVisible(flag);
	}
	
	public static Object getPassword(JFrame prmParent, String prmMessage) {
		PasswordDialog input = new PasswordDialog(prmParent, prmMessage);
		input.setVisible(true);
		Object pwd = input.password;
		return pwd;
	}
	
	private void init(String prmMessage) {
		dialog.setBounds(100, 100, 400, 200);
		dialog.getContentPane().setLayout(new BorderLayout());
		contentPanel.addMouseMotionListener(new Handler());
		contentPanel.setBackground(new Color(30, 144, 255));
		contentPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(30, 144, 255)));
		dialog.setUndecorated(true);
		dialog.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		dialog.getContentPane().add(contentPanel, BorderLayout.NORTH);
		dialog.setResizable(false);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			Component verticalStrut = Box.createVerticalStrut(10);
			contentPanel.add(verticalStrut);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new MatteBorder(1, 2, 2, 2, (Color) new Color(30, 144, 255)));
			buttonPane.setBackground(new Color(255, 250, 250));
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			dialog.getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEnter = new JButton("Enter");
				btnEnter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						password = (char[]) txtPassword.getPassword();
						dialog.dispose();
					}
				});
				btnEnter.setFocusPainted(false);
				btnEnter.setForeground(new Color(255, 250, 250));
				btnEnter.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 11));
				btnEnter.setBackground(new Color(30, 144, 255));
				btnEnter.setActionCommand("OK");
				buttonPane.add(btnEnter);
				dialog.getRootPane().setDefaultButton(btnEnter);
			}
			{
				btnCancel = new JButton("Cancel");
				btnCancel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnCancel.setBackground(new Color(30, 144, 255));
						btnCancel.setForeground(new Color(255, 250, 250));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btnCancel.setBackground(new Color(255, 250, 250));
						btnCancel.setForeground(new Color(0, 0, 0));
					}
				});
				
				btnCancel.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 11));
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						password = (Boolean) false;
						dialog.dispose();
					}
				});
				btnCancel.setBackground(new Color(255, 250, 250));
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new MatteBorder(0, 2, 0, 2, (Color) new Color(30, 144, 255)));
			panel.setBackground(new Color(255, 250, 250));
			dialog.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			{
				JLabel lblMessage = new JLabel("<html>"+prmMessage+"</html>");
				lblMessage.setIcon(new ImageIcon(PasswordDialog.class.getResource("/res/dialogpassword_fix.png")));
				lblMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
				lblMessage.setPreferredSize(new Dimension(400, 110));
				lblMessage.setOpaque(true);
				lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
				lblMessage.setForeground(Color.BLACK);
				lblMessage.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
				lblMessage.setBorder(null);
				lblMessage.setBackground(new Color(255, 250, 250));
				panel.add(lblMessage);
			}
			{
				
				txtPassword = new JPasswordField();
				txtPassword.setBorder(new LineBorder(new Color(0, 0, 0)));
				txtPassword.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 11));
				txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
				txtPassword.setMaximumSize(new Dimension(300, 2147483647));
				txtPassword.setMinimumSize(new Dimension(5, 20));
				txtPassword.setPreferredSize(new Dimension(5, 10));
				panel.add(txtPassword);
				txtPassword.setColumns(30);
			}
			{
				Component verticalStrut = Box.createVerticalStrut(6);
				panel.add(verticalStrut);
			}
		}
		{
	
		}

	}
	
	private class Handler extends MouseAdapter{
		Point mouseLoc = null;
		@Override
		public void mouseDragged(MouseEvent e) {
			mouseLoc = MouseInfo.getPointerInfo().getLocation();
			dialog.setLocation(mouseLoc);
		}
	}

}
