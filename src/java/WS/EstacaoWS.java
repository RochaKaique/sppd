/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import DAL.EstacaoDAL;
import DTO.EstacaoDTO;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Kaique
 */
@Path("estacao")
public class EstacaoWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EstacaoWS
     */
    public EstacaoWS() {
    }

    /**
     * Retrieves representation of an instance of WS.EstacaoWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Listar")
    public String listarEstacoes() {
        EstacaoDAL est = new EstacaoDAL();
        EstacaoDTO e = new EstacaoDTO();
        Gson gson = new Gson();
        List<EstacaoDTO> lE = est.listarEstacoes();
        return gson.toJson(lE);
    }

    /**
     * PUT method for updating or creating an instance of EstacaoWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
