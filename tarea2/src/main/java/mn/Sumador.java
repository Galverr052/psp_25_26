package mn;

public class Sumador {
    public static void main(String[] args) {
        if(args.length != 2){
            System.err.println("Error se deben introducir dos numeros");
            return;
        }
        try {
            double num1 = Double.parseDouble(args[0]);
            double num2 = Double.parseDouble(args[1]);
            double suma = num1 + num2;

            System.out.printf("la suma de los numeros es: " + suma);
        }  catch (NumberFormatException e){
            System.err.println("Error: Deben ser solo numeros");
        }
    }
}
