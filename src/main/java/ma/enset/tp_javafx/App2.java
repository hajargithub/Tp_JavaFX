package ma.enset.tp_javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App2 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = FXMLLoader.load(getClass().getResource("prodducts.fxml"));
        Scene scene = new Scene(root,450,600);
        // Lier le fichier CSS à la scène
        scene.getStylesheets().add(getClass().getResource("StyleSheet.css").toString());
        stage.setScene(scene);
        stage.setTitle("Prodducts");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
