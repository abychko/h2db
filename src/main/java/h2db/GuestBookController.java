package h2db;

import java.sql.SQLException;
import java.util.List;

public interface GuestBookController{

    void addRecord(String message);

    List<Record> getRecords() throws SQLException;  //Record {id, postDate, message}

}