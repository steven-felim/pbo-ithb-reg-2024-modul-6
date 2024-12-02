package controller;

import model.classes.DataKTP;
import view.InputForm;


public class Validator {
    public static boolean validateForm(DataKTP data) {
        if (data.getNik() == null || data.getNik().trim().isEmpty()) {
            return false;
        }
        if (data.getNama() == null || data.getNama().trim().isEmpty()) {
            return false;
        }
        if (data.getTempatLahir() == null || data.getTempatLahir().trim().isEmpty()) {
            return false;
        }
        if (data.getTanggalLahir() == null) {
            return false;
        }
        if (data.getJenisKelamin() == null) {
            return false;
        }
        if (data.getGolonganDarah() == null) {
            return false;
        }
        if (data.getAlamat() == null || data.getAlamat().trim().isEmpty()) {
            return false;
        }
        if (data.getRtRw() == null || data.getRtRw().trim().isEmpty()) {
            return false;
        }
        if (data.getKelDesa() == null || data.getKelDesa().trim().isEmpty()) {
            return false;
        }
        if (data.getKecamatan() == null || data.getKecamatan().trim().isEmpty()) {
            return false;
        }
        if (data.getAgama() == null) {
            return false;
        }
        if (data.getStatus() == null) {
            return false;
        }
        if (data.getPekerjaan() == null) {
            return false;
        }
        if (data.getKewarganegaraan() == null) {
            return false;
        }
        if (data.getFoto() == null) {
            return false;
        }
        if (data.getTandaTangan() == null) {
            return false;
        }
        if (data.getKotaPembuatanKTP() == null || data.getKotaPembuatanKTP().trim().isEmpty()) {
            return false;
        }
        if (data.getTanggalPembuatanKTP() == null) {
            return false;
        }
        return true;
    }
}
