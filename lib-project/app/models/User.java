package models;

import java.sql.ResultSet;

import static io.ebean.config.TenantMode.DB;

public class User {
    public val connection = DB.getConnection("default");
    public val statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);


}
