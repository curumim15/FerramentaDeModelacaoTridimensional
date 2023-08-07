import java.util.Scanner;

public class Esfera extends FormaGeometrica {

    //atributos
    double raio;

    public Esfera() {
        this.tipo = Tipo.ESFERA;
    }

    public Esfera(double raio) {
        this.raio = raio;
        this.tipo = Tipo.ESFERA;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public String toString() {
        String s = "Objeto: ";
        s = s + " Tipo: Esfera";
        s = s + cor.toString();
        s = s + posicao.toString();
        return s;
    }

    public void dimensoes(Scanner input) {

        do {
            System.out.println("Defina o valor do raio da esfera: ");
            raio = input.nextDouble();

            if (raio < 0) {
                System.out.println("Valor inválido. Introduza valores positivos.");
            } else {
                System.out.println("O raio da esfera terá valor de: " + raio);
            }
        } while (raio < 0);
    }

    @Override
    public String toX3D() {
        String s = posicao.toX3D();
        s = s + "            <shape>\n";
        s = s + "                <appearance> \n";
        s = s + cor.toX3D();
        s = s + "                </appearance> \n";
        s = s + "                <sphere radius='" + raio + "'></sphere> \n";

        s = s + "            </shape> \n";
        s = s + "            </transform> \n";
        return s;
    }

}
