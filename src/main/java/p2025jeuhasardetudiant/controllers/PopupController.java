package p2025jeuhasardetudiant.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PopupController implements Initializable  {

    @FXML
    private Label lNbCoupGagneVal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setMajLabel(String nombre){
        lNbCoupGagneVal.setText(nombre);
    }

    @FXML
    private void bGagneClick(ActionEvent actionEvent) {
        Stage stage = (Stage) lNbCoupGagneVal.getScene().getWindow();
        stage.close();
    }
}
