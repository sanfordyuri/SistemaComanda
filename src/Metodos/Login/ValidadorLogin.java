/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos.Login;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Yuri Sanford
 */
public class ValidadorLogin {
    
	public static boolean validarLogin(String user, String pass) throws ClassNotFoundException, SQLException {
		Connection con;
		boolean retorno = false;
		try {
                    con = Conexao.getConnection();
                    String sql = "SELECT * FROM `Login` WHERE `user` = ?";
                    PreparedStatement stm = con.prepareStatement(sql);
                    stm.setString(1, user);
                    ResultSet rs = stm.executeQuery();
                    while(rs.next()) {
                            if((user.equals(rs.getString("user"))) && pass.equals(rs.getString("pass"))) {
                                    retorno = true;
                            } else {
                                    retorno = false;
                            }
                    }
		} catch (ClassNotFoundException | SQLException  e) {
			retorno = false;
		} 

		return retorno;
	}
}
