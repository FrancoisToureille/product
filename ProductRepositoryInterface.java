package fr.univamu.iut.product;
import java.util.*;

/**
 * Interface d'accès aux données des livres
 */
public interface ProductRepositoryInterface {
    /**
     *  Méthode fermant le dépôt où sont stockées les informations sur les produits
     */
    public void close();

    /**
     * Méthode retournant le livre dont la référence est passée en paramètre
     * @param reference identifiant du produit recherché
     * @return un objet Book représentant le livre recherché
     */
    public Product getProduct( String reference );

    /**
     * Méthode retournant la liste des produits
     * @return une liste d'objets produits
     */
    public ArrayList<Product> getAllProducts() ;

    /**
     * Méthode permettant de mettre à jours un livre enregistré
     * @param reference identifiant du produit à mettre à jour
     * @param name nouveau nom du produit
     * @param prixKg nouveau pmrix au Kg
     * @return true si le produit existe et la mise à jours a été faite, false sinon
     */
    public boolean updateProduct( String reference, String name, double prixKg);


}
