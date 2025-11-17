import java.util.ArrayList;

public class Linea {
    private String color;
    private int  cantidadCabinas;
    private ArrayList<Persona>filaPersonas;
    private ArrayList <Cabina>cabinas;

    public Linea(String color, int cantidadCabinas){
        this.color=color;
        this.cantidadCabinas=0;
        filaPersonas = new ArrayList<>();
        cabinas=new ArrayList<>();
    } 
    public void agregarPersonaFila(Persona p){
        filaPersonas.add(p);
    }

    public void agregarCabina(Cabina c){
        cabinas.add(c);
    }

    public ArrayList<Persona> getFila(){
        return filaPersonas;
    }

    public ArrayList<Cabina> getCabinas(){
        return cabinas;
    }

    public String getColor(){
        return color;
    }
        
}    

