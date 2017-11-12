package controllers;

import models.BooksModel;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;



public class BookController extends Controller {

    private final  Form<BooksModel> modelForm;

    //show all books
    public Result index(){
        List<BooksModel> books = BooksModel.finder.all();
        return ok(views.html.books.index.render(books));
    }

    @Inject
    public BookController(FormFactory formFactory){
        this.modelForm = formFactory.form(BooksModel.class);
    }
    //new book
    public Result create(){

        return ok(views.html.books.create.render(modelForm));
    }

    //save book
    public Result save(){
    Form<BooksModel> boundForm = modelForm.bindFromRequest();
    if(boundForm.hasErrors()){
        flash("danger", "Failed! Correct your form, some values might be missing");
        return badRequest(views.html.books.create.render(boundForm));
    }
    BooksModel book = boundForm.get();
    book.save();
        flash("success", "Success! " + book.title + " has been added to your library");
        return redirect(routes.BookController.index());
    }

    //edit book
    public Result edit(Integer id){
        BooksModel book = BooksModel.finder.byId(id);
        if (book == null){
            return notFound(views.html.partials._404Error.render());
        }
        Form<BooksModel> editBookForm = modelForm.fill(book);
        return ok(views.html.books.edit.render(editBookForm));
    }

    //update book
    public Result update(){
        Form<BooksModel> updateForm = modelForm.bindFromRequest();
        if(updateForm.hasErrors()){
            flash("danger", "Something is wrong with your form");
            return badRequest(views.html.books.edit.render(updateForm));
        }
        BooksModel book = updateForm.get();
        BooksModel oldBook = BooksModel.finder.byId(book.id);
        if (oldBook == null){
            return notFound(views.html.partials._404Error.render());
        }
//        TODO: review tutorial, why have book.id if it's uneditable?
        oldBook.id = book.id;
        oldBook.title = book.title;
        oldBook.price = book.price;
        oldBook.author = book.author;
        oldBook.update();
        flash("success", oldBook.title + " edited successfully!");


        return redirect(routes.BookController.index());
    }

    //delete book
    public Result destroy(Integer id){
        BooksModel bookModel = BooksModel.finder.byId(id);
        if (bookModel == null){
            return notFound(views.html.partials._404Error.render());
        }
        bookModel.delete();
        flash("warning", bookModel.title + " deleted successfully!");

        return redirect(routes.BookController.index());
    }

    //show books details
    public Result show(Integer id){
        BooksModel booksModel = BooksModel.finder.byId(id);
        if (booksModel == null){
            return notFound(views.html.partials._404Error.render());
        }

        return ok(views.html.books.show.render(booksModel));
    }
}
