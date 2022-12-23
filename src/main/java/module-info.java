module com.example.scenebuilderexample {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.desktop;


    opens com.example.scenebuilderexample to javafx.fxml;
    exports com.example.scenebuilderexample;
}