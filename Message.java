import java.time.LocalDate;

public class Message extends Billet{
    private String contenuMsg;
    
    public Message(LocalDate date, String auteur, String contenu){
        super (date,auteur);
        this.contenuMsg = contenu;
    }

    public String getContenu(){
        return this.contenuMsg;
    }
    
}
