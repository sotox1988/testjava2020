package com.example.testjava.matias.people.utils;

import com.example.testjava.matias.people.utils.exceptions.RutConverterException;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RutConverter {
    private static final String RUT_REGEX = "[0-9]+-[0-9kK]{1}";

    public RutConverter() {
    }

    public Integer asInteger(String rutText) {
        if (rutText != null && !rutText.trim().isEmpty()) {
            char digit = 'c';
            Pattern mask = null;
            mask = Pattern.compile("[0-9]+-[0-9kK]{1}");
            String[] auxRutArray = this.generateRutFieldAndRutWhitDot(rutText);
            String rutField = auxRutArray[0];
            String rutWhitDot = auxRutArray[1];
            String[] arreglorutSinPuntos = rutWhitDot.split("\\.");
            String rutWhitoutDot = this.generateRutWithoutDot(arreglorutSinPuntos);
            if (rutField.split("-").length > 1) {
                Matcher matcher = mask.matcher(rutWhitoutDot + "-" + rutField.split("-")[1]);
                if (!matcher.matches()) {
                    throw new RutConverterException("Please enter RUT in correct format");
                }
            }

            if (rutField.split("-").length > 1) {
                digit = rutField.split("-")[1].charAt(0);
                if (Integer.parseInt(rutWhitoutDot) < 1 || digit < 0) {
                    throw new RutConverterException("RUT invalid");
                }
            }

            int m = 0;
            int s = 1;

            for(int t = Integer.parseInt(rutWhitoutDot); t != 0; t /= 10) {
                s = (s + t % 10 * (9 - m++ % 6)) % 11;
            }

            char digitAux = (char)(s != 0 ? s + 47 : 75);
            if (!String.valueOf(digit).equalsIgnoreCase(String.valueOf(digitAux).toUpperCase())) {
                throw new RutConverterException("Incorrect check digit");
            } else {
                return Integer.parseInt(rutWhitoutDot);
            }
        } else {
            return null;
        }
    }

    private String[] generateRutFieldAndRutWhitDot(String rutTexto) {
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

    private String generateRutWithoutDot(String[] arrayRutWithoutDots) {
        StringBuilder sb1 = new StringBuilder("");

        for(int i = 0; i < arrayRutWithoutDots.length; ++i) {
            sb1.append(arrayRutWithoutDots[i]);
        }

        String[] arrayRutWhitoutCommas = sb1.toString().trim().toUpperCase().split("\\,");
        StringBuilder sb2 = new StringBuilder("");

        int rutInt;
        for(rutInt = 0; rutInt < arrayRutWhitoutCommas.length; ++rutInt) {
            sb2.append(arrayRutWhitoutCommas[rutInt]);
        }

        try {
            rutInt = Integer.parseInt(sb2.toString());
            if (rutInt < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException var6) {
            throw new RutConverterException("Please enter RUT in correct format");
        }

        return sb2.toString();
    }

    public String asString(Integer rutNumber) {
        /*
         * convert number from rut to String with its check digit
         */
        String rutAux = null;
        int rut;
        if (rutNumber == null) {
            rut = -1;
        } else {
            rut = rutNumber.intValue();
        }
        if (rut > 0) {
            int m = 0;
            int s = 1;
            int t = rut;
            for (; t != 0; t /= 10) {
                s = (s + t % 10 * (9 - m++ % 6)) % 11;
            }
            char digitAux = (char) (s != 0 ? s + 47 : 75);
            DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();
            formatSymbols.setGroupingSeparator('.');
            DecimalFormat df = new DecimalFormat();
            df.setDecimalFormatSymbols(formatSymbols);
            rutAux = df.format(rut) + "-" + digitAux;
        }
        return rutAux;
    }
}
