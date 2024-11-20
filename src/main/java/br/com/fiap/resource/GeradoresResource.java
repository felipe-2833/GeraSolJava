package br.com.fiap.resource;

import br.com.fiap.bo.GeradoresBO;
import br.com.fiap.to.GeradoresTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("api/geradores")
public class GeradoresResource {
    private GeradoresBO geradoresBO = new GeradoresBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<GeradoresTO> resultado = geradoresBO.findAll();
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
        GeradoresTO resultado = geradoresBO.findById(id);
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
    public Response save(@Valid GeradoresTO gerador) {
        try{
            GeradoresTO resultado = geradoresBO.save(gerador);
            Response.ResponseBuilder response = null;
            if (resultado != null) {
                response = Response.created(null);
            } else {
                response = Response.status(400);
            }
            response.entity(resultado);
            return response.build();
        } catch (Exception e) {
            System.out.println("Erro ao salvar:" + e.getMessage() );
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao salvar gerador: " + e.getMessage())
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }

    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Response.ResponseBuilder response = null;
        if (geradoresBO.delete(id)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid GeradoresTO gerador, @PathParam("id") Long id) {
        try{
            gerador.setIdGerador(id);
            GeradoresTO resultado = geradoresBO.update(gerador);
            Response.ResponseBuilder response = null;
            if (resultado != null) {
                response = Response.status(201);
            } else {
                response = Response.status(400);
            }
            response.entity(resultado);
            return response.build();
        } catch (Exception e) {
            System.out.println("Erro ao atualizar:" + e.getMessage() );
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao atualizar gerador: " + e.getMessage())
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }

    }
}