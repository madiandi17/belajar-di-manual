
package com.wordpress.bmadi.belajar.di.manual.dao;

import com.wordpress.bmadi.belajar.di.manual.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.commons.dbcp2.BasicDataSource;

public class UserDao {
    private BasicDataSource dataSource;
    
    public void setDataSource(BasicDataSource bds){
        this.dataSource = bds;
    }
    
    public void create(User user)throws Exception{
        String sql = "insert into user(firstName, lastName, email) values(?, ?, ?)";
        
        Connection dbConnection = dataSource.getConnection();
        PreparedStatement ps = dbConnection.prepareStatement(sql);
        ps.setString(1, user.getFirstName());
        ps.setString(2, user.getLastName());
        ps.setString(3, user.getEmail());
        ps.executeUpdate();
        
        dbConnection.close();
    }
    
    public void read(User user) throws Exception{
        String sql = "select * from user";
        
        Connection dbConnection = dataSource.getConnection();
        PreparedStatement ps = dbConnection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println("id : " + rs.getInt("id"));
            System.out.println("first Name : " + rs.getString("firstName"));
            System.out.println("last Name : " + rs.getString("lastName"));
            System.out.println("email : " + rs.getString("email"));
        }
        dbConnection.close();
    }
    
    public User cariById(Integer id)throws Exception{
        String sql = "select * from user where id=?";
        
        Connection dbConnection = dataSource.getConnection();
        PreparedStatement ps = dbConnection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println("id : " + rs.getInt("id"));
            System.out.println("firstName : " + rs.getString("firstName"));
            System.out.println("lastName : " + rs.getString("lastName"));
            System.out.println("email : " + rs.getString("email"));
        }
        
        dbConnection.close();
        return null;
    }
    
    public User cariByEmail(String email) throws Exception{
        String sql = "select * from user where email=?";
        
        Connection dbConnection = dataSource.getConnection();
        PreparedStatement ps = dbConnection.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println("id : " + rs.getInt("id"));
            System.out.println("firstName : " + rs.getString("firstName"));
            System.out.println("lastName : " + rs.getString("lastName"));
            System.out.println("email : " + rs.getString("email"));
        }
        
        dbConnection.close();
        return null;
    }
    
    public void update(User user) throws Exception{
        String sql = "update user set firstName=?, lastName=?, email=? where id=?";
        
        Connection dbConnection = dataSource.getConnection();
        PreparedStatement ps = dbConnection.prepareStatement(sql);
        ps.setString(1, user.getFirstName());
        ps.setString(2, user.getLastName());
        ps.setString(3, user.getEmail());
        ps.setInt(4, user.getId());
        ps.executeUpdate();
        
        dbConnection.close();
    }
   
    public void delete(User user) throws Exception{
        String sql = "delete from user where id=?";
        
        Connection dbConnection = dataSource.getConnection();
        PreparedStatement ps = dbConnection.prepareStatement(sql);
        ps.setInt(1, user.getId());
        ps.executeUpdate();
            
        dbConnection.close();
    }   
}
