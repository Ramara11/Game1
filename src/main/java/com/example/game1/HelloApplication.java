package com.example.game1;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        Scene scene = new Scene(root, 1000, 500);
        String style = getClass().getResource("/style.css").toExternalForm();
        scene.getStylesheets().add(style);
        root.setId("pane");

        Label score = new Label("Score-->");
        Label count = new Label();
        score.setId("gm1");
        count.relocate(90,0);

        Circle enemy = createEnemy(scene);
        ImageView ship = createShip(scene);
        ImageView img= createcloud(scene);
        ImageView clud= createcloud2(scene);
        ImageView clud2= cloud(scene);
        ImageView clud3= cld(scene);
        ImageView clud4=cld2(scene);
        ImageView clud5=cld3(scene);
        ImageView clud6=cld4(scene);
        ImageView clud7=cld5(scene);
        ImageView leru=createcloud3(scene);

        ImageView coiin= coin(scene);
        ImageView coin1= coin1(scene);
        coin1.setX(2000);
        coin1.setY(200);
        coiin.setX(700);
        coiin.setY(200);


        root.getChildren().addAll(ship,img,clud,clud2,clud3,clud4,clud5,clud6,clud7,leru,coiin,coin1,score,count);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            double x = ship.getX();
            double y = ship.getY();

            switch (event.getCode()){
                case RIGHT -> ship.setX(x + 10);
                case LEFT -> ship.setX(x - 10);
                case UP -> ship.setY(y - 10);
                case DOWN -> ship.setY(y + 10);
            }
            int XF=0;
            if (ship.getBoundsInParent().intersects(leru.getBoundsInParent())||ship.getBoundsInParent().intersects(clud7.getBoundsInParent())){
                scene.addEventFilter(KeyEvent.KEY_PRESSED,keyEvent -> {
                    Label Go=new Label("GAME OVER");
                    Go.relocate(450,200);
                    Go.setId("gm");
                    root.getChildren().remove(ship);
                    root.getChildren().add(Go);
                    double x2= ship.getX();
                    double y2= ship.getY();

                    switch (keyEvent.getCode()) {
                        case RIGHT -> ship.setX(x2 + 0);
                        case LEFT -> ship.setX(x2 - 0);
                        case UP -> ship.setY(y2 - 0);
                        case DOWN -> ship.setY(y2 + 0);
                    }


                });
            }

            else if(ship.getBoundsInParent().intersects(coiin.getBoundsInParent())){
                XF=+10;
                coiin.setVisible(false);
                count.setText("M"+XF);
                count.setId("gm1");
                score.setId("gm1");
            }
        });

        stage.setTitle("GAME PLAYING!");
        stage.setMaxWidth(1000);
        stage.setMaxHeight(700);
        stage.setScene(scene);
        stage.show();
        stage.setScene(scene);
        stage.setMaxWidth(1090);
        stage.setMaxHeight(750);
        stage.show();
    }


    private Circle createEnemy(Scene scene) {
        int radius = 30;
        Circle enemy = new Circle(radius);
        enemy.setCenterX(scene.getWidth()+50);
        enemy.setCenterY(scene.getHeight()-50);
        enemy.setFill(Color.valueOf("EF5350"));
        TranslateTransition tt = new TranslateTransition(Duration.millis(20000), enemy);
        tt.setByX(scene.getHeight()*-2);
        tt.setCycleCount(Integer.MAX_VALUE);

        tt.play();

        return enemy;
    }

    private ImageView createShip(Scene scene) {
        ImageView image = new ImageView(new Image("jet1.png"));
        image.setFitWidth(350);
        image.setPreserveRatio(true);
        image.setY(scene.getHeight()- 500);
        return image;
    }

    private ImageView createcloud2(Scene scene) {
        ImageView img = new ImageView(new Image("clou.png"));
        img.setFitWidth(450);
        img.setPreserveRatio(true);
        img.setY(scene.getHeight()- 500);
        img.setX(scene.getHeight()+400);
        TranslateTransition tt = new TranslateTransition(Duration.millis(20000), img);
        tt.setByX(scene.getHeight()*-4);
        tt.setCycleCount(Integer.MAX_VALUE);
        tt.play();

        return img;
    }
    private ImageView createcloud3(Scene scene) {
        ImageView img = new ImageView(new Image("leru.png"));
        img.setFitWidth(450);
        img.setPreserveRatio(true);
        img.setX(scene.getHeight()+650);
        img.setY(scene.getWidth()- 800);
        //img.setY(scene.getWidth()- 100);
        TranslateTransition tt = new TranslateTransition(Duration.millis(20000), img);
        tt.setByX(scene.getHeight()*-5);
        tt.setCycleCount(Integer.MAX_VALUE);
        tt.play();

        return img;
    }
    private ImageView createcloud(Scene scene) {
        ImageView image1 = new ImageView(new Image("leru.png"));
        image1.setFitWidth(250);
        image1.setPreserveRatio(true);
        image1.setY(scene.getHeight()- 500);
        image1.setX(scene.getHeight()+350);
        image1.setY(scene.getWidth()- 1000);
        TranslateTransition tt = new TranslateTransition(Duration.millis(17000), image1);
        tt.setByX(scene.getHeight()*-2);
        tt.setCycleCount(Integer.MAX_VALUE);
        tt.play();

        return image1;
    }
    private ImageView cloud(Scene scene) {
        ImageView image1 = new ImageView(new Image("leru.png"));
        image1.setFitWidth(150);
        image1.setPreserveRatio(true);
        image1.setY(scene.getHeight()- 500);
        image1.setX(scene.getHeight()+250);
        image1.setY(scene.getWidth()- 1000);
        TranslateTransition tt = new TranslateTransition(Duration.millis(30000), image1);
        tt.setByX(scene.getHeight()*-2);
        tt.setCycleCount(Integer.MAX_VALUE);
        tt.play();

        return image1;
    }
    private ImageView cld(Scene scene) {
        ImageView image1 = new ImageView(new Image("clouud.png"));
        image1.setFitWidth(150);
        image1.setPreserveRatio(true);
        image1.setY(scene.getHeight()- 500);
        image1.setX(scene.getHeight()+250);
        image1.setY(scene.getWidth()- 1000);
        TranslateTransition tt = new TranslateTransition(Duration.millis(10000), image1);
        tt.setByX(scene.getHeight()*-2);
        tt.setCycleCount(Integer.MAX_VALUE);
        tt.play();

        return image1;
    }
    private ImageView cld2(Scene scene) {
        ImageView image1 = new ImageView(new Image("clou.png"));
        image1.setFitWidth(250);
        image1.setPreserveRatio(true);
        image1.setY(scene.getHeight()- 500);
        image1.setX(scene.getHeight()+450);
        image1.setY(scene.getWidth()- 1000);
        TranslateTransition tt = new TranslateTransition(Duration.millis(10000), image1);
        tt.setByX(scene.getHeight()*-3);
        tt.setCycleCount(Integer.MAX_VALUE);
        tt.play();

        return image1;
    }
    private ImageView cld3(Scene scene) {
        ImageView image1 = new ImageView(new Image("leru.png"));
        image1.setFitWidth(150);
        image1.setPreserveRatio(true);
        image1.setY(scene.getHeight()- 500);
        image1.setX(scene.getHeight()+200);
        image1.setY(scene.getWidth()- 1000);
        TranslateTransition tt = new TranslateTransition(Duration.millis(13000), image1);
        tt.setByX(scene.getHeight()*-3);
        tt.setCycleCount(Integer.MAX_VALUE);
        tt.play();

        return image1;
    }
    private ImageView cld4(Scene scene) {
        ImageView image1 = new ImageView(new Image("clou.png"));
        image1.setFitWidth(200);
        image1.setPreserveRatio(true);
        image1.setY(scene.getHeight()- 500);
        image1.setX(scene.getHeight()+450);
        image1.setY(scene.getWidth()- 900);
        TranslateTransition tt = new TranslateTransition(Duration.millis(13000), image1);
        tt.setByX(scene.getHeight()*-3);
        tt.setCycleCount(Integer.MAX_VALUE);
        tt.play();

        return image1;
    }
    private ImageView cld5(Scene scene) {
        ImageView image1 = new ImageView(new Image("clou.png"));
        image1.setFitWidth(250);
        image1.setPreserveRatio(true);
        //image1.setY(scene.getHeight()- 500);
        image1.setX(scene.getHeight()+650);
        image1.setY(scene.getWidth()- 800);
        TranslateTransition tt = new TranslateTransition(Duration.millis(9000), image1);
        tt.setByX(scene.getHeight()*-3);
        tt.setCycleCount(Integer.MAX_VALUE);
        tt.play();

        return image1;
    }
    private ImageView coin(Scene scene) {
        ImageView image1 = new ImageView(new Image("coin6.png"));
        image1.setFitWidth(100);
        image1.setPreserveRatio(true);
        //image1.setCenterX(scene.getWidth()+50);
        //image1.setCenterY(scene.getHeight()-50);
        image1.setY(scene.getHeight()- 60);
        image1.setX(scene.getWidth()+100);
        //image1.setY(scene.getWidth()- 800);
        TranslateTransition tt = new TranslateTransition(Duration.millis(9000), image1);
        tt.setByX(scene.getHeight()*-3);
        tt.setCycleCount(Integer.MAX_VALUE);
        tt.play();

        return image1;
    }
    private ImageView coin1(Scene scene) {
        ImageView image1 = new ImageView(new Image("coin6.png"));
        image1.setFitWidth(80);
        image1.setPreserveRatio(true);
        //image1.setCenterX(scene.getWidth()+50);
        //image1.setCenterY(scene.getHeight()-50);
        image1.setY(scene.getHeight()- 60);
        image1.setX(scene.getWidth()+100);
        //image1.setY(scene.getWidth()- 800);
        TranslateTransition tt = new TranslateTransition(Duration.millis(9000), image1);
        tt.setByX(scene.getHeight()*-3);
        tt.setCycleCount(Integer.MAX_VALUE);
        tt.play();

        return image1;
    }
    public static void main(String[] args) {
        launch();
    }
}