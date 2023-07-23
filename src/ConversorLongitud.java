import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class ConversorLongitud {

    double metroCentimetro = 100.0;
    double metroKilometro = 1.0/1000.0;
    double metroYarda = 1.094;
    double metroMilla = 1.0/1609.0;
    double metroPulgada = 39.37;
    double centimetroMetro = 1.0/100.0;
    double centimetroPulgada = 1.0/2.54;
    double yardaMetros = 1.0/metroYarda;
    double millaMetros = 1609.0;
    double yardaMilla = 1.0/1760.0;
    double millaYarda = 1760.0;
    double pulgadaCentimetro = 2.54;
    DecimalFormat df = new DecimalFormat("#.000");

    public void conversionLongitud(String deLongitud, double valorLongitud, String aLongitud, double valorConversion) {
        double valorConvertido = valorLongitud * valorConversion;
        JOptionPane.showMessageDialog(null,
                valorLongitud + " " + deLongitud + " equivalen a " + df.format(valorConvertido) + " " + aLongitud
                         + ".");
    }

    public void convertir() {

        String[] longitudes = { "De metro a centímetro", "De metro a kilometro", "De metro a yarda", "De metro a milla",
                "De metro a pulgada", "De centímetro a metro", "De centímetro a pulgada", "De yarda a metros",
                "De milla a metros",
                "De yarda a milla", "De milla a yarda", "De pulgada a centímetro" };

        boolean continuar = true;

        while (continuar) {
            String eleccion = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de conversión:",
                    "Lista de cambios", JOptionPane.QUESTION_MESSAGE, null, longitudes, longitudes[0]);

            if (eleccion == null) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "Gracias por usar el conversor");
                break;
            } else {
                String valorLongitudStr = (String) JOptionPane.showInputDialog(null,
                        "Ingrese la cantidad a convertir:", "Conversion de longitud",
                        JOptionPane.WARNING_MESSAGE, null, null, null);

                double valorLongitud;

                if (valorLongitudStr == null) {
                    JOptionPane.showMessageDialog(null, "Gracias por usar el conversor");
                    break;
                }

                try {
                    valorLongitud = Double.parseDouble(valorLongitudStr);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "La cantidad ingresada no es válida. Inténtelo nuevamente.");
                    continue; // Vuelve al inicio del ciclo
                }
                if (valorLongitud <= 0) {
                    JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor que cero. Inténtelo nuevamente.");
                    continue; // Vuelve al inicio del ciclo
                }
                switch (eleccion) {
                    case "De metro a centímetro":
                        conversionLongitud("metro", valorLongitud, "centímetros", metroCentimetro);
                        break;
                    case "De metro a kilometro":
                        conversionLongitud("metros", valorLongitud, "kilometros", metroKilometro);
                        break;
                    case "De metro a yarda":
                        conversionLongitud("metros", valorLongitud, "yardas", metroYarda);
                        break;
                    case "De metro a milla":
                        conversionLongitud("metros", valorLongitud, "millas", metroMilla);
                        break;
                    case "De metro a pulgada":
                        conversionLongitud("metros", valorLongitud, "pulgadas", metroPulgada);
                        break;
                    case "De centímetro a metro":
                        conversionLongitud("centímetros", valorLongitud, "metros", centimetroMetro);
                        break;
                    case "De centímetro a pulgada":
                        conversionLongitud("centímetros", valorLongitud, "pulgadas", centimetroPulgada);
                        break;
                    case "De yarda a metros":
                        conversionLongitud("yardas", valorLongitud, "metros", yardaMetros);
                        break;
                    case "De milla a metros":
                        conversionLongitud("millas", valorLongitud, "metros", millaMetros);
                        break;
                    case "De yarda a milla":
                        conversionLongitud("yardas", valorLongitud, "millas", yardaMilla);
                        break;
                    case "De milla a yarda":
                        conversionLongitud("millas", valorLongitud, "yardas", millaYarda);
                        break;
                    default:
                        conversionLongitud("pulgadas", valorLongitud, "centimetros", pulgadaCentimetro);
                        break;
                }
            }

            int opcion = JOptionPane.showOptionDialog(null, "¿Desea realizar otra conversión de longitud?",
                    "Otra conversión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new Object[] { "Sí", "No" }, "");

            if (opcion == JOptionPane.NO_OPTION) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "Gracias por usar el conversor");
            }
        }
    }
}
