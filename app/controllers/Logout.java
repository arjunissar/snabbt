package controllers;

import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

public class Logout extends Controller {

    /* This function logs a user out and the response takes the UI to the
       Login page
     */
    @BodyParser.Of(BodyParser.Json.class)
    public Result logout() {
        return ok();
    }
}
