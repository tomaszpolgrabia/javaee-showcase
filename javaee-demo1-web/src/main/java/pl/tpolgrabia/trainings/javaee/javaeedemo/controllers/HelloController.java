package pl.tpolgrabia.trainings.javaee.javaeedemo.controllers;

import pl.tpolgrabia.trainings.javaee.javaeedemo.ejb.SimpleMessageSendingBean;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloController {

    @EJB
    private SimpleMessageSendingBean simpleMessageSendingBean;

    @GET
    @Path("/say/{what}")
    public Response handleSay(
            @PathParam("what") String what) {
        simpleMessageSendingBean.sendHello(what);
        return Response.status(Response.Status.OK)
                .entity("Sent " + what)
                .build();
    }
}
