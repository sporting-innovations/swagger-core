package io.swagger.v3.jaxrs2.resources.petstore.operations;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by rafaellopez on 11/22/17.
 */
public class OperationsResource {
    @Path("/users")
    @GET
    public String getUser() {
        return new String();
    }
}
