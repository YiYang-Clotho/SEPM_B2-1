package app.controllers.shifts;

import app.dao.ShiftsDao;
import app.utils.Views;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * @author Yi Yang, 2021. email: s3798354@student.rmit.edu.au
 */

public class ShiftsShowController implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Long id = ctx.pathParam("id",Long.class).get();
        Map<String, Object> model = Views.baseModel(ctx);
        model.put("currentShift", ShiftsDao.INSTANCE.getByID(id));
        ctx.render("/views/shifts/show.html",model);

    }
}
