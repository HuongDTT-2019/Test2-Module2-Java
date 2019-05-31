import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int EXIT = 0;
        final int SHOW_PRODUCT = 1;
        final int ADD_PRODUCT = 2;
        final int EDIT_PRODUCT = 3;
        final int DELETE_PRODUCT = 4;
        final int SEARCH_PRODUCT = 5;
        final int SORT_PRODUCT = 6;
        final int NOT_FOULD = -1;
        Scanner input = new Scanner(System.in);
        int choice;
        ProductManagerImpl productManager = new ProductManagerImpl();
        ArrayList<Product> listProduct;
        do {
            menu();
            choice = input.nextInt();
            switch (choice) {
                case SHOW_PRODUCT:
                    listProduct = productManager.showListProduct();
                    for (Product product : listProduct) {
                        System.out.println("Id: " + product.getId() +
                                "\nName: " + product.getName() +
                                "\nDescription: " + product.getDescription() +
                                "\nPrice: " + product.getPrice() +
                                "\nStatus: " + product.getStatus());
                    }
                    break;
                case ADD_PRODUCT: {
                    Product product = inputProduct();
                    boolean result = productManager.addProduct(product);
                    if (!result) {
                        System.out.println("Da ton tai san pham");
                    } else {
                        System.out.println("Them thanh cong");
                    }
                    break;
                }
                case EDIT_PRODUCT: {
                    Product product = inputProduct();
                    boolean result = productManager.editProduct(product);
                    if (result) {
                        System.out.println("Sua thanh cong");
                    } else {
                        System.out.println("Khong tim thay san pham");
                    }
                    break;
                }
                case DELETE_PRODUCT: {
                    System.out.println("Nhap Id:");
                    int id = input.nextInt();
                    boolean result = productManager.removeProduct(id);
                    if (!result) {
                        System.out.println("Khong tim thay san pham");
                    } else {
                        System.out.println("Da xoa thanh cong");
                    }
                    break;
                }
                case SEARCH_PRODUCT: {
                    System.out.println("Nhap Id:");
                    int id = input.nextInt();
                    boolean isExist = productManager.searchProduct(id) != NOT_FOULD;
                    if (isExist) {
                        Product product = productManager.showListProduct().get(productManager.searchProduct(id));
                        System.out.println("Ket qua tim kiem:");
                        System.out.println("Id: " + product.getId() +
                                "\nName: " + product.getName() +
                                "\nDescription: " + product.getDescription() +
                                "\nPrice: " + product.getPrice() +
                                "\nStatus: " + product.getStatus());

                    } else {
                        System.out.println("Khong tim thay san pham");
                    }
                    break;
                }
                case SORT_PRODUCT: {
                    productManager.sortProduct();
                    break;
                }
                case EXIT:
                    System.out.println("Cancel");
                    break;
            }
        } while (choice != EXIT);

    }

    private static void menu() {
        System.out.println("\n-Quan ly san pham-");
        System.out.println("1. Hien thi danh sach san pham");
        System.out.println("2. Them san pham");
        System.out.println("3. Sua san pham");
        System.out.println("4. Xoa san pham");
        System.out.println("5. Tim kiem theo ma san pham");
        System.out.println("6. Sap xep theo gia san pham giam dan");
        System.out.println("0. Thoat");
        System.out.println("Nhap vao chon lua: ");
    }

    private static Product inputProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ID:");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Nhap Name:");
        String name = input.nextLine();
        System.out.println("Nhap mo ta:");
        String description = input.nextLine();
        System.out.println("Nhap gia san pham:");
        double price = input.nextDouble();
        input.nextLine();
        System.out.println("Nhap trang thai:");
        String status = input.nextLine();

        Product product = new Product(id, name, description, price, status);
        return product;
    }
}
