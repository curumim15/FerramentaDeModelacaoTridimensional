
import java.util.Scanner;
public class Cor {
    //atributos do objeto
    int red, green, blue;

    public Cor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    @Override
    public String toString() {
        return " Cor RGB: " + red + ", " + green + ", " + blue + ";";
    }

    public static Cor inputCor(Scanner input) {
        int rgbRed, rgbGreen, rgbBlue;
        do {
            System.out.println("Qual a cor do objeto? (R, G, B)");
            System.out.println(" Introduza o valor de R (entre 0 e 1): ");
            rgbRed = input.nextInt();
            System.out.println(" Introduza o valor de G (entre 0 e 1): ");
            rgbGreen = input.nextInt();
            System.out.println(" Introduza o valor de B (entre 0 e 1): ");
            rgbBlue = input.nextInt();

            if (rgbRed < 0 || rgbRed > 1 || rgbGreen < 0 || rgbGreen > 1 || rgbBlue < 0 || rgbBlue > 1) {
                System.out.println("Cor inexistente. Valores de RGB entre 0 e 1.");
            } else {
                System.out.println("Cor: " + rgbRed + ", " + rgbGreen + ", " + rgbRed);
            }
        } while (rgbRed < 0 || rgbRed > 1 || rgbGreen < 0 || rgbGreen > 1 || rgbBlue < 0 || rgbBlue > 1);

        //Devolver um novo objeto Cor
        Cor resultado = new Cor(rgbRed, rgbGreen, rgbBlue);

        return resultado;
    }

    public String toX3D() {
        return  "                <material diffuseColor='" + red + " " + green + " " + blue + "'></material> \n";
    }
}
