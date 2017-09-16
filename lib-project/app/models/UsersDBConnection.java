package models;

import play.db.Database;
import play.db.NamedDatabase;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

//inject users db not default
@javax.inject.Singleton
class UsersDBConnection {

    private Database db;
    private DatabaseExecutionContext executionContext;

    @Inject
    public UsersDBConnection(Database db, DatabaseExecutionContext executionContext){
        this.db = db;
        this.executionContext = executionContext;
    }
    public CompletionStage<Integer> displayConnection(){
        return CompletableFuture.supplyAsync(() ->{
            return db.withConnection(connection -> {
                return 1;
            });
        }, executionContext);

    }
}
