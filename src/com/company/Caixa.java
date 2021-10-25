package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Caixa implements Runnable {

    private List<Client> clients;
    private String nom;

    public Caixa(List<Client> clients, String nom) {
        this.clients = clients;
        this.nom = nom;
    }


    @Override
    public void run() {
        for (Client client : clients
        ) {
            int fl = 0;
            // Si el client no compra
            String productes="";
            if (client.getCarroCompra().isEmpty()){
                System.out.println();
                System.out.println(nom.toUpperCase(Locale.ROOT) + ": " + client.getNom() + "\n----No ha comprat res");
                System.out.println();
                System.out.println("-----------------------");
                System.out.println();
            }
            else {  // Si el client ha comprat
                for (Float flo : client.getCarroCompra()
                ) {
                    // Suma els preus i escriu l'String
                    fl += (flo * 100);
                    productes+=" producte: "+flo+"\n";
                }


                System.out.println(nom.toUpperCase(Locale.ROOT) + " " + client.getNom() +
                        "\n----Numero de productes: " +
                        client.getCarroCompra().size() + "\n" + productes +
                        "\n----Preu total: " + (float) fl / 100);
                System.out.println();
                System.out.println("-----------------------");
                System.out.println();
            }
        }


    }




}
