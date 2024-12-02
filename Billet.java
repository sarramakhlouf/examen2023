import java.time.LocalDate;

public class Billet implements Publiable{
    private LocalDate datePub;
    private String auteurBillet;

    public Billet (LocalDate date, String auteur){
        this.datePub = date;
        this.auteurBillet = auteur;
    }

    public LocalDate getDatePublication(){
        return this.datePub;
    }

    public String getAuteur(){
        return this.auteurBillet;
    }

    @Override
    public String toString (){
        return ("la date de ce billet: "+datePub+" et l'auteur: "+auteurBillet);
    }
}