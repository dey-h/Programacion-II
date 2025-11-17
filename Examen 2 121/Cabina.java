import java.util.ArrayList;

public class Cabina {
    private int nroCabinas;
    private ArrayList<Persona>personasAbordo;

    public Cabina(int nroCabinas){
        this.nroCabinas=nroCabinas;
        personasAbordo=new ArrayList<>();
    }
    //a)
    public boolean agregarPersona(Persona p){
        float pesoTotal = 0;

        for(Persona x : personasAbordo){
            pesoTotal += x.getPeso();
        }
        if(personasAbordo.size() < 10 && (pesoTotal + p.getPeso()) <= 850){
            personasAbordo.add(p);
            return true;
        }
        return false;
    }
    

    public ArrayList<Persona> getPersonas(){
        return personasAbordo;
    }

}
