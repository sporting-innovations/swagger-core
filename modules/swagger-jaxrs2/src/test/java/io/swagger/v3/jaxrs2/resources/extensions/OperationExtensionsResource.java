package io.swagger.v3.jaxrs2.resources.extensions;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Example Resource with extensions in Operations
 * Created by rafaellopez on 1/4/18.
 */

public class OperationExtensionsResource {

    @GET
    @Path("/")
    @Operation(operationId = "operationId",
            summary = "Operation Summary",
            description = "Operation Description",
            extensions = {
                    @Extension(name = "x-operation", properties = {
                            @ExtensionProperty(name = "name", value = "Josh")})})
    public Response getSummaryAndDescription() {
        return Response.ok().entity("ok").build();
    }
}
