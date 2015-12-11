package com.forksystem.app;

import java.awt.Dimension;
import java.util.Properties;

import javax.swing.UIManager;

import com.forksystem.ui.ViewPrincipal;
import com.forksystem.utils.Config;

import de.javasoft.plaf.synthetica.SyntheticaLookAndFeel;

public class App 
{
    public static void main( String[] args )
    {
    	try {
    		Properties prop = Config.getPropriedade();
    		UIManager.put("Synthetica.window.decoration", Boolean.FALSE);
    		UIManager.put("Synthetica.activateMenuByAltKey", Boolean.TRUE);
    		UIManager.put("Synthetica.tabbedPane.keepOpacity", Boolean.TRUE);
     		SyntheticaLookAndFeel.setWindowsDecorated(false);

    		 SyntheticaLookAndFeel.setToolbarSeparatorDimension(new Dimension(1,32));
    		 
    		 String tema=prop.getProperty("prop.btn.Tema");
  
    		System.out.println(tema);
    		UIManager.setLookAndFeel(tema);
    		new ViewPrincipal().setVisible(true);
    	
    	} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	
       
    
    }
}
