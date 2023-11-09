import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        SumaFilas s = new SumaFilas();
        s.mostrar();
        System.out.println("\n");
        s.sumar();
        s.mostrar();
    }
}

class SumaFilas {

    private int[][] matriz;
    private int fila;

    public SumaFilas() {
        matriz = new int[3][3];
        Random rd = new Random();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = rd.nextInt(30);
            }
        }
    }

    public void sumar() {

        for (int i = 0; i < matriz.length; i++) {
            this.fila = i;
            Suma suma = new Suma();
            Thread t = new Thread(suma);

            t.start();
            try {
                t.join(); //esperamos a que el hilo termine
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void mostrar() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");

        }
    }

    class Suma extends Thread {
        @Override
        public void run() {
            for (int j = 0; j < matriz[fila].length; j++) {
                matriz[fila][j] *= 2;
            }
        }
    }

}
