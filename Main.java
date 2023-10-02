import java.sql.*;
import java.util.ArrayList;

public class Main {
        public static void main (String[]args){
            //utilizzare JDBC per eseguire le seguenti query sul jdbc:mysql://localhost:3306/newdbdatabase:
            //creare una vista italian_studentsche ottenga tutti i nomi e cognomi degli studenti italiani
            //creare una vista german_studentsche ottenga tutti i nomi e cognomi degli studenti tedeschi
            //esegui una selezione utilizzando il italian_studentse inserisci il risultato in uno ArrayListdegli Studentoggetti chiamatiitalianStudents
            //esegui una selezione utilizzando il german_studentse inserisci il risultato in uno ArrayListdegli Studentoggetti chiamatigermanStudents

            //use JDBC for executing the following queries on the jdbc:mysql://localhost:3306/newdb database:
            //create a view italian_students that gets all the name and surname of the Italian students
            //create a view german_students that gets all the name and surname of the German students
            //execute a select using the the italian_students and put the result in an ArrayList of Student objects called italianStudents
            //execute a select using the the german_students and put the result in an ArrayList of Student objects called germanStudents

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "Asdasd123stella.");
                Statement statement = connection.createStatement();

                statement.execute("CREATE VIEW italian_students AS " +
                        "SELECT first_name, last_name FROM students WHERE country = 'Italian'");   //creare codice sql
                System.out.println("Italian students view created successfully.");

                statement.execute("CREATE VIEW german_students AS " +
                        "SELECT first_name, last_name FROM students WHERE country = 'German'");    //creare codice sql
                System.out.println("German students view created successfully.");

                ResultSet viewItalian = statement.executeQuery("select * from italian_students");       //prendere da heidisql
                ResultSet viewGerman = statement.executeQuery("select * from german_students");       //prendere da heidisql

                ArrayList<String> italian_students = new ArrayList<>();
                ArrayList<String> german_students = new ArrayList<>();

                while (viewItalian.next()) {
                    italian_students.add(viewItalian.getString("first_name"));
                    italian_students.add(viewItalian.getString("last_name"));
                }
                while (viewGerman.next()) {
                    german_students.add(viewGerman.getString("first_name"));
                    german_students.add(viewGerman.getString("last_name"));
                }

                // il for lo utilizzo per non andare su Heidi e controllare direttamente su IntelliJ
                for (String italianStudent : italian_students) {
                    System.out.println(italianStudent);
                }

                for (String germanStudent : german_students) {
                    System.out.println(germanStudent);
                }


            } catch (SQLException e) {
                e.getMessage();
                e.getErrorCode();
            }

        }

    }



//
//public class View {
//    public static void main(String[] args) {
//        try {
//            Connection connection = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/newdb", "developer", "passwordhere"
//            );
//
//            Statement statement = connection.createStatement();
////            statement.execute("CREATE VIEW italian_students AS " +
////                    "SELECT first_name, last_name FROM students WHERE country = "Italy";");
////            statement.execute("CREATE VIEW german_students AS " +
////                    "SELECT first_name, last_name FROM students WHERE country = "Germany";");
//            ResultSet italianView = statement.executeQuery(
//                    "SELECT FROM italian_students;");
//            ArrayList<String> italianStudents = new ArrayList<>();
//            while(italianView.next()) {
//                italianStudents.add(italianView.getString("first_name"));
//                italianStudents.add(italianView.getString("last_name"));
//            }
//            // ho creato i for per avere direttamente un riscontro qui senza andare su heidi
//            for(String italianStudent : italianStudents) {
//                System.out.println(italianStudent);
//            }
//
//            ResultSet germanView = statement.executeQuery(
//                    "SELECT * FROM german_students;");
//            ArrayList<String> germanStudents = new ArrayList<>();
//            while(germanView.next()) {
//                germanStudents.add(germanView.getString("first_name"));
//                germanStudents.add(germanView.getString("last_name"));
//            }
//
//            for(String germanStudent : germanStudents) {
//                System.out.println(germanStudent);
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}

