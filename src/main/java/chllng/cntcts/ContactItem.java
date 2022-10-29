package chllng.cntcts;

import javafx.beans.property.SimpleStringProperty;

public class ContactItem {
    private final SimpleStringProperty name;
    private final SimpleStringProperty surname;
    private final SimpleStringProperty phoneNumber;
    private final SimpleStringProperty notes;

    public ContactItem(String name, String surname, String phoneNumber, String notes) {
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.notes = new SimpleStringProperty(notes);
    }

    public ContactItem() {
        this.name = new SimpleStringProperty("0");
        this.surname = new SimpleStringProperty("U");
        this.phoneNumber = new SimpleStringProperty("0");
        this.notes = new SimpleStringProperty("0");

    }

    public String getName() {
        return name.get();
    }

    public String getSurname() {
        return surname.get();
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getNotes() {
        return notes.get();
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }
}
