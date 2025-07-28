package ma.enset.tp_javafx;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/ma/enset/tp_javafx/product-view.fxml"));
        Scene scene = new Scene(root, 400, 400);
        scene.getStylesheets().add(getClass().getResource("/ma/enset/tp_javafx/StyleSheet.css").toExternalForm());

        primaryStage.setTitle("Gestion des Produits");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
