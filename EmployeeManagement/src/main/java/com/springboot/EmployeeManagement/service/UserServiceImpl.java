package com.springboot.EmployeeManagement.service;

import com.springboot.EmployeeManagement.DButil.DButil;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService{
    Connection connection;
    int flag=0;
    public UserServiceImpl() throws SQLException{
        connection= DButil.getConnection();
    }
    @Override
    public int loginValidation(String username, String password) {
        try {
            PreparedStatement statement=connection.prepareStatement("select * from users where username='"+username+"'");
            ResultSet rs=statement.executeQuery();
            while (rs.next()){
            if(rs.getString(5).equals(username)&& rs.getString(3).equals(password)){
                flag=1;
            }else{
                System.out.println("Invalid userName/password");
                return flag=0;
            }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
