package app.controllers.shifts;

import app.dao.UserDao;
import app.models.Shift;
import app.utils.Views;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class ShiftsNewController implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Map<String, Object> model = Views.baseModel(ctx);
        model.put("shift", new Shift());
        ctx.render("/views/shifts/new.html", model);

        Map<String, Object> model_availableStaff = Views.baseModel(ctx);
        model_availableStaff.put("availableStaff", UserDao.INSTANCE.getAll());
        ctx.render("/views/shifts/new.html", model_availableStaff);
    }

}
