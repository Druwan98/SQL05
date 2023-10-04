import jdk.jfr.DataAmount;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //use JDBC for executing the following queries on the jdbc:mysql://localhost:3306/newdb database:
        //create a view italian_students that gets all the name and surname of the Italian students
        //create a view german_students that gets all the name and surname of the German students
        //execute a select using the italian_students and put the result in an ArrayList of Student objects called italianStudents
        //execute a select using the german_students and put the result in an ArrayList of Student objects called germanStudents

        try {
            //Connettendomi al mio DataBase
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "Asdasd123stella.");
            Statement statement = connection.createStatement();
            //Creando due view
            statement.execute("CREATE OR REPLACE VIEW italianStudents_view AS \n" +
                    "SELECT first_name,last_name FROM students WHERE country = 'Italy';");
            System.out.println("QUERY ESEGUITA: Creata view italianStudents");
            statement.execute("CREATE OR REPLACE VIEW germanStudents_view AS \n" +
                    "SELECT first_name,last_name FROM students WHERE country = 'Germany';");
            System.out.println("QUERY ESEGUITA: Creata view germanStudents");

            ResultSet italianView = statement.executeQuery("SELECT * FROM italianStudents_view");
            ArrayList<Student> italianStudents = new ArrayList<>();
            while (italianView.next()) {
                String first_name = italianView.getString("first_name");
                String last_name = italianView.getString("last_name");
                italianStudents.add(new Student(first_name, last_name));
            }
            for (Student italianStudent : italianStudents){
                System.out.println(italianStudent);
            }

            ResultSet germanView = statement.executeQuery("SELECT * FROM germanStudents_view");
            ArrayList<Student> germanStudents = new ArrayList<>();
            while (germanView.next()) {
                String first_name = germanView.getString("first_name");
                String last_name = germanView.getString("last_name");
                germanStudents.add(new Student(first_name, last_name));
            }
            for (Student germanStudent: germanStudents){
                System.out.println(germanStudent);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }
    }
}
