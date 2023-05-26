package de.oszimt.presentation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFX_Hello extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //TODO Auto-generated method stub
        Button button1 = new Button("Say, Hello World!");
        button1.setOnAction(e -> System.out.println("Hello World!"));


        /*
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
         */

        StackPane root = new StackPane();
        root.getChildren().add(button1);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setTitle("Hello World!");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
