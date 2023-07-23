import java.text.DecimalFormat;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ConversorMoneda {

    Icon monedaIcon = new ImageIcon(
            "D:/Archivos ONE-ALURA/ChallengeConversor/Conversor/src/Imagenes/conversorMonedas/simboloConversion.png");
    Icon simboloMonedas = new ImageIcon(
            "D:/Archivos ONE-ALURA/ChallengeConversor/Conversor/src/Imagenes/conversorMonedas/simboloCambios.png");
    double cambioPesoADolar = 0.0587;
    double cambioPesoAEuro = 0.0541;
    double cambioPesoALibra = 0.0462;
    double cambioPesoAYen = 8.492;
    double cambioPesoAWon = 76.597;
    double cambioDolarAPeso = 17.026;
    double cambioEuroAPeso = 18.48;
    double cambioLibraAPeso = 21.62;
    double cambioYenAPeso = 0.1177;
    double cambioWonAPeso = 0.0130;
    DecimalFormat df = new DecimalFormat("#.00");

    public void conversionMoneda(double valorCantidad, String deMoneda, double valorCambio, String aMoneda) {
        double valorConvertido = valorCantidad * valorCambio;
        JOptionPane.showMessageDialog(null,
                valorCantidad + " " + deMoneda + " equivalen a " + df.format(valorConvertido) + " " + aMoneda + ".");
    }

    public void convertir() {

        String[] monedas = { "De peso mexicano a dólar", "De peso mexicano a euro", "De peso mexicano a libra",
                "De peso mexicano a yen", "De peso mexicano a won coreano",
                "De dólar a peso mexicano", "De euro a peso mexicano", "De libras a peso mexicano",
                "De yen a peso mexicano", "De won coreano a peso mexicano" };

        boolean continuar = true;

        while (continuar) {
            String eleccion = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de cambio:",
                    "Lista de cambios", JOptionPane.QUESTION_MESSAGE, monedaIcon, monedas, monedas[0]);

            if (eleccion == null) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "Gracias por usar el conversor");
                break;
            } else { // (eleccion != null) {

                String cantidadDeMonedaStr = (String) JOptionPane.showInputDialog(null,
                        "Ingrese la cantidad a convertir:", "Conversion de moneda",
                        JOptionPane.WARNING_MESSAGE, simboloMonedas, null, null);

                double cantidadDeMoneda;

                if (cantidadDeMonedaStr == null) {
                    JOptionPane.showMessageDialog(null, "Gracias por usar el conversor");
                    break;
                }
                
                try {
                    cantidadDeMoneda = Double.parseDouble(cantidadDeMonedaStr);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "La cantidad ingresada no es válida. Inténtelo nuevamente.");
                    continue; // Vuelve al inicio del ciclo
                }

                if (cantidadDeMoneda <= 0) {
                    JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor que cero. Inténtelo nuevamente.");
                    continue; // Vuelve al inicio del ciclo
                }
                switch (eleccion) {
                    case "De peso mexicano a dólar":
                        conversionMoneda(cantidadDeMoneda, "pesos mexicanos", cambioPesoADolar, "Dolares");
                        break;
                    case "De peso mexicano a euro":
                        conversionMoneda(cantidadDeMoneda, "pesos mexicanos", cambioPesoAEuro, "Euros");
                        break;
                    case "De peso mexicano a libra":
                        conversionMoneda(cantidadDeMoneda, "pesos mexicanos", cambioPesoALibra, "Libras");
                        break;
                    case "De peso mexicano a yen":
                        conversionMoneda(cantidadDeMoneda, "pesos mexicanos", cambioPesoAYen, "Yenes");
                        break;
                    case "De peso mexicano a won coreano":
                        conversionMoneda(cantidadDeMoneda, "pesos mexicanos", cambioPesoAWon, "Wons Coreano");
                        break;
                    case "De dólar a peso mexicano":
                        conversionMoneda(cantidadDeMoneda, "dolares", cambioDolarAPeso, "Pesos Mexicanos");
                        break;
                    case "De euro a peso mexicano":
                        conversionMoneda(cantidadDeMoneda, "euros", cambioEuroAPeso, "Pesos Mexicanos");
                        break;
                    case "De libra a peso mexicano":
                        conversionMoneda(cantidadDeMoneda, "libras", cambioLibraAPeso, "Pesos Mexicanos");
                        break;
                    case "De yen a peso mexicano":
                        conversionMoneda(cantidadDeMoneda, "Yen japonés", cambioYenAPeso, "Pesos Mexicanos");
                        break;
                    default:
                        conversionMoneda(cantidadDeMoneda, "Wons surcoreanos", cambioWonAPeso, "Pesos Mexicanos");
                        break;
                }
            }

            int opcion = JOptionPane.showOptionDialog(null, "¿Desea realizar otra conversión de moneda?",
                    "Otra conversión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new Object[] { "Sí", "No" }, "");

            if (opcion == JOptionPane.NO_OPTION) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "Gracias por usar el conversor");
            }
        }
    }
}