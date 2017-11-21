package io.swagger.v3.jaxrs2.resources.petstore;

import io.swagger.v3.oas.annotations.Operation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by rafaellopez on 11/16/17.
 */
public class BasicOperationInfoResource {
    @GET
    @Path("/1")
    @Operation(operationId = "operationId",
            summary = "Operation Summary",
            description = "Operation Description")
    public Response getSummaryAndDescription() {
        return Response.ok().entity("ok").build();
    }

}
