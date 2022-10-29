package chllng;

import chllng.cntcts.ContactData;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DialogController {

    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField notes;
    @FXML
    private TextField phone;

    public void processResult() {
        String name_field = name.getText().trim();
        String surname_field = surname.getText().trim();
        String notes_field = notes.getText().trim();
        String phone_field = phone.getText().trim();
        ContactData.getInstance().addContactItem(name_field,surname_field,phone_field,notes_field);
    }
}
