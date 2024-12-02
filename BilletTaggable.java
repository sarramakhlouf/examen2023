import java.time.LocalDate;

public class BilletTaggable extends Billet implements Taggable{
    private String[]LTags;
    private int nbTags;

    public BilletTaggable(LocalDate datePub, String auteur, int capacite){
        super(datePub,auteur);
        this.LTags = new String[capacite];
        this.nbTags = 0; 
    }

    @Override
    public String toString(){
        return super.toString() + " tags: "+LTags.toString();
    }

    public void ajoutTag(String tag){
        for(int i = 0; i<nbTags; i++){
            if(LTags[i].equals(tag)){
                System.out.println("Tag déjà existe");
                return;
            }
        }
        if (nbTags < LTags.length){
            LTags[nbTags++] = tag;
        }
        else {
            System.out.println("la liste est pleine");
        }
    }

    public void supprimeTag(String tag) {
        boolean found = false; 
        for (int i = 0; i < nbTags; i++) {
            if (LTags[i].equals(tag)) { 
                found = true;
                for (int j = i; j < nbTags - 1; j++) {
                    LTags[j] = LTags[j + 1];
                }
                LTags[nbTags - 1] = null;
                nbTags--;
                break;
            }
        }
        if (!found) {
            System.out.println("Tag non trouvé.");
        }
    }

    public int nombreTags(){
        return this.nbTags;
    }

    public int rechercheTag(String tag){
        for (int i = 0; i<nbTags; i++){
            if (LTags[i].equals(tag)){
                return i;
            }
        }
        return -1;    
    }

}
