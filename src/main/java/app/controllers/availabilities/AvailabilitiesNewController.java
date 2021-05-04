package app.controllers.availabilities;

import app.models.Availability;
import app.utils.Views;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class AvailabilitiesNewController implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Map<String, Object> model = Views.baseModel(ctx);
        model.put("availability", new Availability());
        ctx.render("/views/availabilities/new.html", model);

//        Map<String, Object> model_user = Views.baseModel(ctx);
//        ctx.render("/views/availabilities/new.html", model_user);
    }
}
