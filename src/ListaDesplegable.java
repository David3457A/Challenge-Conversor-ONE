import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ListaDesplegable {

    static Icon monedaIcon = new ImageIcon(
            "D:/Archivos ONE-ALURA/ChallengeConversor/Conversor/src/Imagenes/conversorMonedas/simboloMoneda.png");

    public static void main(String[] args) {
        String[] opciones = { "Conversor de moneda", "Conversor de temperatura",
                "Conversor de masa", "Conversor de longitud"};

        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione el conversor que necesite:",
                "Lista de conversores", JOptionPane.QUESTION_MESSAGE, monedaIcon, opciones, opciones[3]);

        if (seleccion != null) {
            // System.out.println("Opción seleccionada: " + seleccion);

            switch (seleccion) {
                case "Conversor de moneda":
                    ConversorMoneda conversorMoneda = new ConversorMoneda();
                    conversorMoneda.convertir();
                    break;
                case "Conversor de temperatura":
                    ConversorTemperatura conversorTemperatura = new ConversorTemperatura();
                    conversorTemperatura.convertir();
                    break;
                case "Conversor de masa":
                    ConversorMasa conversorMasa = new ConversorMasa();
                    conversorMasa.convertir();
                    break;
                case "Conversor de longitud":
                    ConversorLongitud conversorLongitud = new ConversorLongitud();
                    conversorLongitud.convertir();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }
}
