package app.utils;

import app.auth.AccessManager;
import app.models.Role;
import app.models.User;
import io.javalin.http.Context;

import java.util.HashMap;
import java.util.Map;

/**
 * A Utility Class with useful methods for Views of our application
 *
 * @author Sebastian Rodriguez, 2020. email: sebastian.rodriguez@rmit.edu.au
 */
public class Views {

    /**
     * Root location of html views
     */
    private static final String TEMPLATE_BASE = "/views/";

    /**
     * Use this method to obtain the final path for your templates.
     * @param template
     * @return
     */
    public static String templatePath(String template) {
        return TEMPLATE_BASE.concat(template);
    }

    /**
     * Use this method to populate the model with common information.
     * Eg: model.put("user", getSessionCurrentUser(ctx));
     * @param ctx
     * @return a pre-populated model
     */
    public static Map<String, Object> baseModel(Context ctx) {
        Map<String, Object> model = new HashMap<>();
        //add currentUser information
        User user = AccessManager.getSessionCurrentUser(ctx);
        model.put("user", user);
        model.put("user_logged_in", (user.getRole() == Role.ANONYMOUS ? false : true));
        return model;
    }
}