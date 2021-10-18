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
import java.awt.event.MouseMotionAdapter;

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

public class ConfirmDialog {

	private JDialog dialog;
	private JPanel contentPanel;
	private JLabel lblMessage;
	private JButton btnConfirm;
	private JButton btnCancel;
	private Boolean confirm;

	public ConfirmDialog(JFrame prmParent, String prmMessage) {
		dialog = new JDialog(prmParent, "", true);
		contentPanel = new JPanel();
		dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		init(prmMessage);
		dialog.setLocationRelativeTo(prmParent);
	}
	
	public void setVisible(Boolean flag) {
		dialog.setVisible(flag);
	}
	
	public static Boolean getResult(JFrame prmParent, String prmMessage) {
		ConfirmDialog responseDialog = new ConfirmDialog(prmParent, prmMessage);
		responseDialog.setVisible(true);
		Boolean response = responseDialog.confirm;
		return response;
	}
	
	private void init(String prmMessage) {
		confirm = false;
		dialog.setBounds(100, 100, 400, 200);
		dialog.getContentPane().setLayout(new BorderLayout());
		contentPanel.addMouseMotionListener(new MouseMotionAdapter() {
			Point mouseLoc = null;
			@Override
			public void mouseDragged(MouseEvent e) {
				mouseLoc = MouseInfo.getPointerInfo().getLocation();
				dialog.setLocation(mouseLoc);
			}
		});
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
				btnConfirm = new JButton("Confirm");
				btnConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						confirm = true;
						dialog.dispose();
						
					}
				});
				btnConfirm.setFocusPainted(false);
				btnConfirm.setForeground(new Color(255, 250, 250));
				btnConfirm.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 11));
				btnConfirm.setBackground(new Color(30, 144, 255));
				btnConfirm.setActionCommand("OK");
				buttonPane.add(btnConfirm);
				dialog.getRootPane().setDefaultButton(btnConfirm);
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
						dialog.dispose();
					}
				});
				btnCancel.setBackground(new Color(255, 250, 250));
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
		{
			lblMessage = new JLabel("<html>"+prmMessage+"</html>");
			lblMessage.setIcon(new ImageIcon(ConfirmDialog.class.getResource("/res/question_fix.png")));
			lblMessage.setBorder(new MatteBorder(0, 2, 0, 2, (Color) new Color(30, 144, 255)));
			lblMessage.setOpaque(true);
			lblMessage.setForeground(new Color(0, 0, 0));
			lblMessage.setBackground(new Color(255, 250, 250));
			lblMessage.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
			lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
			dialog.getContentPane().add(lblMessage, BorderLayout.CENTER);
		}
	}
	

}
