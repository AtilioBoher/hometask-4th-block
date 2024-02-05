package com.solvd.hometask.api;

import com.solvd.hometask.api.products.DeleteProduct;
import com.solvd.hometask.api.products.GetProduct;
import com.solvd.hometask.api.products.PostProduct;
import com.solvd.hometask.api.products.PutProduct;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

public class APICourseTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Atilio")
    public void getProductTest() {
        GetProduct getProduct = new GetProduct();
        getProduct.setIndex(2);
        getProduct.callAPIExpectSuccess();
        getProduct.validateResponseAgainstSchema("api/products/_get/rs.schema");
    }

    @Test
    @MethodOwner(owner = "Atilio")
    public void postProductTest() {
        PostProduct postProduct = new PostProduct();
        postProduct.setProperties("api/products/product.properties");
        postProduct.callAPIExpectSuccess();
        postProduct.validateResponse();
    }

    @Test
    @MethodOwner(owner = "Atilio")
    public void putProductTest() {
        PutProduct putProduct = new PutProduct();
        putProduct.setIndex(1);
        putProduct.setProperties("api/products/product.properties");
        putProduct.callAPIExpectSuccess();
        putProduct.validateResponseAgainstSchema("api/products/_put/rs.schema");
        putProduct.validateResponse();
    }

    @Test
    @MethodOwner(owner = "Atilio")
    public void deleteProductTest() {
        DeleteProduct deleteProduct = new DeleteProduct();
        deleteProduct.setIndex(1);
        deleteProduct.callAPIExpectSuccess();
        deleteProduct.validateResponseAgainstSchema("api/products/_delete/rs.schema");
        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("datePredicate", date -> isDateValid(date));

        deleteProduct.validateResponse(comparatorContext);
    }

    private static boolean isDateValid(String date) {
        try {
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(date);
            return zonedDateTime.isAfter(
                    LocalDate.of(2000, 1, 1)
                            .atStartOfDay(ZoneId.systemDefault())
            );
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
