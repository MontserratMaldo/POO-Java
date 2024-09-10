import java.util.Scanner;

public class Calificaciones {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese el número de materias: ");
        int numMaterias = sc.nextInt();
        
        int[] creditos = new int[numMaterias];
        double[] calificaciones = new double[numMaterias];
        
        ingresarDatos(creditos, calificaciones, sc);
        
        calcularYMostrarPromedioPonderado(creditos, calificaciones);
        
    }

    public static void ingresarDatos(int[] creditos, double[] calificaciones, Scanner sc) {
        for (int i = 0; i < creditos.length; i++) {
            System.out.print("Ingrese los créditos de la materia " + (i + 1) + ": ");
            creditos[i] = sc.nextInt();
            System.out.print("Ingrese la calificación de la materia " + (i + 1) + ": ");
            calificaciones[i] = sc.nextDouble();
        }
    }

    public static void calcularYMostrarPromedioPonderado(int[] creditos, double[] calificaciones) {
        double sumaPonderada = 0;
        int sumaCreditos = 0;
        
        System.out.println("\nCRÉDITOS\tCALIFICACIONES\tTOTAL");
        
        for (int i = 0; i < creditos.length; i++) {
            double total = calificaciones[i] * creditos[i];
            sumaPonderada += total;
            sumaCreditos += creditos[i];
            System.out.printf("%d\t\t%.1f\t\t\t%.1f\n", creditos[i], calificaciones[i], total);
        }
        
        System.out.println("------------------------------------------------");
        System.out.printf("%d\t\t\t\t\t%.1f\n", sumaCreditos, sumaPonderada);
        
        if (sumaCreditos == 0) {
            System.out.println("No se puede calcular el promedio ponderado (suma de créditos es 0).");
            return;
        }
        
        double promedioPonderado = sumaPonderada / sumaCreditos;
        System.out.printf("\nPromedio Ponderado = %.2f\n", promedioPonderado);
    }
    
}
