package p2025jeuhasardetudiant.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class MainController implements Initializable {


    @FXML
    private  Label lDe1, lDe2, lDe3;
    @FXML
    private Random rand = new Random();
    @FXML
    private int monDe1 = 6;
    @FXML
    private int monDe2 = 6;
    @FXML
    private int monDe3 = 6;

    @FXML
    private Button bLancerAuto1, bModeAuto2;

    private int compteur = 0;
    private boolean fin = false;
    private boolean finDe1 = false;
    private boolean finDe2 = false;
    private boolean finDe3 = false;
    private Thread t;

    @FXML
    private TextField tfNbTentative;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void bTousLesDesClick(ActionEvent actionEvent) {
        monDe1 = rand.nextInt(1,7);
        monDe2 = rand.nextInt(1,7);
        monDe3 = rand.nextInt(1,7);

        this.lDe1.setText(Integer.toString(monDe1));
        this.lDe2.setText(Integer.toString(monDe2));
        this.lDe3.setText(Integer.toString(monDe3));
        compteur++;
        tfNbTentative.setText(Integer.toString(compteur));

        if ((monDe1 == 1 || monDe1 == 2 || monDe1 == 4) &&
                ((monDe2 == 1 || monDe2 == 2 || monDe2 == 4) && monDe2 != monDe1) &&
                ((monDe3 == 1 || monDe3 == 2 || monDe3 == 4) && monDe2 != monDe3 && monDe1 != monDe3)){

            reinitialisation();
        }


    }

    @FXML
    public void bDe1Click(ActionEvent actionEvent) {
        monDe1 = rand.nextInt(1,7);
        this.lDe1.setText(Integer.toString(monDe1));
        compteur++;
        tfNbTentative.setText(Integer.toString(compteur));
        if ((monDe1 == 1 || monDe1 == 2 || monDe1 == 4) &&
                ((monDe2 == 1 || monDe2 == 2 || monDe2 == 4) && monDe2 != monDe1) &&
                ((monDe3 == 1 || monDe3 == 2 || monDe3 == 4) && monDe2 != monDe3 && monDe1 != monDe3)){

            reinitialisation();
        }

    }

    @FXML
    public void bDe2Click(ActionEvent actionEvent) {
        monDe2 = rand.nextInt(1,7);
        this.lDe2.setText(Integer.toString(monDe2));
        compteur++;
        tfNbTentative.setText(Integer.toString(compteur));
        if ((monDe1 == 1 || monDe1 == 2 || monDe1 == 4) &&
                ((monDe2 == 1 || monDe2 == 2 || monDe2 == 4) && monDe2 != monDe1) &&
                ((monDe3 == 1 || monDe3 == 2 || monDe3 == 4) && monDe2 != monDe3 && monDe1 != monDe3)){

            reinitialisation();
        }

    }

    @FXML
    public void bDe3Click(ActionEvent actionEvent) {
        monDe3 = rand.nextInt(1,7);
        this.lDe3.setText(Integer.toString(monDe3));
        compteur++;
        tfNbTentative.setText(Integer.toString(compteur));
        if ((monDe1 == 1 || monDe1 == 2 || monDe1 == 4) &&
                ((monDe2 == 1 || monDe2 == 2 || monDe2 == 4) && monDe2 != monDe1) &&
                ((monDe3 == 1 || monDe3 == 2 || monDe3 == 4) && monDe2 != monDe3 && monDe1 != monDe3)){

            reinitialisation();
        }

    }

    @FXML
    public void bLancerAuto1Click(ActionEvent actionEvent){

        bLancerAuto1.setDisable(true);
        new Thread(()->{
            while (!finDe1) {
                if (monDe1 == 1 || monDe1 == 2 || monDe1 == 4) {
                    finDe1 = true;
                } else {
                    monDe1 = rand.nextInt(0, 6);
                    compteur++;
                    Platform.runLater(()->{
                        this.lDe1.setText(Integer.toString(monDe1));
                        tfNbTentative.setText(Integer.toString(compteur));
                    });
                    try{
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
            while (!finDe2) {
                if ((monDe2 == 1 || monDe2 == 2 || monDe2 == 4) && monDe2 != monDe1) {
                    finDe2 = true;
                } else {
                    monDe2 = rand.nextInt(0, 6);
                    compteur++;
                    Platform.runLater(() -> {
                        this.lDe2.setText(Integer.toString(monDe2));
                        tfNbTentative.setText(Integer.toString(compteur));
                    });
                    try{
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
            while (!finDe3) {
                if ((monDe3 == 1 || monDe3 == 2 || monDe3 == 4) && monDe2 != monDe3 && monDe1 != monDe3) {
                    finDe3 = true;

                } else {
                    monDe3 = rand.nextInt(0, 6);
                    compteur++;
                    Platform.runLater(()->{
                        this.lDe3.setText(Integer.toString(monDe3));
                        tfNbTentative.setText(Integer.toString(compteur));
                    });
                    try{
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }

            Platform.runLater(()-> {
                bLancerAuto1.setDisable(false);
                reinitialisation();
            });
        }).start();

    }

    @FXML
    public void bLancerAuto2Click(ActionEvent actionEvent) {
        bModeAuto2.setDisable(true);
        new Thread(()->{
            while (!finDe1 || !finDe2 || !finDe3){
            if ((monDe1 == 1 || monDe1 == 2 || monDe1 == 4) && monDe2 != monDe1 && monDe3 != monDe1) {
                finDe1 = true;

            } else {
                monDe1 = rand.nextInt(0, 6);
                compteur++;
                Platform.runLater(()->{
                    this.lDe1.setText(Integer.toString(monDe1));
                    tfNbTentative.setText(Integer.toString(compteur));
                });
                try{
                    Thread.sleep(500);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
            if ((monDe2 == 1 || monDe2 == 2 || monDe2 == 4) && monDe2 != monDe3 && monDe1 != monDe2) {
                finDe2 = true;

            } else {
                monDe2 = rand.nextInt(0, 6);
                compteur++;
                Platform.runLater(()->{
                    this.lDe2.setText(Integer.toString(monDe2));
                    tfNbTentative.setText(Integer.toString(compteur));
                });
                try{
                    Thread.sleep(500);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
            if ((monDe3 == 1 || monDe3 == 2 || monDe3 == 4) && monDe2 != monDe3 && monDe1 != monDe3) {
                finDe3 = true;

            } else {
                monDe3 = rand.nextInt(0, 6);
                compteur++;
                Platform.runLater(()->{
                    this.lDe3.setText(Integer.toString(monDe3));
                    tfNbTentative.setText(Integer.toString(compteur));
                });
                try{
                    Thread.sleep(500);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        }

            Platform.runLater(()-> {
                bModeAuto2.setDisable(false);
                reinitialisation();
            });
        }).start();

    }

    public void reinitialisation() {
        showPopup();
        monDe1 = 6;
        monDe2 = 6;
        monDe3 = 6;
        compteur=0;
        fin=false;
        finDe1=false;
        finDe2=false;
        finDe3=false;
        tfNbTentative.setText(Integer.toString(compteur));
        this.lDe3.setText(Integer.toString(monDe3));
        this.lDe2.setText(Integer.toString(monDe2));
        this.lDe1.setText(Integer.toString(monDe1));
    }



    @FXML
    private void showPopup() {
        try {
            // Charger le fichier FXML pour la pop-up
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2025jeuhasardetudiant/views/ihm_421_popup_Etudiant.fxml"));
            Parent root = fxmlLoader.load();

            // Obtenir le contrôleur de la pop-up
            PopupController popupController = fxmlLoader.getController();

            // Passer la variable au contrôleur de la pop-up
            popupController.setMajLabel(Integer.toString(compteur));

            // Créer une nouvelle fenêtre (Stage)
            Stage stage = new Stage();
            stage.setTitle("Popup Window");
            stage.setScene(new Scene(root));

            // Configurer la fenêtre en tant que modal
            stage.initModality(Modality.APPLICATION_MODAL);

            // Afficher la fenêtre et attendre qu'elle se ferme
            stage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
