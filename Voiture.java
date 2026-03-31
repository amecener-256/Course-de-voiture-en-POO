abstract class Voiture {
    protected String Nom;
    protected String Marque;
    protected double Vitesse_Max;
    protected double Acceleration;
    protected int Durabilite;
    protected double Niv_Carburant;
    protected double Capacite_Reservoir;
    protected double Consommation;

    public Voiture(String Nom, String Marque, double Vitesse_Max, double Acceleration, int Durabilite, double Niv_Carburant, double Capacite_Reservoir, double Consommation){
        this.Nom = Nom;
        this.Marque = Marque;
        this.Vitesse_Max = Vitesse_Max;
        this.Acceleration = Acceleration;
        this.Durabilite = Durabilite;
        this.Niv_Carburant = Niv_Carburant;
        this.Capacite_Reservoir = Capacite_Reservoir;
        this.Consommation = Consommation;
    }


    // Les Getters
    public String Get_Nom(){
        return Nom;
    }

    public String Get_Marque(){
        return Marque;
    }

    public double Get_Vitesse_Max(){
        return Vitesse_Max;
    }

    public double Get_Acceleration(){
        return Acceleration;
    }

    public int Get_Durabilite(){
        return Durabilite;
    }

    public double Get_Niv_Carburant(){
        return Niv_Carburant;
    }

    public double Get_Capacite_Reservoir(){
        return Capacite_Reservoir;
    }


    // Les Setters
    public void Set_Nom(String Nom){
        this.Nom = Nom;
    }

    public void Set_Marque(String Marque){
        this.Marque = Marque;
    }


    public void Set_Vitesse_Max(double Vitesse_Max){
        this.Vitesse_Max = Vitesse_Max;
    }

    public void Set_Acceleration(double Acceleration){
        this.Acceleration = Acceleration;
    }

    public void Set_Durabilite(int Durabilite){
        this.Durabilite = Durabilite;
    }

    public void Set_Niv_Carburant(double Niv_Carburant){
        this.Niv_Carburant = Niv_Carburant;
    }

    public void Set_Capacite_Reservoir(String Capacite_Reservoir){
        this.Capacite_Reservoir = Capacite_Reservoir;
    }


    // je sais pas si c'est bien !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public boolean Consommer_Carburant(double km){
        this.Niv_Carburant -= (this.Consommation / 100) * km;
        return this.Est_En_Panne();
    }

    public void Subir_Degats(int Degats){
        this.Durabilite = Durabilite - 3;
    }

    public boolean Est_En_Panne(){
        return this.Durabilite <= 0 || this.Niv_Carburant <= 0;
        /*
        if (this.Durabilite <= 0 || this.Niv_Carburant <= 0) {
            return true;
        } else {
            return false;
        }
        */
    }

    public abstract double Calculer_Vitesse_Effective(TypeSurface surface);
}

// Je ne suis pas sur !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// Rapide mais fragile
class Voiture_De_Sport extends Voiture{
    public Voiture_De_Sport(String Nom, String Marque, double Niv_Carburant, double Capacite_Reservoir){
        super(Nom, Marque, 320, 9, 70, Niv_Carburant, Capacite_Reservoir, 12);
    }


    public double Calculer_Vitesse_Effective(TypeSurface surface){
        if (surface.equals("Asphalte")){
            return this.Vitesse_Max *= 1.15;
        } else if (surface.equals("Terre")){
            return this.Vitesse_Max *= 0.60;
        } else {
            return this.Vitesse_Max;
        }
    }
}

// Résistante mais lente
class Voiture_Tout_Terrain extends Voiture{
    public Voiture_Tout_Terrain(String Nom, String Marque, double Niv_Carburant, double Capacite_Reservoir){
        super(Nom, Marque, 180, 5.0, 100, Niv_Carburant, Capacite_Reservoir, 9);
    }
}

// Accélération élevée mais autonomie limitée
class Voiture_Electrique extends Voiture{
        public Voiture_Electrique(String Nom, String Marque, double Niv_Carburant, double Consommation){
        super(Nom, Marque, 240, 11.0, 100, Niv_Carburant, 40, Consommation);
    }
}