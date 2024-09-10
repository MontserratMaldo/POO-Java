import java.util.Scanner;

public class Calificaciones {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Ingrese el número de materias: ");
        int numero_materias = input.nextInt();
        
        int[] creditos = new int[numero_materias];
        double[] calificaciones = new double[numero_materias];
        
        ingresarDatos(creditos, calificaciones, input);
        
        calcularYMostrarPromedioPonderado(creditos, calificaciones);
        
    }

    public static void ingresarDatos(int[] creditos, double[] calificaciones, Scanner input) {
        for (int i = 0; i < creditos.length; i++) {
            System.out.print("Ingrese los créditos de la materia " + (i + 1) + ": ");
            creditos[i] = input.nextInt();
            System.out.print("Ingrese la calificación de la materia " + (i + 1) + ": ");
            calificaciones[i] = input.nextDouble();
        }
    }

    public static void calcularYMostrarPromedioPonderado(int[] creditos, double[] calificaciones) {
        double suma_ponderada = 0;
        int suma_creditos = 0;
        
        System.out.println("\nCRÉDITOS\tCALIFICACIONES\tTOTAL");
        
        for (int i = 0; i < creditos.length; i++) {
            double total = calificaciones[i] * creditos[i];
            suma_ponderada += total;
            suma_creditos += creditos[i];
            System.out.printf("%d\t\t%.1f\t\t\t%.1f\n", creditos[i], calificaciones[i], total);
        }
        
        System.out.println("------------------------------------------------");
        System.out.printf("%d\t\t\t\t\t%.1f\n", suma_creditos, suma_ponderada);
        
        if (suma_creditos == 0) {
            System.out.println("No se puede calcular el promedio ponderado (suma de créditos es 0).");
            return;
        }
        
        double promedio_ponderado = suma_ponderada / suma_creditos;
        System.out.printf("\nPromedio Ponderado = %.2f\n", promedio_ponderado);
    }
    
}
