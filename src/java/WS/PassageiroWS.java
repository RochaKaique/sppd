/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import DAL.PassageiroDAL;
import DTO.PassageiroDTO;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Kaique
 */
@Path("passageiro")
public class PassageiroWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PassageiroWS
     */
    public PassageiroWS() {
    }

    /**
     * Retrieves representation of an instance of WS.PassageiroWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Inserir/{nome}/{cpf}/{rg}/{logradouro}/{numero}/{complemento}/{cep}/{bairro}/{cidade}/{nascimento}/{categoria}/{ativo}/{saldo}/{ultimoMovimento}")
    public String inserirPassageiro(@PathParam("nome") String nome, @PathParam("cpf") String cpf, @PathParam("rg") String rg, @PathParam("logradoruo") String logradouro, @PathParam("numero") String numero, @PathParam("complemrnto") String Complemento, @PathParam("cep") String cep, @PathParam("bairro") String bairro, @PathParam("cidade") int cidade, @PathParam("nascimento") String nascimento, @PathParam("categoria") int categoria, @PathParam("ativo") boolean ativo, @PathParam("saldo") double saldo, @PathParam("ultimoMovimento") int ultimoMovimento) {

        PassageiroDAL pass = new PassageiroDAL();
        PassageiroDTO p = new PassageiroDTO();
        Gson gson = new Gson();
        
        return gson.toJson(pass.inserir(p));
    }

    /**
     * PUT method for updating or creating an instance of PassageiroWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
