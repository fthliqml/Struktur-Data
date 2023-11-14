package Kamus.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import Kamus.Node;
import Kamus.Tree;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class MainController implements Initializable {

    @FXML
    private ImageView imgSwap;

    @FXML
    private ImageView imgGim1;

    @FXML
    private ImageView imgGim2;

    @FXML
    private Label lblDesc;

    @FXML
    private Label lblClock;

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

    @FXML
    private VBox vBox;

    private int swap = 0;
    private boolean gimmick = false;
    Tree IdEnTree = new Tree(); // Indonesia -> English
    Tree EnIdTree = new Tree(); // English -> Indonesia

    private void initClock() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            lblClock.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        imgGim1.setVisible(false);
        imgGim2.setVisible(false);
        lblClock.setVisible(false);
        initClock();

        String[] stringArray = new String[44];

        try {
            String filename = "KataKunci.txt";
            String absoluteFilePath = "";
            String workingDir = System.getProperty("user.dir") + "\\src\\Kamus\\Data";

            absoluteFilePath = workingDir + File.separator + filename;
            FileReader fileReader = new FileReader(absoluteFilePath);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                int i = 0;
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringArray[i] = line.replaceAll("\\s", " ");
                    i++;
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        for (int i = 0; i < stringArray.length; i += 4) {
            if (i + 1 < stringArray.length) {
                IdEnTree.add(stringArray[i], stringArray[i + 1], stringArray[i + 2], stringArray[i + 3]);
            }
        }
        for (int i = 0; i < stringArray.length; i += 4) {
            if (i + 1 < stringArray.length) {
                EnIdTree.add(stringArray[i + 1], stringArray[i], stringArray[i + 2], stringArray[i + 3]);
            }
        }
    }

    void IDNtoENG(String key) {
        if (IdEnTree.search(key) == true) {
            tfOutput.setText(IdEnTree.getValue(key));
            tfDeskripsi.setText(IdEnTree.getDescriptionId(tfInput.getText()));
            tfDesc.setText(EnIdTree.getDescriptionEn(IdEnTree.getValue(tfInput.getText())));
        } else {
            tfOutput.setText(". . .");
            tfDesc.setText(null);
            tfDeskripsi.setText(null);
        }
    }

    void ENGtoIDN(String value) {
        if (EnIdTree.search(value) == true) {
            tfOutput.setText(EnIdTree.getValue(value));
            tfDeskripsi.setText(IdEnTree.getDescriptionId(EnIdTree.getValue(tfInput.getText())));
            tfDesc.setText(EnIdTree.getDescriptionEn(tfInput.getText()));
        } else {
            tfOutput.setText(". . .");
            tfDesc.setText(null);
            tfDeskripsi.setText(null);
        }
    }

    public String strGimmick() {
        String gimmick = "";
        if (swap % 2 == 0) {
            if (IdEnTree.search(tfInput.getText()) == true) {
                Node node = IdEnTree.isExist(IdEnTree.getRoot(), tfInput.getText());
                gimmick = node.getGimmick();
                return gimmick;
            }
        } else if (swap % 2 == 1) {
            if (EnIdTree.search(tfInput.getText()) == true) {
                Node node = EnIdTree.isExist(EnIdTree.getRoot(), tfInput.getText());
                gimmick = node.getGimmick();
                return gimmick;
            }
        }
        return gimmick;
    }

    @FXML
    void btnExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnSubmit(ActionEvent event) {
        IdEnTree.inorderTraversal(IdEnTree.getRoot());

        if (gimmick == true) {
            lblDesc.setVisible(true);
            tfDesc.setVisible(true);
            tfDeskripsi.setVisible(true);
            lblClock.setVisible(false);
            imgGim1.setVisible(false);
            imgGim2.setVisible(false);

            gimmick = false;
        }

        if (tfInput.getText() != null) {
            if (swap % 2 == 0) {
                IDNtoENG(tfInput.getText());
            } else {
                ENGtoIDN(tfInput.getText());
            }

            if (strGimmick() != "") {
                if (strGimmick().compareTo("clock") == 0) {
                    // date Succeed
                    lblClock.setVisible(true);
                    gimmick = true;
                } else if (strGimmick().compareTo("erase") == 0) {
                    // hapus Succeed
                    lblDesc.setVisible(false);
                    tfDesc.setVisible(false);
                    tfDeskripsi.setVisible(false);
                    gimmick = true;
                } else if (strGimmick().compareTo("popup") == 0) {
                    // foto Succeed
                    lblDesc.setVisible(false);
                    tfDesc.setVisible(false);
                    tfDeskripsi.setVisible(false);
                    imgGim1.setVisible(true);
                    imgGim2.setVisible(true);
                    gimmick = true;
                } else if (strGimmick().compareTo("link") == 0) {
                    // map Succeed
                    gimmick = true;
                    try {
                        Runtime.getRuntime().exec(new String[] { "cmd", "/c", "start chrome https://maps.app.goo.gl/pAq67vZxGAdrWQfZA" });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (strGimmick().compareTo("spinning") == 0) {
                    RotateTransition rotate = new RotateTransition(Duration.seconds(1), vBox);
                    rotate.setByAngle(360);
                    rotate.play();
                }

            }
        }
    }

    @FXML
    void btnSwap(ActionEvent event) {
        swap++;
        String temp = "";
        RotateTransition rotate = new RotateTransition(Duration.seconds(0.3), imgSwap);
        rotate.setByAngle(180);
        rotate.play();

        if (swap % 2 == 1) {
            Lindo.setTranslateX(463);
            Linggris.setTranslateX(-463);

            tfInput.setPromptText("Translate");
            tfOutput.setPromptText("Terjemahan");

            if (tfInput.getText() != null) {
                if (IdEnTree.search(tfInput.getText()) == false) {
                    tfInput.setText(null);
                    tfOutput.setText(null);
                } else {
                    temp = tfInput.getText();
                    tfInput.setText(tfOutput.getText());
                    tfOutput.setText(temp);
                }
            }
        }

        else {
            Lindo.setTranslateX(0);
            Linggris.setTranslateX(0);
            tfInput.setPromptText("Terjemahan");
            tfOutput.setPromptText("Translate");

            if (tfInput.getText() != null) {
                if (EnIdTree.search(tfInput.getText()) == false) {
                    tfInput.setText(null);
                    tfOutput.setText(null);
                } else {
                    temp = tfInput.getText();
                    tfInput.setText(tfOutput.getText());
                    tfOutput.setText(temp);
                }
            }
        }
    }
}
