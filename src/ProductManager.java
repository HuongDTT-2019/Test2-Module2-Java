import java.util.ArrayList;
public interface ProductManager{
     ArrayList<Product> showListProduct();
      boolean addProduct(Product product);
      boolean editProduct(Product product);
      boolean removeProduct(int id);
      int searchProduct(int id);
      void sortProduct();
}
