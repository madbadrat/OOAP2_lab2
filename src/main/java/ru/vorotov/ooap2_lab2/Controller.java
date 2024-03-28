package ru.vorotov.ooap2_lab2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ImageView shrekImage;
    @FXML
    private ImageView qrImage;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField otpField;

    private User user;
    private Authentication authentication;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        shrekImage.setVisible(false);
    }

    public void onRegButtonClick(ActionEvent actionEvent) {
        authentication = new BaseAuthentication();
        user = new User(loginField.getText(), passwordField.getText());
    }

    public void onLoginButtonClick(ActionEvent actionEvent) {
        if (authentication instanceof TwoFAAuthentication) {
            if (((TwoFAAuthentication) authentication).authenticate(user, loginField.getText(), passwordField.getText(), Integer.parseInt(otpField.getText()))) {
                shrekImage.setVisible(true);
            }
        } else if (authentication instanceof BaseAuthentication) {
            if (authentication.authenticate(user, loginField.getText(), passwordField.getText())) {
                shrekImage.setVisible(true);
            }
        }
    }

    public void onExitButtonClick(ActionEvent actionEvent) {
        shrekImage.setVisible(false);
        qrImage.setVisible(false);
        loginField.setText("");
        passwordField.setText("");
        otpField.setText("");
    }

    public void onAdd2FAButtonClick(ActionEvent actionEvent) {
        if (shrekImage.isVisible()) {
            authentication = new TwoFAAuthentication(qrImage);
            qrImage.setVisible(true);
        }
    }
}