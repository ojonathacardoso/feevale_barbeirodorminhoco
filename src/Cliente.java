
public class Cliente {
    
    private Barbearia barbearia;
    private String nome;
    
    public Cliente(Barbearia b, String n) {
        this.barbearia = b;
        this.nome = n;
    }
    
    public void irAoBarbeiro() {
        synchronized(this.barbearia) {
            if ( this.barbearia.sentarCliente(this) ) {
                this.barbearia.notifyAll();
                System.out.println("CLIENTE "+this.nome+": "
                        + "AGUARDANDO a sua vez de ser atendido.");
                System.out.println("\tEle é o "+this.barbearia.lugarOndeClienteSentou()+"º da fila a ser atendido"); 
            }
            else {
               System.out.println("CLIENTE "+this.nome+": "
                       + "FOI EMBORA pois a barbearia estava lotada."); 
               System.out.println("\tNão há lugares disponíveis!");
            }           
        }
    }
    
    public String getNome() {
        return this.nome;
    }
    
}