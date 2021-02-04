/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.empdb;

/**
 *
 * @author stanc
 */


import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class DbAccess {

    Connection conn;
    PreparedStatement pst;
    
    public DbAccess() throws ClassNotFoundException, SQLException{
        
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/empdb;create=false","app","app");
    }
    public User login(String username, String password) throws SQLException{
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM users WHERE username='"+username+"' and password='"+password+"'");
            
        if (rs.next()) {
            return new User(rs.getString("username"), rs.getString("password"));
        }          
        return null;
    }
    public ResultSet updateTable() throws SQLException{
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM EMPLOYEEINFO");  
        return rs;
    }
    public void insert(Employee e) throws SQLException {
        
        
        String sql = "INSERT INTO EMPLOYEEINFO (name,gender,age,bloodgroup,contactno,qualification, datejoined, address, image) values (?,?,?,?,?,?,?,?,?)";
        pst=conn.prepareStatement(sql);

        pst.setString(1, e.getName());
        pst.setString(2, e.getGender());
        pst.setString(3, e.getAge());
        pst.setString(4, e.getBloodGroup());
        pst.setString(5, e.getContactNo());
        pst.setString(6, e.getQualification());

        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        String strDateOutput = sdf.format(e.getDateJoined());

        pst.setString(7, strDateOutput);
        pst.setString(8, e.getAddress());
        pst.setBytes(9,e.getImage());

        pst.execute();
        pst.close();
        
    }
    public ResultSet tableClicked(int rowID) throws SQLException{
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM EMPLOYEEINFO WHERE ID="+rowID+"");  
        return rs;
    }
    
    public void update(String name, String gender, String age, String bg, String contact, String qualification, java.util.Date date, String address, byte[] image, String id)
        throws SQLException {

    String sql = "update employeeinfo set Name=?,Gender=?,Age=?,BloodGroup=?,ContactNo=?,Qualification=?,DATEJOINED=?,Address=?,Image=? where ID=?"; 
    pst=conn.prepareStatement(sql);

    pst.setString(1, name);
    pst.setString(2, gender);
    pst.setString(3, age);
    pst.setString(4, bg);
    pst.setString(5, contact);
    pst.setString(6, qualification);

    SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
    String strDateOutput = sdf.format(date);

    pst.setString(7, strDateOutput);
    pst.setString(8, address);
    pst.setBytes(9,image);
    pst.setString(10, id);

    pst.execute();
    pst.close();

}
    public void delete(String id) throws SQLException {
        String sql = "DELETE FROM EMPLOYEEINFO WHERE ID=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, id);
        pst.execute();
        pst.close();
    }
    
    public Employee findById(String id) throws SQLException{
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM EmployeeInfo WHERE ID="+id+"");
        if(rs.next()){
            return new Employee(rs.getString("name"),rs.getString("gender"),rs.getString("age"),rs.getString("bloodgroup"),rs.getString("contactno"),
                                rs.getString("qualification"),rs.getDate("datejoined"),rs.getString("address"),rs.getBytes("image"));
        }else{
            return null;
        }           
    }
}

