import java.util.ArrayList;

public class Barbearia {
    
    int qtdeLugares;
private ArrayList<Cliente> lugares = new ArrayList<>();
    
    public Barbearia(int lugares) {
        this.qtdeLugares = lugares;
    }
     
    public boolean sentarCliente(Cliente c) {
        if(this.lugares.size() == this.qtdeLugares) {
            return false;
        }
        else {
            this.lugares.add(c);
            return true;
        }        
    }
    
    
    public Cliente chamarCliente() {
        return this.lugares.remove(0);
    }
    
    public boolean clienteAguardando() {
        return this.lugares.size() > 0;            
    }
    
    public int lugarOndeClienteSentou() {
        return this.lugares.size();
    }
    
}