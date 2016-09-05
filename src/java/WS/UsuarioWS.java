/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import DAL.UsuarioDAL;
import DTO.UsuarioDTO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author Kaique
 */
@Path("usuario")
public class UsuarioWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuarioWS
     */
    public UsuarioWS() {
    }

    /**
     * Retrieves representation of an instance of WS.UsuarioWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Listar")
    public String listarUsuarios() {
        UsuarioDAL usu = new UsuarioDAL();
        Gson gson = new Gson();
        List<UsuarioDTO> usuarios = usu.listarUsuarios();
        return gson.toJson(usuarios);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Inserir/{nome}/{senha}/{tipo}")
    public String inserirUsuario(@PathParam("nome") String nome, @PathParam("senha") String senha, @PathParam("tipo") int tipo){
        UsuarioDAL usu = new UsuarioDAL();
        UsuarioDTO u = new UsuarioDTO();
        u.setNome(nome);
        u.setSenha(senha);
        u.setTipo(tipo);
        Gson gson = new Gson();
        return gson.toJson(usu.inserir(u));
    }

    /**
     * PUT method for updating or creating an instance of UsuarioWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
