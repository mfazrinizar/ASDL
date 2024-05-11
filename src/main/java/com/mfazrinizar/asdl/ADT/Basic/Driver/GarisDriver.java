package com.mfazrinizar.asdl.ADT.Basic.Driver;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

import com.mfazrinizar.asdl.ADT.Basic.Garis;
import com.mfazrinizar.asdl.ADT.Basic.Poin;

public class GarisDriver {
    public static void main(String[] args) {
        Poin awal = new Poin(0, 0);
        Poin akhir = new Poin(1, 1);
        
        Garis garis = new Garis(awal, akhir);
        
        System.out.println(garis);
        
        Poin newAwal = new Poin(2, 2);
        garis.setAwal(newAwal);
        
        System.out.println(garis);
        
        Poin newAkhir = new Poin(3, 3);
        garis.setAkhir(newAkhir);
        
        System.out.println(garis);

        garis.setAwal(newAkhir); // Output "Poin awal tidak boleh sama dengan poin akhir (keduanya tidak boleh sama), operasi setting dibatalkan."
    }
}