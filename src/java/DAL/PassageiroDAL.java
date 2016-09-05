/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import CONEXAO.ConnectionFactory;
import DTO.PassageiroDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kaique
 */
public class PassageiroDAL {
    
    public boolean inserir(PassageiroDTO p)
    {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("INSERT INTO USUARIO (nome, cpf, rg, logradouro, numero, complemento, cep, bairro, "
                    + "cidade, nascimento, categoria, ativo, saldo, ultimoMovimento) VAUES (?,?,?,?,?,?,?,?,?,STR_TO_DATE(?,'%d/%m/%Y'),?,?,?,?,?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCpf());
            stmt.setString(3, p.getRg());
            stmt.setString(4, p.getLogradouro());
            stmt.setString(5, p.getNumero());
            stmt.setString(6, p.getComplemento());
            stmt.setString(7, p.getCep());
            stmt.setString(8, p.getBairro());
            stmt.setInt(9, p.getCidade());
            stmt.setString(10, p.getNascimento());
            stmt.setInt(11, p.getCategoria());
            stmt.setBoolean(12, p.isAtivo());
            stmt.setDouble(13, p.getSaldo());
            stmt.setInt(14, 0);
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(PassageiroDAL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
                
    }
    
}
