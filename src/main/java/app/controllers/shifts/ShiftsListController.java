package app.controllers.shifts;

import app.auth.AccessManager;
import app.dao.ShiftsDao;
import app.models.Role;
import app.utils.Views;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class ShiftsListController implements Handler {

//    static final String TEMPLATE = Views.templatePath("/views/users/me.html");

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
//        Role userRole = (Role) AccessManager.getSessionCurrentUser(ctx).getRole();

//        if (userRole.toString().equals("REGISTERED")){
            //button of 'Add shift' invisible

            Map<String, Object> model = Views.baseModel(ctx);
            model.put("shifts", ShiftsDao.INSTANCE.getAll());
            ctx.render("/views/shifts/list.html", model);
//        }else {
//            Map<String, Object> model = Views.baseModel(ctx);
////            model.put("shifts", ShiftsDao.INSTANCE.getAll());
//            ctx.render(TEMPLATE,model);
//        }
    }


}
