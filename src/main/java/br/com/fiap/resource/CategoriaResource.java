package br.com.fiap.resource;

import br.com.fiap.bo.CategoriaBO;
import br.com.fiap.to.CategoriaTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("api/categoria")
public class CategoriaResource {
    private CategoriaBO categoriaBO = new CategoriaBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<CategoriaTO> resultado = categoriaBO.findAll();
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
        CategoriaTO resultado = categoriaBO.findById(id);
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
    public Response save(@Valid CategoriaTO categoria) {
        CategoriaTO resultado = categoriaBO.save(categoria);
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
        if (categoriaBO.delete(id)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid CategoriaTO categoria, @PathParam("id") Long id) {
        categoria.setIdCategoria(id);
        CategoriaTO resultado = categoriaBO.update(categoria);
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