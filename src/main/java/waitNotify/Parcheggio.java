package waitNotify;

public class Parcheggio {
    private int totalePosti = 10;

    public int getTotalePosti() {
        return totalePosti;
    }
    
    //Metodo per regolare l'igresso delle auto
    public void ingresso(){
        while (totalePosti == 0) { //se non ci sono posti disponibili
            try{
                wait(); //prova a mettere il thread in attesa             
            } catch (InterruptedException e) {}
        } 
        totalePosti--;
    }
    
    //L'auto esce dal parcheggio
    public void uscita()
    {
        totalePosti++; //viene aggiunto il posto che è appena stato liberato
        notifyAll();
    }
}
