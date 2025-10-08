package mn;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class shell {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Debes indicar un fichero o un directorio");
            System.err.println("Uso: java shell <ruta>");
            return;
        }
        //verificando que exita la ruta
        File ruta = new File(args[0]);
        if (!ruta.exists()){
            System.err.println("La ruta no se ha encontrado.");
            return;
        }
        //detectando el OS
        String os = System.getProperty("os.name").toLowerCase();
        try {
            if (ruta.isFile()){
                System.out.println(ruta + "\nEs un archivo.txt:");
                Process process;
                if (os.contains("win")){
                    process = new ProcessBuilder("cmd", "/c", "more", ruta.getAbsolutePath()).inheritIO().start();
                } else {
                    process = new ProcessBuilder("sh", "-c", "more", ruta.getAbsolutePath()).inheritIO().start();
                }
                process.waitFor();

            } else if (ruta.isDirectory()) {
                System.out.println(ruta + "\n Es un directorio");
                File [] files = ruta.listFiles();
                if (files != null && files.length > 0){
                    System.out.println("Contenido del Directorio " + ruta.getAbsolutePath() + ":");
                    for (File f : files)  {
                        if (f.isDirectory()){
                            System.out.println("[DIR]  " + f.getName());
                        } else {
                            System.out.println("       " + f.getName());
                        }
                    }
                } else {
                    System.out.println("El directorio esta vacío.");
                }
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al ejecturar el comando" + e.getMessage());
        }
    }
}