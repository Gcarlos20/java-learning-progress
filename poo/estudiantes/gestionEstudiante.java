package estudiantes;

import java.util.Scanner;
import java.util.ArrayList;

public class gestionEstudiante {
    String nombre;
    int edad;
    double nota1;
    double nota2;
    double nota3;
    // bloque de estadisticas
    public static void mostrarEstadisticas(ArrayList<gestionEstudiante> estudiantes){
        if(estudiantes.isEmpty()){
            System.out.println("No hay estudiantes Registrados para Mostrar Estadisticas.");
            return;
        }
        // calcular el promedio general, numero de aprobados y reprobados 
        double sumaPromedios=0;
        int aprobados=0;
        int reprobados=0;
        for(gestionEstudiante est : estudiantes){
            double promedio = est.calcularPromedio();
            sumaPromedios += promedio;
            if (promedio >= 3.0){
                aprobados++;
            } else {
                reprobados++;
            }
            }
            double promedioGeneral= sumaPromedios / estudiantes.size();
            System.out.println("Estadisticas de los estudiantes:");
            System.out.println("Promedio General: " + promedioGeneral);
            System.out.println("Numero de aprobados: " + aprobados);
            System.out.println("Numero de reprobados: " +  reprobados);
        }
        // bloque de busqueda de estudiantes
        public static gestionEstudiante buscarEstudiantePorNombre(ArrayList<gestionEstudiante> estudiantes, String nombre){
            for (gestionEstudiante est : estudiantes){
                if (est.nombre.equalsIgnoreCase(nombre))
                    return est;
            }
            System.out.println("Estudiante no encontrado: " + nombre);
            return null; 
        }
        // bloque de eliminacion de estudiantes
        public static boolean eliminarEstudiantePorNombre (ArrayList<gestionEstudiante> estudiantes, String nombre){
            for (int i=0; i<estudiantes.size(); i++){
                if (estudiantes.get(i).nombre.equalsIgnoreCase(nombre)){
                    estudiantes.remove(i);
                    System.out.println("Estudiante eliminado: " + nombre);
                    return true;
                }
            }
            System.out.println("Estudiante no encontrado para eliminar: " + nombre);
            return false;
        }

    

    public gestionEstudiante(String nombre, int edad, double nota1, double nota2, double nota3){
        this.nombre = nombre;
        this.edad = edad;
        this.nota1 = nota1;
        this.nota2= nota2;
        this.nota3= nota3;
    }
    // metodo para calcula el promedio
    public double calcularPromedio(){
        return (nota1+nota2+nota3)/3;
    }
    // para obtener el estado del estudiante
    public String obtenerEstado(){
        double promedio = calcularPromedio();
        if(promedio >= 3.0){
            return "Aprobado";
         } else {
            return "Reprobado";
         }
    }  
    // metodo para mostrar la informacion del estudiante
    public void mostrarInformacion(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("promedio: " + calcularPromedio());
        System.out.println("Estado: " + obtenerEstado());

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<gestionEstudiante> estudiantes = new ArrayList<>(); // lista para almacenar estudiantes
        int opcion;
        do {
            System.out.println("--- Menu de Gestion de Estudiantes ---");
            System.out.println("                                      ");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Mostrar informacion del estudiante");
            System.out.println("3. mostrar estadistica de Los estudiantes");
            System.out.println("4. buscar estudiante por nombre"); /// modificacionn 
            System.out.println("5. Eliminar estudiante");
            System.out.println("6. salir");
            System.out.println("seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar el buffer
            switch (opcion) {
                case 1: // registrar estudiante 
                    System.out.println("Ingrese el nombre del estudiante:");
                    String nombre = sc.nextLine();
                    System.out.println(" Ingrese la edad del estudiante:");
                    int edad = sc.nextInt();
                    System.out.println("Ingrese la primer nota:");
                    double nota1 = sc.nextDouble();
                    System.out.println("Ingrese la segunda nota: ");
                    double nota2= sc.nextDouble();
                    System.out.println("Ingrese la tercer nota:");
                    double nota3= sc.nextDouble();

                   // crear un nuevo objeto estudiante y agregarlo a la lista
                    estudiantes.add(new gestionEstudiante(nombre, edad, nota1, nota2, nota3));
                    System.out.println("Estudiante registrado existosamente.");
                    break;
                case 2:
                    if (!estudiantes.isEmpty()){ // verificar si hay estudiantes registrados
                        System.out.println("INformacion de los estudiantes registrados:");
                        for (gestionEstudiante est : estudiantes) {  // recorrer la lista y mostrar informacion
                            est.mostrarInformacion();
                            System.out.println("---");
                        }
                    }
                    else{
                        System.out.println("No hay estudiantes registrados. Por favor registre un estudiante primero.");
                    }
                    break;

                    case 3:
                        mostrarEstadisticas(estudiantes);
                        break;
                case 4: // se modificcara esta linea
                    System.out.println("Ingrese el nombre del estudiante a buscar:");
                    String nombreBuscar=sc.nextLine();
                    gestionEstudiante estbuscado = buscarEstudiantePorNombre(estudiantes, nombreBuscar);
                    if (estbuscado != null){
                        estbuscado.mostrarInformacion();
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el nombre a eliminar:");
                    String nombreEliminar = sc.nextLine();
                    eliminarEstudiantePorNombre(estudiantes, nombreEliminar);
                    break;
                case 6:
                    System.out.println("Saliendo del programa. Hasta luego!");
                default:
                    System.out.println("Opcion Invalida. Por Favor intente de nuevo");
            }
                
        } while(opcion != 3);
        sc.close();
    }
}

