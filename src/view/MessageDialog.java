package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class MessageDialog{

	private JDialog dialog;
	private final JPanel contentPanel;

	public MessageDialog(JFrame prmParent, String prmMessage, String prmIcon) {
		dialog = new JDialog(prmParent, "", true);
		contentPanel = new JPanel();
		dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		init(prmMessage, prmIcon);
		dialog.setLocationRelativeTo(prmParent);
	}
	
	private void setVisible(Boolean flag) {
		dialog.setVisible(flag);
	}
	
	public static void showDialog(JFrame prmParent, String prmMessage, String prmIcon) {
		MessageDialog message = new MessageDialog(prmParent, prmMessage, prmIcon);
		message.setVisible(true);
	}
	
	private void init(String prmMessage, String prmIcon) {
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
				JButton btnConfirm = new JButton("OK");
				btnConfirm.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnConfirm.setForeground(new Color(255, 250, 250));
						btnConfirm.setBackground(new Color(30, 144, 255));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btnConfirm.setForeground(new Color(0, 0, 0));
						btnConfirm.setBackground(new Color(255, 250, 250));
					}
				});
				btnConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
					}
				});
				btnConfirm.setFocusPainted(false);
				btnConfirm.setForeground(new Color(0, 0, 0));
				btnConfirm.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 11));
				btnConfirm.setBackground(new Color(255, 250, 250));
				btnConfirm.setActionCommand("OK");
				buttonPane.add(btnConfirm);
				dialog.getRootPane().setDefaultButton(btnConfirm);
			}
		}
		{
			JLabel lblMessage = new JLabel("<html>"+prmMessage+"</html>");
			
			switch (prmIcon) {
			case "Info":
				lblMessage.setIcon(new ImageIcon(MessageDialog.class.getResource("/res/info_fix.png")));
				break;
			case "Warning":
				lblMessage.setIcon(new ImageIcon(MessageDialog.class.getResource("/res/warning_fix.png")));
				break;
			case "Success":
				lblMessage.setIcon(new ImageIcon(MessageDialog.class.getResource("/res/success_fix.png")));
				break;
			default:
				lblMessage.setIcon(new ImageIcon(MessageDialog.class.getResource("/res/info_fix.png")));
				break;
			}
			
			lblMessage.setBorder(new MatteBorder(0, 2, 0, 2, (Color) new Color(30, 144, 255)));
			lblMessage.setOpaque(true);
			lblMessage.setForeground(new Color(0, 0, 0));
			lblMessage.setBackground(new Color(255, 250, 250));
			lblMessage.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
			lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
			dialog.getContentPane().add(lblMessage, BorderLayout.CENTER);
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
