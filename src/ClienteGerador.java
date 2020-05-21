import java.util.Random;

public class ClienteGerador extends Thread {
 
    private Barbearia barbearia;
    
    private int intervaloCriacaoCliente;
    
    public ClienteGerador(Barbearia b, int i) {
        this.barbearia = b;
        this.intervaloCriacaoCliente = i;
    }
    
    public void run() {
        while(true) {
            Cliente c = new Cliente(this.barbearia, this.gerarNome());
            c.irAoBarbeiro();
            try{
                Thread.sleep((int) (Math.random() * this.intervaloCriacaoCliente));
            } catch (InterruptedException e) { }
        }
    }
    
    private String gerarNome() {
        Random r = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        final int n = 10;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
        }
        
        return sb.toString();
    }
}
