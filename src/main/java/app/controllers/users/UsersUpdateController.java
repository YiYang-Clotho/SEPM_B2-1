package app.controllers.users;

import app.auth.AccessManager;
import app.dao.ShiftsDao;
import app.dao.UserDao;
import app.models.User;
import app.utils.Views;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import java.util.Map;



public class UsersUpdateController implements Handler {
    private static final String USER_KEY = "currentUser";

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Map<String, Object> model = Views.baseModel(ctx);
        User user = ctx.sessionAttribute(USER_KEY);


        User user1 = UserDao.INSTANCE.getById(user.getId());
        System.out.println("user" + user);

        System.out.println("user1:" + user1);

        user1.setEmail(ctx.formParam("email", String.class).get());
        user1.setPhone(ctx.formParam("phone", String.class).get());
        user1.setName(ctx.formParam("name", String.class).get());
        user1.setPassword(ctx.formParam("password", String.class).get());
        user1.setId(ctx.formParam("id", Long.class).get());
        UserDao.INSTANCE.update(user1);

        ctx.redirect("/users/me");

    }
}
