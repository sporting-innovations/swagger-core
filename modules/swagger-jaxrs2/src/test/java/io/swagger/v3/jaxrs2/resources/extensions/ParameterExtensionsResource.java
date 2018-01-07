package io.swagger.v3.jaxrs2.resources.extensions;

import io.swagger.v3.jaxrs2.resources.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.extensions.Extensions;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Example Resource with extensions in Operations
 * Created by rafaellopez on 1/4/18.
 */

public class ParameterExtensionsResource {

    @GET
    @Path("/")
    @Operation(operationId = "Id"
    )
    public void getParameters(
            @Extension(name = "x-parameter", properties = {
                    @ExtensionProperty(name = "parameter", value = "value")})
            @Extensions(value = {
                    @Extension(name = "x-extension", properties = {
                            @ExtensionProperty(name = "name", value = "param")}),
                    @Extension(name = "x-extension2", properties = {
                            @ExtensionProperty(name = "another", value = "val")})})
            @Parameter(description = "Parameter with no IN", required = true)
            @RequestBody(description = "Request Body in Param") User user) {
    }

}
