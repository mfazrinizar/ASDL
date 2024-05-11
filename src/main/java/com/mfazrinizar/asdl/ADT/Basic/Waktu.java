package com.mfazrinizar.asdl.ADT.Basic;

public class Waktu {
    private int jam, menit, detik;

    public Waktu() {
        this.jam = 0;
        this.menit = 0;
        this.detik = 0;
    }

    public Waktu(int jam, int menit, int detik) {
        this.jam = (jam >= 0 && jam <= 23) ? jam : 0;
        this.menit = (menit >= 0 && menit <= 59) ? menit : 0;
        this.detik = (detik >= 0 && detik <= 59) ? detik : 0;
    }

    public int getJam() {
        return this.jam;
    }

    public void setJam(int jam) {
        if (jam >= 0 && jam <= 23) {
            this.jam = jam;
        } else {
            // throw new IllegalArgumentException("Jam harus berada di antara 0 dan 23.");
            System.out.println("Jam harus berada di antara 0 dan 23.");
        }
    }

    public int getMenit() {
        return this.menit;
    }

    public void setMenit(int menit) {
        if (menit >= 0 && menit <= 59) {
            this.menit = menit;
        } else {
            // throw new IllegalArgumentException("Menit harus berada di antara 0 dan 59.");
            System.out.println("Menit harus berada di antara 0 dan 59.");
        }
    }

    public int waktuToDetik() {
        return ((jam * 3600) + (menit * 60) + detik);
    }

    public void detikToWaktu(int detik) {
        this.jam = detik / 3600;
        detik %= 3600;
        this.menit = detik / 60;
        this.detik = detik % 60;
    }

    public int getDetik() {
        return this.detik;
    }

    public void setDetik(int detik) {
        if (detik >= 0 && detik <= 59) {
            this.detik = detik;
        } else {
            // throw new IllegalArgumentException("Detik harus berada di antara 0 dan 59.");
            System.out.println("Detik harus berada di antara 0 dan 59.");
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", jam, menit, detik);
    }
}
