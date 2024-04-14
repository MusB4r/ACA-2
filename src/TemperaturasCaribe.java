import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TemperaturasCaribe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear un ArrayList para almacenar las temperaturas por ciudad
        ArrayList<Double> temperaturasBarranquilla = new ArrayList<>();
        ArrayList<Double> temperaturasCartagena = new ArrayList<>();
        ArrayList<Double> temperaturasSantaMarta = new ArrayList<>();
        ArrayList<Double> temperaturasRiohacha = new ArrayList<>();
        ArrayList<Double> temperaturasSincelejo = new ArrayList<>();
        ArrayList<Double> temperaturasValledupar = new ArrayList<>();
        ArrayList<Double> temperaturasMonteria = new ArrayList<>();

        // Capturar las mediciones de temperatura para cada ciudad
        capturarTemperaturas("Barranquilla", temperaturasBarranquilla, scanner);
        capturarTemperaturas("Cartagena", temperaturasCartagena, scanner);
        capturarTemperaturas("Santa Marta", temperaturasSantaMarta, scanner);
        capturarTemperaturas("Riohacha", temperaturasRiohacha, scanner);
        capturarTemperaturas("Sincelejo", temperaturasSincelejo, scanner);
        capturarTemperaturas("Valledupar", temperaturasValledupar, scanner);
        capturarTemperaturas("Montería", temperaturasMonteria, scanner);

        // Mostrar las temperaturas almacenadas por ciudad
        mostrarTemperaturas("Barranquilla", temperaturasBarranquilla);
        mostrarTemperaturas("Cartagena", temperaturasCartagena);
        mostrarTemperaturas("Santa Marta", temperaturasSantaMarta);
        mostrarTemperaturas("Riohacha", temperaturasRiohacha);
        mostrarTemperaturas("Sincelejo", temperaturasSincelejo);
        mostrarTemperaturas("Valledupar", temperaturasValledupar);
        mostrarTemperaturas("Montería", temperaturasMonteria);

        // Determinar la ciudad con la mayor temperatura
        String ciudadMayorTemperatura = determinarCiudadMayorTemperatura(
                temperaturasBarranquilla, temperaturasCartagena, temperaturasSantaMarta,
                temperaturasRiohacha, temperaturasSincelejo, temperaturasValledupar,
                temperaturasMonteria);
        System.out.println("La ciudad con la mayor temperatura es: " + ciudadMayorTemperatura);

        // Determinar la ciudad con la menor temperatura
        String ciudadMenorTemperatura = determinarCiudadMenorTemperatura(
                temperaturasBarranquilla, temperaturasCartagena, temperaturasSantaMarta,
                temperaturasRiohacha, temperaturasSincelejo, temperaturasValledupar,
                temperaturasMonteria);
        System.out.println("La ciudad con la menor temperatura es: " + ciudadMenorTemperatura);

        scanner.close();
    }

    // Método para capturar las temperaturas de una ciudad y almacenarlas en el ArrayList correspondiente
    public static void capturarTemperaturas(String ciudad, ArrayList<Double> temperaturas, Scanner scanner) {
        System.out.println("Ingrese las temperaturas para " + ciudad + ":");
        for (int i = 0; i < 7; i++) {
            System.out.print("Temperatura día " + (i + 1) + ": ");
            double temperatura = scanner.nextDouble();
            temperaturas.add(temperatura);
        }
    }

    // Método para mostrar las temperaturas almacenadas por ciudad
    public static void mostrarTemperaturas(String ciudad, ArrayList<Double> temperaturas) {
        System.out.println("Temperaturas almacenadas para " + ciudad + ": " + temperaturas);
    }

    // Método para determinar la ciudad con la mayor temperatura
    public static String determinarCiudadMayorTemperatura(ArrayList<Double>... temperaturasPorCiudad) {
        double maxTemperatura = Double.MIN_VALUE;
        String ciudadMaxTemperatura = "";

        for (int i = 0; i < temperaturasPorCiudad.length; i++) {
            ArrayList<Double> temperaturas = temperaturasPorCiudad[i];
            double max = temperaturas.stream().max(Double::compare).orElse(Double.MIN_VALUE);
            if (max > maxTemperatura) {
                maxTemperatura = max;
                switch (i) {
                    case 0:
                        ciudadMaxTemperatura = "Barranquilla";
                        break;
                    case 1:
                        ciudadMaxTemperatura = "Cartagena";
                        break;
                    case 2:
                        ciudadMaxTemperatura = "Santa Marta";
                        break;
                    case 3:
                        ciudadMaxTemperatura = "Riohacha";
                        break;
                    case 4:
                        ciudadMaxTemperatura = "Sincelejo";
                        break;
                    case 5:
                        ciudadMaxTemperatura = "Valledupar";
                        break;
                    case 6:
                        ciudadMaxTemperatura = "Montería";
                        break;
                }
            }
        }

        return ciudadMaxTemperatura;
    }

    // Método para determinar la ciudad con la menor temperatura
    public static String determinarCiudadMenorTemperatura(ArrayList<Double>... temperaturasPorCiudad) {
        double minTemperatura = Double.MAX_VALUE;
        String ciudadMinTemperatura = "";

        for (int i = 0; i < temperaturasPorCiudad.length; i++) {
            ArrayList<Double> temperaturas = temperaturasPorCiudad[i];
            double min = temperaturas.stream().min(Double::compare).orElse(Double.MAX_VALUE);
            if (min < minTemperatura) {
                minTemperatura = min;
                switch (i) {
                    case 0:
                        ciudadMinTemperatura = "Barranquilla";
                        break;
                    case 1:
                        ciudadMinTemperatura = "Cartagena";
                        break;
                    case 2:
                        ciudadMinTemperatura = "Santa Marta";
                        break;
                    case 3:
                        ciudadMinTemperatura = "Riohacha";
                        break;
                    case 4:
                        ciudadMinTemperatura = "Sincelejo";
                        break;
                    case 5:
                        ciudadMinTemperatura = "Valledupar";
                        break;
                    case 6:
                        ciudadMinTemperatura = "Montería";
                        break;
                }
            }
        }

        return ciudadMinTemperatura;
    }
}
