package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public ImageView imgView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    public void onOpenImage(ActionEvent actionEvent)  {
        final FileChooser fileChooser = new FileChooser();
        configureFileChooser(fileChooser);
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            try {
                BufferedImage i = ImageIO.read(file);
                WritableImage wi = new WritableImage(70, 70);
                SwingFXUtils.toFXImage(i, wi);
                System.out.println(imgView);
                imgView.setImage(wi);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void configureFileChooser(
            final FileChooser fileChooser) {
        fileChooser.setTitle("View Pictures");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("BPM", "*.bmp"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
    }
}
