package Kamus.Controller;

import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class MainController {

    private int swap = 0;

    @FXML
    private ImageView imgSwap;
    
    @FXML
    private TextField tfIndo;

    @FXML
    private TextField tfInggris;

    @FXML
    private AnchorPane Lindo;

    @FXML
    private AnchorPane Linggris;
    
    @FXML
    void btnExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnSubmit(ActionEvent event) {

    }

    @FXML
    void btnSwap(ActionEvent event) {
        swap++;

        RotateTransition rotate = new RotateTransition(Duration.seconds(0.3), imgSwap);
        rotate.setByAngle(180);
        rotate.play();

        if (swap % 2 == 1){
            Lindo.setTranslateX(463);
            Linggris.setTranslateX(-463);

            tfIndo.setPromptText("Translate");
            tfIndo.setEditable(true);
            tfInggris.setPromptText("Terjemahan");
            tfInggris.setEditable(false);

        }

        else{
            Lindo.setTranslateX(-1);
            Linggris.setTranslateX(1);

            tfIndo.setPromptText("Terjemahan");
            tfIndo.setEditable(true);
            tfInggris.setPromptText("Translate");
            tfInggris.setEditable(false);
        }



    }

}
