package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.ZerbitzuKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class KautotuKud implements Initializable {

    // Reference to the main application.
    private Main mainApp;

    @FXML
    private ComboBox comboZerbitzua;

    @FXML
    private TextField txtErabiltzaile;

    @FXML
    private TextField txtPasahitza;

    @FXML
    private Button btn_Ezabatu;

    @FXML
    void klikEgin(ActionEvent event) {
        ZerbitzuKud.getInstance().zerbitzuaEzabatu((String) comboZerbitzua.getValue());
        this.eguneratu();

    }

    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    @FXML
    public void onClick(ActionEvent actionEvent) {
        System.out.println(txtErabiltzaile.getText() + ":" + txtPasahitza.getText());
        System.out.println(comboZerbitzua.getValue());

        if ("Flickr".equals(comboZerbitzua.getValue()) &&
                "juanan".equals(txtErabiltzaile.getText()) &&
                "pereira".equals(txtPasahitza.getText())) {

            mainApp.mainErakutsi();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> herrialdeakList = ZerbitzuKud.getInstance().lortuZerbitzuak();
        ObservableList<String> herrialdeak = FXCollections.observableArrayList(herrialdeakList);

        comboZerbitzua.setItems( herrialdeak );

    }

    private void eguneratu(){
        ObservableList<String> zerbitzuak =comboZerbitzua.getItems();
        zerbitzuak.remove(comboZerbitzua.getValue());
    }

}
