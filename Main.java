package com.example.colorpicker;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    ScrollBar redScrollBar;
    ScrollBar blueScrollBar;
    ScrollBar greenScrollBar;
    Color color=Color.rgb(127,127,127,1);
    @Override
    public void start(Stage stage) throws IOException {

        Font font=new Font("Arial",15);
        Label redLabel=new Label("Red");
        Label blueLabel=new Label("Blue");
        Label greenLabel=new Label("Green");
        Rectangle selectedColor=new Rectangle();
        redScrollBar=new ScrollBar();
        blueScrollBar=new ScrollBar();
        greenScrollBar=new ScrollBar();


        Image image = new Image(getClass().getResourceAsStream("/images/face-look-down.jpg"));


        redLabel.setLayoutX(80);
        redLabel.setLayoutY(50);
        redLabel.setFont(font);


        greenLabel.setLayoutX(80);
        greenLabel.setLayoutY(80);
        greenLabel.setFont(font);


        blueLabel.setLayoutX(80);
        blueLabel.setLayoutY(110);
        blueLabel.setFont(font);


        selectedColor.setStroke(Color.BLACK);
        selectedColor.setFill(Color.BLACK);
        selectedColor.setLayoutX(310);
        selectedColor.setLayoutY(50);
        selectedColor.setHeight(60);
        selectedColor.setWidth(150);
        selectedColor.setFill(color);

        redScrollBar.setBlockIncrement(1);
        redScrollBar.setMin(0);
        redScrollBar.setMax(255);
        redScrollBar.setValue(127);
        redScrollBar.setOrientation(Orientation.HORIZONTAL);
        redScrollBar.setLayoutX(150);
        redScrollBar.setLayoutY(50);
        redScrollBar.setPrefSize(120,7);


        greenScrollBar.setBlockIncrement(1);
        greenScrollBar.setMin(0);
        greenScrollBar.setMax(255);
        greenScrollBar.setValue(127);
        greenScrollBar.setOrientation(Orientation.HORIZONTAL);
        greenScrollBar.setLayoutX(150);
        greenScrollBar.setLayoutY(80);
        greenScrollBar.setPrefSize(120,7);

        blueScrollBar.setBlockIncrement(1);
        blueScrollBar.setMin(0);
        blueScrollBar.setMax(255);
        blueScrollBar.setValue(127);
        blueScrollBar.setOrientation(Orientation.HORIZONTAL);
        blueScrollBar.setLayoutX(150);
        blueScrollBar.setLayoutY(110);
        blueScrollBar.setPrefSize(120,7);

        redScrollBar.setStyle("-fx-background-color: red");
        greenScrollBar.setStyle("-fx-background-color: green");
        blueScrollBar.setStyle("-fx-background-color: blue");

        ChangeListener listener=new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                int red=(int)redScrollBar.getValue();
                int green=(int)greenScrollBar.getValue();
                int blue=(int)blueScrollBar.getValue();

                color=Color.rgb(red,green,blue,1);
                selectedColor.setFill(color);

            }
        };
        redScrollBar.valueProperty().addListener(listener);
        greenScrollBar.valueProperty().addListener(listener);
        blueScrollBar.valueProperty().addListener(listener);


        Group group=new Group();
        group.getChildren().addAll(redLabel,blueLabel,greenLabel,redScrollBar,greenScrollBar,
                blueScrollBar,selectedColor);
        Scene scene=new Scene(group,540,180);
        stage.setScene(scene);


        stage.setTitle("Color Picker");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}