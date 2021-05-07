package app;

import app.auth.AccessManager;
import app.auth.LoginController;
import app.controllers.shifts.*;
import app.controllers.users.UsersEditController;
import app.controllers.users.UsersMeController;
import app.controllers.welcome.WelcomeController;
import app.models.Role;
import app.utils.Views;
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import io.javalin.plugin.rendering.JavalinRenderer;
import io.javalin.plugin.rendering.template.JavalinThymeleaf;

import static io.javalin.core.security.SecurityUtil.roles;

/**
 * Main Application Class.
 * <p>
 * Running this class as regular java application will start the HTTP Server and configure our web application.
 */
public class App {


    public static void main(String[] args) {

        //Create our HTTP server and listen in port 7000
        Javalin app = Javalin.create(config -> {
            config.enableDevLogging();
            config.registerPlugin(new RouteOverviewPlugin("/help/routes"));
            config.addStaticFiles("public/");
            config.accessManager(new AccessManager());
        }).start(3000);

        //Register the engine to process html views
        JavalinRenderer.register(JavalinThymeleaf.INSTANCE, ".html");

        //Configure Web Routes
        configureRoutes(app);

    }

    public static void configureRoutes(Javalin app) {

        app.get(WelcomeController.URL, new WelcomeController());

        //Auth
        app.get("/login", ctx -> {
            ctx.render("/views/auth/login.html", Views.baseModel(ctx));
        });

        app.post("auth", new LoginController());
        app.get("/logout", ctx -> {
            AccessManager.logout(ctx);
            ctx.redirect("/");
        });

        app.get("/users/me", new UsersMeController(),roles(Role.REGISTERED,Role.ADMIN));

        app.get("/users/me/edit", new UsersEditController(),roles(Role.REGISTERED,Role.ADMIN));

//        app.get("/users/me/edit", new UsersEditController(),roles(Role.REGISTERED,Role.ADMIN));
//
//        app.get("/users/me/edit", new UsersEditController(),roles(Role.REGISTERED,Role.ADMIN));

        app.get("/shifts", new ShiftsListController());
        app.get("/shifts/new", new ShiftsNewController(), roles(Role.ADMIN));
        app.post("/shifts", new ShiftsCreateController(), roles(Role.ADMIN));
        app.get("/shifts/:id/edit", new ShiftsEditController(), roles(Role.ADMIN));
        app.post("shifts/:id", new ShiftsCreateController(), roles(Role.ADMIN));
        app.get("/shifts/:id", new ShiftsShowController());





    }


}
