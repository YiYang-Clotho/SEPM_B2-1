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
                ctx.formParam("date"),
                ctx.formParam("day"),
                ctx.formParam("start_time"),
                ctx.formParam("end_time"),
                ctx.formParam("staff"),
                ctx.formParam("position")
        );

        shift = ShiftsDao.INSTANCE.create(shift);
        ctx.redirect("/shifts");
    }

}
