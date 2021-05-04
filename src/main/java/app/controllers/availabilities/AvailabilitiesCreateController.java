package app.controllers.availabilities;

import app.dao.AvailabilitiesDao;
import app.models.Availability;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class AvailabilitiesCreateController implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Availability availability = new Availability(
                ctx.formParam("start_time", String.class).get(),
                ctx.formParam("end_time", String.class).get(),
                null
//                ctx.formParam("staff_name", String.class).get()
        );

        availability = AvailabilitiesDao.INSTANCE.create(availability);
        ctx.redirect("/users/me");
    }
}
//