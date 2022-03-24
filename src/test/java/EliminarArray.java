public class EliminarArray{

    public static void main(String []args){

        String[][] info = new String[3][3];

        info[0][0]="Laura";
        info[0][1]="9";
        info[0][2]="8";
        info[1][0]="Pedro";
        info[1][1]="9";
        info[1][2]="8";
        info[2][0]="Luís";
        info[2][1]="9";
        info[2][2]="8";

        mostrarMatriz(info);

        //VAMOS A ELIMINAR A PEDRO
        System.out.println("\nVamos a eliminar a Pedro, que está en la fila 1\n");
        String[][] nuevaMatriz = new String[info.length-1][info[0].length];
        nuevaMatriz = eliminarFila(1, info);

        mostrarMatriz(nuevaMatriz);
    }

    public static String[][] eliminarFila(int numeroFila, String[][] info) {
        String[][] nuevaMatriz = new String[info.length-1][info[0].length];
        int contador = 0;

        for(int filaActual=0; filaActual<info.length; filaActual++) {
            for(int columnaActual=0; columnaActual<info[0].length; columnaActual++) {
                if(numeroFila==filaActual) {
                    filaActual++;
                }

                nuevaMatriz[contador][columnaActual]= info[filaActual][columnaActual];
            }
            contador++;
        }

        return nuevaMatriz;
    }

    public static void mostrarMatriz(String[][] info) {
        for (int i = 0; i < info.length; i++) {
            for (int j = 0; j < info[i].length; j++) {
                System.out.println(info[i][j]);
            }
        }
    }
}