package br.com.lojaGame.db.utils;

import br.com.lojaGame.constants.MainConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtils {

    public static Connection getConnetion() {

        Connection connection = null;

        try {
            //Endereço de conexão com o banco
            String dbURL = "jdbc:derby://localhost:1527/db_lojaGames";

            //Armazena usuário e senha
            Properties properties = new Properties();
            properties.put("user", "admgames");
            properties.put("password", "games");

            //realiza a conexâo com o banco
            connection = DriverManager.getConnection(dbURL, properties);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
        
        //Retorna a conezão
        return connection;

    }

}
