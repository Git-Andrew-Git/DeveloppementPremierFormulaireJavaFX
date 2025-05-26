package fr.andrew.developpementpremierformulaire;

import com.jfoenix.controls.JFXDecorator;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {

    // TODO ajouter "transitive" après "requires" de la ligne "requires org.controlsfx.controls" du fichier "module-info"
    @Override
    public void start(Stage stage) throws IOException {


//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        var vBox = new VBox();
//        var label = new Label("Hi!!");
//        Button button = new Button("Quitter");
//
//        label.setTextFill(Color.ORANGE);
//        label.setBorder(Border.stroke(Color.DARKCYAN));
//        label.setText("Bye");
//
//        label.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 36));
//        label.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-border-style: dashed;");
//
//        button.setStyle("-fx-background-color: #4CAF50;" +
//                "-fx-text-fill: white;" +
//                "-fx-font-size: 50px;" +
//                "-fx-padding: 10px 20px;" +
//                "-fx-border-color: blue;" +
//                "-fx-border-width: 16px;" +
//                "-fx-border-radius: 15px;");
//
//        button.setOnAction(actionEvent -> getHostServices().showDocument("https://www.mememaker.net/static/images/memes/4893099.jpg"));
//
//        vBox.getChildren().add(label);
//        vBox.getChildren().add(button);
//        vBox.setSpacing(50);
//
//        vBox.setAlignment(Pos.CENTER);
//
//        Scene scene = new Scene(vBox, 1024, 720);
//        stage.setTitle("Program");
//        stage.setScene(scene);
//        stage.show();

        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        for (int i = 0; i < 7; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100/7);
            root.getColumnConstraints().add(colConst);
        }

        for (int i = 0; i < 5; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / 5); // Distribute height evenly
            root.getRowConstraints().add(rowConst);
        }



        var label1 = new Label("Entrée utilisateur :");
        var label2 = new Label("Copie de l'entrée :");
        var button1 = new Button("Recopier");
        var button2 = new Button("Effacer");
        var button3 = new Button("Quitter");
        button3.setOnAction(actionEvent -> stage.close());

        var textField1 = new TextField();
        var textField2 = new TextField();
        button1.setOnAction(actionEvent -> {
            String text = textField1.getText();
            textField2.setText(text);
        });
        button2.setOnAction(actionEvent -> textField2.setText(""));

        textField1.setPromptText("Saisissez un texte");
        textField2.setPromptText("Saisissez un texte");
//        root.setGridLinesVisible(true);

        root.add(label1, 0, 1, 2, 1);
        root.add(label2,0,3, 2, 1);
        root.add(textField1, 2, 1, 3, 1);
        root.add(textField2, 2, 3, 3, 1);

        VBox vBox = new VBox();
        root.add(vBox, 5, 0, 2, 5);

        Pane spacerTop = new Pane();
        Pane spacer1 = new Pane();
        Pane spacer2 = new Pane();
        Pane spacerBotton = new Pane();

        VBox.setVgrow(spacerTop, Priority.ALWAYS);
        VBox.setVgrow(spacer1, Priority.ALWAYS);
        VBox.setVgrow(spacer2, Priority.ALWAYS);
        VBox.setVgrow(spacerBotton, Priority.ALWAYS);
        vBox.getChildren().addAll(spacerTop, button1, spacer1, button2, spacer2, button3, spacerBotton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10));
        VBox.setMargin(button1, new Insets(8));
        VBox.setMargin(button2, new Insets(8));
        VBox.setMargin(button3, new Insets(8));

        button1.setPadding(new Insets(5));
        button2.setPadding(new Insets(5));
        button3.setPadding(new Insets(5));


        VBox.setVgrow(button1, Priority.ALWAYS);
        VBox.setVgrow(button2, Priority.ALWAYS);
        VBox.setVgrow(button3, Priority.ALWAYS);

        button1.setMaxWidth(Double.MAX_VALUE);
        button2.setMaxWidth(Double.MAX_VALUE);
        button3.setMaxWidth(Double.MAX_VALUE);


//        root.add(button1, 5,0, 2, 2);
//        root.add(button2, 5,2, 2, 1);
//        root.add(button3, 5,3, 2,2);

        GridPane.setHalignment(label1, HPos.CENTER);
        GridPane.setHalignment(label2, HPos.CENTER);
        GridPane.setHalignment(textField1, HPos.CENTER);
        GridPane.setHalignment(textField2, HPos.CENTER);
//        GridPane.setHalignment(button1, HPos.CENTER);
//        GridPane.setHalignment(button2, HPos.CENTER);
//        GridPane.setHalignment(button3, HPos.CENTER);
        GridPane.setHalignment(vBox, HPos.CENTER);

        GridPane.setValignment(label1, VPos.CENTER);
        GridPane.setValignment(label2, VPos.CENTER);
        GridPane.setValignment(textField1, VPos.CENTER);
        GridPane.setValignment(textField2, VPos.CENTER);
//        GridPane.setValignment(button1, VPos.CENTER);
//        GridPane.setValignment(button2, VPos.CENTER);
//        GridPane.setValignment(button3, VPos.CENTER);
        GridPane.setValignment(vBox, VPos.CENTER);
        root.setStyle("-fx-background-color: beige");


        Scene scene = new Scene(root);
        JFXDecorator decorator = new JFXDecorator(stage, scene.getRoot());
        decorator.setCustomMaximize(true);

        Scene decoratedScene = new Scene(decorator);
        stage.setScene(decoratedScene);

        // === Load External CSS File ===
        // J'apprécie particulièrement le style :)
        URL cssUrl = getClass().getResource("/fr/andrew/developpementpremierformulaire/styles.css");
        if (cssUrl != null) {
            decoratedScene.getStylesheets().add(cssUrl.toExternalForm());
            System.out.println("CSS loaded from: " + cssUrl.toExternalForm());
        } else {
            System.err.println("Error: styles.css NOT FOUND!");
        }

        stage.setTitle("Formulaire");

        // === Manually Set Title Bar Background Color ===
        Platform.runLater(() -> {
            try {
                // Try accessing the title bar using the correct selector
                Pane titleBar = (Pane) decorator.lookup(".title-bar");
                if (titleBar != null) {
                    titleBar.setStyle("-fx-background-color: #1E90FF;");
                } else {
                    System.err.println("Error: Could not find .title-bar");
                }

                // Also style button pane just in case
                Pane buttonPane = (Pane) decorator.lookup(".window-buttons");
                if (buttonPane != null) {
                    buttonPane.setStyle("-fx-background-color: #1E90FF;");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            // Optional: Force repaint by slightly resizing window
            stage.sizeToScene();
            stage.setWidth(stage.getWidth() + 1);
        });

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}