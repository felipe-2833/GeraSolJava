package br.com.fiap.resource;

import br.com.fiap.bo.PedidosBO;
import br.com.fiap.to.PedidosTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("api/pedidos")
public class PedidosResource {
    private PedidosBO pedidosBO = new PedidosBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<PedidosTO> resultado = pedidosBO.findAll();
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
        PedidosTO resultado = pedidosBO.findById(id);
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
    public Response save(@Valid PedidosTO pedido) {
        try{
            PedidosTO resultado = pedidosBO.save(pedido);
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
        if (pedidosBO.delete(id)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid PedidosTO pedido, @PathParam("id") Long id) {
        try{
            pedido.setIdPedido(id);
            PedidosTO resultado = pedidosBO.update(pedido);
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
                    .entity("Erro ao atualizar pedido: " + e.getMessage())
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }

    }
}
