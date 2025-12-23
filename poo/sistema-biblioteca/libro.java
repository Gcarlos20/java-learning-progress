
public class libro {
    
    // atributos para los libros
    private int id;
    private String titulo;
    private String autor;
    private String editorial;
    private boolean disponible;

    // constructor
public libro(int id, String titulo, String autor, String editorial) {
    this.id = id;
    this.titulo = titulo;
    this.autor = autor;
    this.editorial = editorial;
    this.disponible = true;
}


    // ahora hacemos los getters y setters
         public int getId() {
        return id;
    }
    public String gettitulo(){
        return titulo;
    }
    public String getautor(){
        return autor;
    }
    public String geteditorial(){
        return editorial;
    }
    public boolean getdisponible(){
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public void mostrarInfo(){ // método para mostrar información del libro
        System.out.println("ID " + id + 
            "| Titulo " + titulo + 
            "| Autor "  + autor +
            "| Editorial " + editorial +
            "| Disponible " + disponible
        );
    }
    

    



 }
    


    

