package models;

import play.db.Database;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.concurrent.CompletableFuture;


@javax.inject.Singleton
class UsersDBConnection {

    private Database db;
    //private DatabaseExecutionContext executionContext;

    @Inject
    public UsersDBConnection(Database db){
        this.db = db;
        //this.executionContext = executionContext;
    }
    public CompletableFuture<Void> displayConnection(){
        return CompletableFuture.runAsync(() ->{
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/laebrariDB", "root", "root");
                PreparedStatement state = conn.prepareStatement("CREATE TABLE laebrariBook");
                //int result = state.executeUpdate();
                System.out.println("Connected Boss");
            }
            catch (Exception e){
                e.printStackTrace();
            }

            return;
        });

    }
}
