/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlsupport;

import java.sql.Connection;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author bgc
 */
public class SqlSupport {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            UIManager.setLookAndFeel(
                    //   UIManager.getCrossPlatformLookAndFeelClassName()
                    UIManager.getSystemLookAndFeelClassName()
            );
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            // Do Nothing
        }
        SqlSupport listener = new SqlSupport();
    //    DbConnect c = new DbConnect();
    //    Connection cn = c.cConnect();
    }

    public SqlSupport() {
        MainFrame pframe = new MainFrame();
        pframe.setVisible(true); // Rend la fenêtre visible
    }

}
