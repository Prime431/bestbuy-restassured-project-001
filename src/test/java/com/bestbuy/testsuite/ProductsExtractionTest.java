package com.bestbuy.testsuite;

import com.bestbuy.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static com.bestbuy.testsuite.StoresAssertionTest.response;
import static io.restassured.RestAssured.given;

public class ProductsExtractionTest extends TestBase {
    static ValidatableResponse response;

    @BeforeClass
    public static void response() {
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
        response.log().all();
    }

    //21. Extract the limit
    @Test
    public void test021() {

        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    //22. Extract the total
    @Test
    public void test022() {

        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

//23. Extract the name of 5th product

    @Test
    public void test023() {

        String fifthProduct = response.extract().path("data[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + fifthProduct);
        System.out.println("------------------End of Test---------------------------");
    }

    //24. Extract the names of all the products
    @Test
    public void test024() {
        List<String> allProductsName = response.extract().path("data.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + allProductsName);
        System.out.println("------------------End of Test---------------------------");
    }

    //25. Extract the productId of all the products
    @Test
    public void test025() {
        List<Integer> allProductsId = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + allProductsId);
        System.out.println("------------------End of Test---------------------------");
    }
//26. Print the size of the data list

    @Test
    public void test026() {
        int dataList = response.extract().path("data.size()");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + dataList);
        System.out.println("------------------End of Test---------------------------");
    }

    //27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void test027() {
        List<HashMap<String, ?>> value = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-pack)'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The values for product name 'Energizer - MAX Batteries AA (4-pack)' are: " + value);
        System.out.println("------------------End of Test---------------------------");
    }

//28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)

    @Test
    public void test028() {
        String model = response.extract().path("data[8].model");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of model is : " + model);
        System.out.println("------------------End of Test---------------------------");
    }
//29. Get all the categories of 8th products

    @Test
    public void test029() {
        List<HashMap<String, ?>> allCategories = response.extract().path("data[7].categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of all Categories is : " + allCategories);
        System.out.println("------------------End of Test---------------------------");
    }

    //30. Get categories of the store where product id = 150115
    @Test
    public void test030() {
        List<HashMap<String, ?>> allCategories = response.extract().path("data[3].categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of all Categories is : " + allCategories);
        System.out.println("------------------End of Test---------------------------");
    }

    //31. Get all the descriptions of all the products
    @Test
    public void test031() {

        List<HashMap<String, ?>> allDescription = response.extract().path("data.description");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of all description is : " + allDescription);
        System.out.println("------------------End of Test---------------------------");
    }

    //32. Get id of all the all categories of all the products
    @Test
    public void test032() {

        List<HashMap<String, ?>> allCategories = response.extract().path("data.categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of all categoriesis : " + allCategories);
        System.out.println("------------------End of Test---------------------------");
    }
//33. Find the product names Where type = HardGood

    @Test
    public void test011() {
        List<?> productName = response.extract().path("data.findAll{it.type == 'HardGood'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The prices of products whose name end with = Vehicles are: " + productName);
        System.out.println("------------------End of Test---------------------------");
    }

    //34. Find the Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)
    @Test
    public void totalNumberOfCategories() {
        List<String> totalCategories = response.extract().path("data.find{it.name == 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total number of categories are: " + totalCategories.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //35. Find the createdAt for all products whose price < 5.49
    @Test
    public void test035() {
        List<String> createdAt = response.extract().path("data.findAll{it.price<5.49}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of products that price is less than 16.99 are: " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }
//36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)”

    @Test
    public void test036() {
        List<String> allCategoriesName = response.extract().path("data.find{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.categories.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All Categories names are : " + allCategoriesName);
        System.out.println("------------------End of Test---------------------------");
    }

    //37. Find the manufacturer of all the products
    @Test
    public void test037() {
        List<String> manufacturer = response.extract().path("data.manufacturer");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of manufacturer are : " + manufacturer);
        System.out.println("------------------End of Test---------------------------");
    }

    //38. Find the imge of products whose manufacturer is = Energizer
    @Test
    public void test038() {
        List<String> image = response.extract().path("data.findAll{it.manufacturer == 'Energizer'}.image");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The image of  : " + image);
        System.out.println("------------------End of Test---------------------------");
    }

//39. Find the createdAt for all categories products whose price > 5.99

    @Test
    public void test039() {
        List<String> createdAt = response.extract().path("data.findAll{it.price>5.99}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of products that price is more than 5.99 are: " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }

    //40. Find the uri of all the products
    @Test
    public void test040() {
        List<String> allUri = response.extract().path("data.url");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The find of all Uri :  " +allUri);
        System.out.println("------------------End of Test---------------------------");
    }
}
