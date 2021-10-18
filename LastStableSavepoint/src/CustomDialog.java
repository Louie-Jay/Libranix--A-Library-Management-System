import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomDialog implements CustomDesign{
	
	private static JDialog dialog;
	private static JPanel panelDialog;
	
	private static JPanel panelMsg;
	private static JLabel lblMessage;
	private static JPanel panelButtons;
	private static JButton btnOk;
	private static JButton btnConfirm;
	private static JButton btnCancel;
	private static boolean confirmFlag;
	
	public static void showMessage(JFrame parent, String msg) {
		dialog = new JDialog(parent, true);
		dialog.setSize(350, 150);
		
		Point windowLocation = parent.getLocation();
		dialog.setLocation(windowLocation.x+260, windowLocation.y+230);
		
		panelDialog = new JPanel();
		panelDialog.setLayout(new BoxLayout(panelDialog, BoxLayout.PAGE_AXIS));
		
		panelMsg = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lblMessage = new JLabel(msg);
		lblMessage.setFont(textFont);
		panelMsg.add(lblMessage);
		panelMsg.setFont(textFont);
		
		panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnOk = new JButton("Ok");
		panelButtons.add(btnOk);
		
		panelDialog.add(Box.createRigidArea(new Dimension(0,5)));
		panelDialog.add(panelMsg);
		panelDialog.add(panelButtons);
		
		dialog.add(panelDialog);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		btnOk.addMouseListener(new DialogHandler());
		dialog.setVisible(true);
		
	}
	
	public static void showErrorDialog(JFrame parent, String er) {
		dialog = new JDialog(parent, true);
		dialog.setSize(350, 150);
		
		Point windowLocation = parent.getLocation();
		dialog.setLocation(windowLocation.x+260, windowLocation.y+230);
		
		panelDialog = new JPanel();
		panelDialog.setLayout(new BoxLayout(panelDialog, BoxLayout.PAGE_AXIS));
		
		panelMsg = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lblMessage = new JLabel(er);
		lblMessage.setFont(textFont);
		panelMsg.add(lblMessage);
		panelMsg.setFont(textFont);
		
		panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnOk = new JButton("Ok");
		panelButtons.add(btnOk);
		
		panelDialog.add(Box.createRigidArea(new Dimension(0,5)));
		panelDialog.add(panelMsg);
		panelDialog.add(panelButtons);
		
		dialog.add(panelDialog);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		btnOk.addMouseListener(new DialogHandler());
		dialog.setVisible(true);
	}
	
	public static void showWarningDialog(JFrame parent, String warn) {
		dialog = new JDialog(parent, true);
		dialog.setSize(350, 150);
		
		Point windowLocation = parent.getLocation();
		dialog.setLocation(windowLocation.x+260, windowLocation.y+230);
		
		panelDialog = new JPanel();
		panelDialog.setLayout(new BoxLayout(panelDialog, BoxLayout.PAGE_AXIS));
		
		panelMsg = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lblMessage = new JLabel(warn);
		lblMessage.setFont(textFont);
		panelMsg.add(lblMessage);
		panelMsg.setFont(textFont);
		
		panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnOk = new JButton("Ok");
		panelButtons.add(btnOk);
		
		panelDialog.add(Box.createRigidArea(new Dimension(0,5)));
		panelDialog.add(panelMsg);
		panelDialog.add(panelButtons);
		
		dialog.add(panelDialog);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		btnOk.addMouseListener(new DialogHandler());
		dialog.setVisible(true);
	}
	
	public static boolean showConfirmDialog(JFrame parent, String conf) {
		dialog = new JDialog(parent, true);
		dialog.setSize(350, 150);
		
		Point windowLocation = parent.getLocation();
		dialog.setLocation(windowLocation.x+260, windowLocation.y+230);
		
		panelDialog = new JPanel();
		panelDialog.setLayout(new BoxLayout(panelDialog, BoxLayout.PAGE_AXIS));
		
		panelMsg = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lblMessage = new JLabel(conf);
		lblMessage.setFont(textFont);
		panelMsg.add(lblMessage);
		panelMsg.setFont(textFont);
		
		panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnConfirm = new JButton("Confirm");
		btnCancel = new JButton("Cancel");
		panelButtons.add(btnConfirm);
		panelButtons.add(btnCancel);
		
		panelDialog.add(Box.createRigidArea(new Dimension(0,5)));
		panelDialog.add(panelMsg);
		panelDialog.add(panelButtons);
		
		dialog.add(panelDialog);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		btnConfirm.addMouseListener(new DialogHandler());
		btnCancel.addMouseListener(new DialogHandler());
		dialog.setVisible(true);
		return confirmFlag;
	}
	
	private static class DialogHandler extends MouseAdapter{
		Object source;
		
		@Override
		public void mouseClicked(MouseEvent e) {
			source = e.getSource();
			
			if(source == btnOk) {
				closeDialog();
			}else if(source == btnConfirm){
				confirmFlag = true;
				System.out.println("confirm called");
				closeDialog();
			}else if(source == btnCancel) {
				confirmFlag = false;
				System.out.println("cancel called");
				closeDialog();
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}
		
		public void closeDialog() {
			dialog.dispose();
		}
		
	}
	
}
