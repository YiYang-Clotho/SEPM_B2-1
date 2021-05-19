package app.controllers.users;

import app.dao.UserDao;
import app.models.User;
import app.utils.Views;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;


public class UsersEditController implements Handler{
    private static final String USER_KEY = "currentUser";

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Map<String, Object> model = Views.baseModel(ctx);
        User user = ctx.sessionAttribute(USER_KEY);
        User user1 = UserDao.INSTANCE.getById(user.getId());

        model.put("currentUser", user1);
        ctx.render("/views/users/edit.html", model);
    }

}
