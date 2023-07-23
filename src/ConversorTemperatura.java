import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class ConversorTemperatura {

    DecimalFormat df = new DecimalFormat("#.00");

    public void conversionKelvinACelsius(double gradosKelvin) {
        double gradosCelsius = gradosKelvin - 273.15;
        JOptionPane.showMessageDialog(null,
                gradosKelvin + " grados Kelvin equivalen a " + df.format(gradosCelsius) + " grados Celsius.");
    }

    public void conversionKelvinAFahrenheit(double gradosKelvin) {
        double gradosFahrenheit = (9 * (gradosKelvin - 273.15) / 5) + 32.0;
        JOptionPane.showMessageDialog(null,
                gradosKelvin + " grados Kelvin equivalen a " + df.format(gradosFahrenheit) + " grados Fahrenheit.");
    }

    public void conversionFahrenheitACelsius(double gradosFahrenheit) {
        double gradosCelsius = (5 * (gradosFahrenheit - 32)) / 9;
        JOptionPane.showMessageDialog(null,
                gradosFahrenheit + " grados Fahrenheit equivalen a " + df.format(gradosCelsius) + " grados celsius.");
    }

    public void conversionFahrenheitAKelvin(double gradosFahrenheit) {
        double gradosKelvin = (5 * (gradosFahrenheit - 32) / 9) + 273.15;
        JOptionPane.showMessageDialog(null,
                gradosFahrenheit + " grados Fahrenheit equivalen a " + df.format(gradosKelvin) + " grados Kelvin.");
    }

    public void conversionCelsiusAKelvin(double gradosCelsius) {
        double gradosKelvin = gradosCelsius - 273.15;
        JOptionPane.showMessageDialog(null,
                gradosCelsius + " grados Celsius equivalen a " + df.format(gradosKelvin) + " grados Kelvin.");
    }

    public void conversionCelsiusAFahrenheit(double gradosCelsius) {
        double gradosFahrenheit = (9 * gradosCelsius) / 5 + 32;
        JOptionPane.showMessageDialog(null,
                gradosCelsius + " grados Celsius equivalen a " + df.format(gradosFahrenheit) + " grados Fahrenheit.");
    }

    public void convertir() {

        String[] temperaturas = { "De Kelvin a Celsius", "De Kelvin a Fahrenheit", "De Fahrenheit a Celsius",
                "De Fahrenheit a Kelvin", "De Celsius a Kelvin", "De Celsius a Fahrenheit" };

        boolean continuar = true;

        while (continuar) {
            String eleccion = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de conversion:",
                    "Lista de cambios", JOptionPane.QUESTION_MESSAGE, null, temperaturas, temperaturas[0]);

            if (eleccion == null) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "Gracias por usar el conversor");
                break;
            } else {

                String numeroGradosStr = (String) JOptionPane.showInputDialog(null,
                        "Ingrese los grados a convertir:", "Conversion de temperatura",
                        JOptionPane.WARNING_MESSAGE, null, null, null);

                double numeroGrados;
                
                if (numeroGradosStr == null) {
                    JOptionPane.showMessageDialog(null, "Gracias por usar el conversor");
                    break;
                }

                try {
                    numeroGrados = Double.parseDouble(numeroGradosStr);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "La cantidad ingresada no es válida. Inténtelo nuevamente.");
                    continue; // Vuelve al inicio del ciclo
                }

                switch (eleccion) {
                    case "De Kelvin a Celsius":
                        conversionKelvinACelsius(numeroGrados);
                        break;
                    case "De Kelvin a Fahrenheit":
                        conversionKelvinAFahrenheit(numeroGrados);
                        break;
                    case "De Fahrenheit a Celsius":
                        conversionFahrenheitACelsius(numeroGrados);
                        break;
                    case "De Fahrenheit a Kelvin":
                        conversionFahrenheitAKelvin(numeroGrados);
                        break;
                    case "De Celsius a Kelvin":
                        conversionCelsiusAKelvin(numeroGrados);
                        break;
                    default:
                        conversionCelsiusAFahrenheit(numeroGrados);
                        break;
                }
            }
            int opcion = JOptionPane.showOptionDialog(null, "¿Desea realizar otra conversión de grados?",
                    "Otra conversión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new Object[] { "Sí", "No" }, "");

            if (opcion == JOptionPane.NO_OPTION) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "Gracias por usar el conversor");
            }
        }
    }
}
