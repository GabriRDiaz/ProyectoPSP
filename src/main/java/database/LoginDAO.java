/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Login;

/**
 *
 * @author Gabriel
 */
public class LoginDAO {
   
    private final String LOGIN_QUERY="SELECT * FROM usr WHERE mail = ? AND pwd = ? ";
    private final String REGISTER_QUERY="INSERT INTO usr(mail,pwd) VALUES(?,?)";
    private final String CHECK_IF_EXISTS="SELECT mail FROM usr WHERE mail = ?";
    private Login login;
    public LoginDAO(Login login){
        this.login = login;
    }
    public boolean validate() throws ClassNotFoundException {
		boolean status = false;

		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(ConnectionGet.URL, ConnectionGet.USER, ConnectionGet.PWD);
                        PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_QUERY)) {
			preparedStatement.setString(1, login.getMail());
			preparedStatement.setString(2, login.getPwd());
                           System.out.println(login.getMail());
                           System.out.println(login.getPwd());
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
                        System.out.println(status);

		} catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("SQL Error");}
		return status;
	}
    
    public boolean checkIfExists() throws ClassNotFoundException {
		boolean status = false;

		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(ConnectionGet.URL, ConnectionGet.USER, ConnectionGet.PWD);
                        PreparedStatement preparedStatement = connection.prepareStatement(CHECK_IF_EXISTS)) {
			preparedStatement.setString(1, login.getMail());
                           System.out.println(login.getMail());
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
                        System.out.println(status);

		} catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("SQL Error");}
		return status;
	}
    public boolean register() throws ClassNotFoundException{
        boolean status = false;
        if(validateForm()){
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(ConnectionGet.URL, ConnectionGet.USER, ConnectionGet.PWD);
                        PreparedStatement preparedStatement = connection.prepareStatement(REGISTER_QUERY)) {
			preparedStatement.setString(1, login.getMail());
			preparedStatement.setString(2, login.getPwd());
                           System.out.println(login.getMail());
                           System.out.println(login.getPwd());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
                        System.out.println(login.getMail()+" registered succesfully!");
		} catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("SQL Error");}
            return true;
        }else{
            return false;
        }
    }

    private boolean validateForm() throws ClassNotFoundException {
        if(login.getMail().contains("@") && !login.getPwd().equals("") || login.getPwd()!=null){
            if(checkIfExists()){
                System.out.println("That mail is already in use!");
                return false;}
            return true;
        }else{return false;}
    }
}
