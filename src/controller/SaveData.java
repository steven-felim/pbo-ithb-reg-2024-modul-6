package controller;

import model.classes.DataKTP;
import model.classes.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.TimeZone;

public class SaveData {

    public SaveData() {
    }

    public boolean insertToDatabase(Map<String, Object> allInput) {
        DataKTP tempData = Temporary.temp(allInput);

        DatabaseConnector conn = new DatabaseConnector();
        conn.Connect();

        String query = "INSERT INTO data_ktp VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

            stmt.setString(1, tempData.getNik());
            stmt.setString(2, tempData.getNama());
            stmt.setDate(3, new java.sql.Date(tempData.getTanggalLahir().getTime()));
            stmt.setString(4, tempData.getTempatLahir());
            stmt.setString(5, tempData.getJenisKelamin().toString());
            stmt.setString(6, tempData.getGolonganDarah().toString());
            stmt.setString(7, tempData.getAlamat());
            stmt.setString(8, tempData.getRtRw());
            stmt.setString(9, tempData.getKelDesa());
            stmt.setString(10, tempData.getKecamatan());
            stmt.setString(11, tempData.getAgama().toString());
            stmt.setString(12, tempData.getStatus().toString());
            stmt.setString(13, tempData.getPekerjaan());
            stmt.setString(14, tempData.getKewarganegaraan());
            stmt.setString(15, tempData.getFoto());
            stmt.setString(16, tempData.getTandaTangan());
            stmt.setString(17, tempData.getBerlakuHingga());
            stmt.setString(18, tempData.getKotaPembuatanKTP());
            stmt.setDate(19, new java.sql.Date(tempData.getTanggalPembuatanKTP().getTime()));

            stmt.executeUpdate();
            conn.Disconnect();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            conn.Disconnect();
            return (false);
        }
    }
}