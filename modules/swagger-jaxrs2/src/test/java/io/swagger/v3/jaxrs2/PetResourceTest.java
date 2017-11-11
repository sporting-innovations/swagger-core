package io.swagger.v3.jaxrs2;

import io.swagger.v3.jaxrs2.annotations.AbstractAnnotationTest;
import io.swagger.v3.jaxrs2.resources.petstore.EmptyPetResource;
import io.swagger.v3.oas.models.OpenAPI;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Pet Resource Test Class
 * Adding a lot of tests of different pet resource examples
 * Created by rafaellopez on 11/9/17.
 */
public class PetResourceTest extends AbstractAnnotationTest {

    private static final String EMPTY_PET_RESOURCE = "petstore/emptyPetResource.yaml";

    @Test(description = "Test an empty resource class (Without operations or annotations)")
    public void testEmptyPetResource() {
        Reader reader = new Reader(new OpenAPI());
        OpenAPI openAPI = reader.read(EmptyPetResource.class);
        assertNotNull(openAPI);
        assertEquals(readIntoYaml(openAPI.getClass()), getOpenAPIasYAML(EMPTY_PET_RESOURCE));
    }
}
