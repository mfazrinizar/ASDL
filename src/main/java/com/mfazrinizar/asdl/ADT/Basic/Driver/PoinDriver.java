package com.mfazrinizar.asdl.ADT.Basic.Driver;

import com.mfazrinizar.asdl.ADT.Basic.Poin;

public class PoinDriver {
    public static void main(String[] args) {
        Poin p1 = new Poin();
        System.out.println("Poin 1: " + p1);
        
        Poin p2 = new Poin(5, 7);
        System.out.println("Poin 2: " + p2);

        System.out.println("Poin 1 x-coordinate: " + p1.getX());
        System.out.println("Poin 1 y-coordinate: " + p1.getY());
        System.out.println("Poin 2 x-coordinate: " + p2.getX());
        System.out.println("Poin 2 y-coordinate: " + p2.getY());

        System.out.print("Poin 1: ");
        p1.cetakPoin();
        System.out.print("Poin 2: ");
        p2.cetakPoin();
    }
}
