package io.swagger.v3.jaxrs2.resources.extensions;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * Example Resource with extensions in Parameters
 * Created by rafaellopez on 1/4/18.
 */

public class ParameterExtensionsResource {

    @GET
    @Path("/")
    @Operation(operationId = "Id")
    public void getParameters(@Extension(name = "x-parameter", properties = {
            @ExtensionProperty(name = "parameter", value = "value")})
                              @QueryParam("subscriptionId") String subscriptionId) {
    }

}
