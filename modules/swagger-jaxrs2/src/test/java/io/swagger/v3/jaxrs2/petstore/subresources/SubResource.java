package io.swagger.v3.jaxrs2.petstore.subresources;

import io.swagger.v3.jaxrs2.resources.model.Pet;
import io.swagger.v3.oas.annotations.Operation;

import javax.ws.rs.core.Response;

/**
 * SubResource
 * Created by rafaellopez on 12/31/17.
 */

public class SubResource implements InterfaceResource {
    @Override
    @Operation(summary = "Find pet by ID Operation in SubResource",
            description = "Returns a pet in SubResource"
    )
    public Response getPetById(Long petId) {
        return Response.ok().entity(new Pet()).build();
    }
}
