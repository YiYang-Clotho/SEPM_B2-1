package app.controllers.users;

import app.dao.UserDao;
import app.models.User;
import app.utils.Views;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import java.util.Map;



public class UsersUpdateController implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Map<String, Object> model = Views.baseModel(ctx);
        User user = new User();

        user.setEmail(ctx.formParam("email"));
        user.setPhone(ctx.formParam("phone"));
        user.setName(ctx.formParam("name"));

        UserDao.INSTANCE.update(user);
        ctx.redirect("/users/me");

    }
}
