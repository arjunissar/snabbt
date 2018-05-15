package controllers;

import model.Employee;
import play.db.DB;
import play.mvc.*;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Application extends Controller {

//    public Result getAllEmployees() {
//        DataSource ds = DB.getDataSource();
//        ResultSet resultSet = null;
//        ArrayList<Employee> mEmployees = new ArrayList<>();
//        try {
//            Connection conn = ds.getConnection();
//            // the mysql insert statement
//            String query = "SELECT * FROM employee";
//            PreparedStatement statement = conn.prepareStatement(query);
//            resultSet = statement.executeQuery();
//
//            if (resultSet != null) {
//                while (resultSet.next()) {
//                    String username = resultSet.getString("username");
//                    String password = resultSet.getString("password");
//                    String type = resultSet.getString("type");
//                    String first_name = resultSet.getString("first_name");
//                    String last_name = resultSet.getString("last_name");
//                    String dob = resultSet.getString("dob");
//                    Employee employee = new Employee();
//                    employee.setUsername(username);
//                    employee.setPassword(password);
//                    employee.setType(type);
//                    employee.setFirstName(first_name);
//                    employee.setLastName(last_name);
//                    employee.setDateOfBirth(dob);
//                    mEmployees.add(employee);
//                }
//            }
//
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return ok("Result : "+mEmployees.toString());
//
//    }

    public Result addEmployee() {
        boolean executed = addEmployeeToDatabase();
        if (executed) {
            return ok("Added");
        } else {
            return ok("Failed");
        }
    }

    public Result getAllConductors() throws SQLException {
        DataSource ds = DB.getDataSource();
        ResultSet resultSet = null;
        ArrayList<Employee> mEmployees = new ArrayList<>();
        try {
            Connection conn = ds.getConnection();
            // the mysql insert statement
            String query = "SELECT * FROM employee WHERE type='COND'";
            PreparedStatement statement = conn.prepareStatement(query);
            resultSet = statement.executeQuery();

        if (resultSet != null) {
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String type = resultSet.getString("type");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String dob = resultSet.getString("dob");
                Employee employee = new Employee();
                employee.setUsername(username);
                employee.setPassword(password);
                employee.setType(type);
                employee.setFirstName(first_name);
                employee.setLastName(last_name);
                employee.setDateOfBirth(dob);
                mEmployees.add(employee);
            }
        }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok("Result : "+mEmployees.toString());
    }

    public Result getAllOwners() {
        DataSource ds = DB.getDataSource();
        ResultSet resultSet = null;
        ArrayList<Employee> mEmployees = new ArrayList<>();
        try {
            Connection conn = ds.getConnection();
            // the mysql insert statement
            String query = "SELECT * FROM employee WHERE type='OWNER'";
            PreparedStatement statement = conn.prepareStatement(query);
            resultSet = statement.executeQuery();

            if (resultSet != null) {
                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String type = resultSet.getString("type");
                    String first_name = resultSet.getString("first_name");
                    String last_name = resultSet.getString("last_name");
                    String dob = resultSet.getString("dob");
                    Employee employee = new Employee();
                    employee.setUsername(username);
                    employee.setPassword(password);
                    employee.setType(type);
                    employee.setFirstName(first_name);
                    employee.setLastName(last_name);
                    employee.setDateOfBirth(dob);
                    mEmployees.add(employee);
                }
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok("Result : "+mEmployees.toString());
    }

    public Result getAllManagers() {
        DataSource ds = DB.getDataSource();
        ResultSet resultSet = null;
        ArrayList<Employee> mEmployees = new ArrayList<>();
        try {
            Connection conn = ds.getConnection();
            // the mysql insert statement
            String query = "SELECT * FROM employee WHERE type='MANAGER'";
            PreparedStatement statement = conn.prepareStatement(query);
            resultSet = statement.executeQuery();

            if (resultSet != null) {
                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String type = resultSet.getString("type");
                    String first_name = resultSet.getString("first_name");
                    String last_name = resultSet.getString("last_name");
                    String dob = resultSet.getString("dob");
                    Employee employee = new Employee();
                    employee.setUsername(username);
                    employee.setPassword(password);
                    employee.setType(type);
                    employee.setFirstName(first_name);
                    employee.setLastName(last_name);
                    employee.setDateOfBirth(dob);
                    mEmployees.add(employee);
                }
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok("Result : "+mEmployees.toString());
    }

//    public Result removeAllEmployees() {
//        DataSource ds = DB.getDataSource();
//        int resultSet=-1;
//        try {
//            Connection conn = ds.getConnection();
//
//            // the mysql insert statement
//            String query = "DELETE FROM employee";
//            PreparedStatement statement = conn.prepareStatement(query);
//            resultSet = statement.executeUpdate();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ok(""+resultSet);
//    }

    /* This function adds a user to the database.
    TODO : Take the user values as parameters as a JSON object. Should be a POST call.
    * */
    public boolean addEmployeeToDatabase() {
        DataSource ds = DB.getDataSource();
        boolean executed = false;
        try {
            Connection conn = ds.getConnection();

            // the mysql insert statement
            String query = " insert into employee (username, password, type, first_name, last_name, dob, isActive)"
                    + " values (?, ?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, "rajat");
            preparedStmt.setString(2, "12345678");
            preparedStmt.setString(3, "ADMIN");
            preparedStmt.setString(4, "Rajat");
            preparedStmt.setString(5, "Shekhar");
            preparedStmt.setString(6, "14/08/1993");
            preparedStmt.setBoolean(7, true);

            // execute the preparedstatement
            executed = preparedStmt.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return executed;
    }

    /* This function makes a user inactive on the database
    * */
    public Result makeEmployeeInactive() {
        String username = "arjun";
        DataSource ds = DB.getDataSource();
        int executed = -1;
        try {
            Connection conn = ds.getConnection();

            // the mysql insert statement
            String query = "UPDATE employee\n" +
                    "   SET isActive = false\n" +
                    " WHERE username = '"+username+"'";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            // execute the preparedstatement
            executed = preparedStmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok("Done"+executed);
    }

    /* This function makes a user active on the database
    * */
    public Result makeEmployeeActive() {
        String username = "arjun";
        DataSource ds = DB.getDataSource();
        int executed = -1;
        try {
            Connection conn = ds.getConnection();

            // the mysql insert statement
            String query = "UPDATE employee\n" +
                    "   SET isActive = true\n" +
                    " WHERE username = '"+username+"'";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            // execute the preparedstatement
            executed = preparedStmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok("Done"+executed);
    }

    /* This function makes adds a bus to the database
    * */
    public Result addBus() {
        DataSource ds = DB.getDataSource();
        boolean executed = false;
        try {
            Connection conn = ds.getConnection();

            // the mysql insert statement
            String query = " insert into bus (busNum, busOwner, insuranceDate, permitNum, pollutionCheckDate, isActive)"
                    + " values (?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, "TS10EF4511");
            preparedStmt.setString(2, "ram");
            preparedStmt.setString(3, "12/01/19");
            preparedStmt.setString(4, "12/01/19");
            preparedStmt.setString(5, "12/01/19");
            preparedStmt.setBoolean(6, true);

            // execute the preparedstatement
            executed = preparedStmt.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok("Done"+executed);
    }

    /* This function makes a user inactive on the database
    * */
    public Result makeBusInactive() {
        String username = "ram";
        DataSource ds = DB.getDataSource();
        int executed = -1;
        try {
            Connection conn = ds.getConnection();

            // the mysql insert statement
            String query = "UPDATE bus\n" +
                    "   SET isActive = false\n" +
                    " WHERE busOwner = '"+username+"'";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            // execute the preparedstatement
            executed = preparedStmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok("Done"+executed);
    }

    /* This function makes a user active on the database
    * */
    public Result makeBusActive() {
        String username = "ram";
        DataSource ds = DB.getDataSource();
        int executed = -1;
        try {
            Connection conn = ds.getConnection();

            // the mysql insert statement
            String query = "UPDATE bus\n" +
                    "   SET isActive = true\n" +
                    " WHERE busOwner = '"+username+"'";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            // execute the preparedstatement
            executed = preparedStmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok("Done"+executed);
    }
}
