class Circuit{
    private String Nom;
    private String Pays;
    private int Nombre_De_Tours;
    private double Longueur;
    private String Type_De_Surface;

    public void Circuit(String Nom, String Pays, int Nombre_De_Tours, double Longueur, String Type_De_Surface) {
        this.Nom = Nom;
        this.Pays = Pays;
        this.Nombre_De_Tours = Nombre_De_Tours;
        this.Longueur = Longueur;
        this.Type_De_Surface = Type_De_Surface;
    }
}