package fr.univamu.iut.product;
import java.io.Closeable;
import java.sql.*;
import java.util.ArrayList;

/**
 * Classe permettant d'accèder aux produits stockés dans une base de données Mariadb
 */
public class ProductRepositoryMariadb implements ProductRepositoryInterface, Closeable{
    /**
     * Accès à la base de données (session)
     */
    protected Connection dbConnection ;

    /**
     * Constructeur de la classe
     * @param infoConnection chaîne de caractères avec les informations de connexion
     *                       (p.ex. jdbc:mariadb://mysql-[compte].alwaysdata.net/[compte]_library_db
     * @param user chaîne de caractères contenant l'identifiant de connexion à la base de données
     * @param pwd chaîne de caractères contenant le mot de passe à utiliser
     */
    public ProductRepositoryMariadb(String infoConnection, String user, String pwd ) throws java.sql.SQLException, java.lang.ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        dbConnection = DriverManager.getConnection( infoConnection, user, pwd ) ;
    }

    @Override
    public void close() {
        try{
            dbConnection.close();
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Product getProduct(String reference) {

        Product myProduct = null;

        String query = "SELECT * FROM Product WHERE reference=?";

        // construction et exécution d'une requête préparée
        try ( PreparedStatement ps = dbConnection.prepareStatement(query) ){
            ps.setString(1, reference);

            // exécution de la requête
            ResultSet result = ps.executeQuery();

            // récupération du premier (et seul) tuple résultat
            // (si la référence du produit est valide)
            if( result.next() )
            {
                String name = result.getString("name");
                double prixKg = result.getDouble("prix_kg");

                // création de l'objet Produit
                myProduct = new Product(reference, name, prixKg);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myProduct;
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> listProducts ;

        String query = "SELECT * FROM Product";

        // construction et exécution d'une requête préparée
        try ( PreparedStatement ps = dbConnection.prepareStatement(query) ){
            // exécution de la requête
            ResultSet result = ps.executeQuery();

            listProducts = new ArrayList<>();

            // récupération du premier (et seul) tuple résultat
            while ( result.next() )
            {
                String reference = result.getString("reference");
                String name = result.getString("name");
                double prixKg = result.getDouble("prix_kg");

                // création du produit courant
                Product currentProduct= new Product(reference, name, prixKg);

                listProducts.add(currentProduct);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listProducts;
    }

    @Override
    public boolean updateProduct(String reference, String name, double prixKg) {
        String query = "UPDATE Product SET name=?, prix_kg=?  where reference=?";
        int nbRowModified = 0;

        // construction et exécution d'une requête préparée
        try ( PreparedStatement ps = dbConnection.prepareStatement(query) ){
            ps.setString(1, name);
            ps.setDouble(2, prixKg);
            ps.setString(3, reference );

            // exécution de la requête
            nbRowModified = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ( nbRowModified != 0 );
    }

}
