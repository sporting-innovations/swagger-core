package io.swagger.v3.jaxrs2.petstore.operation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Resource With a Default Operation without Annotation
 */
public class DefaultOperationResource {
    @Path("/users")
    @GET
    public String getUser() {
        return new String();
    }
}
