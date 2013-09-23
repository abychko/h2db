package h2db;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class GuestBook
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException {

        GuestBookControllerImpl guestBookController;
        guestBookController = new GuestBookControllerImpl("guestbook", "SYSDBA", "MASTERKEY");
        guestBookController.addRecord("Hi there! are you alive?");

        for(Record rec : guestBookController.getRecords()){
            rec.print();
        }



    /*


while(resultSet.next()){
System.out.println(resultSet.getBigDecimal("col1"));
System.out.println(resultSet.getString("s"));
System.out.println("--------------");
}

resultSet.close();
connection.close();*/
    }
}
