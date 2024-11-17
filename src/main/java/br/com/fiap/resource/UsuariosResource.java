package br.com.fiap.resource;
import br.com.fiap.bo.UsuariosBO;
import br.com.fiap.to.UsuariosTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("api/usuarios")
public class UsuariosResource {
    private UsuariosBO usuariosBO = new UsuariosBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<UsuariosTO> usuarios = usuariosBO.findAll();
        return Response.ok(usuarios).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        UsuariosTO usuario = usuariosBO.findById(id);
        if (usuario != null) {
            return Response.ok(usuario).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(UsuariosTO usuario) {
        UsuariosTO savedUsuario = usuariosBO.save(usuario);
        if (savedUsuario != null) {
            return Response.status(Response.Status.CREATED).entity(savedUsuario).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        if (usuariosBO.delete(id)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(UsuariosTO usuario, @PathParam("id") Long id) {
        usuario.setIdUsuario(id);
        UsuariosTO updatedUsuario = usuariosBO.update(usuario);
        if (updatedUsuario != null) {
            return Response.ok(updatedUsuario).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
