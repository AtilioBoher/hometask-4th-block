package com.solvd.carina.demo;

import com.solvd.carina.demo.api.products.GetProduct;
import com.solvd.carina.demo.api.products.PostProduct;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class APICourseTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Atilio")
    public void getProductTest() {
        GetProduct getProduct = new GetProduct();
        getProduct.setIndex(2);
        Response response = getProduct.callAPIExpectSuccess();
        getProduct.validateResponseAgainstSchema("api/products/_get/rs.schema");
        System.out.println("############### " + JsonPath.from(response.asString()).getString("description"));
    }

    @Test
    @MethodOwner(owner = "Atilio")
    public void postProductTest() {
        PostProduct postProduct = new PostProduct();
        postProduct.setProperties("api/products/product.properties");
        postProduct.callAPIExpectSuccess();
        postProduct.validateResponse();
    }
}
