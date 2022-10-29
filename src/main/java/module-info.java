module chllng.challenge {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    opens chllng to javafx.fxml;
    exports chllng;
    exports chllng.cntcts;
    opens chllng.cntcts to javafx.fxml;
}