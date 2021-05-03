package app.controllers.shifts;

import app.dao.ShiftsDao;
import app.models.Shift;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class ShiftsCreateController implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Shift shift = new Shift(
                ctx.formParam("title", String.class).get(),
                ctx.formParam("staff_name", String.class).get(),
                ctx.formParam("detail", String.class).get(),
                ctx.formParam("status", String.class).get(),
                ctx.formParam("created_time", String.class).get(),
                ctx.formParam("finish_time", String.class).get(),
                ctx.formParam("due_time", String.class).get()
        );

        shift = ShiftsDao.INSTANCE.create(shift);
        ctx.redirect("/shifts");
    }

}
