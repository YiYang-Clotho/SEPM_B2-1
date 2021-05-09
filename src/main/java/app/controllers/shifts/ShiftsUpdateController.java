package app.controllers.shifts;

import app.dao.ShiftsDao;
import app.models.Shift;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

/**
 * @author Yi Yang, 2021. email: s3798354@student.rmit.edu.au
 */

public class ShiftsUpdateController implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Long id = ctx.pathParam("id", Long.class).get();
        Shift currentShift = ShiftsDao.INSTANCE.getByID(ctx.pathParam("id", Long.class).get());
        currentShift.setTitle(ctx.formParam("title", String.class).get());
        currentShift.setStaff_name(ctx.formParam("staff_name", String.class).get());
        currentShift.setDetail(ctx.formParam("detail", String.class).get());
        currentShift.setStatus(ctx.formParam("status", String.class).get());
        currentShift.setCreated_time(ctx.formParam("created_time", String.class).get());
        currentShift.setFinish_time(ctx.formParam("finish_time", String.class).get());
        currentShift.setDue_time(ctx.formParam("due_time", String.class).get());

        ShiftsDao.INSTANCE.update(currentShift);
        ctx.redirect("/shifts");

    }
}
