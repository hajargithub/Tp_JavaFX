package ma.enset.tp_javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ProductController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;

    @FXML
    private Button addButton;

    @FXML
    private ListView<Product> productListView;

    @FXML
    private Text errorMessage;

    private ObservableList<Product> productList;

    @FXML
    public void initialize() {
        productList = FXCollections.observableArrayList();
        productListView.setItems(productList);
    }

    @FXML
    private void addProduct() {
        String name = nameField.getText();
        String priceText = priceField.getText();

        if (name.isEmpty() || priceText.isEmpty()) {
            errorMessage.setText("Tous les champs sont obligatoires.");
            return;
        }

        try {
            double price = Double.parseDouble(priceText);
            Product product = new Product(name, price);
            productList.add(product);
            nameField.clear();
            priceField.clear();
            errorMessage.setText("");
        } catch (NumberFormatException e) {
            errorMessage.setText("Le prix doit être un nombre valide.");
        }
    }
}