package com.crosoften.rest;


import com.crosoften.utils.email.Email;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class AppApi {

    private static final String JSON_RETURN = "application/json";

    @Autowired
    private Email email;


    @RequestMapping("")
    public ResponseEntity<String> index() {

        return email.prepareAndSend("valmar.junior1@gmail.com", "Teste de Autowired", "Teste");


    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = JSON_RETURN)
    public String login(@RequestBody String jsonString) {

        JsonObject loginCredentialsjsonObject = new Gson().fromJson(jsonString, JsonObject.class);

        return null;
    }


//    private JsonObject handleRawDataFromJson(String jsonObject) {
//        JsonObject rawJson = new Gson().fromJson(jsonObject, JsonObject.class);
//
////        String
//
//
//    }


}
