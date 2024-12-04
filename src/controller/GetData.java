package controller;

import model.classes.DataKTP;
import model.classes.DatabaseConnector;
import model.enums.Agama;
import model.enums.GolonganDarah;
import model.enums.JenisKelamin;
import model.enums.StatusPerkawinan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetData {

    public GetData() {
    }

    public DataKTP fetchDataFromDB(String NIK) {
        DatabaseConnector conn = new DatabaseConnector();
        conn.Connect();
        String query = "SELECT * FROM data_ktp WHERE NIK='" + NIK + "'";
        DataKTP user = new DataKTP();
        user.setNik(NIK);
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                user.setNama(rs.getString("nama"));
                user.setTanggalLahir(rs.getDate("tanggalLahir"));
                user.setTempatLahir(rs.getString("tempatLahir"));

                switch (rs.getString("jenisKelamin")) {
                    case "PRIA":
                        user.setJenisKelamin(JenisKelamin.PRIA);
                        break;
                    case "WANITA":
                        user.setJenisKelamin(JenisKelamin.WANITA);
                        break;
                }

                switch (rs.getString("golDarah")) {
                    case "A":
                        user.setGolonganDarah(GolonganDarah.A);
                        break;
                    case "B":
                        user.setGolonganDarah(GolonganDarah.B);
                        break;
                    case "O":
                        user.setGolonganDarah(GolonganDarah.O);
                        break;
                    case "AB":
                        user.setGolonganDarah(GolonganDarah.AB);
                        break;
                }

                user.setAlamat(rs.getString("alamat"));
                user.setRtRw(rs.getString("rtRw"));
                user.setKelDesa(rs.getString("kelDesa"));
                user.setKecamatan(rs.getString("kecamatan"));

                switch (rs.getString("agama")) {
                    case "ISLAM":
                        user.setAgama(Agama.ISLAM);
                        break;
                    case "KRISTEN":
                        user.setAgama(Agama.KRISTEN);
                        break;
                    case "KATHOLIK":
                        user.setAgama(Agama.KATHOLIK);
                        break;
                    case "BUDDHA":
                        user.setAgama(Agama.BUDDHA);
                        break;
                    case "HINDU":
                        user.setAgama(Agama.HINDU);
                        break;
                    case "KONGHUCHU":
                        user.setAgama(Agama.KHONGHUCHU);
                        break;
                }

                switch (rs.getString("statusKawin")) {
                    case "BELUM_MENIKAH":
                        user.setStatus(StatusPerkawinan.BELUM_MENIKAH);
                        break;
                    case "MENIKAH":
                        user.setStatus(StatusPerkawinan.MENIKAH);
                        break;
                    case "JANDA":
                        user.setStatus(StatusPerkawinan.JANDA);
                        break;
                    case "DUDA":
                        user.setStatus(StatusPerkawinan.DUDA);
                        break;
                }

                user.setPekerjaan(rs.getString("pekerjaan"));
                user.setKewarganegaraan(rs.getString("kewarganegaraan"));
                user.setFoto(rs.getString("foto"));
                user.setTandaTangan(rs.getString("ttd"));
                user.setBerlakuHingga(rs.getString("berlakuHingga"));
                user.setKotaPembuatanKTP(rs.getString("kotaPembuatanKTP"));
                user.setTanggalPembuatanKTP(rs.getDate("tanggalPembuatanKTP"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (user);
    }
}