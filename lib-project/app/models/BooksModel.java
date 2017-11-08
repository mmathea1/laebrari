package models;


import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BooksModel extends Model{

    @Id
    @Constraints.Required
    public Integer id;
    @Constraints.Required
    public String title;
    @Constraints.Required
    public String author;
    @Constraints.Required
    public Integer price;

   public static Finder<Integer, BooksModel> finder = new Finder<>(BooksModel.class);
}
