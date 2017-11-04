package models;


import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import io.ebean.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BooksModel extends Model{

    @Id
    public Integer id;
    public String title;
    public String author;
    public Integer price;

   public static Finder<Integer, BooksModel> finder = new Finder<>(BooksModel.class);
}
