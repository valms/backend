package com.crosoften.rest;


import com.crosoften.utils.email.EmailService;
import com.crosoften.utils.json.JsonHandler;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class AppApi {

    private static final String JSON_RETURN = "application/json";

    private final EmailService emailService;
    private Gson gson;

    @Autowired
    public AppApi(EmailService emailService) {
        this.gson = new Gson();
        this.emailService = emailService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = JSON_RETURN)
    public ResponseEntity<JsonObject> index(@RequestBody String request) {

        Map<String, String> map = JsonHandler.jsonDeserialization(request);

        return emailService.prepareAndSend(map.get("recipient"), map.get("message"), map.get("subject"));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = JSON_RETURN)
    public String login(@RequestBody String jsonString) {

        JsonObject loginCredentialsjsonObject = new Gson().fromJson(jsonString, JsonObject.class);

        return null;
    }














}
