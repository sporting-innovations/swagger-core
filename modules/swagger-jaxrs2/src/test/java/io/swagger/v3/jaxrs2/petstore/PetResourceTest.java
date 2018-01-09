package io.swagger.v3.jaxrs2.petstore;

import io.swagger.v3.jaxrs2.annotations.AbstractAnnotationTest;
import io.swagger.v3.jaxrs2.petstore.callback.MultipleCallbacksTestWithOperationResource;
import io.swagger.v3.jaxrs2.petstore.callback.RepeatableCallbackResource;
import io.swagger.v3.jaxrs2.petstore.openapidefintion.OpenAPIDefinitionResource;
import io.swagger.v3.jaxrs2.petstore.example.ExamplesResource;
import io.swagger.v3.jaxrs2.petstore.link.LinksResource;
import io.swagger.v3.jaxrs2.petstore.operation.DefaultOperationResource;
import io.swagger.v3.jaxrs2.petstore.operation.ExternalDocumentationResource;
import io.swagger.v3.jaxrs2.petstore.operation.HiddenOperationResource;
import io.swagger.v3.jaxrs2.petstore.operation.NotAnnotatedSameNameOperationResource;
import io.swagger.v3.jaxrs2.petstore.operation.OperationsResource;
import io.swagger.v3.jaxrs2.petstore.operation.ServerOperationResource;
import io.swagger.v3.jaxrs2.petstore.parameter.ArraySchemaResource;
import io.swagger.v3.jaxrs2.petstore.parameter.ParametersResource;
import io.swagger.v3.jaxrs2.petstore.parameter.RepeatableParametersResource;
import io.swagger.v3.jaxrs2.petstore.requestbody.RequestBodyMethodPriorityResource;
import io.swagger.v3.jaxrs2.petstore.requestbody.RequestBodyParameterPriorityResource;
import io.swagger.v3.jaxrs2.petstore.requestbody.RequestBodyResource;
import io.swagger.v3.jaxrs2.petstore.responses.ImplementationResponseResource;
import io.swagger.v3.jaxrs2.petstore.responses.MethodResponseResource;
import io.swagger.v3.jaxrs2.petstore.responses.NoImplementationResponseResource;
import io.swagger.v3.jaxrs2.petstore.responses.NoResponseResource;
import io.swagger.v3.jaxrs2.petstore.responses.OperationResponseResource;
import io.swagger.v3.jaxrs2.petstore.responses.PriorityResponseResource;
import io.swagger.v3.jaxrs2.petstore.security.SecurityResource;
import io.swagger.v3.jaxrs2.petstore.subresources.SubResource;
import io.swagger.v3.jaxrs2.petstore.tags.CompleteTagResource;
import io.swagger.v3.jaxrs2.petstore.tags.TagClassResource;
import io.swagger.v3.jaxrs2.petstore.tags.TagMethodResource;
import io.swagger.v3.jaxrs2.petstore.tags.TagOpenAPIDefinitionResource;
import io.swagger.v3.jaxrs2.petstore.tags.TagOperationResource;
import io.swagger.v3.jaxrs2.resources.SimpleCallbackResource;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.fail;

/**
 * Pet Resource Test Class
 * Adding a lot of tests of different pet resource examples
 */
public class PetResourceTest extends AbstractAnnotationTest {
    private static final String PETSTORE_SOURCE = "petstore/";
    private static final String TAGS_SOURCE = "petstore/tags/";
    private static final String OPERATIONS_SOURCE = "petstore/operation/";
    private static final String CALLBACKS_SOURCE = "petstore/callbacks/";
    private static final String RESPONSES_SOURCE = "petstore/responses/";
    private static final String PARAMETERS_SOURCE = "petstore/parameters/";
    private static final String LINKS_SOURCE = "petstore/links/";
    private static final String EXAMPLES_SOURCE = "petstore/example/";
    private static final String REQUEST_BODIES_SOURCE = "petstore/requestbody/";
    private static final String SUBRESOURCES_SOURCE = "petstore/subresources/";
    private static final String YAML_EXTENSION = ".yaml";

    @Test(description = "Test an empty resource class (Without operations or annotations)")
    public void testEmptyPetResource() {
        compare(EmptyPetResource.class, PETSTORE_SOURCE);
    }

    @Test(description = "Test a resource with examples)")
    public void testExamplesResource() {
        compare(ExamplesResource.class, EXAMPLES_SOURCE);
    }

    @Test(description = "Test a resource with Links)")
    public void testLinksResource() {
        compare(LinksResource.class, LINKS_SOURCE);
    }

    @Test(description = "Test some resources with Callbacks)")
    public void testCallBacksResources() {
        compare(SimpleCallbackResource.class, CALLBACKS_SOURCE);
        compare(MultipleCallbacksTestWithOperationResource.class, CALLBACKS_SOURCE);
        compare(RepeatableCallbackResource.class, CALLBACKS_SOURCE);
    }

    @Test(description = "Test some resources with different Operations scenarios)")
    public void testOperationsResources() {
        compare(HiddenOperationResource.class, OPERATIONS_SOURCE);
        compare(DefaultOperationResource.class, OPERATIONS_SOURCE);
        compare(OperationsResource.class, OPERATIONS_SOURCE);
        compare(NotAnnotatedSameNameOperationResource.class, OPERATIONS_SOURCE);
        compare(ExternalDocumentationResource.class, OPERATIONS_SOURCE);
        compare(ServerOperationResource.class, OPERATIONS_SOURCE);
    }

    @Test(description = "Test OpenAPIDefinition resource)")
    public void testOpenAPIDefinitionResource() {
        compare(OpenAPIDefinitionResource.class, PETSTORE_SOURCE);
    }

    @Test(description = "Sub resources tests)")
    public void testSubResource() {
        compare(SubResource.class, SUBRESOURCES_SOURCE);
    }

    @Test(description = "Test RequestBody resource)")
    public void tetRequestBodyResource() {
        compare(RequestBodyResource.class, REQUEST_BODIES_SOURCE);
        compare(RequestBodyParameterPriorityResource.class, REQUEST_BODIES_SOURCE);
        compare(RequestBodyMethodPriorityResource.class, REQUEST_BODIES_SOURCE);
    }

    @Test(description = "Test Parameters resources)")
    public void testParametersResource() {
        compare(ParametersResource.class, PARAMETERS_SOURCE);
        compare(RepeatableParametersResource.class, PARAMETERS_SOURCE);
        compare(ArraySchemaResource.class, PARAMETERS_SOURCE);
    }

    @Test(description = "Test ApiResponses resource)")
    public void testResponsesResource() {
        compare(MethodResponseResource.class, RESPONSES_SOURCE);
        compare(OperationResponseResource.class, RESPONSES_SOURCE);
        compare(NoResponseResource.class, RESPONSES_SOURCE);
        compare(ImplementationResponseResource.class, RESPONSES_SOURCE);
        compare(NoImplementationResponseResource.class, RESPONSES_SOURCE);
        compare(PriorityResponseResource.class, RESPONSES_SOURCE);
    }

    @Test(description = "Test Security resource)")
    public void testSecurityResource() {
        compare(SecurityResource.class, PETSTORE_SOURCE);
    }

    @Test(description = "Test Tags resource)")
    public void testTagsResource() {
        compare(CompleteTagResource.class, TAGS_SOURCE);
        compare(TagOpenAPIDefinitionResource.class, TAGS_SOURCE);
        compare(TagClassResource.class, TAGS_SOURCE);
        compare(TagMethodResource.class, TAGS_SOURCE);
        compare(TagOperationResource.class, TAGS_SOURCE);
    }

    private void compare(final Class clazz, final String source) {
        final String file = source + clazz.getSimpleName() + YAML_EXTENSION;

        try {
            compareAsYaml(clazz, getOpenAPIasString(file));
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }
}