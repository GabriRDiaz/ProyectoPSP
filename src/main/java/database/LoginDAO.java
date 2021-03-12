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
    private final String URL="jdbc:mysql://localhost:3306/psp_games?useSSL=false";
    private final String USER="root";
    private final String PWD="abc123.";
    private final String LOGIN_QUERY="SELECT * FROM usr WHERE mail = ? AND pwd = ? ";
    private Login login;
    public LoginDAO(Login login){
        this.login = login;
    }
    public boolean validate() throws ClassNotFoundException {
		boolean status = false;

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(URL, USER, PWD);

				
                        PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_QUERY)) {
			preparedStatement.setString(1, login.getMail());
			preparedStatement.setString(2, login.getPwd());

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();

		} catch (SQLException e) {System.out.println("SQL Error");}
		return status;
	}

}
