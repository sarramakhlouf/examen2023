public class Blog {
    private String titreBlog;
    private Publiable[] LBillets;
    private int nbBillets;

    public Blog (String titre, int capacite){
        this.titreBlog = titre;
        this.LBillets = new Publiable[capacite];
        this.nbBillets = 0;
    }

    public void post(Publiable billet) throws InvalidURLException {
        if (billet instanceof Video) {
            Video video = (Video) billet;
            String url = video.getUrl();
            if (!url.startsWith("https://")) {
                throw new InvalidURLException("L'URL de la vidéo n'est pas sécurisée : " + url);
            }
        }
        LBillets[nbBillets++] = billet ;
        System.out.println("Billet publié avec succès !");
    }
    public int getNombreBilletsTaggables(){
        int count = 0;
        for (int i = 0; i<nbBillets; i++){
            if (LBillets[i] instanceof Taggable){
                count ++;
            }
        }
        return count ++;
    }

    public Publiable[] RechercheBilletsTaggableParAuteur(String auteur){
        Publiable[] result = new Publiable[nbBillets];
        int index = 0;
        for (int i = 0; i<nbBillets; i++){
            if(LBillets[i] instanceof Taggable && LBillets[i].getAuteur().equals(auteur)){
                result[index] = LBillets[nbBillets];
            }
        }
        return result;
    }

    public Publiable getPlusRécentBillet(){
        Publiable recent = LBillets[0];
        for (int i = 0; i<nbBillets; i++){
            if (LBillets[i].getDatePublication().isAfter(recent.getDatePublication())){
                recent = LBillets[i];
            }
        }
        return recent;
    }
    

}
