import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class ConversorMasa {

    DecimalFormat df = new DecimalFormat("#.00000");
    double conversionKiloAOnza = 35.274;
    double conversionKiloALibras = 2.2046;
    double conversionGramosAOnza = 28.35;
    double conversionGramosALibras = 453.6;
    double conversionToneladasALibras = 2205;
    double conversionToneladasAOnza = 35720;

    public void conversion(String deTipoMasa, double cantidadMasa, int n, String aTipoMasa) {
        // sirve de kilo a gramos, de kilo a toneladas, de gramos a kilos, tonelada a
        // kilogramos
        double conversion = cantidadMasa * Math.pow(10, n);
        JOptionPane.showMessageDialog(null,
                cantidadMasa + " " + deTipoMasa + " son " + df.format(conversion) + " " + aTipoMasa);
    }

    public void conversionAOnzasLibras(String deTipoMasa, double cantidadMasa, String convertirA) {
        // sirve para realizar la conversion a onzas o a libras 
        double conversion = 0;
        String aTipoMasa = "";
        if (deTipoMasa.equals("kilogramos")) {
            if (convertirA.equals("onzas")) {
                conversion = cantidadMasa * conversionKiloAOnza;
                aTipoMasa = "onzas";
            } else if (convertirA.equals("libras")) {
                conversion = cantidadMasa * conversionKiloALibras;
                aTipoMasa = "libras";
            }
        } else if (deTipoMasa.equals("gramos")) {

            if (convertirA.equals("onzas")) {
                conversion = cantidadMasa / conversionGramosAOnza;
                aTipoMasa = "onzas";
            } else if (convertirA.equals("libras")) {
                conversion = cantidadMasa / conversionGramosALibras;
                aTipoMasa = "libras";
            }
        } else if (deTipoMasa.equals("toneladas")){
            if (convertirA.equals("onzas")) {
                conversion = cantidadMasa * conversionToneladasAOnza;
                aTipoMasa = "onzas";
            } else if (convertirA.equals("libras")) {
                conversion = cantidadMasa * conversionToneladasALibras;
                aTipoMasa = "libras";
            }
        }


        JOptionPane.showMessageDialog(null,
                cantidadMasa + " " + deTipoMasa + " son " + df.format(conversion) + " " + aTipoMasa);
    }

    public void conversionGramos(double cantidadMasa, int n, String aTipoMasa) {

    }

    public void convertir() {

        String[] masas = { "De kilogramos a gramos", "De kilogramos a toneladas",
                "De kilogramos a onzas", "De kilogramos a libras", "De gramos a kilogramos",
                "De gramos a onzas", "De gramos a libras",
                "De toneladas a kilogramos", "De toneladas a gramos", "De toneladas a onzas", "De toneladas a libras",
                "De onzas a kilogramos", "De onzas a gramos", "De onzas a libras", "De libras a kilogramos",
                "De libras a gramos", "De libras a onzas" };

        boolean continuar = true;

        while (continuar) {

            String eleccion = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de conversion:",
                    "Lista de cambios", JOptionPane.QUESTION_MESSAGE, null, masas, masas[0]);

            if (eleccion == null) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "Gracias por usar el conversor");
                break;
            } else {

                String cantidadMasaStr = (String) JOptionPane.showInputDialog(null,
                        "Ingrese la cantidad de masa a convertir:", "Conversion de masa",
                        JOptionPane.WARNING_MESSAGE, null, null, null);

                double cantidadMasa;

                if (cantidadMasaStr == null) {
                    JOptionPane.showMessageDialog(null, "Gracias por usar el conversor");
                    break;
                }

                try {
                    cantidadMasa = Double.parseDouble(cantidadMasaStr);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "La cantidad ingresada no es válida. Inténtelo nuevamente.");
                    continue; // Vuelve al inicio del ciclo
                }
                switch (eleccion) {
                    case "De kilogramos a gramos":
                        conversion("kilogramos", cantidadMasa, 3, "gramos");
                        break;
                    case "De kilogramos a toneladas":
                        conversion("kilogramos", cantidadMasa, -4, "toneladas");
                        break;
                    case "De kilogramos a onzas":
                        conversionAOnzasLibras("kilogramos", cantidadMasa, "onzas");
                        break;
                    case "De kilogramos a libras":
                        conversionAOnzasLibras("kilogramos", cantidadMasa, "libras");
                        break;
                    case "De gramos a kilogramos":
                        conversion("gramos", cantidadMasa, -3, "kilogramos");
                        break;
                    case "De gramos a onzas":
                        conversionAOnzasLibras("gramos", cantidadMasa, "onzas");
                        break;
                    case "De gramos a libras":
                        conversionAOnzasLibras("gramos", cantidadMasa, "libras");
                        break;
                    case "De toneladas a kilogramos":
                        conversion("toneladas", cantidadMasa, 3, "kilogramos");
                        break;
                    case "De toneladas a gramos":
                        conversion("toneladas", cantidadMasa, 6, "gramos");
                        break;
                    case "De toneladas a onzas":
                        conversionAOnzasLibras("toneladas", cantidadMasa, "onzas");
                        break;
                    case "De toneladas a libras":
                        conversionAOnzasLibras("toneladas", cantidadMasa, "libras");
                        break;
                    case "De onzas a kilogramos":
                        
                        break;
                    case "De onzas a gramos":

                        break;
                    case "De onzas a libras":
                        break;
                    case "De libras a kilogramos":
                        break;
                    case "De libras a gramos":
                        break;

                    default:
                        // "De libras a onzas"

                        break;

                }

            }
            int opcion = JOptionPane.showOptionDialog(null, "¿Desea realizar otra conversión de masas?",
                    "Otra conversión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new Object[] { "Sí", "No" }, "");

            if (opcion == JOptionPane.NO_OPTION) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "Gracias por usar el conversor");
            }
        }
    }
}
