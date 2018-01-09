package io.swagger.v3.jaxrs2.petstore.operation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Resource With a Default Operation without Annotation
 */
public class NotAnnotatedSameNameOperationResource {
    @Path("/users")
    @GET
    public String getUser() {
        return new String();
    }

    @Path("/users/{id}")
    @GET
    public String getUser(final String id) {
        return new String();
    }
}
