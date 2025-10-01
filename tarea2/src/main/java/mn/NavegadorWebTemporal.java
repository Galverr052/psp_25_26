package mn;

import java.io.IOException;
import java.util.Scanner;

public class NavegadorWebTemporal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("Introduce tu url: ");
            String url = scanner.nextLine();
            if(url.isEmpty()){
                System.out.println("No se ha introducido nada");
            } else {
                abrirNavegador(url);
            }
            try{
               Thread.sleep(10000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    private static void abrirNavegador(String url){
        try{
            ProcessBuilder pb = new ProcessBuilder("cmd","/c","start", url);
            pb.start();
            System.out.println("abriendo" + url);
        }catch (IOException e) {
            System.out.println("error al abrir la URL" + e.getMessage());
        }
    }
}
