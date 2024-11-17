package br.com.fiap.resource;

import br.com.fiap.bo.EnderecosBO;
import br.com.fiap.to.EnderecoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("api/enderecos")
public class EnderecosResource {
    private EnderecosBO enderecosBO = new EnderecosBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<EnderecoTO> resultado = enderecosBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        EnderecoTO resultado = enderecosBO.findById(id);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid EnderecoTO endereco) {
        EnderecoTO resultado = enderecosBO.save(endereco);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Response.ResponseBuilder response = null;
        if (enderecosBO.delete(id)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid EnderecoTO endereco, @PathParam("id") Long id) {
        endereco.setIdEndereco(id);
        EnderecoTO resultado = enderecosBO.update(endereco);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.status(201);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }
}