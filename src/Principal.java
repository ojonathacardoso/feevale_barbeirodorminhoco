/**
 *
 * @author Jonatha
 */
public class Principal {
    
    public static void main(String[] args) {
        
        int qtdeLugares = 8;
        int intervaloCriacaoCliente = 300;
        
        Barbearia barbearia = new Barbearia(qtdeLugares);
        
        Barbeiro barb1 = new Barbeiro(barbearia, "Pedro", 1000);
        Barbeiro barb2 = new Barbeiro(barbearia, "João", 800);
        
        ClienteGerador gerador = new ClienteGerador(barbearia, intervaloCriacaoCliente);  
        
        barb1.start();
        barb2.start();       
              
        gerador.start();
    }
    
}
