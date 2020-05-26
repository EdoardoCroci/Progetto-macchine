package Semaforo;

import java.util.concurrent.Semaphore;

public class Parcheggio {
    private int totalePosti  = 10;
    private Semaphore semDisp;
    private Semaphore semOccup;
    
    //Costruttore
    public Parcheggio() {
        semDisp = new Semaphore(totalePosti, true); //semaforo per i posti liberi
        semOccup = new Semaphore(0, true); //semaforo per i posti occupati
    }
    
    public int getTotalePosti() {
        return totalePosti;
    }
    
    public void ingresso()
    {
        try
        {
            semDisp.acquire(); //blocca l'accesso dalle altre auto
            totalePosti--;
        } catch (InterruptedException e) {}       
        semOccup.release(); //      
    }
    
    public  void uscita()
    {
        try
        {
            semOccup.acquire(); //
            totalePosti++;
        } catch (InterruptedException e) {}      
        semDisp.release(); //
    }
}
