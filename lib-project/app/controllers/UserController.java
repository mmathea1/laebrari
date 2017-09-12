package controllers;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

// Add the following to conf/routes 
/*
GET     /useruser        controllers.UserController.useruserGet
POST    /useruser        controllers.UserController.useruserPost
*/

/**
 * Userform controller for Play Java
 */
public class UserController extends Controller {

    private final Form<UserData> userForm;

    @Inject
    public UserController(FormFactory formFactory) {
        this.userForm = formFactory.form(UserData.class);
    }

    public Result userGet() {
        return ok(views.html.user.form.render(userForm));
    }

    public Result userPost() {
        Form<UserData> boundForm = userForm.bindFromRequest();
        if (boundForm.hasErrors()) {
            return badRequest(views.html.user.form.render(boundForm));

        } else {
            UserData user = boundForm.get();
            flash("success", "User " + user);
            return redirect(routes.UserController.userGet());
        }
    }

}
