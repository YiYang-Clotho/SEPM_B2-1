package app.controllers.shifts;

import app.dao.ShiftsDao;
import app.dao.UserDao;
import app.models.Shift;
import app.utils.Views;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class ShiftsEditController implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Map<String, Object> model = Views.baseModel(ctx);
        Shift shift = ShiftsDao.INSTANCE.getByID(ctx.pathParam("id", Long.class).get());
        model.put("shift", shift);
        ctx.render("/views/shifts/edit.html", model);

        Map<String, Object> model_availableStaff = Views.baseModel(ctx);
        model_availableStaff.put("availableStaffs", UserDao.INSTANCE.getAll());
        ctx.render("/views/shifts/edit.html", model_availableStaff);
    }

}
