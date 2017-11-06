package controllers;

import models.BooksModel;
import play.mvc.Controller;
import play.mvc.Result;


import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import play.data.Form;
import play.data.FormFactory;



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
    BooksModel book = boundForm.get();
    book.save();
        return redirect(routes.BookController.index());
    }

    //edit book
    public Result edit(Integer id){
        BooksModel book = BooksModel.finder.byId(id);
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
        BooksModel oldBook = BooksModel.finder.byId(book.id);
        if (oldBook == null){
            return notFound("Book Not Found");
        }
//        TODO: review tutorial, why have book.id if it's uneditable?
        oldBook.id = book.id;
        oldBook.title = book.title;
        oldBook.price = book.price;
        oldBook.author = book.author;
        oldBook.update();


        return redirect(routes.BookController.index());
    }

    //delete book
    public Result destroy(Integer id){
        BooksModel bookModel = BooksModel.finder.byId(id);
        if (bookModel == null){
            return notFound("Book not found");
        }
        bookModel.delete();

        return redirect(routes.BookController.index());
    }

    //show books details
    public Result show(Integer id){
        BooksModel booksModel = BooksModel.finder.byId(id);
        if (booksModel == null){
            return notFound("Book Not Found");
        }

        return ok(views.html.books.show.render(booksModel));
    }
}
