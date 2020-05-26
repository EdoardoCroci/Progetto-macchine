package waitNotify;

public class Auto extends Thread{
    private Parcheggio parcheggio;

    //Costruttore
    public Auto(String nome, Parcheggio parcheggio) {
        super(nome);
        this.parcheggio = parcheggio;
        start(); //il thread inizia la sua esecuzione 
    }
    
    @Override
    public void run(){
        while(true) { //loop
            synchronized (parcheggio){ //viene inserito nel synchronized per regolare l'accesso da 1 solo thread
                parcheggio.ingresso(); //l'auto entra nel parcheggio
                System.out.println("L'auto " + super.getName() + " é entrata\n Posti disponibili: " + parcheggio.getTotalePosti() + "\n");
            }          
            synchronized (parcheggio){ //viene inserito nel synchronized per regolare l'accesso da 1 solo thread
                parcheggio.uscita(); //l'auto esce dal parcheggio
                System.out.println("L'auto " + super.getName() + " é uscita\n Posti disponibili: " + parcheggio.getTotalePosti() + "\n");
            }
        }
    } 
}
