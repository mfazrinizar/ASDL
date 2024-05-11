package com.mfazrinizar.asdl.ADT.Basic;

public class Mahasiswa {
    private String nama;
    private String nim;
    private String programStudi;
    private int angkatan;
    
    public Mahasiswa() {
        this.nama = "";
        this.nim = "";
        this.programStudi = "";
        this.angkatan = 2005;
    }

    public Mahasiswa(String nama, String nim, String programStudi, int angkatan) {
        this.nama = nama;
        this.nim = nim;
        this.programStudi = programStudi;
        this.angkatan = (angkatan >= 2005 && angkatan <= 2023) ? angkatan : 2005;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return this.nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getProgramStudi() {
        return this.programStudi;
    }

    public void setProgramStudi(String programStudi) {
        this.programStudi = programStudi;
    }

    public int getAngkatan() {
        return this.angkatan;
    }

    public void setAngkatan(int angkatan) {
        if (angkatan >= 2005 && angkatan <= 2023)
            this.angkatan = angkatan;
        else
            System.out.println("Angkatan harus berada di antara 2005 dan 2023.");
    }

    @Override
    public String toString() {
        return "Mahasiswa - \n" +
                "Nama: " + nama + ", \n" +
                "NIM: " + nim + ", \n" +
                "Program Studi: " + programStudi + ", \n" +
                "Angkatan: " + angkatan;
    }
}