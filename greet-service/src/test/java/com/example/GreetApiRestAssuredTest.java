package com.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetApiRestAssuredTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void hello_returnsOkWithGreeting() {
        given()
            .pathParam("name", "Alice")
        .when()
            .get("/api/hello/{name}")
        .then()
            .statusCode(200)
            .body(equalTo("Hello, Alice!"));
    }

    @Test
    void hello_withDifferentName() {
        given()
            .pathParam("name", "Bob")
        .when()
            .get("/api/hello/{name}")
        .then()
            .statusCode(200)
            .body(equalTo("Hello, Bob!"));
    }

    @Test
    void hello_withNumericName() {
        given()
            .pathParam("name", "123")
        .when()
            .get("/api/hello/{name}")
        .then()
            .statusCode(200)
            .body(equalTo("Hello, 123!"));
    }

    @Test
    void hello_returnsTextContentType() {
        given()
            .pathParam("name", "Test")
        .when()
            .get("/api/hello/{name}")
        .then()
            .statusCode(200)
            .contentType("text/plain;charset=UTF-8");
    }

    @Test
    void hello_missingName_returns404() {
        given()
        .when()
            .get("/api/hello")
        .then()
            .statusCode(404);
    }
}
