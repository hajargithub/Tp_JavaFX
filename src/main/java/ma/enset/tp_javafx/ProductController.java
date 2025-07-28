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
    private Product selectedProduct;

    @FXML
    public void initialize() {
        productList = FXCollections.observableArrayList();
        productListView.setItems(productList);

        productListView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null) {
                selectedProduct = newValue;
                nameField.setText(newValue.getName());
                priceField.setText(String.valueOf(newValue.getPrice()));
                errorMessage.setText("");
            }
        });
    }

    @FXML
    public void addProduct() {
        String name = nameField.getText().trim();
        String priceText = priceField.getText().trim();

        if (name.isEmpty() || priceText.isEmpty()) {
            errorMessage.setText("Champs requis manquants.");
            return;
        }

        try {
            double price = Double.parseDouble(priceText);

            if (selectedProduct != null) {
                // Modifier produit existant
                selectedProduct.setName(name);
                selectedProduct.setPrice(price);
                productListView.refresh(); // Mettre à jour l'affichage
                selectedProduct = null;
            } else {
                // Ajouter nouveau produit
                Product newProduct = new Product(name, price);
                productList.add(newProduct);
            }

            nameField.clear();
            priceField.clear();
            errorMessage.setText("");

        } catch (NumberFormatException e) {
            errorMessage.setText("Le prix doit être un nombre.");
        }
    }

    @FXML
    public void deleteProduct() {
        Product selected = productListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            productList.remove(selected);
            nameField.clear();
            priceField.clear();
            errorMessage.setText("");
            selectedProduct = null;
        } else {
            errorMessage.setText("Aucun produit sélectionné.");
        }
    }
}