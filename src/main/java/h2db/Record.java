package h2db;

import java.sql.Timestamp;

public class Record {
    int id;
    Timestamp postDate;
    String message;
    Record(int id, Timestamp ts, String message){
        this.id = id;
        this.postDate = ts;
        this.message = message;
    }
    
    void print(){
        System.out.println(id + "\t|\t" + postDate.toString() + "\t|\t" + message);
    }

}
