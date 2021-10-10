package com.dad.adivinapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {
    private final int NUMEROSECRETO = 15;
    private int intentos = 0;
    private Label aciertoLabel;
    private Button comprobarButton;
    private TextField textoNumeros;
    private VBox rootPanel;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        aciertoLabel = new Label();
        aciertoLabel.setText("Introduce un numero del 1 al 100");

        textoNumeros = new TextField();
        textoNumeros.setMaxWidth(150);
        textoNumeros.setAlignment(Pos.CENTER);

        comprobarButton = new Button();
        comprobarButton.setText("Comprobar");
        comprobarButton.setOnAction(e -> onComprobarButtonAction(e, intentos));

        rootPanel = new VBox();
        rootPanel.setSpacing(15);
        rootPanel.setAlignment(Pos.CENTER);
        rootPanel.getChildren().addAll(aciertoLabel, textoNumeros, comprobarButton);

        Scene scene = new Scene(rootPanel, 320, 200);

        primaryStage.setTitle("AdivinApp");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void onComprobarButtonAction(ActionEvent e, int intentos) {
        try {
            int numeroInput = Integer.parseInt(textoNumeros.getText());
            intentos++;

            Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
            alertInformation.setTitle("AdivinApp");
            alertInformation.setHeaderText("¡Has ganado!");
            alertInformation.setContentText("Sólo has necesitado " + intentos + " intentos\n\n" + "Vuelve a jugar y hazlo mejor.");

            Alert alertWarning = new Alert(Alert.AlertType.WARNING);
            alertWarning.setTitle("AdivinApp");
            alertWarning.setHeaderText("¡Has fallado!");
            alertWarning.setContentText("El numero a adivinar" + (numeroInput < NUMEROSECRETO ? " es mayor que " + numeroInput : " es menor que " + numeroInput) + "\n\nVuelve a intentarlo");
            if (numeroInput < 100) {
                if (NUMEROSECRETO == numeroInput) {
                    alertInformation.showAndWait();
                } else {
                    alertWarning.showAndWait();
                }
            } else {
                throw new NumberFormatException();
            }

        } catch (NumberFormatException exception) {
            Alert alertError = new Alert(Alert.AlertType.ERROR);
            alertError.setTitle("AdivinApp");
            alertError.setHeaderText("Error");
            alertError.setContentText("El número introducido no es válido");
            alertError.showAndWait();
        }

    }
}
