import com.sun.prism.shader.DrawSemiRoundRect_RadialGradient_PAD_Loader;
import java.util.Scanner;
public class Main {

 
    public static void main(String[] args) {
        
     Volo meridiana = new Volo(3,4531);
     
         
         Scanner input =new Scanner(System.in);
         
        
         String risposta;
        do { 
            System.out.println("**************************");
            System.out.println("Scegli opzione desiderata");
            System.out.println("**************************");
            System.out.println("1 Prenotazione");
            System.out.println("2 Disdetta");
            System.out.println("3 Numero posti liberi");
            System.out.println("4 Clienti attesa");
            System.out.println("5 Persone prenotate in aereo");
            System.out.println("6 Statistiche");
            System.out.println("7 Esci");
            System.out.println("");
            System.out.println("");
            risposta=input.next();
            
                switch(risposta){
                        
                    case "1":System.out.println("Digita nome");
                    String nome=input.next();
                    System.out.println("Digita cognome");
                    
                    String cognome =input.next();
                    meridiana.prenota(nome,cognome);break;
                    
                    case "2":System.out.println("Digita nome");
                    String nomeDisdetta=input.next();
                    System.out.println("Digita cognome");
                    String cognomeDisdetta=input.next();
                    try{
                    meridiana.disdetta(nomeDisdetta,cognomeDisdetta);
                        System.out.println("Prenotazione annullata");}
                    catch(ClienteNotFound e) {
            
                          System.out.println(e);
                                               }break;
                        
                    case "3":System.out.println("Numero posti liberi="+meridiana.postiLiberi());break;
                    case "4":meridiana.stampaClientiAttesa();break;
                    case "5":meridiana.stampaClienti();break;
                    case "6":System.out.println("Digita lettera di ricerca");
                    String lettera=input.next();
                    char lettera1=lettera.charAt(0);
                        System.out.println("Il numero di clienti con la lettera "+lettera1+" sono "+meridiana.statistica(lettera1));
                        break;
                    default : System.out.println("Scelta errata");
                        
                }
            
            
        } while (!risposta.equals(7));
         
        
         
    }
    
}
