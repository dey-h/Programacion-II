import java.util.ArrayList;

public class MiTeleferico {
    private ArrayList <Linea> lineas;
    private float cantidadIngreos;

    public MiTeleferico(float cantidadIngreos){
        this.cantidadIngreos=cantidadIngreos;
        lineas=new ArrayList<>();
    }
    public void agregarLinea(Linea l){
        lineas.add(l);
    }

    public Linea buscarLinea(String color){
        for(Linea l : lineas){
            if(l.getColor().equalsIgnoreCase(color)){
                return l;
            }
        }
        return null;
    }
    //c)
    public float calcularIngresos(){
        float total = 0;

        for(Linea l : lineas){
            for(Cabina c : l.getCabinas()){
                for(Persona p : c.getPersonas()){
                    if(p.getEdad() < 25 || p.getEdad() > 60){
                        total += 1.5f;
                    } else {
                        total += 3f;
                    }
                }
            }
        }
        return total;
    }
    

}
