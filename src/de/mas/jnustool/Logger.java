package de.mas.jnustool;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import de.mas.jnustool.gui.NUSGUI;
import de.mas.jnustool.util.Settings;

public class Logger {

	public static void log(String string) {
		if(!java.awt.GraphicsEnvironment.isHeadless()){
			NUSGUI.output.append(string + "\n");
			NUSGUI.output.setCaretPosition(NUSGUI.output.getDocument().getLength());
		}
		if(Settings.logToPrintLn) System.out.println(string);		
	}

	public static void messageBox(String string) {
		if(!java.awt.GraphicsEnvironment.isHeadless()){
			JOptionPane.showMessageDialog(new JFrame(), string);
		}
	}
	
}
