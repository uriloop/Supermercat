package com.company;

import javax.sound.sampled.EnumControl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    ///    DADES A INTRODUIR AL SUPERMERCAT


    static int numClients = 50;          // SI NUMcLIIENTS I NUMcAIXES NO SON DIVISIBLES
    static int numCaixes = 10;             // ES TREURAN CLIENTS FINS A SER-HO.
    static int numProductesMax = 30;

    static Caixa[] caixes;


    public static void main(String[] args) throws InterruptedException {



        caixes = new Caixa[numCaixes];

        crearClientsICaixes();


        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newScheduledThreadPool(numCaixes);

        int ti=(int)System.currentTimeMillis();
        for (Caixa caixa:caixes
             ) {
            executor.execute(caixa);
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        int te=(int) System.currentTimeMillis();

        System.out.println();
        System.out.println(" Temps d'execució "+((te-ti)/1000f) + " segons");
    }

    private static void crearClientsICaixes() {


        //
        while (numClients%numCaixes!=0) {
            numClients--;
        }

        int clientsXcaixa = numClients / numCaixes;
        int nomClient=1;
        for (int i = 0; i < numCaixes; i++) {
            ArrayList<Client> cl= new ArrayList<>();
            for (int j = 0; j < clientsXcaixa; j++) {
                cl.add(new Client("Client" + (nomClient), (int) ((Math.random() * numProductesMax) + 1)));
                nomClient++;
            }
            caixes[i]= new Caixa(cl,"Caixa"+(i+1));
        }
    }
}
