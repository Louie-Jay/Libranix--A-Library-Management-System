package controller;

import java.util.Arrays;

import javax.swing.JSplitPane;

import model.MainWindowModel;
import view.R_SettingsPanel;

public class MainWindowController {
	
	MainWindowModel model;

	public MainWindowController() {
		model = new MainWindowModel();
	}
	
	public boolean verifyPassword(char[] prmPassword) {
		if (Arrays.equals(model.getSaltInput(prmPassword), model.getPassword())) {
			return true;
		}else {
			return false;
		}
	}
}
