package Control;

import Modelo.SistemaNumerico;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class ControlSistemaNumerico {

    private SistemaNumerico sn = new SistemaNumerico();
    private ObservableList<String> operaciones = FXCollections.observableArrayList();
    private ObservableList<String> sistemas = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cboSeleccionOperacion;

    @FXML
    private ComboBox<String> cboSeleccionSistemaNumerico;

    @FXML
    private ComboBox<String> cboSistemaNumericoActual;

    @FXML
    private ComboBox<String> cboSistemaNumericoConvertir;

    @FXML
    private Button cmdConvertir;

    @FXML
    private Button cmdIgual;

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

    private void llenarCombos() {
        this.operaciones.addAll("+", "-", "X", "/");
        this.sistemas.addAll("Decimal", "Binario", "Hexadecimal", "Octal");
        this.cboSeleccionOperacion.setItems(this.operaciones);
        this.cboSeleccionSistemaNumerico.setItems(sistemas);
        this.cboSistemaNumericoActual.setItems(sistemas);
        this.cboSistemaNumericoConvertir.setItems(sistemas);
    }

    @FXML
    void convertirNumero(ActionEvent event) {
        this.verificarCampos1();
        String s1 = this.cboSistemaNumericoActual.getSelectionModel().getSelectedItem();
        String s2 = this.cboSistemaNumericoConvertir.getSelectionModel().getSelectedItem();
        String numero = this.txtNumeroConvertir.getText();
        if (s1.equals("Decimal") && s2.equals("Decimal")) {
            this.verificarLetra(numero);
            this.txtNumeroConvertido.setText(numero);
        }
        if (s1.equals("Decimal") && s2.equals("Binario")) {
            this.verificarLetra(numero);
            this.txtNumeroConvertido.setText(sn.decimalABinario(Long.parseLong(numero)));
        }
        if (s1.equals("Decimal") && s2.equals("Octal")) {
            this.verificarLetra(numero);
            this.txtNumeroConvertido.setText(sn.decimalOctal(Long.parseLong(numero)));
        }
        if (s1.equals("Decimal") && s2.equals("Hexadecimal")) {
            this.verificarLetra(numero);
            this.txtNumeroConvertido.setText(sn.decimalHexadecimal(Long.parseLong(numero)));
        }
        if (s1.equals("Binario") && s2.equals("Decimal")) {
            this.verificarBinario(numero);
            this.txtNumeroConvertido.setText(String.valueOf(sn.binarioDecimal(Long.parseLong(numero))));
        }
        if (s1.equals("Binario") && s2.equals("Binario")) {
            this.verificarBinario(numero);
            this.txtNumeroConvertido.setText(numero);
        }
        if (s1.equals("Binario") && s2.equals("Octal")) {
            this.verificarBinario(numero);
            this.txtNumeroConvertido.setText(sn.binarioOctal(Long.parseLong(numero)));
        }
        if (s1.equals("Binario") && s2.equals("Hexadecimal")) {
            this.verificarBinario(numero);
            this.txtNumeroConvertido.setText(sn.binarioHexadecimal(Long.parseLong(numero)));
        }
        if (s1.equals("Octal") && s2.equals("Decimal")) {
            this.verificarOctal(numero);
            this.txtNumeroConvertido.setText(sn.octalBinario(Long.parseLong(numero)));
        }
        if (s1.equals("Octal") && s2.equals("Binario")) {
            this.verificarOctal(numero);
            this.txtNumeroConvertido.setText(sn.octalBinario(Long.parseLong(numero)));
        }
        if (s1.equals("Octal") && s2.equals("Octal")) {
            this.verificarOctal(numero);
            this.txtNumeroConvertido.setText(numero);
        }
        if (s1.equals("Octal") && s2.equals("Hexadecimal")) {
            this.verificarOctal(numero);
            this.txtNumeroConvertido.setText(sn.octalHexadecimal(Long.parseLong(numero)));
        }
        if (s1.equals("Hexadecimal") && s2.equals("Decimal")) {
            this.verificarHexadecimal(numero);
            this.txtNumeroConvertido.setText(String.valueOf(sn.hexadecimalDecimal(numero)));
        }
        if (s1.equals("Hexadecimal") && s2.equals("Binario")) {
            this.verificarHexadecimal(numero);
            this.txtNumeroConvertido.setText(sn.hexadecimalBinario(numero));
        }
        if (s1.equals("Hexadecimal") && s2.equals("Octal")) {
            this.verificarHexadecimal(numero);
            this.txtNumeroConvertido.setText(sn.hexadecimalOctal(numero));
        }
        if (s1.equals("Hexadecimal") && s2.equals("Hexadecimal")) {
            this.verificarHexadecimal(numero);
            this.txtNumeroConvertido.setText(numero);
        }
    }
    
    private void verificarCampos1(){
        if(this.cboSistemaNumericoActual.getSelectionModel().isEmpty()){
            this.alerta("Debe seleccionar el sistema actual");
        }else if(this.cboSistemaNumericoConvertir.getSelectionModel().isEmpty()){
            this.alerta("Debe seleccionar el sistema a convertir");
        }else if(this.txtNumeroConvertir.getText().isBlank()){
            this.alerta("Debe ingresar un número para convertir");
        }
    }
    
    private void verificarCampos2(){
        String mensaje = "";
        if(this.cboSeleccionSistemaNumerico.getSelectionModel().isEmpty()){
            mensaje = "Debe seleccionar un sistema numérico";
        }else if(this.cboSeleccionOperacion.getSelectionModel().isEmpty()){
            mensaje = "Debe seleccionar una operación";
        }else if(this.txtNumero1.getText().isBlank()){
            mensaje = "Debe ingresar el primer número";
        }else if(this.txtNumero2.getText().isBlank()){
            mensaje = "Debe ingresar el segundo número";
        }     
        if(!mensaje.equals(""))this.alerta(mensaje);
    }

    private void verificarLetra(String numero) {
        long conversion = 0;
        try {
            conversion = Long.parseLong(numero);
        } catch (NumberFormatException e) {
            this.alerta("Número: " + numero + " no válido");
            this.txtNumeroConvertir.setText("");
            this.txtNumeroConvertido.setText("");
        }
        if (conversion < 0) {
            this.alerta("Número: " + numero +" negativo");
            this.txtNumeroConvertir.setText("");
            this.txtNumeroConvertido.setText("");
        }
    }

    private void verificarBinario(String binario) {
        for (int i = 0; i < binario.length(); i++) {
            if (binario.charAt(i) != '0' && binario.charAt(i) != '1') {
                this.alerta("El número: " + binario + " no es binario");
                this.txtNumeroConvertir.setText("");
                this.txtNumeroConvertido.setText("");
                break;
            }
        }
    }

    private void verificarOctal(String octal) {
        for (int i = 0; i < octal.length(); i++) {
            if (octal.charAt(i) < '0' || octal.charAt(i) > '7') {
                this.alerta("El número: " + octal + " no es octal");
                this.txtNumeroConvertir.setText("");
                this.txtNumeroConvertido.setText("");
                break;
            }
        }
    }

    private void verificarHexadecimal(String hexa) {
        for (int i = 0; i < hexa.length(); i++) {
            if (!((hexa.charAt(i) >= 'A' && hexa.charAt(i) <= 'F')
                    || (hexa.charAt(i) >= 'a' && hexa.charAt(i) <= 'f')
                    || (hexa.charAt(i) >= '0' && hexa.charAt(i) <= '9'))) {
                this.alerta("El número: " + hexa + " no es hexadecimal");
                this.txtNumeroConvertir.setText("");
                this.txtNumeroConvertido.setText("");
                break;
            }
        }
    }

    private void alerta(String mensaje) {
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR, mensaje, ButtonType.OK);
        alert.showAndWait();
    }

    @FXML
    void hacerOperacion(ActionEvent event) {
        this.verificarCampos2();
        String n1 = this.txtNumero1.getText();
        String n2 = this.txtNumero2.getText();
        String operacion = this.cboSeleccionOperacion.getSelectionModel().getSelectedItem();
        String sistema = this.cboSeleccionSistemaNumerico.getSelectionModel().getSelectedItem();
        TextArea resultado = this.txtResultado;
        if(operacion.equals("+")){
            if(sistema.equals("Decimal")){
                this.verificarLetra(n1);
                this.verificarLetra(n2);
                resultado.setText(String.valueOf(Long.parseLong(n1) + Long.parseLong(n2)));
            }
            if(sistema.equals("Binario")){
                this.verificarBinario(n1);
                this.verificarBinario(n2);
                resultado.setText(String.valueOf(sn.sumaBinario(n1, n2)));
            }
            if(sistema.equals("Octal")){
                this.verificarOctal(n1);
                this.verificarOctal(n2);
                resultado.setText(String.valueOf(sn.sumaOctal(n1, n2)));
            }
            if(sistema.equals("Hexadecimal")){
                this.verificarHexadecimal(n1);
                this.verificarHexadecimal(n2);
                resultado.setText(sn.sumaHexadecimal(n1, n2));
            }
        }
        if(operacion.equals("-")){
            if(sistema.equals("Decimal")){
                this.verificarLetra(n1);
                this.verificarLetra(n2);
                resultado.setText(String.valueOf(Long.parseLong(n1) - Long.parseLong(n2)));
            }
            if(sistema.equals("Binario")){
                this.verificarBinario(n1);
                this.verificarBinario(n2);
                resultado.setText(String.valueOf(sn.restaBinario(n1, n2)));
            }
            if(sistema.equals("Octal")){
                this.verificarOctal(n1);
                this.verificarOctal(n2);
                resultado.setText(String.valueOf(sn.restaOctal(n1, n2)));
            }
            if(sistema.equals("Hexadecimal")){
                this.verificarHexadecimal(n1);
                this.verificarHexadecimal(n2);
                resultado.setText(String.valueOf(sn.restaHexadecimal(n1, n2)));
            }
        }
        if(operacion.equals("X")){
            if(sistema.equals("Decimal")){
                this.verificarLetra(n1);
                this.verificarLetra(n2);
                resultado.setText(String.valueOf(Long.parseLong(n1) * Long.parseLong(n2)));
            }
            if(sistema.equals("Binario")){
                this.verificarBinario(n1);
                this.verificarBinario(n2);
                resultado.setText(String.valueOf(sn.multiplicacionBinario(n1, n2)));
            }
            if(sistema.equals("Octal")){
                this.verificarOctal(n1);
                this.verificarOctal(n2);
                resultado.setText(String.valueOf(sn.restaOctal(n1, n2)));
            }
            if(sistema.equals("Hexadecimal")){
                this.verificarHexadecimal(n1);
                this.verificarHexadecimal(n2);
                resultado.setText(String.valueOf(sn.multiplicacionHexadecimal(n1, n2)));
            }
        }
        if(operacion.equals("/")){
            if(sistema.equals("Decimal")){
                this.verificarLetra(n1);
                this.verificarLetra(n2);
                resultado.setText(String.valueOf(Long.parseLong(n1) / Long.parseLong(n2)));
            }
            if(sistema.equals("Binario")){
                this.verificarBinario(n1);
                this.verificarBinario(n2);
                resultado.setText(String.valueOf(sn.divisionBinario(n1, n2)));
            }
            if(sistema.equals("Octal")){
                this.verificarOctal(n1);
                this.verificarOctal(n2);
                resultado.setText(String.valueOf(sn.restaOctal(n1, n2)));
            }
            if(sistema.equals("Hexadecimal")){
                this.verificarHexadecimal(n1);
                this.verificarHexadecimal(n2);
                resultado.setText(String.valueOf(sn.divisionHexadecimal(n1, n2)));
            }
        }
    }

    @FXML
    void initialize() {
        assert cboSeleccionOperacion != null : "fx:id=\"cboSeleccionOperacion\" was not injected: check your FXML file 'vistaSistemasNumericos.fxml'.";
        assert cboSeleccionSistemaNumerico != null : "fx:id=\"cboSeleccionSistemaNumerico\" was not injected: check your FXML file 'vistaSistemasNumericos.fxml'.";
        assert cboSistemaNumericoActual != null : "fx:id=\"cboSistemaNumericoActual\" was not injected: check your FXML file 'vistaSistemasNumericos.fxml'.";
        assert cboSistemaNumericoConvertir != null : "fx:id=\"cboSistemaNumericoConvertir\" was not injected: check your FXML file 'vistaSistemasNumericos.fxml'.";
        assert cmdConvertir != null : "fx:id=\"cmdConvertir\" was not injected: check your FXML file 'vistaSistemasNumericos.fxml'.";
        assert cmdIgual != null : "fx:id=\"cmdIgual\" was not injected: check your FXML file 'vistaSistemasNumericos.fxml'.";
        assert txtNumero1 != null : "fx:id=\"txtNumero1\" was not injected: check your FXML file 'vistaSistemasNumericos.fxml'.";
        assert txtNumero2 != null : "fx:id=\"txtNumero2\" was not injected: check your FXML file 'vistaSistemasNumericos.fxml'.";
        assert txtNumeroConvertido != null : "fx:id=\"txtNumeroConvertido\" was not injected: check your FXML file 'vistaSistemasNumericos.fxml'.";
        assert txtNumeroConvertir != null : "fx:id=\"txtNumeroConvertir\" was not injected: check your FXML file 'vistaSistemasNumericos.fxml'.";
        assert txtResultado != null : "fx:id=\"txtResultado\" was not injected: check your FXML file 'vistaSistemasNumericos.fxml'.";
        this.llenarCombos();
    }

}
