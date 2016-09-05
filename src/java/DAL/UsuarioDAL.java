/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.util.List;
import CONEXAO.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kaique
 */
public class UsuarioDAL {
    
    public List<UsuarioDTO> listarUsuarios(){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<UsuarioDTO> lU = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM USUARIO");
            rs = stmt.executeQuery();
            while(rs.next())
            {
                UsuarioDTO u = new UsuarioDTO();
                u.setId(rs.getInt("codUsuario"));
                u.setSenha(rs.getString("senha"));
                u.setTipo(rs.getInt("tipoUsuario"));
                u.setNome(rs.getString("nomeUsuario"));
                
                lU.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally{
            ConnectionFactory.closeConnection(conn, stmt);
        }
        return lU;
    }
    
    public boolean inserir(UsuarioDTO u){
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("INSERT INTO usuario(nomeUsuario, tipoUsuario, senha) VALUES(?,?,?)");
            stmt.setString(1, u.getNome());
            stmt.setInt(2, u.getTipo());
            stmt.setString(3, u.getSenha());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAL.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
        
        return true;
    }
    
}
