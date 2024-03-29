package cloudy.e_voiture.models;

import cloudy.e_voiture.models.connect.Connect;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Annonce
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_annonce;
    private String description;
    private int nbr_place;
    private int nbr_porte;
    private int etat;
    private double kilometrage;
    private double conso;
    private Date date_annonce;
    private int annee;
    private int id_user;
    private int id_carburant;
    private int id_transmission;
    private int id_moteur;
    private int id_categorie;
    private int id_couleur;
    private int id_modeles;
    private int id_marque;

    //    getters & setters
    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbr_place() {
        return nbr_place;
    }

    public void setNbr_place(int nbr_place) {
        this.nbr_place = nbr_place;
    }

    public int getNbr_porte() {
        return nbr_porte;
    }

    public void setNbr_porte(int nbr_porte) {
        this.nbr_porte = nbr_porte;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public double getConso() {
        return conso;
    }

    public void setConso(double conso) {
        this.conso = conso;
    }

    public Date getDate_annonce() {
        return date_annonce;
    }

    public void setDate_annonce(Date date_annonce) {
        this.date_annonce = date_annonce;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_carburant() {
        return id_carburant;
    }

    public void setId_carburant(int id_carburant) {
        this.id_carburant = id_carburant;
    }

    public int getId_transmission() {
        return id_transmission;
    }

    public void setId_transmission(int id_transmission) {
        this.id_transmission = id_transmission;
    }

    public int getId_moteur() {
        return id_moteur;
    }

    public void setId_moteur(int id_moteur) {
        this.id_moteur = id_moteur;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public int getId_couleur() {
        return id_couleur;
    }

    public void setId_couleur(int id_couleur) {
        this.id_couleur = id_couleur;
    }

    public int getId_modeles() {
        return id_modeles;
    }

    public void setId_modeles(int id_modeles) {
        this.id_modeles = id_modeles;
    }

    public int getId_marque() {
        return id_marque;
    }

    public void setId_marque(int id_marque) {
        this.id_marque = id_marque;
    }

    //    contrsuctor
    protected Annonce() {}
    public Annonce(int id_annonce, String description, int nbr_place, int nbr_porte, int etat, double kilometrage, double conso, Date date_annonce, int annee, int id_user, int id_carburant, int id_transmission, int id_moteur, int id_categorie, int id_couleur, int id_modeles, int id_marque) {
        this.id_annonce = id_annonce;
        this.description = description;
        this.nbr_place = nbr_place;
        this.nbr_porte = nbr_porte;
        this.etat = etat;
        this.kilometrage = kilometrage;
        this.conso = conso;
        this.date_annonce = date_annonce;
        this.annee = annee;
        this.id_user = id_user;
        this.id_carburant = id_carburant;
        this.id_transmission = id_transmission;
        this.id_moteur = id_moteur;
        this.id_categorie = id_categorie;
        this.id_couleur = id_couleur;
        this.id_modeles = id_modeles;
        this.id_marque = id_marque;
    }

    @Override
    public String toString() {
        return "Annonce{" +
                "id_annonce=" + id_annonce +
                ", description='" + description + '\'' +
                ", nbr_place=" + nbr_place +
                ", nbr_porte=" + nbr_porte +
                ", etat=" + etat +
                ", kilometrage=" + kilometrage +
                ", conso=" + conso +
                ", date_annonce=" + date_annonce +
                ", annee=" + annee +
                ", id_user=" + id_user +
                ", id_carburant=" + id_carburant +
                ", id_transmission=" + id_transmission +
                ", id_moteur=" + id_moteur +
                ", id_categorie=" + id_categorie +
                ", id_couleur=" + id_couleur +
                ", id_modeles=" + id_modeles +
                ", id_marque=" + id_marque +
                '}';
    }

    public static List<Annonce> findByIdUser(Connection connection, int id_user)
    {
        List<Annonce> valiny = new ArrayList<>();
        boolean isOuvert = false;
        String query = "select * from annonce where id_user = "+id_user+";";
        try
        {
            if (connection == null)
            {
                connection = Connect.connectToPostgre();
                isOuvert = true;
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                Annonce temp = new Annonce();
                temp.setId_annonce(resultSet.getInt("id_medicament"));
                temp.setDescription(resultSet.getString("nom"));
                valiny.add(temp);
            }
            resultSet.close();
            statement.close();
            if (isOuvert)
            {
                connection.close();
            }
        }
        catch (Exception e)
        {
            System.out.println("Annonce findByIdUser issues !");
            e.printStackTrace();
        }
        return valiny;
    }
}
