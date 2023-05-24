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
        String accessToken = "ya29.a0AWY7CkmX2AYFldbCT7JrsXvPkLmCm1AEYr-F4mNJ6n8xFGYh_TE1I4NjUsQ_XjFp7l5YGhdKBCnu59MQ27TBGjLRaWAVzbZ-Kgl0xcy2EByD_FZ4TQrJOGverW4uJSOgvIkkksfDOPvB26zc84WjRrIPZGGq3AaCgYKAZsSARISFQG1tDrpTA2WYAFrKdV_7LRihNdnaA0165";

        // API endpoint URL
        String apiUrl = "https://gmail.googleapis.com/gmail/v1/users/tango.charlie.test.mail@gmail.com/messages";

        // Send GET request with OAuth2 authentication
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .get(apiUrl);
        String jsonString=response.getBody().asString();
        JsonObject jsonObject = new Gson().fromJson(jsonString, JsonObject.class);
        
        JsonArray messagesArray = jsonObject.getAsJsonArray("messages");
        System.out.println(messagesArray.toString());
        System.out.println(response.getStatusCode());
        String text="";
        
//        Looping Ids
        for(JsonElement messageElement : messagesArray) {
//        	System.out.println("Entered Loop");
        	JsonObject messageObject = messageElement.getAsJsonObject();
        	String id = messageObject.get("id").getAsString();
        	String apiUrl2="https://gmail.googleapis.com/gmail/v1/users/tango.charlie.test.mail@gmail.com/messages/"+id;
//        	System.out.println(apiUrl);
        	Response response2 = RestAssured.given().header("Authorization", "Bearer " + accessToken).get(apiUrl2);
        	String responseBody = response2.getBody().asString();
        	 JsonObject jsonObject2 = new Gson().fromJson(responseBody, JsonObject.class);
 	        String snippet = jsonObject2.get("snippet").getAsString();
// 	        System.out.println(snippet);
 	        text=snippet.toUpperCase();
// 	        System.out.println(text);
 	        String subject ="Microsoft account security code";
 	        subject = subject.toUpperCase();
 	        if(text.contains(subject)) {
 	        	System.out.println("It Contains");
 	        	break;
 	        }
// 	        if(snippet.contains(subject)) {
// 	        System.out.println("It Contains");
//// 	        System.out.println(text);
// 	        break;
// 	        }
        }
        System.out.println(text);
//        for (JsonElement messageElement : messagesArray) {
//            JsonObject messageObject = messageElement.getAsJsonObject();
//            String id = messageObject.get("id").getAsString();
////            System.out.println("ID: " + id);
//            String apiUrl2="https://gmail.googleapis.com/gmail/v1/users/tango.charlie.test.mail@gmail.com/messages/"+id;
//            Response response2 = RestAssured.given()
//                    .header("Authorization", "Bearer " + accessToken)
//                   .get(apiUrl2);
//            String responseBody = response2.getBody().asString();
////            System.out.println(responseBody);
//            JsonObject jsonObject2 = new Gson().fromJson(responseBody, JsonObject.class);
//	        String snippet = jsonObject2.get("snippet").getAsString();
//	        String text=snippet;
//	        String subject ="Microsoft account security code";
////	        System.out.println(snippet);
//	        if(snippet.contains(subject)) {
//	        System.out.println("It Contains");
//	        System.out.println(text);
//	        break;
//	        }
//      }
//        System.out.println(text);
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
