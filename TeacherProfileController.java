import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TeacherProfileController implements Initializable {

    @FXML
    private Label Gender;

    @FXML
    private Label idLabel;

    @FXML
    private JFXButton editProfileBtn;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private JFXButton logoutBtn;

    @FXML
    private Label middleNameLabel;

    @FXML
    private JFXButton profileBtn;

    @FXML
    private JFXButton studentInfoBtn;

    @FXML
    private Label userNameLabel;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        logoutBtn.setOnAction(e -> {
            AnchorPane root;
            try {
                root = FXMLLoader.load(getClass().getResource("Scene/Login.fxml"));
                Stage stage = (Stage) logoutBtn.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e1) {

                e1.printStackTrace();
            }

        });

    }

}
