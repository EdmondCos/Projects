package com.sda.jdbc;

//    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
//    first_name VARCHAR(255) NOT NULL,
//    last_name VARCHAR(255) NOT NULL,
//    hire_date DATE

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import org.junit.Test;

public class TeacherTest {

    private String user = "root";
    private String password = "mindgame";
    private String url = "jdbc:mysql://localhost:3306/COURSES?useSSL=false";

    @Test
    public void createTeacher() throws SQLException {
        String sqlString =
                "INSERT INTO teacher(first_name, last_name, hire_date) VALUES('Ionel', 'Popescu', '2019-01-23')";

        //In varianta try with resources resursele declarate in interior sunt inchise automat
        try (Connection conn = DriverManager
                .getConnection( "jdbc:mysql://localhost:3306/COURSES?useSSL=false", "root",
                        "mindgame" );
                Statement statement = conn.createStatement()) {

            //get transaction - change default behaviour of transaction
            conn.setAutoCommit( false );

            //no of rows affected
            int res = statement.executeUpdate( sqlString );

            //commit transaction
            conn.commit();
        }
    }

    @Test
    public void deleteTeacher() {
        String sqlString = "DELETE FROM teacher WHERE id = ?";
        //am sa utilizez try-ul clasic pentru a exemplifica inchiderea resurselor

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection( url, user, password );
            stmt = conn.prepareStatement( sqlString );

            conn.setAutoCommit( false );

            //
            stmt.setInt( 1, 2 );

            //no of deleted rows
            int res = stmt.executeUpdate();

            System.out.println( "no of affected rows " + res );

            conn.commit();

            stmt.close();
            conn.close();
        } catch (Exception ex) {
            try {
                if (null != conn) {
                    conn.rollback();
                    conn.close();
                }

                if (null != stmt) {
                    stmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void removeLastRow() throws SQLException {
        String sqlMaxId = "SELECT max(id) FROM teacher";
        String sqlDeleteLastRow = "DELETE FROM teacher WHERE id = ? ";

        try (Connection conn = DriverManager.getConnection( url, user, password );
                PreparedStatement stmt1 = conn.prepareStatement( sqlMaxId );
                PreparedStatement stmt2 = conn.prepareStatement( sqlDeleteLastRow )
        ) {
            int maxId = 0;
            ResultSet rs = stmt1.executeQuery();
            while (rs.next()) {
                maxId = rs.getInt( 1 );
            }

            stmt2.setInt( 1, maxId );
            int res = stmt2.executeUpdate();
            System.out.println( "no of affected rows " + res );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectedTeacher() throws SQLException {
        String sqlString = "SELECT * FROM teacher";

        try (Connection conn = DriverManager.getConnection( url, user, password );
                Statement stmt = conn.createStatement()) {

            //pentru SELECT (READ) nu este nevoie de o tranzactie (este best practice)
            ResultSet rs = stmt.executeQuery( sqlString );

            //move cursor to the next row while it exists
            while (rs.next()) {
                int id = rs.getInt( "id" );
                String firstName = rs.getString( "first_name" );
                String lastName = rs.getString( "last_name" );
                Date hireDate = rs.getDate( "hire_date" );

                System.out.println(
                        "Prof :: " + id + " / " + firstName + " / " + lastName + " / " + hireDate );
            }
        }
    }
}
