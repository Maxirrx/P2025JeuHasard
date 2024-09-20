package p2025jeuhasardetudiant;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    public void start(Stage stage) throws IOException {

        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2025jeuhasardetudiant/views/ihm_421_Etudiant.fxml"));
        final Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();

    }
}
