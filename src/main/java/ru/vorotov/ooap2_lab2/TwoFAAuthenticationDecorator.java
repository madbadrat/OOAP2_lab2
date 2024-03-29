package ru.vorotov.ooap2_lab2;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

public class TwoFAAuthenticationDecorator extends AuthenticationDecorator {
    private GoogleAuthenticator gAuth = new GoogleAuthenticator();
    private GoogleAuthenticatorKey key = gAuth.createCredentials();
    private String otpAuthURL = "otpauth://totp/MyApp:user@example.com?secret=" + key.getKey() + "&issuer=MyApp";

    public TwoFAAuthenticationDecorator(Authentication authentication, ImageView view) {
        super(authentication);
        view.setImage(generateQRCode(otpAuthURL, 200, 200));
    }

    @Override
    public boolean authenticate(User user, String enteredLogin, String enteredPassword, int OTP) {
        return super.authenticate(user, enteredLogin, enteredPassword) && gAuth.authorize(key.getKey(), OTP);
    }

    public Image generateQRCode(String text, int width, int height) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = null;

        try {
            bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        WritableImage writableImage = new WritableImage(width, height);
        javafx.scene.paint.Color colorBlack = javafx.scene.paint.Color.BLACK;
        javafx.scene.paint.Color colorWhite = javafx.scene.paint.Color.WHITE;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                writableImage.getPixelWriter().setColor(x, y, bitMatrix.get(x, y) ? colorBlack : colorWhite);
            }
        }

        return writableImage;
    }
}
