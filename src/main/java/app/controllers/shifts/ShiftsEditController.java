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
        Map<String, Object> currentShift = Views.baseModel(ctx);
        currentShift.put("currentShift", ShiftsDao.INSTANCE.getByID(ctx.pathParam("id", Long.class).get()));
        ctx.render("/views/shifts/edit.html", currentShift);

        Map<String, Object> model_availableStaff = Views.baseModel(ctx);
        model_availableStaff.put("availableStaff", UserDao.INSTANCE.getAll());
        ctx.render("/views/shifts/edit.html", model_availableStaff);
    }

}
