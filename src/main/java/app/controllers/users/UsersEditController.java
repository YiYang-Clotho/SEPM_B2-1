package app.controllers.users;

import app.utils.Views;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;


public class UsersEditController implements Handler{
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Map<String, Object> model = Views.baseModel(ctx);
//        model.put("user", UserDao.INSTANCE.getByEmail("admin@test.com"));
        ctx.render("/views/users/edit.html", model);
    }

}
