
public class Barbeiro extends Thread {
    
    private Barbearia barbearia;
    private String nome;
    private int tempoCorte;
    
    public Barbeiro(Barbearia b, String n, int t) {
        super(n);
        this.nome = n;
        this.barbearia = b;
        this.tempoCorte = t;
    }
    
    public void trabalhar() {
        synchronized(this.barbearia) {            
            if(this.barbearia.clienteAguardando()) {
                Cliente c = this.barbearia.chamarCliente();
                System.out.print("BARBEIRO "+this.nome+": "
                        + "CORTANDO O CABELO do cliente "+c.getNome());
                try{
                    Thread.sleep((int) (Math.random() * this.tempoCorte));
                } catch (InterruptedException e) { }
                System.out.println("... e pronto!");
            } else {
                try {                    
                    this.barbearia.wait();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void run() {
        while(true) {
            this.trabalhar();
            try{
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) { }
        }
    }    
    
}