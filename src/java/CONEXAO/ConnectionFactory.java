package CONEXAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author KAIQUE
 */
public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/sppda";
    private static final String USER = "root";
    private static final String PASS = "2601";
    
    public static Connection getConnection()
    {
        try 
        {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASS);       
        } 
        catch (ClassNotFoundException | SQLException ex) 
        {
            throw new RuntimeException("Erro ao Conecar", ex);
        }        
    }
    
    public static void closeConnection(Connection conn)
    {
        try 
        {
            if(conn != null)
                conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao Fechar a Conexão", ex);
        }
        
    }
    
    public static void closeConnection(Connection conn, PreparedStatement stmt)
    {
        closeConnection(conn);
        try 
        {
            if(stmt != null)
                stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao Fechar a Conexão", ex);
        }
    }
    
    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs)
    {
        closeConnection(conn, stmt);
        try 
        {
            if(rs != null)
                rs.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao Fechar a Conexão", ex);
        }
    }
}
