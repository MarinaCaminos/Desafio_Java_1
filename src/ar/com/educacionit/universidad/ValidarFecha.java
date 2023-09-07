package ar.com.educacionit.universidad;
import java.util.Scanner;

public class ValidarFecha {
	
	// Ingreso de datos
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fecha;

        do {
            System.out.print("Ingrese una fecha (dd/mm/yyyy): ");
            fecha = scanner.nextLine();
        } while (!validarFormato(fecha));

        scanner.close();

        if (validarFecha(fecha)) {
            System.out.println("La fecha es válida.");
        } else {
            System.out.println("La fecha no es válida.");
        }
    }

    // Valido formato ingresado, debe ser "dd/mm/yyyy"
    public static boolean validarFormato(String fecha) {
        String[] partes = fecha.split("/");
        if (partes.length != 3) {
            System.out.println("Formato incorrecto. Debe ser dd/mm/yyyy.");
            return false;
        }

        try {
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int anio = Integer.parseInt(partes[2]);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto. Debe ser dd/mm/yyyy.");
            return false;
        }

        return true;
    }

    // Valido fecha
    public static boolean validarFecha(String fecha) {
        String[] partes = fecha.split("/");
        if (partes.length != 3) {
            return false;
        }

        int dia, mes, anio;
        try {
            dia = Integer.parseInt(partes[0]);
            mes = Integer.parseInt(partes[1]);
            anio = Integer.parseInt(partes[2]);
        } catch (NumberFormatException e) {
            return false;
        }

        // Valido anio
        if (anio < 1900 || anio > 2099) {
            return false;
        }
        
        // Valido mes
        if (mes < 1 || mes > 12) {
            return false;
        }

        // Valido dia
        if (dia < 1 || dia > diasEnMes(mes, anio)) {
            return false;
        }

        return true;
    }

    public static int diasEnMes(int mes, int anio) {
        int[] diasPorMes = {31, 28 + (esBisiesto(anio) ? 1 : 0), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return diasPorMes[mes - 1];
    }

    public static boolean esBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }
}