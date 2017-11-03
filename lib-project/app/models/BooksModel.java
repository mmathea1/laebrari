package models;


import java.util.HashSet;
import java.util.Set;

public class BooksModel {

    public String title;
    public Integer id;
    public String author;
    public Integer price;

    //default constructor
    public BooksModel(){}
    //constructor
    public BooksModel(Integer id, String title, String author, Integer price){
        this.title =title;
        this.id = id;
        this.author= author;
        this.price =price;
    }

    //fake db
    private static Set<BooksModel> books;

    //to initialize books storage
    static {
        books = new HashSet<>();
        books.add(new BooksModel(1, "Harry Potter", "J.K. Rowling", 2000));
        books.add(new BooksModel(2, "Nancy Drew", "Nancy Drew", 200));
        books.add(new BooksModel(3, "hardy Boys", "J.K. Hardy", 100));
    }

    //return all books in fake storage
    public static Set<BooksModel> allBooks()
    {
        return books;
    }

    //find book by id
    public static BooksModel findById(Integer id){
        for (BooksModel book : books){
            if (id.equals(book.id)){
                return book;
            }
        }
        return null;
    }

    //add book to fake storage
    public static void add(BooksModel book){
        books.add(book);
    }
    //remove book to fake storage
    public static boolean remove(BooksModel book){
        return books.remove(book);



    }
}
