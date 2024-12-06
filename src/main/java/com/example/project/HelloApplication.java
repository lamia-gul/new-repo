package com.example.project;//package com.example.project;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class HelloApplication extends Application {
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//    }
//
//
//    public static void main(String[] args) {
//        launch();
//    }
//}
//
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Root layout
        Pane root = new Pane();
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #301934, #1a0e20);");

        // Add decorations to the walls
        ImageView bats = createImageView("bats.png", 50, 50, 300, 150);
        ImageView mask = createImageView("mask.png", 200, 100, 100, 150);

        // Add furniture
        Region bed = createFurniture(100, 300, 400, 200, "#3b1b1b");
        Region table = createFurniture(550, 300, 200, 100, "#3e3e3e");

        // Add lighting effects
        DropShadow lampGlow = new DropShadow(40, Color.ORANGE);
        Region lamp = createFurniture(120, 260, 40, 80, "#ffcc00");
        lamp.setEffect(lampGlow);

        // Add glowing pumpkins
        ImageView pumpkin1 = createImageView("pumpkin1.png", 600, 400, 100, 100);
        pumpkin1.setEffect(new DropShadow(50, Color.ORANGE));

        // Add text
        Text spookyText = new Text(300, 100, "Happy Haunting!");
        spookyText.setFill(Color.ORANGE);
        spookyText.setStyle("-fx-font-size: 30px; -fx-font-family: 'Serif';");

        // Add all components to the layout
        root.getChildren().addAll(bats, mask, bed, table, lamp, pumpkin1, spookyText);

        // Scene setup
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Monster's Room");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ImageView createImageView(String fileName, double x, double y, double width, double height) {
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("Style.css")));
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        return imageView;
    }

    private Region createFurniture(double x, double y, double width, double height, String color) {
        Region furniture = new Region();
        furniture.setLayoutX(x);
        furniture.setLayoutY(y);
        furniture.setPrefSize(width, height);
        furniture.setStyle("-fx-background-color: " + color + "; -fx-border-radius: 5px;");
        return furniture;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

