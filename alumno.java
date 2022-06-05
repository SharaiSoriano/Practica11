import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class archivo{
    public String leerarchivo(String direccion){

        try{
            BufferedReader bf = BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                
                temp = temp + bfRead;
            }

            texto = temp;
        }catch(Exception e){
            System.err.println("No se encontro el archivo");
        }
        return texto;
    }
}



public class alumno {
 
    String nombre;
    static String promedio;
    String matricula;
    int calificaciones;
 
    public alumno(String nombre, String promedio, String matricula, int calificaciones) {
        this.nombre = nombre;
        this.promedio = promedio;
        this.matricula = matricula;
        this.calificaciones = calificaciones;
    }
 
    public int getcalificaciones() {
        return calificaciones;
    }
 
    @Override
    public String toString() {
        return "Nombre: " + nombre
                + "\nMatricula: " + matricula
                + "\nCalificaciones: " + calificaciones
                + "\nPromedio: " + calificaciones
                + "\n\n";
    }
 
    public static void main(String[] args) {
        List<alumno> array = new ArrayList();
        for (int i = 1; i <= 3; i++) {
            System.out.println("Alumno num. " + i);
            array.add(imprimiralum());
            System.out.println();
        }
 
        alumno[] array2 = new alumno[array.size()];
        array.toArray(array2);
        for (int i = array2.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (j + 1 <= i && array2[j].getcalificaciones() < array2[j + 1].getcalificaciones()) {
                    alumno aux = array2[j];
                    array2[j] = array2[j + 1];
                    array2[j + 1] = aux;
                }
            }
        }
 
        for (alumno d : array2) {
            System.out.println(d);
        }

        archivo a = new archivo();

        String s1 = a.leerarchivo("C:\\Users\\David\\OneDrive\\Escritorio\\POO\\P11\\practica11.csv");
        System.out.println(s1);

    }
 
    public static alumno imprimiralum() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Introduce el nombre: ");
            String nombre = br.readLine();
            System.out.print("Introduce la matricula: ");
            String matricula = br.readLine();
            System.out.print("Calificaciones: ");
            String calificaciones = br.readLine();
            System.out.print("Promedio: ");

            promedio= calificaciones;
            String promedio = br.readLine();
            
            
            
            System.out.println("Se genero el archivo con la informacion.");
            
            return new alumno(nombre, promedio, matricula, Integer.parseInt(calificaciones));
        } 
        
        catch (IOException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Hubo un error de lectura, favor intentar de nuevo...");
            return imprimiralum();
        }
    }
}