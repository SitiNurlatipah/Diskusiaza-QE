package Starter.Login;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;
public class PostLogin {
    public static String url = "https://capstone-go.dikatest.xyz/";

    @Step("user post login endpoints")
    public String postloginendpoint(){
        return url + "auth/login";
    }

    @Step("user login with valid email and valid password")
    public void loginusingvalidemailandpassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "ardhikayoviyanto@gmail.com");
        requestBody.put("password", "123");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(postloginendpoint());
    }
    @Step("user succes login respon 200 OK on login 1")
    public void  succesloginresponcode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("user receive valid token")
    public void receivevalidtoken(){
        restAssuredThat(response -> response.body("data", equalTo("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJkYXRhIjp7ImVtYWlsIjoiYXJkaGlrYXlvdml5YW50b0BnbWFpbC5jb20iLCJmaXJzdG5hbWUiOiJBcmRoaWthIFJlc3R1IiwiaWQiOjEsImxhc3RuYW1lIjoiWW92aXlhbnRvIiwicm9sZUlkIjoxfSwiZXhwIjoxNjU1MjI3NDY3fQ.WAy5X6_dPSCjrIUsTpFnIJLNxf_0uTGX0xxCYEtxwaI")));
    }
}
