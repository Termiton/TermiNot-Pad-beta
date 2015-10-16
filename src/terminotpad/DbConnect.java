/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminotpad;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author DL
 */
public class DbConnect {

    @SuppressWarnings("CallToPrintStackTrace")
    public static Connection cConnect() throws FileNotFoundException, IOException, ParseException {
        @SuppressWarnings("UnusedAssignment")
        String dbtype = null;          // = "sqlserver";
        String dbserv = null;          // = "BLAISE-PC";
        int dbport = 1;                // = 1433;
        String dbname = null;          // = "sqlsupport.dbo";
        String usrnam = null;          // = "usersupport";
        String psswrd = null;          // = "azerty";
        String connectOK = " ça marche ";
        String connectKO = " la connexion a échoué ";
        String filePath = "src/doc/config.json";

        // read the json file
        FileReader reader = new FileReader(filePath);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

        // get a String from the JSON object
        dbtype = (String) jsonObject.get("dbtype");
        dbserv = (String) jsonObject.get("dbserv");
        dbname = (String) jsonObject.get("dbname");
        usrnam = (String) jsonObject.get("usrnam");
        psswrd = (String) jsonObject.get("psswrd");
        // get a number from the JSON object
        int id = (int) jsonObject.get("dbport");

        try {
            // chargement de la classe du pilote
            switch (dbtype) {
                case "sqlserver":
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    break;
                case "mysql":
                    Class.forName("com.mysql.jdbc.Driver");
                default:
                /**/System.out.println("Pas de base de donnée valide sélectionnée");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String url = "jdbc:" + dbtype + "://" + dbserv + ":" + dbport;// +"/."+dbname;
            System.out.println("/*before driver*/");
            Connection conn = DriverManager.getConnection(url, usrnam, psswrd);
            System.out.println(connectOK);
            return conn;
        } catch (Exception e) {
            System.out.println(connectKO);
            return null;
        }
    }
}
