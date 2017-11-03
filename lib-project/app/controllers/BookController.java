package controllers;

import models.BooksModel;
import play.mvc.Controller;
import play.mvc.Result;


import java.util.Set;
import javax.inject.Inject;
import play.data.Form;
import play.data.FormFactory;



public class BookController extends Controller {

    private final  Form<BooksModel> modelForm;

    //show all books
    public Result index(){
        Set<BooksModel> books = BooksModel.allBooks();
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
    BooksModel book = boundForm.get();
    BooksModel.add(book);
        return redirect(routes.BookController.index());
    }

    //edit book
    public Result edit(Integer id){
        BooksModel book = BooksModel.findById(id);
        if (book == null){
            return notFound("Book Not Found");
        }
        Form<BooksModel> editBookForm = modelForm.fill(book);
        return ok(views.html.books.edit.render(editBookForm));
    }

    //update book
    public Result update(){
        Form<BooksModel> updateForm = modelForm.bindFromRequest();
        BooksModel book = updateForm.get();
        BooksModel oldBook = BooksModel.findById(book.id);
        if (oldBook == null){
            return notFound("Book Not Found");
        }
        oldBook.title = book.title;
        oldBook.price = book.price;
        oldBook.author = book.author;

        return redirect(routes.BookController.index());
    }

    //delete book
    public Result destroy(Integer id){
        return TODO;
    }

    //show books details
    public Result show(Integer id){
        BooksModel booksModel = BooksModel.findById(id);
        if (booksModel == null){
            return notFound("Book Not Found");
        }

        return ok(views.html.books.show.render(booksModel));
    }
}
