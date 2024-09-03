package restcountries;


import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestCountries {

    //Build using mvn install
    //Run the TestNG_Runner.xml file to get the results

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://restcountries.com/";
    }

    //------------------- Positive Cases--------------------//
    @Test(priority = 0)
    public void validCountrySpanish() {
        given()
                .when()
                .get("/v3.1/lang/Spanish")
                .then()
                .statusCode(200);
    }

    @Test(priority = 1)
    public void InvalidCountryTest() {
        given()
                .when()
                .get("/v3.1/lang/Test")
                .then()
                .statusCode(404);
    }

    @Test(priority = 2)
    public void validCountrySpanishPathParam() {
        given()
                .when()
                .pathParams("county", "Spanish")
                .get("/v3.1/lang/{county}")
                .then()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void InvalidCountryTestPathParam() {
        given()
                .when()
                .pathParams("county", "Test")
                .get("/v3.1/lang/{county}")
                .then()
                .statusCode(404);
    }

    //------------------- Negative Cases--------------------//

    @Test(priority = 4)
    public void negative1() {
        given()
                .when()
                .get("/v3.1/lang/Spanish")
                .then()
                .statusCode(500);
    }

    @Test(priority = 5)
    public void negative2() {
        given()
                .when()
                .get("/v3.1/lang/Test")
                .then()
                .statusCode(200);
    }

    @Test(priority = 6)
    public void negative3() {
        given()
                .when()
                .pathParams("county", "Spanish")
                .get("/v3.1/lang/{county}")
                .then()
                .statusCode(403);
    }

    @Test(priority = 7)
    public void negative4() {
        given()
                .when()
                .pathParams("county", "Test")
                .get("/v3.1/lang/{county}")
                .then()
                .statusCode(200);
    }
}
