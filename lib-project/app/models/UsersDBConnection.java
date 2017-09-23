package models;

import play.db.Database;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:9000/?user=root&password=rootpassword");
                PreparedStatement state = conn.prepareStatement("CREATE DATABASE playdbfirst");
                int result = state.executeUpdate();
            }
            catch (Exception e){
                e.printStackTrace();
            }

           return;
        });

    }
}
