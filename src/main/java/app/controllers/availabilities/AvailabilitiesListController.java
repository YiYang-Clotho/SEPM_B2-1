package app.controllers.availabilities;

import app.dao.AvailabilitiesDao;
import app.utils.Views;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;


public class AvailabilitiesListController implements Handler{

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
//        Role userRole = (Role) AccessManager.getSessionCurrentUser(ctx).getRole();

//        if (userRole.toString().equals("REGISTERED")){
        //button of 'Add shift' invisible

        Map<String, Object> model = Views.baseModel(ctx);
        model.put("availabilities", AvailabilitiesDao.INSTANCE.getAll());
        ctx.render("/views/availabilities/list.html", model);
//        }else {
//            Map<String, Object> model = Views.baseModel(ctx);
////            model.put("shifts", ShiftsDao.INSTANCE.getAll());
//            ctx.render(TEMPLATE,model);
//        }
    }
}
