package com.mfazrinizar.asdl.ADT.Basic.Driver;

import com.mfazrinizar.asdl.ADT.Basic.Waktu;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

public class WaktuDriver {
    public static void main(String[] args) {
        Waktu waktu1 = new Waktu();
        System.out.println("Waktu 1: " + waktu1);
        
        Waktu waktu2 = new Waktu(5, 7, 9);
        System.out.println("Waktu 2: " + waktu2);

        System.out.println("Waktu 1 jam: " + waktu1.getJam());
        System.out.println("Waktu 1 menit: " + waktu1.getMenit());
        System.out.println("Waktu 1 detik: " + waktu1.getDetik());
        System.out.println("Waktu 2 jam: " + waktu2.getJam());
        System.out.println("Waktu 2 menit: " + waktu2.getMenit());
        System.out.println("Waktu 2 detik: " + waktu2.getDetik());

        System.out.print("Waktu 1: ");
        System.out.println(waktu1.waktuToDetik() + " detik || " + waktu1);
        System.out.print("Waktu 2: ");
        System.out.println(waktu2.waktuToDetik() + " detik || " + waktu2);
    }
}
