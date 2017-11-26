package io.swagger.v3.jaxrs2.resources.petstore.operations;

import io.swagger.v3.jaxrs2.resources.model.Pet;
import io.swagger.v3.oas.annotations.Operation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Resource With a Default Operation without Annotation
 * Created by rafaellopez on 11/26/17.
 */
public class DefaultOperationResource {
    @Path("/users")
    @GET
    public String getUser() {
        return new String();
    }
}
