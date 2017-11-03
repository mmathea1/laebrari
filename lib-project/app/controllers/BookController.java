package controllers;

import models.BooksModel;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Set;


public class BookController extends Controller {
    //show all books
    public Result index(){
        Set<BooksModel> books = BooksModel.allBooks();
        return ok(views.html.books.index.render(books));
    }
    //new book
    public Result create(){
        return TODO;
    }

    //save book
    public Result save(){
        return TODO;
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
