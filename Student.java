import java.sql.*;
import java.util.ArrayList;

public class Student {
    String name;
    String surname;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName(String name) {
        return name;
    }

    public String getSurname(String surname) {
        return surname;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append('}');
        return sb.toString();
    }
}


