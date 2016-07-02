package net.clickwifi.cloud.auth;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.simple.parser.ParseException;

import java.util.Map;

public class Jinanlu extends AuthBase {
    private org.json.simple.JSONObject config;
    private org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();

    public Jinanlu(String config) {
        Unirest.setTimeouts(30000L, 30000L);
        try {
            this.config = (org.json.simple.JSONObject) parser.parse(config);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public boolean login() {
        HttpResponse<String> response;
        try {
            response = Unirest.get((String) config.get("login_url"))
                    .header("accept", "application/json")
                    .queryString((Map<String, Object>) config.get("params"))
                    .asString();
            String body = removeUTF8BOM(response.getBody());
            org.json.simple.JSONObject result = (org.json.simple.JSONObject) parser.parse(body);
            if ((Integer) result.get("allowedtime") > 1) {
                return true;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean logout() {
        HttpResponse<String> response;
        try {
            response = Unirest.get((String) config.get("logout_url"))
                    .header("accept", "application/json")
                    .queryString((Map<String, Object>) config.get("params"))
                    .asString();
            String body = removeUTF8BOM(response.getBody());
            org.json.simple.JSONObject result = (org.json.simple.JSONObject) parser.parse(body);
            if (result.containsKey("starttime")) {
                return true;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}
