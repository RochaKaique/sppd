/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import CONEXAO.ConnectionFactory;
import DTO.EstacaoDTO;
import DTO.GrafoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kaique
 */
public class EstacaoDAL {
    
    public List<EstacaoDTO> listarEstacoes()
    {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<EstacaoDTO> lE = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM ESTACAO");
            rs = stmt.executeQuery();
            while(rs.next())
            {
                EstacaoDTO u = new EstacaoDTO();
                u.setNome(rs.getString("nome"));
                u.setLinha(rs.getInt("linha"));
                u.setCodEstacao(rs.getInt("codEstacao"));
                
                lE.add(u);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EstacaoDAL.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }
        return lE;
    }
    
    public List<GrafoDTO> consultarConexoes()
    {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<GrafoDTO> lN = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM grafodasestacoes");
            rs = stmt.executeQuery();
            while(rs.next())
            {
                GrafoDTO g = new GrafoDTO();
                g.setCodEstacao(rs.getInt("codEstacao"));
                g.setCodEstacaoProx(rs.getInt("codEstacaoProx"));
                g.setDistancia(rs.getDouble("distancia"));
                
                lN.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstacaoDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return lN;
    }
    
}
