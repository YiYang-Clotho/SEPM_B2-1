package app.controllers.users;

import app.dao.ShiftsDao;
import app.utils.Views;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class UsersShiftsController implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Map<String, Object> model = Views.baseModel(ctx);
        System.out.println("these are all the shifts" + ShiftsDao.INSTANCE.getByName("Customer"));

        model.put("shifts", ShiftsDao.INSTANCE.getByName("Customer"));
        ctx.render("/views/shifts/list1.html", model);
    }
}
