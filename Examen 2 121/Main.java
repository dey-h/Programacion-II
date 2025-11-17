public class Main {
    public static void main(String[] args) {
        MiTeleferico mt = new MiTeleferico(20);
        Linea l1 = new Linea("amarillo", 10);
        Linea l2 = new Linea("rojo",15);
        Linea l3 = new Linea("verde",15);

        mt.agregarLinea(l1);
        mt.agregarLinea(l2);

        Cabina c1 = new Cabina(1);
        Cabina c2 = new Cabina(2);

        l1.agregarCabina(c1);
        l1.agregarCabina(c2);

        Persona per1 = new Persona("Juan", 15, 60);
        Persona per2 = new Persona("Maria", 30, 70);
        Persona per3 = new Persona("Luis", 70, 80);
      
        l1.agregarPersonaFila(per1);
        l1.agregarPersonaFila(per2);
        l1.agregarPersonaFila(per3);
        //b)
        for(Persona p : l1.getFila()){
            for(Cabina cab : l1.getCabinas()){
                if(cab.agregarPersona(p)){
                    break;
                }
            }
        }
        System.out.println("agregar a cabina nrox"+c1.agregarPersona(per1));
        System.out.println("Ingreso total: " + mt.calcularIngresos());
    }
}
