package controller;

import model.classes.DatabaseConnector;

import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData{
    public boolean DeleteFromDatabase(String NIK){
        DatabaseConnector conn = new DatabaseConnector();
        conn.Connect();

        String query = "DELETE FROM data_ktp WHERE nik='" + NIK + "'";
        try {
            Statement stmt = conn.con.createStatement();
            int check = stmt.executeUpdate(query);
            conn.Disconnect();

            if (check==0) {
                return false;
            }
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            conn.Disconnect();
            return (false);
        }
    }
}