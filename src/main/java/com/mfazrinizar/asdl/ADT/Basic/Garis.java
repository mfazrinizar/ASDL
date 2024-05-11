package com.mfazrinizar.asdl.ADT.Basic;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

public class Garis {
    private Poin awal, akhir;

    public Garis() {
        this(new Poin(0, 0), new Poin(0, 1));
    }

    public Garis(Poin awal, Poin akhir) {
        // if (cekPoin(awal, akhir)) {
        // System.out.println(
        // "Poin awal tidak boleh sama dengan poin akhir (keduanya tidak boleh sama),
        // poin awal dan poin akhir masing-masing ditetapkan menjadi (0, 0) dan (0,
        // 1).");
        // this.awal = new Poin(0, 0);
        // this.akhir = new Poin(0, 1);
        // } else {
        // this.awal = awal;
        // this.akhir = akhir;
        // }

        Poin copyAwal = new Poin(awal.getX(), awal.getY());
        Poin copyAkhir = new Poin(akhir.getX(), akhir.getY());
        if (cekPoin(copyAwal, copyAkhir)) {
            System.out.println(
                    "Poin awal tidak boleh sama dengan poin akhir (keduanya tidak boleh sama), poin awal dan poin akhir masing-masing ditetapkan menjadi (0, 0) dan (0, 1).");
            this.awal = new Poin(0, 0);
            this.akhir = new Poin(0, 1);
        } else {
            this.awal = copyAwal;
            this.akhir = copyAkhir;
        }
    }

    public Poin getAwal() {
        return this.awal;
    }

    // public Poin getAwal() {
    // return new Poin(this.awal.getX(), this.awal.getY());
    // }

    public void setAwal(Poin awal) {
        cekSetPoin(awal, true);
    }

    // public void setAwal(Poin awal) {
    // Poin copyAwal = new Poin(awal.getX(), awal.getY());
    // cekSetPoin(copyAwal, true);
    // }

    public Poin getAkhir() {
        return this.akhir;
    }

    // public Poin getAkhir() {
    // return new Poin(this.akhir.getX(), this.akhir.getY());
    // }

    public void setAkhir(Poin akhir) {
        cekSetPoin(akhir, false);
    }

    // public void setAkhir(Poin akhir) {
    // Poin copyAkhir = new Poin(akhir.getX(), akhir.getY());
    // cekSetPoin(copyAkhir, false);
    // }

    private boolean cekPoin(Poin a, Poin b) {
        return a.getX() == b.getX() && a.getY() == b.getY();
    }

    private void cekSetPoin(Poin yangDicek, boolean adalahAwal) {
        if (adalahAwal ? cekPoin(yangDicek, akhir) : cekPoin(yangDicek, awal)) {
            System.out.println(
                    "Poin awal tidak boleh sama dengan poin akhir (keduanya tidak boleh sama), operasi setting dibatalkan.");
        } else {
            if (adalahAwal)
                this.awal = yangDicek;
            else
                this.akhir = yangDicek;
        }
    }

    public void cetakGaris() {
        System.out.println("Garis dengan poin awal = " + this.awal + " dan poin akhir = " + this.akhir);
    }

    @Override
    public String toString() {
        return "Garis dengan poin awal = " + this.awal + " dan poin akhir = " + this.akhir;
    }
}
