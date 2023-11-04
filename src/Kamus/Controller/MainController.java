package Kamus.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;
import Kamus.Tree;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class MainController implements Initializable {

    @FXML
    private ImageView imgSwap;
    
    @FXML
    private TextField tfInput;

    @FXML
    private TextField tfOutput;

    @FXML
    private TextArea tfDeskripsi;

    @FXML
    private TextArea tfDesc;

    @FXML
    private AnchorPane Lindo;

    @FXML
    private AnchorPane Linggris;

    
    private int swap = 0;
    Tree IdEnTree = new Tree();  // Indonesia -> English
    Tree EnIdTree = new Tree();  // English -> Indonesia 
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String[] stringArray = new String[82];

        try {
            String filename = "KataKunci.txt";
            String absoluteFilePath = "";
            String workingDir = System.getProperty("user.dir") + "\\src\\Kamus\\Data";

            absoluteFilePath = workingDir + File.separator + filename;
            FileReader fileReader = new FileReader(absoluteFilePath);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                int i = 0 ;
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringArray[i] =  line.replaceAll("\\s", "");
                    i++;
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        for (int i = 0; i < stringArray.length; i +=2) {
            if (i + 1 < stringArray.length) {
                IdEnTree.add(stringArray[i], stringArray[i+1]);
            }
        }
        for (int i = 0; i < stringArray.length; i +=2) {
            if (i + 1 < stringArray.length) {
                EnIdTree.add(stringArray[i + 1], stringArray[i]);
            }
        }
    }
    
    void IDNtoENG(String key){
        if (IdEnTree.search(key) == true){
            tfOutput.setText(IdEnTree.getResult(key));
        }
        else{
            tfOutput.setText(". . .");
        }
    }

    void ENGtoIDN(String value){
        if (EnIdTree.search(value) == true){
            tfOutput.setText(EnIdTree.getResult(value));
        }
        else{
            tfOutput.setText(". . .");
        }
    }
    @FXML
    void btnExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnSubmit(ActionEvent event) {
        if (tfInput.getText() != null){
            if (swap % 2 == 0) {
                IDNtoENG(tfInput.getText());
            }
            else {
                ENGtoIDN(tfInput.getText());
            }
        }

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

            tfInput.setPromptText("Translate");
            tfInput.setText(null);
            tfOutput.setPromptText("Terjemahan");
            tfOutput.setText(null);

        }

        else{
            Lindo.setTranslateX(0);
            Linggris.setTranslateX(0);
            tfInput.setPromptText("Terjemahan");
            tfInput.setText(null);
            tfOutput.setPromptText("Translate");
            tfOutput.setText(null);
        }



    }


}
