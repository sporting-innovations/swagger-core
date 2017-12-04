package io.swagger.v3.jaxrs2.petstore.operations;

import io.swagger.v3.jaxrs2.resources.model.Pet;
import io.swagger.v3.jaxrs2.resources.model.User;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Resource With a Hidden Operation
 * Created by rafaellopez on 11/26/17.
 */
public class HiddenOperationResource {
    @Path("/pets")
    @GET
    @Operation(operationId = "Pets", description = "Pets Example", hidden = true)
    public Pet getPet() {
        return new Pet();
    }

    @Path("/users")
    @GET
    @Operation(operationId = "Users", description = "Users Example")
    @Hidden
    public User getUser() {
        return new User();
    }
}
