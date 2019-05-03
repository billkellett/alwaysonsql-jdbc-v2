package com.datastax.kellett;

import java.sql.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlwaysOnSqlJdbcMain {

    public static void main (String args[]) {

        String ipAddress = "";

        // get IP address for AlwaysOnSQL
        try {
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter IP Address for AlwaysOnSQL:");
            // Reading data using readLine
            ipAddress = reader.readLine();

            // Printing the read line
            System.out.println("Connecting to " + ipAddress);

        }

        catch(IOException e) {
            System.out.println(e);
        }

        try {
            // Load the JDBC Driver class
            Class.forName("com.simba.spark.jdbc41.Driver");

            // Create connection.  Note that user and password are not required for Workshop cluster, but
            // are included for completeness.
            Connection con = DriverManager.getConnection(
                    "jdbc:spark://" + ipAddress + ":10000", "cassandra", "cassandra");

            // Create a SQL statement and execute
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from alwaysonsql_workshop.customers limit 5");

            // Print the results - columns are in alpha order.  I used the Notebook Schema view to get the column indexes
            // (column index begins at 1)
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(10) + "  " + rs.getString(16));
            con.close();

        }

        catch (Exception e) {
            System.out.println(e);
        }
    }
}
