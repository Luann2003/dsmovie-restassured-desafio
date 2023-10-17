package com.devsuperior.dsmovie.controllers;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.devsuperior.dsmovie.tests.TokenUtil;

import io.restassured.http.ContentType;

public class ScoreControllerRA {
	
	private String clientUsername, clientPassword, adminUsername, adminPassword;
	private String adminToken, clientToken, invalidToken;
	
	private Long existingId, nonExistingId;
	
	private Map<String, Object> putScoreInstance;
	
	
	@BeforeEach
	void setup() throws JSONException {
		baseURI = "http://localhost:8080";
		
		clientUsername = "alex@gmail.com";
		clientPassword = "123456";
		adminUsername = "maria@gmail.com";
		adminPassword = "123456";
		
		clientToken = TokenUtil.obtainAccessToken(clientUsername, clientPassword);
		adminToken = TokenUtil.obtainAccessToken(adminUsername, adminPassword);
		invalidToken = adminToken + "xpto";
		
		putScoreInstance = new HashMap<>();
		putScoreInstance.put("movieId", 1);
		putScoreInstance.put("score", 4);
		
	}
	
	@Test
	public void saveScoreShouldReturnNotFoundWhenMovieIdDoesNotExist() throws Exception {
		putScoreInstance.put("movieId", 1000);
		JSONObject newProduct = new JSONObject(putScoreInstance);
		
		 given()
         .header("Content-Type", "application/json")
         .header("Authorization", "Bearer " + adminToken) 
         .contentType(ContentType.JSON)
         .body(newProduct)
     .when()
         .put("/scores")
     .then()
         .statusCode(404)
         .body("error", equalTo("Recurso não encontrado"));
	}
	
	@Test
	public void saveScoreShouldReturnUnprocessableEntityWhenMissingMovieId() throws Exception {
		putScoreInstance.put("movieId", "");
		JSONObject newProduct = new JSONObject(putScoreInstance);
		
		 given()
         .header("Content-Type", "application/json")
         .header("Authorization", "Bearer " + adminToken) 
         .contentType(ContentType.JSON)
         .body(newProduct)
     .when()
         .put("/scores")
     .then()
         .statusCode(422)
         .body("errors.message[0]", equalTo("Campo requerido"));
	}
	
	@Test
	public void saveScoreShouldReturnUnprocessableEntityWhenScoreIsLessThanZero() throws Exception {
		putScoreInstance.put("score", -1);
		JSONObject newProduct = new JSONObject(putScoreInstance);
		
		 given()
         .header("Content-Type", "application/json")
         .header("Authorization", "Bearer " + adminToken) 
         .contentType(ContentType.JSON)
         .body(newProduct)
     .when()
         .put("/scores")
     .then()
         .statusCode(422)
         .body("errors.message[0]", equalTo("Valor mínimo 0"));
	}
}
