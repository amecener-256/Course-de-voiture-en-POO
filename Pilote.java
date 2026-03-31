import java.util.Random;
import java.util.Scanner;

public enum Niveau {
    EXPERT(1.15, "Expert"), INTERMEDIAIRE(1.00, "Intermediaire"), DEBUTANT(0.90, "Débutant")
    }


abstract class Pilote {
    private String Nom;
    private Voiture Voiture_Associee;
    private Niveau Niveau_De_Competence;
    private int Victoires;
    private int Podiums;
    private int Abandons;
    private int Courses;

    public Pilote (String Nom, Voiture Voiture_Associee, Niveau Niveau_De_Competence, int Victoires, int Podiums, int Abandons, int Courses) {
        this.Nom = Nom;
        this.Voiture_Associee = Voiture_Associee;
        this.Niveau_De_Competence = Niveau_De_Competence;
        this.Victoires = Victoires;
        this.Podiums = Podiums;
        this.Abandons = Abandons;
        this.Courses = Courses;
    }

    // Je ne suis pas sur.
    abstract public void Jouer_Tour(int Numero_De_Tour, int Position_Du_Pilote, double Niv_Carburant, int Durabilite);

    // Je ne suis pas sur.
    public void Enregistrer_Resultat(int Victoires, int Podiums, int Courses) {
        this.Victoires = Victoires + 1;
        this.Podiums = Podiums + 1;
        this.Courses = Courses + 1;
    }

    public void Enregistrer_Abandon(int Abandons) {
        this.Abandons = Abandons + 1;
    }

    public Afficher_Statistiques(String Nom, int Victoire, int Podiums, int Courses, int Abandons) {
        System.out.println(this.Nom +
            " | Victoires:  " + this.Victoires +
            " | Podiums:  " + this.Podiums +
            " | Abandons:  " + this.Abandons +
            " | Courses: " + this.Courses);
    }
}

class Pilote_Humain extends Pilote {
    private int Tour_De_Jeu;
    private double Position_Du_Pilote;

    public Pilote_Humain (String Nom, Voiture Voiture_Associee, Niveau Niveau_De_Competence, int Victoires, int Podiums, int Abandons, int Courses) {
        super(Nom, Voiture_Associee, Niveau_De_Competence, Victoires, Podiums, Abandons, Courses);
    }

    // Je suis pas sur.
    public Jouer_Tour(int Tour_De_Jeu, double Position_Du_Pilote, double Niv_Carburant, int Durabilite) {

        this.Numero_De_Tour += 1;

        Random Aleatoire = new Random();

        Evenement_Durabilite = Aleatoire.nextInt(10) + 1;
        this.Durabilite = Durabilite - Evenement_Durabilite;
        Evenement_Niv_Carburant = Aleatoire.nextInt(10) + 1;
        this.Niv_Carburant = Niv_Carburant - Evenement_Niv_Carburant;
        Evenement_Position_Du_Pilote = Aleatoire.nextInt(10) + 1;
        this.Position_Du_Pilote = Position_Du_Pilote - Evenement_Position_Du_Pilote;

        Scanner Scan = new Scanner(System.in);  // Crée un objet Scanner

        System.out.println(
            " |Tour De Jeu : " + this.Tour_De_Jeu +
            " | Position du pilote : " + this.Position_Du_Pilote +
            " | Niveau du carburant : " + this.Niv_Carburant +
            " | Durabilité : " + this.Durabilite
        );

        System.out.println(
            "Vous 2 possibilité stratégique pour ce tour : conduire normalement (taper : 1) ou adopter un style agressif (taper : 2)."
        );

        int Reponse;

        do {
            Reponse = Scan.nextInt();  // Lit la réponse saisit.

            if (Reponse == 1 || Reponse == 2) {
                System.out.println("Réponse valider !");
            } else {
                System.out.println("Réponse invalide, resaisisez votre réponse !");
            }
        } while (Reponse != 1 && Reponse != 2);


    }
}