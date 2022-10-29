package chllng;

import chllng.cntcts.ContactData;
import chllng.cntcts.ContactItem;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Optional;

public class HelloController {

    ContactData cD = ContactData.getInstance();
    private final ObservableList<ContactItem> contactItems = cD.getContacts();

    @FXML
    private TableView<ContactItem> contactListView = new TableView<>();

    @FXML
    private BorderPane mainBorderPane;

    public void initialize() {

    contactListView.setEditable(true);
    TableColumn<ContactItem, String> firstNameCol = new TableColumn<>("Imię");
    TableColumn<ContactItem, String> lastNameCol = new TableColumn<>("Nazwisko");
    TableColumn<ContactItem, String> phoneCol = new TableColumn<>("Nr telefonu");
    TableColumn<ContactItem, String> notesCol = new TableColumn<>("Notatki");
         firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("surname")
        );
        phoneCol.setCellValueFactory(
                new PropertyValueFactory<>("phoneNumber")
        );
        notesCol.setCellValueFactory(
                new PropertyValueFactory<>("notes")
        );
          contactListView.setItems(contactItems);
          contactListView.getColumns().addAll(firstNameCol, lastNameCol, phoneCol, notesCol);
          contactListView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    public void showNewContactDialog(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        FXMLLoader fmxlloader = new FXMLLoader();
        fmxlloader.setLocation(getClass().getResource("contactDialog.fxml"));
        try{
            dialog.getDialogPane().setContent(fmxlloader.load());
        }
         catch (IOException e) {
             System.out.println(e.getMessage());
         }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            DialogController controller = fmxlloader.getController();
            controller.processResult();
            System.out.println("Okay pressed");
        }
        else {
            System.out.println("Cancel pressed");
        }
    }
}