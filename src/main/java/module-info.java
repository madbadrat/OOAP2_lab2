module ru.vorotov.ooap2_lab2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires googleauth;
    requires com.google.zxing;
    requires com.google.zxing.javase;
    requires java.desktop;


    opens ru.vorotov.ooap2_lab2 to javafx.fxml;
    exports ru.vorotov.ooap2_lab2;
}