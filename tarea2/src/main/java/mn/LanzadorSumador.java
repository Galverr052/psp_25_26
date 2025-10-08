package mn;

import java.io.*;

public class LanzadorSumador {
    public static void main(String[] args) {
        try {
        ProcessBuilder pb1 = new ProcessBuilder("java", "C:\\Users\\2DAM-galverr052\\repositorios\\psp_25_26\\tarea2\\src\\main\\java\\mn\\Sumador.java", "5", "8");
        ProcessBuilder pb2 = new ProcessBuilder("java", "C:\\Users\\2DAM-galverr052\\repositorios\\psp_25_26\\tarea2\\src\\main\\java\\mn\\Sumador.java", "4", "1");

        Process hijo1 = pb1.start();
        Process hijo2 = pb2.start();

        hijo1.waitFor();
        hijo2.waitFor();

        try (BufferedReader br1 = new BufferedReader(new InputStreamReader(hijo1.getInputStream()))){
            String linea;
            System.out.println("Salida del hijo 1:");
            while ((linea = br1.readLine()) !=null) {
                System.out.println(linea);
            }
        }
        try (BufferedReader br2 = new BufferedReader(new InputStreamReader(hijo2.getInputStream()))){
            PrintWriter pw = new PrintWriter(new FileWriter("salidaHijo2.txt"));
            String linea;
            while ((linea = br2.readLine()) !=null) {
                pw.println(linea);
                pw.close();
            }
        }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
