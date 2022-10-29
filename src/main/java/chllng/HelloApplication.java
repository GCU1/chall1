package chllng;

import chllng.cntcts.ContactData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    ContactData cD = ContactData.getInstance();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainwindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 500);
        stage.setTitle("Contacts");
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void stop() {
                cD.saveContacts();
    }

    public static void main(String[] args) {
        launch();
    }
}