package pl.tpolgrabia.trainings.javaee.javaeedemo.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/math")
public class MathController {
    @GET
    @Path("/add/{x}/{y}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response handleAdd(
            @PathParam("x") int x,
            @PathParam("y") int y) {
        MathResponse response = new MathResponse();
        response.setX(x);
        response.setY(y);
        response.setZ(x + y);
        return Response.status(Response.Status.OK)
                .entity(response)
                .build();
    }
}
