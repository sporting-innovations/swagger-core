package io.swagger.v3.jaxrs2.petstore.operations;

import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;

/**
 * Resource With a Default Operation without Annotation
 * Created by rafaellopez on 11/26/17.
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
