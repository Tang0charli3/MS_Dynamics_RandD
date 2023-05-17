package testMsd;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetEmail {

    public static void main(String[] args) {
        // OAuth2 access token
        String accessToken = "ya29.a0AWY7CklvXLh_hXBn5vFhP3XjiLLKL3Fkt9KJrlTpAMArTFlYwUcCkh_ymTlxEDB5deEFpZj0mkO825UOIKfXgA49PNsB-qAWE3VUfRCAKCpwhI5S7LMvhc5-qmwQdzIPa1FEFQs_4DAqfpPdxlY2-kIKil8CaCgYKAUUSARISFQG1tDrpPs-Ivl7S_r5CU9hmD-5yUg0163";

        // API endpoint URL
        String apiUrl = "https://gmail.googleapis.com/gmail/v1/users/tango.charlie.test.mail@gmail.com/messages";

        // Send GET request with OAuth2 authentication
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .get(apiUrl);
        String jsonString=response.getBody().asString();
        JsonObject jsonObject = new Gson().fromJson(jsonString, JsonObject.class);
        
        JsonArray messagesArray = jsonObject.getAsJsonArray("messages");
        System.out.println(response.getStatusCode());
        String text="";

        // Loop through the "messages" array
        for (JsonElement messageElement : messagesArray) {
            JsonObject messageObject = messageElement.getAsJsonObject();
            String id = messageObject.get("id").getAsString();
//            System.out.println("ID: " + id);
            String apiUrl2="https://gmail.googleapis.com/gmail/v1/users/tango.charlie.test.mail@gmail.com/messages/"+id;
            Response response2 = RestAssured.given()
                    .header("Authorization", "Bearer " + accessToken)
                    .get(apiUrl2);
            String responseBody = response2.getBody().asString();
//            System.out.println(responseBody);
            JsonObject jsonObject2 = new Gson().fromJson(responseBody, JsonObject.class);
	        String snippet = jsonObject2.get("snippet").getAsString();
	        text=snippet;
//	        System.out.println(snippet);
	        if(snippet.contains("Microsoft account Security code")) {
	        System.out.println("It Contains");
	        break;
	        }
      }
        System.out.println(text);
        }

        // Print the response status code

        // Print the response body
//        String responseBody = response.getBody().asString();
      
//        System.out.println("Response Body: " + responseBody);
        
//        JsonObject jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
//        String snippet = jsonObject.get("snippet").getAsString();
//        System.out.println(snippet);
//        if(snippet.contains("Microsoft account Security code")) {
//        	System.out.println("It Contains");
//        }
    
}
