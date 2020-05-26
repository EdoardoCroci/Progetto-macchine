package waitNotify;

public class Test {
    public static void main(String[] args) {
        Parcheggio p = new Parcheggio();
        for(int i = 1; i < 12; i++)
        {
            Auto auto = new Auto (" n." + i, p);
        }
    }
}
