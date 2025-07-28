package ma.enset.tp_javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        HBox hbox = new HBox();
        Label labelNom = new Label("Nom : ");
        TextField NomField = new TextField();
        Button buttonAdd = new Button("Entrez");
        Button buttonDel= new Button("Supprimer");

        hbox.getChildren().addAll(labelNom, NomField,buttonAdd,buttonDel);
        hbox.setSpacing(3);
        root.setTop(hbox);
        ListView <String> listView = new ListView<>();
        root.setCenter(listView);
        // Définir le padding (espacement interne) du bouton
        root.setPadding(new Insets(5));
        // (top, right, bottom, left)
        hbox.setPadding(new Insets(5));
        Scene scene = new Scene(root, 600, 300);
        // Lier le fichier CSS à la scène
        scene.getStylesheets().add(getClass().getResource("StyleSheet.css").toString());
        stage.setScene(scene);
        stage.setTitle("Besties");
        stage.show();
        buttonAdd.setOnAction(e -> {
            String nom = NomField.getText();
            if (nom.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Veuillez entrer le nom");
                alert.showAndWait();
            }
            listView.getItems().add(nom);
            NomField.clear();
        });
        buttonDel.setOnAction(e -> {
            int index = listView.getSelectionModel().getSelectedIndex();
            if (index == -1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Veuillez séléctionner un produit!!!");
                alert.showAndWait();
            }else{
                listView.getItems().remove(index);
            };
        });

    }

    public static void main(String[] args) {
        launch();
    }
}