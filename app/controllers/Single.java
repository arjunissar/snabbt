package controllers;

import model.Employee;
import play.db.DB;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import scala.io.StdIn;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Single extends Controller {

    /* This function initiates a single
     */
//    @BodyParser.Of(BodyParser.Json.class)
    public Result initiateSingle() {

        // TODO: Check what single is it of the day


        DataSource ds = DB.getDataSource();
        boolean executed = false;
        try {
            Connection conn = ds.getConnection();

            // the mysql insert statement
            String query = " insert into single (busNum, latSource, lonSource, timeSource, isActive, isToday)"
                    + " values (?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, "TS10EF5411");
            preparedStmt.setDouble(2, 123.45678);
            preparedStmt.setDouble(3, 123.45678);
            preparedStmt.setString(4, "000000000");
            preparedStmt.setBoolean(5, true);
            preparedStmt.setBoolean(6, true);

            // execute the preparedstatement
            executed = preparedStmt.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok("Done"+executed);
    }

    /* This function marks the completion of a single
     */
//    @BodyParser.Of(BodyParser.Json.class)
    public Result finalizeSingle() {

        boolean isLastSingle = false;
        String busNum = "TS10EF5411"; // Get from user as a parameter
        double latSource;
        double lonSource;
        String timeSource;


        double latDest = 123.123456;
        double lonDest = 73.123456;
        String timeDest = "12345678";
        String singleDistance = "DISTANCE";
        String singleTime = "TIME";
        String singleCollection = "4321";
        int singleTickets = 120;
        String singleExpenses = "1234";
        String rfidCollection = "750";

        int executed = -1;

        if (isLastSingle) {

        } else {
            // Not the last single of the day
            DataSource ds = DB.getDataSource();
            ResultSet resultSet = null;
            model.Single single = new model.Single();
            try {
                Connection conn = ds.getConnection();
                // the mysql insert statement
                String query = "SELECT * FROM employee WHERE busNum='"+busNum+"' AND isActive=true AND isToday=true";
                PreparedStatement statement = conn.prepareStatement(query);
                resultSet = statement.executeQuery();

                if (resultSet != null) {
                    while (resultSet.next()) {
                        single.setBusNo(busNum);
                        latSource = resultSet.getBigDecimal("latSource").doubleValue();
                        single.setLatSource(String.valueOf(latSource));
                        lonSource = resultSet.getBigDecimal("lonSource").doubleValue();
                        single.setLonSource(String.valueOf(lonSource));
                        timeSource = resultSet.getString("timeSource");
                        single.setTimeSource(timeSource);
                        single.setIsToday(true);
                        single.setIsActive(false);
                    }
                }

                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            single.setLatDest(String.valueOf(latDest));
            single.setLonDest(String.valueOf(lonDest));
            single.setTimeDest(timeDest);
            // TODO : Calculate distance of the trip
            // TODO : Calculate time of the trip
            single.setSingleDistance(singleDistance);
            single.setTimeDest(singleTime);
            single.setSingleCollection(singleCollection);
            single.setSingleTickets(singleTickets);
            // TODO : The parameters will also have a list of expenses that needs to be stored in a different table
            single.setSingleExpenses(singleExpenses);
            single.setSingleRFIDCollection(rfidCollection);


            // After all computations are done, need to add the remaining data to the database
            DataSource dataSource = DB.getDataSource();
            try {
                Connection conn = ds.getConnection();

                // the mysql insert statement
                String query = "UPDATE single\n" +
                        "   SET latDest ="+latDest+", " +
                        "lonDest ="+lonDest+", " +
                        "timeDest ='"+timeDest+"', " +
                        "singleDist ='"+singleDistance+"', " +
                        "singleTime ='"+singleTime+"', " +
                        "singleCollection ='"+singleCollection+"', " +
                        "singleTickets ="+singleTickets+", " +
                        "singleExpenses ='"+singleExpenses+"', " +
                        "singleRFIDCollection ='"+rfidCollection+"', " +
                        "isActive = false" +
                        " WHERE busNum = '"+busNum+"' AND isActive = true";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);

                // execute the preparedstatement
                executed = preparedStmt.executeUpdate();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ok("DONE "+executed);
    }
}
