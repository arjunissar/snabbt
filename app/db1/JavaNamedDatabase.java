package db1;

import model.Employee;
import play.db.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class JavaNamedDatabase {

    public static void insert()  {
        DataSource ds = DB.getDataSource();
        try {
            Connection conn = ds.getConnection();

            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " insert into users (first_name, last_name, date_created, is_admin, num_points)"
                    + " values (?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, "Barney");
            preparedStmt.setString(2, "Rubble");
            preparedStmt.setDate(3, startDate);
            preparedStmt.setBoolean(4, false);
            preparedStmt.setInt(5, 5000);

            // execute the preparedstatement
            preparedStmt.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Employee> selectAll() {
        DataSource ds = DB.getDataSource();
        ArrayList<Employee> mEmployees = new ArrayList<>();
        Employee employee = new Employee();
        try {
            Connection conn = ds.getConnection();
            String query = "select * from employee";

            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs =  statement.executeQuery();
            List<String[]> list = new ArrayList<>();
            while (rs.next()) {
                employee.setUsername(rs.getString("username"));
                employee.setPassword(rs.getString("password"));
                employee.setType(rs.getString("type"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setDateOfBirth(rs.getString("dob"));
                employee.setDateOfBirth(rs.getString("date_created"));
                mEmployees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mEmployees;
    }

    public static void update() {
        DataSource ds = DB.getDataSource();
        try {
            Connection conn = ds.getConnection();
            String query = "UPDATE table_name\n" +
                    "SET first_name = Choot, last_name = Issar\n" +
                    "WHERE first_name = Arjun;";

            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs =  statement.executeQuery();
            List<String[]> list = new ArrayList<>();
            while (rs.next()) {
                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                System.out.print(fName);
                System.out.println(lName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
