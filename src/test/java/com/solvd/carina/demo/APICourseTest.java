package com.solvd.carina.demo;

import com.solvd.carina.demo.api.products.GetProduct;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;

public class APICourseTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Atilio")
    public void getProductTest() {
        GetProduct getProduct = new GetProduct();
        getProduct.callAPIExpectSuccess();
        getProduct.validateResponseAgainstSchema("api/products/_get/rs.schema");
    }
}
