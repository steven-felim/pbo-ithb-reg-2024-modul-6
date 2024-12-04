package controller;

import model.classes.DataKTP;
import model.enums.Agama;
import model.enums.GolonganDarah;
import model.enums.JenisKelamin;
import model.enums.StatusPerkawinan;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Date;
import java.util.Map;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Temporary {
    public static DataKTP temp(Map<String, Object> allInput){
        DataKTP tempData = new DataKTP();

        tempData.setNik((String) allInput.get("nik"));
        tempData.setNama((String) allInput.get("nama"));
        tempData.setTanggalLahir((Date) allInput.get("tanggalLahir"));
        tempData.setTempatLahir((String) allInput.get("tempatLahir"));

        if (allInput.get("gender").equals("PRIA")) {
            tempData.setJenisKelamin(JenisKelamin.PRIA);
        } else {
            tempData.setJenisKelamin(JenisKelamin.WANITA);
        }

        if (allInput.get("golDar").equals("A")) {
            tempData.setGolonganDarah(GolonganDarah.A);
        } else if (allInput.get("golDar").equals("B")) {
            tempData.setGolonganDarah(GolonganDarah.B);
        } else if (allInput.get("golDar").equals("AB")) {
            tempData.setGolonganDarah(GolonganDarah.AB);
        } else {
            tempData.setGolonganDarah(GolonganDarah.O);
        }

        tempData.setAlamat((String) allInput.get("alamat"));
        tempData.setRtRw((String) allInput.get("rtRw"));
        tempData.setKelDesa((String) allInput.get("kelDesa"));
        tempData.setKecamatan((String) allInput.get("kecamatan"));

        if (allInput.get("agama").equals("ISLAM")) {
            tempData.setAgama(Agama.ISLAM);
        } else if (allInput.get("agama").equals("KRISTEN")) {
            tempData.setAgama(Agama.KRISTEN);
        } else if (allInput.get("agama").equals("KATHOLIK")) {
            tempData.setAgama(Agama.KATHOLIK);
        } else if (allInput.get("agama").equals("HINDU")) {
            tempData.setAgama(Agama.HINDU);
        } else if (allInput.get("agama").equals("BUDDHA")) {
            tempData.setAgama(Agama.BUDDHA);
        } else if (allInput.get("agama").equals("KHONGHUCHU")) {
            tempData.setAgama(Agama.KHONGHUCHU);
        }

        if (allInput.get("statusKawin").equals("MENIKAH")) {
            tempData.setStatus(StatusPerkawinan.MENIKAH);
        } else if (allInput.get("statusKawin").equals("JANDA")) {
            tempData.setStatus(StatusPerkawinan.JANDA);
        } else if (allInput.get("statusKawin").equals("DUDA")) {
            tempData.setStatus(StatusPerkawinan.DUDA);
        } else {
            tempData.setStatus(StatusPerkawinan.BELUM_MENIKAH);
        }

        tempData.setPekerjaan((String) allInput.get("pekerjaan"));

        tempData.setKewarganegaraan(allInput.get("kewarganegaraan").toString()+" "+allInput.get("additionalWNA"));

        File foto = (File) allInput.get("fileFoto");
        moveFile(foto);
        tempData.setFoto(foto.getName());

        File tandaTangan = (File) allInput.get("fileTandaTangan");
        moveFile(tandaTangan);
        tempData.setTandaTangan(tandaTangan.getName());

        tempData.setBerlakuHingga("Seumur Hidup");
        tempData.setKotaPembuatanKTP((String) allInput.get("kotaPembuatanKtp"));
        tempData.setTanggalPembuatanKTP((Date) allInput.get("tanggalPembuatanKTP"));

        return tempData;
    }

    private static void moveFile(File file){
        Path sourcePath = file.toPath();
        Path targetPath = Paths.get("D:\\#ITHB Semester 3\\Ganjil 2024 - Praktikum Pemrograman Berorientasi Objek\\20241129\\pbo-ithb-reg-2024-modul-6\\src\\img", file.getName());
        try {
            Files.copy(sourcePath, targetPath, REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}