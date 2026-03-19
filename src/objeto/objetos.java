package src.objeto;

public class objetos {
    public static void main(String[] args) {
        // Crear un objeto de la clase Persona
        persona persona1 = new persona( "Juan", 30);
        // Mostrar los atributos del objeto
        System.out.println("Nombre: " + persona1.nombre);
        System.out.println("Edad: " + persona1.edad);
    }
 }

 class persona {
    String nombre;
    int edad;
     persona(String nombre, int edad){ // Constructor para inicializar los atributos
        this.nombre = nombre;
        this.edad = edad;
     }
 }
  