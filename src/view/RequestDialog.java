package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.RequestController;

public class RequestDialog extends JDialog{
	
	
	private RequestController controller;
	
	JFrame parentFrame;
	JPanel dialogPanel;
	
	JScrollPane spTxtAreaRequest;
	JTextArea txtRequest;
	
	JPanel footerPanel;
	JButton btnSave;
	JButton btnCancel;
	private JPanel borderWindowPanel;
	private JLabel lblNewLabel;

	public RequestDialog(JFrame parentFrm) {
		super(parentFrm, "Requests Note",true);
		setUndecorated(true);
		controller = new RequestController();
		
		parentFrame = parentFrm;
		
		Point windowLocation = parentFrm.getLocation();
		this.setLocation(windowLocation.x+210, windowLocation.y+180);
		this.setSize(550, 350);
		dialogPanel = new JPanel(new BorderLayout());
		
		this.loadContentTextArea();
		this.loadFooterButtons();
		
		this.getContentPane().add(dialogPanel);
		
		borderWindowPanel = new JPanel();
		FlowLayout fl_borderWindowPanel = (FlowLayout) borderWindowPanel.getLayout();
		fl_borderWindowPanel.setVgap(10);
		fl_borderWindowPanel.setHgap(10);
		fl_borderWindowPanel.setAlignment(FlowLayout.LEFT);
		borderWindowPanel.setBackground(new Color(30, 144, 255));
		getContentPane().add(borderWindowPanel, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("Write Requests:");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		borderWindowPanel.add(lblNewLabel);
		
		borderWindowPanel.addMouseMotionListener(new Handler());
	}
	
	private void loadContentTextArea() {
		txtRequest = new JTextArea();
		txtRequest.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		txtRequest.setLineWrap(true);
		txtRequest.setSelectionColor(new Color(100, 149, 237));
		JScrollPane spEditorTextRequest = new JScrollPane(txtRequest);
		spEditorTextRequest.getVerticalScrollBar().setUI(new CustomScrollBarProperties());
		dialogPanel.add(spEditorTextRequest,BorderLayout.CENTER);
	}
	
	private void loadFooterButtons() {
		footerPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		footerPanel.setBackground(new Color(30, 144, 255));
		btnSave = new JButton("Save");
		btnSave.setPreferredSize(new Dimension(55, 25));
		btnSave.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnSave.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		btnSave.setBackground(new Color(255, 250, 250));
		btnCancel = new JButton("Cancel");
		btnCancel.setPreferredSize(new Dimension(55, 25));
		btnCancel.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnCancel.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		btnCancel.setBackground(new Color(255, 250, 250));
		
		btnSave.addActionListener(new RequestDialogHandler());
		btnCancel.addActionListener(new RequestDialogHandler());
		btnSave.addMouseListener(new MouseHandler());
		btnCancel.addMouseListener(new MouseHandler());
		
		footerPanel.add(btnSave);
		footerPanel.add(btnCancel);
		
		dialogPanel.add(footerPanel,BorderLayout.PAGE_END);
	}
	
	
	public void open() {
		this.controller.loadRequest(txtRequest);
		this.setLocationRelativeTo(parentFrame);
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
				if (ConfirmDialog.getResult(parentFrame, "Overwrite request, Confirm changes?")) {
					controller.saveRequest(txtRequest);
					MessageDialog.showDialog(parentFrame, "Request overwrite success!", "Success");
				}
				break;
			case "Cancel":
				close();
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
			btnSource.setBorder(new LineBorder(new Color(255, 250, 250)));
		}
		
	}
	
	private class Handler extends MouseAdapter{
		Point mouseLoc = null;
		@Override
		public void mouseDragged(MouseEvent e) {
			mouseLoc = MouseInfo.getPointerInfo().getLocation();
			RequestDialog.this.setLocation(mouseLoc);
		}
	}

}
