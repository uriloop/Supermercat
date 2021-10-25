package com.company;

import java.util.ArrayList;

public class Client {

    private String nom;
    private ArrayList<Float> carroCompra=new ArrayList<>();

    public String getNom() {
        return nom;
    }

    public ArrayList<Float> getCarroCompra() {
        return carroCompra;
    }

    public Client(String nom, int numProductes) {
        this.nom = nom;


        for (int i = 0; i < ((int)(Math.random()*numProductes)); i++) {
            carroCompra.add(nouProducte());
        }
    }

    private Float nouProducte() {
        return (float) ((int)(Math.random()*500))/100;
    }
}
