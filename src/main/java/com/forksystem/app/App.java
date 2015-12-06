package com.forksystem.app;

import java.awt.Dimension;

import javax.swing.UIManager;

import com.forksystem.ui.ViewPrincipal;

import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaLookAndFeel;

public class App 
{
    public static void main( String[] args )
    {
    	//for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
    	try {
    	//	if ("Nimbus".equals(info.getName())) {
		//	UIManager.setLookAndFeel(info.getClassName());
	//		break;
	//	}
    		UIManager.put("Synthetica.window.decoration", Boolean.FALSE);
    		UIManager.put("Synthetica.activateMenuByAltKey", Boolean.TRUE);
    		UIManager.put("Synthetica.tabbedPane.keepOpacity", true);
//    		SyntheticaLookAndFeel.setWindowsDecorated(false);

    		 SyntheticaLookAndFeel.setToolbarSeparatorDimension(new Dimension(1,32));
    		 


    		
    		UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
    		new ViewPrincipal().setVisible(true);
    	
    	} catch (Exception e) {
			// TODO: handle exception
		}
    	
       
    	//}
    }
}
