package com.mfazrinizar.asdl.ADT.Basic;

public final class Poin {
    private final int x, y;

    public Poin() {
        this(0, 0);
    }

    public Poin(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // public void setX(int x) {
    //     this.x = x;
    // }

    public int getX() {
        return this.x;
    }

    // public void setY(int y) {
    //     this.y = y;
    // }

    public int getY() {
        return this.y;
    }

    public void cetakPoin() {
        System.out.println("(" + this.x + ", " + this.y + ")");
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + y + ")";
    }
}
