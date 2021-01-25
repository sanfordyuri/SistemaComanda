/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Yuri Sanford
 */
public class Conexao {
    
    	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/comanda","root","");
	}

	public static void createTable() throws ClassNotFoundException, SQLException {
		if(getConnection() != null) {
			PreparedStatement stm = null;
			stm = (PreparedStatement) getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `Login`(`user` VARCHAR(24), `pass` VARCHAR(24))");
			stm.executeUpdate();
		}
	}
        
        public static void createTableProdutos() throws ClassNotFoundException, SQLException {
            if(getConnection() != null) {
                    PreparedStatement stm = null;
                    stm = (PreparedStatement) getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `produtos`(`nome_produto` VARCHAR(64), `preco_produto` DOUBLE, `codigo_produto` VARCHAR(24), `quantidade_inicial` INT)");
                    stm.executeUpdate();
            }
	}
        
        public static void createTableRelatorio() throws ClassNotFoundException, SQLException {
            if(getConnection() != null) {
                    PreparedStatement stm = null;
                    stm = (PreparedStatement) getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `relatorios`(`data_venda` VARCHAR(64), `valor_conta` DOUBLE)");
                    stm.executeUpdate();
            }
	}
        
}
