/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminotpad;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author DL
 */
public class DbRequest {

    DbConnect c = new DbConnect();
    Connection cn;

    public DbRequest() throws ParseException, IOException {
        this.cn = DbConnect.cConnect();
    }

    public void execRequest(String request) {
        Statement begin = null;
        Statement stmI = null;
        try {
            stmI = cn.createStatement();
        } catch (SQLException ex) {
            System.out.println(request);
            Logger.getLogger(DbRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            begin.executeQuery("BEGIN TRANSACTION T");
            int ret = stmI.executeUpdate(request);
        } catch (SQLException ex) {
            System.out.println(request);
            Logger.getLogger(DbRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet selectRequest(String request) {
        ResultSet rs = null;
        Statement stmA = null;
        try {
            stmA = cn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DbRequest.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(request);
        }
        try {
            rs = stmA.executeQuery(request);
        } catch (SQLException ex) {
            Logger.getLogger(DbRequest.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(request);
        }
        return rs;
    }

    public ResultSet selectTables() {
        ResultSet rs = null;
        Statement stmA = null;
        try {
            stmA = cn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DbRequest.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("select table_name,table_type \n"
                    + "from information_schema.tables order by table_type");
        }
        try {
            rs = stmA.executeQuery("select table_name,table_type \n"
                    + "from information_schema.tables order by table_type");
        } catch (SQLException ex) {
            Logger.getLogger(DbRequest.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("select table_name,table_type \n"
                    + "from information_schema.tables order by table_type");
        }
        return rs;
    }
    
    public void commit() {
        Statement commit = null;
        try {
            commit = cn.createStatement();
            commit.executeQuery("COMMIT TRANSACTION T");
        } catch (SQLException ex) {
            System.out.println("commit");
            Logger.getLogger(DbRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void rollback() {
        Statement rollback = null;
        try {
            rollback = cn.createStatement();
            rollback.executeQuery("ROLLBACK TRANSACTION T");
        } catch (SQLException ex) {
            System.out.println("rollback");
            Logger.getLogger(DbRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
