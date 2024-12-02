package model.classes;

import model.enums.*;

import java.util.Date;

public class DataKTP {
    private String nik, nama;
    private Date tanggalLahir;
    private String tempatLahir;
    private JenisKelamin jenisKelamin;
    private GolonganDarah golonganDarah;
    private String alamat, rtRw, kelDesa, kecamatan;
    private Agama agama;
    private StatusPerkawinan status;
    private String pekerjaan, kewarganegaraan, foto, tandaTangan, berlakuHingga, kotaPembuatanKTP;
    private Date tanggalPembuatanKTP;

    public DataKTP(String nik, String nama, Date tanggalLahir, String tempatLahir, JenisKelamin jenisKelamin, GolonganDarah golonganDarah, String alamat, String rtRw, String kelDesa, String kecamatan, Agama agama, StatusPerkawinan status, String pekerjaan, String kewarganegaraan, String foto, String tandaTangan, String berlakuHingga, String kotaPembuatanKTP, Date tanggalPembuatanKTP) {
        this.nik = nik;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.tempatLahir = tempatLahir;
        this.jenisKelamin = jenisKelamin;
        this.golonganDarah = golonganDarah;
        this.alamat = alamat;
        this.rtRw = rtRw;
        this.kelDesa = kelDesa;
        this.kecamatan = kecamatan;
        this.agama = agama;
        this.status = status;
        this.pekerjaan = pekerjaan;
        this.kewarganegaraan = kewarganegaraan;
        this.foto = foto;
        this.tandaTangan = tandaTangan;
        this.berlakuHingga = berlakuHingga;
        this.kotaPembuatanKTP = kotaPembuatanKTP;
        this.tanggalPembuatanKTP = tanggalPembuatanKTP;
    }

    public DataKTP() {

    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public JenisKelamin getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(JenisKelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public GolonganDarah getGolonganDarah() {
        return golonganDarah;
    }

    public void setGolonganDarah(GolonganDarah golonganDarah) {
        this.golonganDarah = golonganDarah;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getRtRw() {
        return rtRw;
    }

    public void setRtRw(String rtRw) {
        this.rtRw = rtRw;
    }

    public String getKelDesa() {
        return kelDesa;
    }

    public void setKelDesa(String kelDesa) {
        this.kelDesa = kelDesa;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public Agama getAgama() {
        return agama;
    }

    public void setAgama(Agama agama) {
        this.agama = agama;
    }

    public StatusPerkawinan getStatus() {
        return status;
    }

    public void setStatus(StatusPerkawinan status) {
        this.status = status;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(String kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTandaTangan() {
        return tandaTangan;
    }

    public void setTandaTangan(String tandaTangan) {
        this.tandaTangan = tandaTangan;
    }

    public String getBerlakuHingga() {
        return berlakuHingga;
    }

    public void setBerlakuHingga(String berlakuHingga) {
        this.berlakuHingga = berlakuHingga;
    }

    public String getKotaPembuatanKTP() {
        return kotaPembuatanKTP;
    }

    public void setKotaPembuatanKTP(String kotaPembuatanKTP) {
        this.kotaPembuatanKTP = kotaPembuatanKTP;
    }

    public Date getTanggalPembuatanKTP() {
        return tanggalPembuatanKTP;
    }

    public void setTanggalPembuatanKTP(Date tanggalPembuatanKTP) {
        this.tanggalPembuatanKTP = tanggalPembuatanKTP;
    }
}