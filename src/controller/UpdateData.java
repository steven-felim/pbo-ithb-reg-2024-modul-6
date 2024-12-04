package controller;

import model.classes.DataKTP;
import model.classes.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class UpdateData {
    public boolean updateToDatabase(Map<String, Object> allInput) {
        DataKTP tempData = Temporary.temp(allInput);
        DatabaseConnector conn = new DatabaseConnector();
        conn.Connect();

        String query = "UPDATE data_ktp SET "
                + "nama = ?, "
                + "tanggalLahir = ?, "
                + "tempatLahir = ?, "
                + "jenisKelamin = ?, "
                + "golDarah = ?, "
                + "alamat = ?, "
                + "rtRw = ?, "
                + "kelDesa = ?, "
                + "kecamatan = ?, "
                + "agama = ?, "
                + "statusKawin = ?, "
                + "pekerjaan = ?, "
                + "kewarganegaraan = ?, "
                + "foto = ?, "
                + "ttd = ?, "
                + "berlakuHingga = ?, "
                + "kotaPembuatanKTP = ?, "
                + "tanggalPembuatanKTP = ? "
                + "WHERE nik = ?";

        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, tempData.getNama());
            stmt.setDate(2, new java.sql.Date(tempData.getTanggalLahir().getTime()));
            stmt.setString(3, tempData.getTempatLahir());
            stmt.setString(4, tempData.getJenisKelamin().toString());
            stmt.setString(5, tempData.getGolonganDarah().toString());
            stmt.setString(6, tempData.getAlamat());
            stmt.setString(7, tempData.getRtRw());
            stmt.setString(8, tempData.getKelDesa());
            stmt.setString(9, tempData.getKecamatan());
            stmt.setString(10, tempData.getAgama().toString());
            stmt.setString(11, tempData.getStatus().toString());
            stmt.setString(12, tempData.getPekerjaan());
            stmt.setString(13, tempData.getKewarganegaraan());
            stmt.setString(14, tempData.getFoto());
            stmt.setString(15, tempData.getTandaTangan());
            stmt.setString(16, tempData.getBerlakuHingga());
            stmt.setString(17, tempData.getKotaPembuatanKTP());
            stmt.setDate(18, new java.sql.Date(tempData.getTanggalPembuatanKTP().getTime()));
            stmt.setString(19, tempData.getNik());

            int check = stmt.executeUpdate();
            conn.Disconnect();

            if(check==0){
                return (false);
            }
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}