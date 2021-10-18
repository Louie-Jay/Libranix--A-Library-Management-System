import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class RequestDialog extends JDialog{
	
	JFrame parentFrame;
	JPanel dialogPanel;

	
	JScrollPane spTxtAreaRequest;
	JEditorPane txtRequest;
	
	JPanel footerPanel;
	JButton btnSave;
	JButton btnCancel;

	public RequestDialog(JFrame parentFrm) {
		super(parentFrm, "Requests Note",true);
		parentFrame = parentFrm;
		
		Point windowLocation = parentFrm.getLocation();
		this.setLocation(windowLocation.x+210, windowLocation.y+180);
		this.setSize(550, 350);
		dialogPanel = new JPanel(new BorderLayout());
		
		this.loadContentTextArea();
		this.loadFooterButtons();
		
		this.getContentPane().add(dialogPanel);
	}
	
	private void loadContentTextArea() {
		txtRequest = new JEditorPane();
		JScrollPane spEditorTextRequest = new JScrollPane(txtRequest);
		spEditorTextRequest.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		dialogPanel.add(spEditorTextRequest,BorderLayout.CENTER);
	}
	
	private void loadFooterButtons() {
		footerPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		btnSave = new JButton("Save");
		btnCancel = new JButton("Cancel");
		
		btnSave.addActionListener(new RequestDialogHandler());
		btnCancel.addActionListener(new RequestDialogHandler());
		
		footerPanel.add(btnSave);
		footerPanel.add(btnCancel);
		
		dialogPanel.add(footerPanel,BorderLayout.PAGE_END);
	}
	
	
	public void open() {
		this.setVisible(true);
	}
	
	public void close() {
		this.setVisible(false);
		dispose();
	}
	
	private class RequestDialogHandler implements ActionListener{
		JButton source;
		
		@Override
		public void actionPerformed(ActionEvent evt) {
			source = (JButton) evt.getSource();
			
			switch (source.getActionCommand()) {
			case "Save":
				System.out.println("Nothing for now"+txtRequest.getText());
				CustomDialog.showConfirmDialog(parentFrame, "Do you want to confirm changes before closing?");
				break;
			case "Cancel":
				close();
				break;
			default:
				break;
			}
			
		}
		
	}

}
