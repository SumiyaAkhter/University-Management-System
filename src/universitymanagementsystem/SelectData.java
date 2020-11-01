/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlcom;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author LENOVO
 */
public class SelectData {
    String host="jdbc:derby://localhost:1527/UniversityManagementSystem";
String Username="university";
String Password="123a";
public ResultSet getsdata(String query)
{
    ResultSet rs=null;
    try{
        Connection con=DriverManager.getConnection(host,Username,Password);
        Statement stmt=con.createStatement();
        rs=stmt.executeQuery(query);
        
    }catch(Exception e)
    {
       JOptionPane.showMessageDialog(null,"ERROR"+e);
    }
        return rs;
}
public void delete(String query)
{
    try{
       Connection con=DriverManager.getConnection(host,Username,Password);
        Statement stmt=con.createStatement();
        stmt.execute(query);
          JOptionPane.showMessageDialog(null,"Deleted");
    }catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,"ERROR"+e);
    }
}
public void update(String query)
{
    try{
       Connection con=DriverManager.getConnection(host,Username,Password);
        Statement stmt=con.createStatement();
        stmt.execute(query);
          JOptionPane.showMessageDialog(null,"updated");
    }catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,"ERROR"+e);
    }
}
public void insert(String query)
{
    try{
         Connection con=DriverManager.getConnection(host,Username,Password);
        Statement stmt=con.createStatement();
        stmt.execute(query);
          JOptionPane.showMessageDialog(null,"saved");
    }catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,"ERROR"+e);
    }
}
}

