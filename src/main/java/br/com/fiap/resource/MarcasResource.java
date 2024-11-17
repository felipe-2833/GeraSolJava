package br.com.fiap.resource;

import br.com.fiap.bo.MarcasBO;
import br.com.fiap.to.MarcasTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("api/marcas")
public class MarcasResource {
    private MarcasBO marcasBO = new MarcasBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<MarcasTO> resultado = marcasBO.findAll();
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
        MarcasTO resultado = marcasBO.findById(id);
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
    public Response save(@Valid MarcasTO marca) {
        MarcasTO resultado = marcasBO.save(marca);
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
        if (marcasBO.delete(id)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid MarcasTO marca, @PathParam("id") Long id) {
        marca.setIdMarca(id);
        MarcasTO resultado = marcasBO.update(marca);
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