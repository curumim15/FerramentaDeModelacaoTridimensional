import java.util.Scanner;

public class Posicao {

    //atributos do objeto
    int x, y, z;

    //construtor
    public Posicao(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return " Posição XYZ: " + x + ", " + y + ", " + z + " ";
    }

    public static Posicao inputPosicao(Scanner input) {
        int posicaoX, posicaoY, posicaoZ;

        System.out.println("Qual a posição do objeto? (X, Y, Z)");
        System.out.println(" Introduza o valor de X: ");
        posicaoX = input.nextInt();
        System.out.println(" Introduza o valor de Y: ");
        posicaoY = input.nextInt();
        System.out.println(" Introduza o valor de Z: ");
        posicaoZ = input.nextInt();

        Posicao resultado = new Posicao(posicaoX, posicaoY, posicaoZ);

        return resultado;
    }

    public String toX3D() {
        return "            <transform translation='" + x + " " + y + " " + z + "'>\n";

    }

}
