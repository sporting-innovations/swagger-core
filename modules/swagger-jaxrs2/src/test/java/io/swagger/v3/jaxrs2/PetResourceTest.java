package io.swagger.v3.jaxrs2;

import io.swagger.v3.jaxrs2.annotations.AbstractAnnotationTest;
import io.swagger.v3.jaxrs2.resources.petstore.EmptyPetResource;
import io.swagger.v3.jaxrs2.resources.petstore.example.ExamplesResource;
import io.swagger.v3.jaxrs2.resources.petstore.link.LinksResource;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Pet Resource Test Class
 * Adding a lot of tests of different pet resource examples
 * Created by rafaellopez on 11/9/17.
 */
public class PetResourceTest extends AbstractAnnotationTest {
    private static final String EMPTY_PET_RESOURCE = "petstore/emptyPetResource.yaml";
    private static final String EXAMPLES_RESOURCE = "petstore/examplesResource.yaml";
    private static final String LINKS_RESOURCE = "petstore/linksResource.yaml";

    @Test(description = "Test an empty resource class (Without operations or annotations)")
    public void testEmptyPetResource() {
        assertEquals(readIntoYaml(EmptyPetResource.class), getOpenAPIasString(EMPTY_PET_RESOURCE));
    }

    @Test(description = "Test a resource with examples)")
    public void testExamplesResource() {
        assertEquals(readIntoYaml(ExamplesResource.class), getOpenAPIasString(EXAMPLES_RESOURCE));
    }

    @Test(description = "Test a resource with Links)", enabled = false)
    public void testLinksResource() {
        assertEquals(readIntoYaml(LinksResource.class), getOpenAPIasString(LINKS_RESOURCE));
    }
}
