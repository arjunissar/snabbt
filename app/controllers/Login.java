package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

public class Login extends Controller {

    /* This function return the type of login associated with the username entered
       Returns -
       1. Conductor - UI for accepting QR can be triggered
       2. Manager - UI for accepting password field
       3. Owner - UI for accepting password field
    */
    @BodyParser.Of(BodyParser.Json.class)
    public Result initializeLogin() {
        JsonNode json = request().body().asJson();
        String username = json.get("username").asText();
        // TODO: Access the EMPLOYEE table and get the type associated to trigger the UI

        switch ("TYPE_OF_EMPLOYEE") {
            case "CONDUCTOR" :
                return ok();
            case "MANAGER" :
                return ok();
            case "OWNER" :
                return ok();
            default:
                // No return type. Return error.
                return ok();
        }
    }

    /* This function completes the login process by validating the login details
       and returns the necessary details for the HOME page
     */
    @BodyParser.Of(BodyParser.Json.class)
    public Result login() {
        JsonNode json = request().body().asJson();
        return ok();
    }

    /* This function is called if the user opens the app and is already logged in.
       The function only needs to return the necessary data for the HOME page to open
     */
    @BodyParser.Of(BodyParser.Json.class)
    public Result resumeLogin() {
        JsonNode json = request().body().asJson();
        return ok();
    }
}