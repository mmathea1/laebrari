package controllers;

import models.BooksModel;
import play.mvc.Controller;
import play.mvc.Result;


import java.util.Set;
import javax.inject.Inject;
import play.data.Form;
import play.data.FormFactory;



public class BookController extends Controller {

    private final  Form<BooksModel> bookForm;

    //show all books
    public Result index(){
        Set<BooksModel> books = BooksModel.allBooks();
        return ok(views.html.books.index.render(books));
    }

    @Inject
    public BookController(FormFactory formFactory){
        this.bookForm = formFactory.form(BooksModel.class);
    }
    //new book
    public Result create(){

        return ok(views.html.books.create.render(bookForm));
    }

    //save book
    public Result save(){
    Form<BooksModel> boundForm = bookForm.bindFromRequest();
    BooksModel book = boundForm.get();
    BooksModel.add(book);
        return redirect(routes.BookController.index());
    }

    //edit book
    public Result edit(Integer id){
        return TODO;
    }

    //update book
    public Result update(){
        return TODO;
    }

    //delete book
    public Result destroy(Integer id){
        return TODO;
    }

    //show books details
    public Result show(Integer id){
        return TODO;
    }
}
