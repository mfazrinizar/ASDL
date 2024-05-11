package com.mfazrinizar.asdl.ADT.Basic.Driver;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

import com.mfazrinizar.asdl.ADT.Basic.Mahasiswa;

public class MahasiswaDriver {
    public static void main(String[] args) {
        Mahasiswa m1 = new Mahasiswa();
        System.out.println("Mahasiswa 1: \n" + m1);

        Mahasiswa m2 = new Mahasiswa("Onot", "1234567890", "Computer Science", 2001);
        System.out.println("Mahasiswa 2: \n" + m2);

        m1.setNama("Tono");
        m1.setNim("0987654321");
        m1.setProgramStudi("Information Systems");
        m1.setAngkatan(2022);
        System.out.println("Updated Mahasiswa 1: \n" + m1);

        System.out.println("Mahasiswa 2 name: " + m2.getNama());
        System.out.println("Mahasiswa 2 NIM: " + m2.getNim());
        System.out.println("Mahasiswa 2 program studi: " + m2.getProgramStudi());
        System.out.println("Mahasiswa 2 angkatan: " + m2.getAngkatan());
    }
}