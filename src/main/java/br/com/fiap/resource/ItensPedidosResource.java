package br.com.fiap.resource;

import br.com.fiap.bo.ItensPedidosBO;
import br.com.fiap.to.ItensPedidoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("api/itens-pedido")
public class ItensPedidosResource {
    private ItensPedidosBO itensPedidosBO = new ItensPedidosBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ItensPedidoTO> resultado = itensPedidosBO.findAll();
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
        ItensPedidoTO resultado = itensPedidosBO.findById(id);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Response.ResponseBuilder response = null;
        if (itensPedidosBO.delete(id)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ItensPedidoTO item, @PathParam("id") Long id) {
        item.setIdItem(id);
        ItensPedidoTO resultado = itensPedidosBO.update(item);
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
