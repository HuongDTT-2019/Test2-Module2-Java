import java.util.ArrayList;
import java.util.Comparator;

public class ProductManagerImpl implements ProductManager {
    private ArrayList<Product> listProduct;
    private final int NOT_FOULD = -1;

    public ProductManagerImpl() {
        listProduct = new ArrayList<>();
    }

    public ProductManagerImpl(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public ArrayList<Product> getListProduct() {
        return listProduct;
    }

    @Override
    public ArrayList<Product> showListProduct() {
        return listProduct;
    }

    private boolean isExistsProduct(Product product) {
        boolean isExists = false;
        if (listProduct != null) {
            for (Product value : listProduct) {
                boolean isMatchValue = value.getId() == product.getId();
                if (isMatchValue) {
                    isExists = true;
                    break;
                }
            }
        }
        return isExists;
    }

    @Override
    public boolean addProduct(Product product) {
        if (isExistsProduct(product)) {
            return false;
        } else {
            listProduct.add(product);
            return true;
        }
    }

    @Override
    public boolean editProduct(Product product) {
        int index = NOT_FOULD;
        for (int i = 0; i < listProduct.size(); i++) {
            boolean isSameID = listProduct.get(i).getId() == product.getId();
            if (isSameID) {
                index = i;
            }
        }
        if (index != NOT_FOULD) {
            listProduct.get(index).setName(product.getName());
            listProduct.get(index).setDescription(product.getDescription());
            listProduct.get(index).setPrice(product.getPrice());
            listProduct.get(index).setStatus(product.getStatus());

            return true;
        }
        return false;
    }

    @Override
    public boolean removeProduct(int id) {
        if (getIndexById(id) != NOT_FOULD) {
                listProduct.remove(getIndexById(id));
            return true;
        }
        return false;
    }

    @Override
    public int searchProduct(int id) {
        if (getIndexById(id) != NOT_FOULD) {
            return getIndexById(id);
        }
        return NOT_FOULD;
    }

    private int getIndexById(int id) {
        int index = NOT_FOULD;
        for (int i = 0; i < listProduct.size(); i++) {
            boolean isSameID = listProduct.get(i).getId() == id;
            if (isSameID) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void sortProduct() {
        listProduct.sort(Comparator.comparingDouble(Product::getPrice).reversed());
    }
}
