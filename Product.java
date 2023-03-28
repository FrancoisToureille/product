package fr.univamu.iut.product;


/**
 * Classe représentant un produit
 */
public class Product {

    /**
     * Référence du produit
     */
    protected String reference;

    /**
     * nom du produit
     */
    protected String name;

    /**
     * prix du produit au Kg
     */
    protected double prixKg;

    /**
     * Constructeur par défaut
     */
    public Product(){
    }

    /**
     * Constructeur de produit
     * @param reference référence du produit
     * @param name titre du produit
     * @param prixKg prix au Kg du produit
     */
    public Product(String reference, String name, double prixKg){
        this.reference = reference;
        this.name = name;
        this.prixKg = prixKg;

    }

    /**
     * Méthode permettant d'accéder à la réference du livre
     * @return un chaîne de caractères avec la référence du livre
     */
    public String getReference() {
        return reference;
    }

    /**
     * Méthode permettant d'accéder au nom du produit
     * @return un chaîne de caractères avec le nom du produit
     */
    public String getName() {
        return name;
    }


    /**
     * Méthode permettant d'accéder au prix au Kg du produit
     * @return un nombre à virgule correspondant indiquant le  prix au Kg
     */
    public double getPrixKg() {
        return prixKg;
    }

    /**
     * Méthode permettant de modifier la référence du produit
     * @param reference une chaîne de caractères avec la référence à utiliser
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * Méthode permettant de modifier le nom du produit
     * @param name une chaîne de caractères avec le nom à utiliser
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Méthode permettant de modifier le prix au Kg du produit
     * @param prixKg nombre à virgule correspondant correspondant au prix au Kg
     */
    public void setPrixKg(double prixKg) {
        this.prixKg = prixKg;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "reference='" + reference + '\'' +
                ", nom='" + name + '\'' +
                ", prix='" + prixKg + '\'' +
                '}';
    }
}

