import java.util.ArrayList;

public class Volo {
    private int maxPosti;
    private int id;
    private ArrayList<Cliente> posti;
    private ArrayList<Cliente> attesa;

    public Volo(int maxPosti, int id) {
        this.maxPosti = maxPosti;
        this.id = id;
        posti = new ArrayList <Cliente>(maxPosti);
        attesa= new ArrayList<Cliente>();
    }

    public int getMaxPosti() {
        return maxPosti;
    }

    public int getId() {
        return id;
    }
    
    public int postiLiberi(){
    return  maxPosti-posti.size();
    }
    public int postiAttesa(){
        return  attesa.size();
    }
    
    public void prenota(String nome, String cognome){
        Cliente cliente = new Cliente(nome, cognome);
        if(postiLiberi()>0){
            posti.add(cliente);
        }
        else{
            System.err.println("Volo pieno");
            attesa.add(cliente);
        }
    }
    
    public void disdetta(String nome, String cognome)throws ClienteNotFound{
        /*posti.remove(cliente);
        
        if(postiAttesa()>0){
            Cliente clienteattesa =attesa.remove(0);
            posti.add(clienteattesa);*/
       Cliente inattesa=null;
        for (Cliente cliente : attesa) {
            if(cliente.getNome().equals(nome) && cliente.getCognome().equals(cognome)){
                inattesa=cliente;
            }  
        }
       Cliente inposti=null;
            for (Cliente cliente : posti) {
            if(cliente.getNome().equals(nome) && cliente.getCognome().equals(cognome)){
                inposti=cliente;
            }   
        }
       

        if(inattesa != null){  
            
            attesa.remove(inattesa);
        }
        else if (inposti != null) { 
            posti.remove(inposti); //posizione X
            if(postiAttesa()>0){
            Cliente clienteattesa =attesa.remove(0); 
            posti.add(clienteattesa);
            }
        }
        else{
            throw new ClienteNotFound("cliente non trovato");
        }
        
        
    }
    
    public int statistica(char ch){
        //
        // throw new CLienteNotFound("Nessun cliente con la lettera " +ch);
        return 0;
    }
    
    public void stampaClienti()
    {
        for (Cliente cliente : posti) {
            System.out.println(cliente);
        }
        
    }

    @Override
    public String toString() {
        return "Volo "+id+", "+"posti liberi "+ postiLiberi()+ ", posti in attesa "+postiAttesa();
    }
    
}
