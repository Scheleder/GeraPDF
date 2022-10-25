/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerapdf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jscheleder
 */
public class ConnectionFactory {
    
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";//com.mysql.jdbc.Driver
    public static String URL="jdbc:mysql://localhost:3306/auditoria?useTimezone=true&serverTimezone=Brazil/East";
    public static String USER="audit";
    public static String PASS="audit2020";
   
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na Conexão: " + ex);
            JOptionPane.showMessageDialog(null, "Verifique a conexão de rede!");
            System.exit(0);
            throw new RuntimeException("Erro na Conexão com o Banco de Dados!", ex);
        }
    }

    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
                JOptionPane.showMessageDialog(null, "Falha na Conexão: " + ex);
                JOptionPane.showMessageDialog(null, "Verifique a conexão de rede!");
                System.exit(0);
            }
        }
    }
    
     public static void closeConnection(Connection con, PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
                JOptionPane.showMessageDialog(null, "Falha na Conexão: " + ex);
                JOptionPane.showMessageDialog(null, "Verifique a conexão de rede!");
                System.exit(0);
            }
        }
        closeConnection(con);
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
                JOptionPane.showMessageDialog(null, "Falha na Conexão: " + ex);
                JOptionPane.showMessageDialog(null, "Verifique a conexão de rede!");
                System.exit(0);
            }
        }
        closeConnection(con, stmt);
    }

}
