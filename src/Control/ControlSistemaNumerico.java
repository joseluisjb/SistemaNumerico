/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author Israel Bulla Rey - 1152358
 *         Jose Luis Jiménez Bayona - 1152384
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class ControlSistemaNumerico {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> cboSeleccionOperacion;

    @FXML
    private ComboBox<?> cboSeleccionSistemaNumerico;

    @FXML
    private ComboBox<?> cboSistemaNumericoActual;

    @FXML
    private ComboBox<?> cboSistemaNumericoConvertir;

    @FXML
    private TextArea txtNumero1;

    @FXML
    private TextArea txtNumero2;

    @FXML
    private TextArea txtNumeroConvertido;

    @FXML
    private TextArea txtNumeroConvertir;

    @FXML
    private TextArea txtResultado;

    @FXML
    void convertirNumero(KeyEvent event) {

    }

    @FXML
    void ingresarNumero1(KeyEvent event) {

    }

    @FXML
    void ingresarNumero2(KeyEvent event) {

    }

    @FXML
    void seleccionarOperacion(ActionEvent event) {

    }

    @FXML
    void seleccionarSistemaNumerico(ActionEvent event) {

    }

    @FXML
    void seleccionarSistemaNumericoActual(ActionEvent event) {

    }

    @FXML
    void seleccionarSistemaNumericoConvertir(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert cboSeleccionOperacion != null : "fx:id=\"cboSeleccionOperacion\" was not injected: check your FXML file 'Untitled'.";
        assert cboSeleccionSistemaNumerico != null : "fx:id=\"cboSeleccionSistemaNumerico\" was not injected: check your FXML file 'Untitled'.";
        assert cboSistemaNumericoActual != null : "fx:id=\"cboSistemaNumericoActual\" was not injected: check your FXML file 'Untitled'.";
        assert cboSistemaNumericoConvertir != null : "fx:id=\"cboSistemaNumericoConvertir\" was not injected: check your FXML file 'Untitled'.";
        assert txtNumero1 != null : "fx:id=\"txtNumero1\" was not injected: check your FXML file 'Untitled'.";
        assert txtNumero2 != null : "fx:id=\"txtNumero2\" was not injected: check your FXML file 'Untitled'.";
        assert txtNumeroConvertido != null : "fx:id=\"txtNumeroConvertido\" was not injected: check your FXML file 'Untitled'.";
        assert txtNumeroConvertir != null : "fx:id=\"txtNumeroConvertir\" was not injected: check your FXML file 'Untitled'.";
        assert txtResultado != null : "fx:id=\"txtResultado\" was not injected: check your FXML file 'Untitled'.";

    }

}
