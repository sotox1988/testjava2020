package com.example.testjava.matias.people.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RutConverter {
    private static final String RUT_REGEX = "[0-9]+-[0-9kK]{1}";

    public RutConverter() {
    }

    public Integer asInteger(String rutTexto) {
        if (rutTexto != null && !rutTexto.trim().isEmpty()) {
            char digito = 'c';
            Pattern mask = null;
            mask = Pattern.compile("[0-9]+-[0-9kK]{1}");
            String[] auxRutArray = this.generarRutFieldYRutConPuntos(rutTexto);
            String rutField = auxRutArray[0];
            String rutConPuntos = auxRutArray[1];
            String[] arreglorutSinPuntos = rutConPuntos.split("\\.");
            String rutSinPuntos = this.generarRutSinPuntos(arreglorutSinPuntos);
            if (rutField.split("-").length > 1) {
                Matcher matcher = mask.matcher(rutSinPuntos + "-" + rutField.split("-")[1]);
                if (!matcher.matches()) {
                    throw new RutConverterException("Por favor ingrese RUN en formato correcto");
                }
            }

            if (rutField.split("-").length > 1) {
                digito = rutField.split("-")[1].charAt(0);
                if (Integer.parseInt(rutSinPuntos) < 1 || digito < 0) {
                    throw new RutConverterException("RUN invalido");
                }
            }

            int m = 0;
            int s = 1;

            for(int t = Integer.parseInt(rutSinPuntos); t != 0; t /= 10) {
                s = (s + t % 10 * (9 - m++ % 6)) % 11;
            }

            char digitoAux = (char)(s != 0 ? s + 47 : 75);
            if (!String.valueOf(digito).equalsIgnoreCase(String.valueOf(digitoAux).toUpperCase())) {
                throw new RutConverterException("Dígito verificador incorrecto");
            } else {
                return Integer.parseInt(rutSinPuntos);
            }
        } else {
            return null;
        }
    }

    private String[] generarRutFieldYRutConPuntos(String rutTexto) {
        String rutField = rutTexto.trim();
        String rutConPuntos;
        if (!rutField.contains("-") && rutField.length() >= 2) {
            rutConPuntos = rutField.subSequence(0, rutField.length() - 1).toString();
            rutField = rutConPuntos + "-" + rutField.subSequence(rutField.length() - 1, rutField.length()).toString();
        } else {
            rutConPuntos = rutField.split("-").length > 0 ? rutField.split("-")[0] : "";
        }

        return new String[]{rutField, rutConPuntos};
    }

    private String generarRutSinPuntos(String[] arreglorutSinPuntos) {
        StringBuilder sb1 = new StringBuilder("");

        for(int i = 0; i < arreglorutSinPuntos.length; ++i) {
            sb1.append(arreglorutSinPuntos[i]);
        }

        String[] arreglorutSinComas = sb1.toString().trim().toUpperCase().split("\\,");
        StringBuilder sb2 = new StringBuilder("");

        int rutInt;
        for(rutInt = 0; rutInt < arreglorutSinComas.length; ++rutInt) {
            sb2.append(arreglorutSinComas[rutInt]);
        }

        try {
            rutInt = Integer.parseInt(sb2.toString());
            if (rutInt < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException var6) {
            throw new RutConverterException("Por favor ingrese RUN en formato correcto");
        }

        return sb2.toString();
    }

    public String asString(Integer rutEntero) {
        /*
         * convertir numero de rut a String con su digito verificador
         */
        String rutAux = null;
        int rut;
        if (rutEntero == null) {
            rut = -1;
        } else {
            rut = (Integer) rutEntero;
        }
        if (rut > 0) {
            int m = 0;
            int s = 1;
            int t = (Integer) rut;
            for (; t != 0; t /= 10) {
                s = (s + t % 10 * (9 - m++ % 6)) % 11;
            }
            char digitoAux = (char) (s != 0 ? s + 47 : 75);
            DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();
            formatSymbols.setGroupingSeparator('.');
            DecimalFormat df = new DecimalFormat();
            df.setDecimalFormatSymbols(formatSymbols);
            rutAux = df.format(rut) + "-" + digitoAux;
        }
        return rutAux;
    }
}
