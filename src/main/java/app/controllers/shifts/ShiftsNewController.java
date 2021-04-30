package app.controllers.shifts;

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
    }

}
