/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loc.dbultis;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class MyConnection {
    public static Connection makeConnection(){
        Connection cn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url="jdbc:sqlserver://loctan-db.database.windows.net:1433;database=FoodManagement;"
//                    + "user=locvtse141035@loctan-db;password=Loctan81;"
//                    + "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
//            cn = DriverManager.getConnection(url);
            String url="jdbc:sqlserver://localhost:1433;databaseName= FoodManagement";
            cn = DriverManager.getConnection(url, "sa", "12345");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "lỗi kết nối sever");
        }
        return cn;
    }
}
