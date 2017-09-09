
public class Main {

 
    public static void main(String[] args) {
        
     Volo meridiana = new Volo(3,4531);
     
         meridiana.prenota("Mario","Cona");
         meridiana.prenota("giuseppe","papp");
         meridiana.prenota("antonio","dacc");
         meridiana.prenota("marco","gimin");
         
         System.out.println(meridiana);
         meridiana.stampaClienti();
         try {
            meridiana.disdetta("Mario","Cona");
        } catch (ClienteNotFound e) {
            
            System.out.println(e);
        }
         catch (Exception e){
             System.err.println(e);
         }
         System.out.println(meridiana); 
         meridiana.stampaClienti();
         
    }
    
}
