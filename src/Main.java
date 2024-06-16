import controller.ProductController;
import exception.ExceptionHandling;
import model.service.ProductServiceImpl;

public class Main {
    public static void main(String[] args) throws ExceptionHandling {
        new ProductController().addNewProduct();
        new ProductController().queryAllProducts().forEach(System.out::println);
    }
}