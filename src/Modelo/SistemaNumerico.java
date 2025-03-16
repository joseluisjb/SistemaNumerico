/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Stack;

/**
 *
 * @author Israel Bulla Rey - 1152384
 *         Jose Luis Jiménez Bayona - 1152384
 */
public class SistemaNumerico {

    //Revisar que no sean negativos
    char[] hexadecimales = {'A', 'B', 'C', 'D', 'E', 'F'};

    public String convertirDecimal(long numero) {
        return decimalABinario(numero);
    }

    private String decimalABinario(long numero) {
        String resultado = "";
        while (numero > 0) {
            resultado = numero % 2 + resultado;
            numero = numero / 2;
        }
        return resultado;
    }

    public String decimalOctal(long numero) {
        String resultado = "";
        while (numero > 0) {
            resultado = numero % 8 + resultado;
            numero = numero / 8;
        }
        return resultado;
    }

    public String decimalHexadecimal(long numero) {
        String resultado = "";
        int residuo = 0;
        while (numero > 0) {
            residuo = (int) (numero);
            resultado = numero % 16 > 9 ? String.valueOf(this.hexadecimales[(int) (numero % 16 - 10)]) + resultado : numero % 16 + resultado;
            numero = numero / 16;
        }
        return resultado;
    }

    public long binarioDecimal(long numero) {
        String binario = String.valueOf(numero);
        long resultado = 0;
        int exponenteDe2 = 0;
        for (int i = binario.length() - 1; i >= 0; i--) {
            resultado += Integer.parseInt(String.valueOf(binario.charAt(i))) * Math.pow(2, exponenteDe2);
            exponenteDe2++;
        }
        return resultado;
    }

    public String binarioOctal(long numero) {
        String binario = String.valueOf(numero);
        String resultado = "";
        for (int i = binario.length() - 1; i >= 0; i -= 3) {
            int finCadena = i - 2 >= 0 ? i - 2 : 0;
            String subcadena = binario.substring(finCadena, i + 1);
            int digito = 0, k = 0;
            for (int j = subcadena.length() - 1; j >= 0; j--) {
                digito += Integer.parseInt(String.valueOf(subcadena.charAt(j))) * Math.pow(2, k);
                k++;
            }
            resultado = digito + resultado;
        }
        return resultado;
    }

    public String binarioHexadecimal(long numero) {
        String binario = String.valueOf(numero);
        String resultado = "";
        for (int i = binario.length() - 1; i >= 0; i -= 4) {
            int finCadena = i - 3 >= 0 ? i - 3 : 0;
            String subcadena = binario.substring(finCadena, i + 1);
            int digito = 0, k = 0;
            for (int j = subcadena.length() - 1; j >= 0; j--) {
                digito += Integer.parseInt(String.valueOf(subcadena.charAt(j))) * Math.pow(2, k);
                k++;
            }
            resultado = digito > 9 ? this.hexadecimales[digito - 10] + resultado : digito + resultado;
        }
        return resultado;
    }

    public long octalDecimal(long numero) {
        long decimal = 0;
        int exponente8 = 0;
        while (numero > 0) {
            decimal += numero % 10 * Math.pow(8, exponente8);
            numero = numero / 10;
            exponente8++;
        }
        return decimal;
    }

    public String octalBinario(long numero) {
        String resultado = "", digito;
        int ultimoDigito = 0, potencia2 = 0;
        while (numero > 0) {
            ultimoDigito = (int) numero % 10;
            potencia2 = 4;
            digito = "";
            for (int i = 0; i < 3; i++) {
                if (ultimoDigito >= potencia2) {
                    digito = digito + "1";
                    ultimoDigito -= potencia2;
                } else {
                    digito = digito + "0";
                }
                potencia2 /= 2;
            }
            numero /= 10;
            resultado = digito + resultado;
        }
        return resultado;
    }

    public String octalHexadecimal(long numero) {
        String binario = this.octalBinario(numero);
        String resultado = "";
        for (int i = binario.length() - 1; i >= 0; i -= 4) {
            int finCadena = i - 3 >= 0 ? i - 3 : 0;
            String subcadena = binario.substring(finCadena, i + 1);
            int digito = 0, k = 0;
            for (int j = subcadena.length() - 1; j >= 0; j--) {
                digito += Integer.parseInt(String.valueOf(subcadena.charAt(j))) * Math.pow(2, k);
                k++;
            }
            if (digito != 0) {
                resultado = digito > 9 ? this.hexadecimales[digito - 10] + resultado : digito + resultado;//Sin esta línea imprime un 0 adelante de las letras
            }
        }
        return resultado;
    }

    public long hexadecimalDecimal(String numero) {
        long resultado = 0;
        int exponente16 = 0, conversion;
        for (int i = numero.length() - 1; i >= 0; i--) {
            try {
                conversion = Integer.parseInt(String.valueOf(numero.charAt(i)));
            } catch (NumberFormatException e) {
                conversion = this.letraANumero(numero.charAt(i));
            }
            resultado += conversion * Math.pow(16, exponente16);
            exponente16++;
        }
        return resultado;
    }

    private int letraANumero(char letra) {
        if (letra == 'A' || letra == 'a') {
            return 10;
        }
        if (letra == 'B' || letra == 'b') {
            return 11;
        }
        if (letra == 'C' || letra == 'c') {
            return 12;
        }
        if (letra == 'D' || letra == 'd') {
            return 13;
        }
        if (letra == 'E' || letra == 'e') {
            return 14;
        }
        if (letra == 'F' || letra == 'f') {
            return 15;
        }
        throw new RuntimeException("El número no es hexadecimal");
    }

    public String hexadecimalBinario(String numero) {
        String resultado = "", digito = "";
        int conversion, bit;
        for (int i = numero.length() - 1; i >= 0; i--) {
            try {
                conversion = Integer.parseInt(String.valueOf(numero.charAt(i)));
            } catch (NumberFormatException e) {
                conversion = this.letraANumero(numero.charAt(i));
            }
            bit = 8;
            digito = "";
            for (int j = 0; j < 4; j++) {
                if (conversion >= bit) {
                    conversion -= bit;
                    digito += "1";
                } else {
                    digito += "0";
                }
                bit /= 2;
            }
            resultado = digito + resultado;
        }
        return resultado;
    }

    public String hexadecimalOctal(String numero) {
        String binario = this.hexadecimalBinario(numero);
        String resultado = "";
        for (int i = binario.length() - 1; i >= 0; i -= 3) {
            int finCadena = i - 2 >= 0 ? i - 2 : 0;
            String subcadena = binario.substring(finCadena, i + 1);
            int digito = 0, exponente2 = 0;
            for (int j = subcadena.length() - 1; j >= 0; j--) {
                digito += Integer.parseInt(String.valueOf(subcadena.charAt(j))) * Math.pow(2, exponente2);
                exponente2++;
            }
            if (digito != 0) {
                resultado = digito + resultado;
            }
        }
        return resultado;
    }

    public String sumaBinario(String sumando1, String sumando2) {
        Stack<Character> pilaSumando1 = new Stack<>();
        Stack<Character> pilaSumando2 = new Stack<>();
        Stack<Character> carrys = new Stack<>();
        String resultado = "";
        for (int i = 0; i < sumando1.length(); i++) {
            pilaSumando1.push(sumando1.charAt(i));
        }
        for (int i = 0; i < sumando2.length(); i++) {
            pilaSumando2.push(sumando2.charAt(i));
        }
        char c1, c2, c3;
        while (!pilaSumando1.isEmpty() || !pilaSumando2.isEmpty() || !carrys.isEmpty()) {
            c1 = pilaSumando1.isEmpty() ? '0' : pilaSumando1.pop();
            c2 = pilaSumando2.isEmpty() ? '0' : pilaSumando2.pop();
            c3 = carrys.isEmpty() ? '0' : carrys.pop();
            if (c1 == '0' && c2 == '0' && c3 == '0') {
                resultado = "0" + resultado;
            } else if (c1 == '0' && c2 == '1' && c3 == '0' || c1 == '1' && c2 == '0' && c3 == '0' || c1 == '0' && c2 == '0' && c3 == '1') {
                resultado = "1" + resultado;
            } else if (c1 == '1' && c2 == '1' && c3 == '0' || c1 == '1' && c2 == '0' && c3 == '1' || c1 == '0' && c2 == '1' && c3 == '1') {
                resultado = "0" + resultado;
                carrys.push('1');
            } else if (c1 == '1' && c2 == '1' && c3 == '1') {
                resultado = "1" + resultado;
                carrys.push('1');
            }
        }
        return resultado;
    }

    public String restaBinario(String minuendo, String sustraendo) {// Resta por el método complemento a 2
        int cerosFaltantes = minuendo.length() - sustraendo.length();
        for (int i = 0; i < cerosFaltantes; i++) {
            sustraendo = "0" + sustraendo;
        }
        minuendo = "0" + minuendo;
        sustraendo = "1" + sustraendo;
        String sustraendoInverso = "";
        for (int i = 0; i < sustraendo.length(); i++) {
            sustraendoInverso += sustraendo.charAt(i) == '0' ? '1' : '0';
        }
        sustraendo = this.sumaBinario(sustraendoInverso, "1");
        String resultado = this.sumaBinario(minuendo, sustraendo);
        return resultado.substring(1, resultado.length());
    }

    public String multiplicacionBinario(String factor1, String factor2) {
        Stack<String> sumandos = new Stack<>();
        int cerosAdicionales;
        String apilar, sumando, resultado = "0";
        for (int i = factor2.length() - 1; i >= 0; i--) {
            if (factor2.charAt(i) == '1') {
                apilar = factor1;
                cerosAdicionales = sumandos.size();
                for (int j = 0; j < cerosAdicionales; j++) {
                    apilar += 0;
                }
            } else {
                apilar = "0";
            }
            sumandos.push(apilar);
        }
        while (!sumandos.isEmpty()) {
            sumando = sumandos.pop();
            resultado = this.sumaBinario(sumando, resultado);
        }
        return resultado;
    }

    public String divisionBinario(String dividendo, String divisor) {
        int i = 0;
        String resultado = "", cifrasTomadas = "";
        while (i < dividendo.length()) {
            cifrasTomadas += dividendo.charAt(i);
            if (this.binarioDecimal(Long.parseLong(cifrasTomadas)) >= this.binarioDecimal(Long.parseLong(divisor))) {
                resultado += "1";
                cifrasTomadas = this.restaBinario(cifrasTomadas, divisor);
            } else {
                resultado += "0";
            }
            i++;
        }
        return resultado;
    }

    public String sumaOctal(String sumando1, String sumando2) {
        String resultado = "";
        Stack<Integer> carrys = new Stack<>();
        Stack<String> pilaSumando1 = new Stack<>();
        Stack<String> pilaSumando2 = new Stack<>();
        int n1, n2, c, indexSumando2 = sumando2.length() - 1;
        int mayor = sumando1.length() >= sumando2.length() ? sumando1.length() : sumando2.length();
        for (int i = 0; i < sumando1.length(); i++) {
            pilaSumando1.push(String.valueOf(sumando1.charAt(i)));
        }
        for (int i = 0; i < sumando2.length(); i++) {
            pilaSumando2.push(String.valueOf(sumando2.charAt(i)));
        }
        while (!pilaSumando1.isEmpty() || !pilaSumando2.isEmpty() || !carrys.isEmpty()) {
            n1 = pilaSumando1.isEmpty() ? 0 : Integer.parseInt(pilaSumando1.pop());
            n2 = pilaSumando2.isEmpty() ? 0 : Integer.parseInt(pilaSumando2.pop());
            c = carrys.isEmpty() ? 0 : carrys.pop();
            if (n1 + n2 + c >= 8) {
                resultado = (n1 + n2 + c - 8) + resultado;
                carrys.push(1);
            } else {
                resultado = n1 + n2 + c + resultado;
            }
        }
        return resultado;
    }

    public String restaOctal(String minuendo, String sustraendo) { //Método del complemento
        String complemento = "";
        int tamanio = Math.max(minuendo.length(), sustraendo.length());
        while (minuendo.length() < tamanio) {
            minuendo = "0" + minuendo;
        }
        while (sustraendo.length() < tamanio) {
            sustraendo = "0" + sustraendo;
        }
        for (int i = 0; i < sustraendo.length(); i++) {
            int digito = 7 - Integer.parseInt(String.valueOf(sustraendo.charAt(i)));
            complemento += digito;
        }
        complemento = sumaOctal(complemento, "1");
        String suma = sumaOctal(minuendo, complemento);

        if (suma.length() > tamanio) {
            suma = suma.substring(1);
        }
        return suma;
    }

    public String multiplicacionOctal(String factor1, String factor2) {
        long decimal = this.octalDecimal(Long.parseLong(factor2));
        String resultado = factor1;
        for (int i = 0; i < decimal - 1; i++) {
            resultado = this.sumaOctal(resultado, factor1);
        }
        return resultado;
    }

    public String divisionOctal(String dividendo, String divisor) {
        int cantidadRestas = 0;
        while (Long.parseLong(dividendo) >= Long.parseLong(divisor)) {
            dividendo = this.restaOctal(dividendo, divisor);
            cantidadRestas++;
        }
        return this.decimalOctal(cantidadRestas);
    }

    public String sumaHexadecimal(String sumando1, String sumando2) {
        int tamanio = Math.max(sumando1.length(), sumando2.length());
        while (sumando1.length() < tamanio) {
            sumando1 = "0" + sumando1;
        }
        while (sumando2.length() < tamanio) {
            sumando2 = "0" + sumando2;
        }
        Stack<Integer> carrys = new Stack<>();
        int a, b, c = 0, d;
        String resultado = "";
        for (int i = tamanio - 1; i >= 0; i--) {
            c = carrys.isEmpty() ? 0 : carrys.pop();
            try {
                a = Integer.parseInt(String.valueOf(sumando1.charAt(i)));
            } catch (NumberFormatException e) {
                a = this.letraANumero(sumando1.charAt(i));
            }
            try {
                b = Integer.parseInt(String.valueOf(sumando2.charAt(i)));
            } catch (NumberFormatException e) {
                b = this.letraANumero(sumando2.charAt(i));
            }
            d = a + b + c;
            if (d >= 16) {
                d -= 16;
                carrys.push(1);
            }
            if (d > 9) {
                resultado = this.hexadecimales[d - 10] + resultado;
            } else {
                resultado = d + resultado;
            }
        }
        if (!carrys.isEmpty()) {
            resultado = "1" + resultado;
        }
        return resultado;
    }

    public String restaHexadecimal(String minuendo, String sustraendo) { // Método del complemento
        String complementoA15 = "", complementoA16, resultado = "";
        int a, tamanio = Math.max(minuendo.length(), sustraendo.length());
        while (minuendo.length() < tamanio) {
            minuendo = "0" + minuendo;
        }
        while (sustraendo.length() < tamanio) {
            sustraendo = "0" + sustraendo;
        }
        for (int i = sustraendo.length() - 1; i >= 0; i--) {
            try {
                a = Integer.parseInt(String.valueOf(sustraendo.charAt(i)));
            } catch (NumberFormatException e) {
                a = this.letraANumero(sustraendo.charAt(i));
            }
            a = 15 - a;
            if (a > 9) {
                complementoA15 = this.hexadecimales[a - 10] + complementoA15;
            } else {
                complementoA15 = a + complementoA15;
            }
        }
        complementoA16 = this.sumaHexadecimal(complementoA15, "1");
        resultado = this.sumaHexadecimal(minuendo, complementoA16);
        if (resultado.length() > minuendo.length()) {
            resultado = resultado.substring(1);
        }
        return resultado;
    }

    public String multiplicacionHexadecimal(String factor1, String factor2) {
        long decimal = this.hexadecimalDecimal(factor2);
        String resultado = factor1;
        for (int i = 0; i < decimal - 1; i++) {
            resultado = this.sumaHexadecimal(resultado, factor1);
        }
        return resultado;
    }

    public String divisionHexadecimal(String dividendo, String divisor) {
        int cantidadRestas = 0;
        while (this.hexadecimalDecimal(dividendo) >= this.hexadecimalDecimal(divisor)) {
            dividendo = this.restaHexadecimal(dividendo, divisor);
            cantidadRestas++;
        }
        return this.decimalHexadecimal(cantidadRestas);
    }

}
