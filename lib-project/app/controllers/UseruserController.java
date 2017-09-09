package controllers;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

// Add the following to conf/routes 
/*
GET     /useruser        controllers.UseruserController.useruserGet
POST    /useruser        controllers.UseruserController.useruserPost
*/

/**
 * Useruser form controller for Play Java
 */
public class UseruserController extends Controller {

    private final Form<UseruserData> useruserForm;

    @Inject
    public UseruserController(FormFactory formFactory) {
        this.useruserForm = formFactory.form(UseruserData.class);
    }

    public Result useruserGet() {
        return ok(views.html.useruser.form.render(useruserForm));
    }

    public Result useruserPost() {
        Form<UseruserData> boundForm = useruserForm.bindFromRequest();
        if (boundForm.hasErrors()) {
            return badRequest(views.html.useruser.form.render(boundForm));
        } else {
            UseruserData useruser = boundForm.get();
            flash("success", "User " + useruser);
            return redirect(routes.UseruserController.useruserGet());
        }
    }

}
