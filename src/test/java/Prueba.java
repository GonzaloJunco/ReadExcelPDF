public class Prueba {
    public static void main(String[] args) {
        String cadenaDondeBuscar = "sql";
        String loQueQuieroBuscar = "lenguaje sql sql sql";
        String[] palabras = loQueQuieroBuscar.split("\\W+");
        for (String palabra : palabras) {
            if (cadenaDondeBuscar.contains(palabra)) {
                System.out.println("Encontrado");
                //aquí tu lógica en caso que se haya encontrado...
            }
        }

//        String cadenaDondeBuscar = "sql";
//        String loQueQuieroBuscar = "lenguaje sql sql";
//        String[] palabras = loQueQuieroBuscar.split("\\s+");
//        for (String palabra : palabras) {
//            if (cadenaDondeBuscar.contains(palabra)) {
//                System.out.println("Encontrado");
//                //aquí tu lógica en caso que se haya encontrado...
//            }
//        }
    }
}

