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
        User user = UserDao.INSTANCE.getById(ctx.formParam("id", Long.class).get());

        user.setEmail(ctx.formParam("email", String.class).get());
        user.setPhone(ctx.formParam("phone", String.class).get());
        user.setName(ctx.formParam("name", String.class).get());
//        user.setId(ctx.formParam("id", Long.class).get());

        User user1 = new User();
        long id = 1;
        user1.setId(id);
        user1.setPhone("123");
        user1.setEmail("123@123");
        user1.setName("user");

        UserDao.INSTANCE.update(user1);
        ctx.redirect("/users/me");

    }
}
