

import java.util.Scanner;

public class Cone extends FormaGeometrica {

    double altura, raio;

    public Cone() {
        this.tipo = Tipo.CONE;

    }

    public Cone(double altura, double raio) {
        this.altura = altura;
        this.raio = raio;
        this.tipo = Tipo.CONE;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
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
        s = s + " Tipo: Cone";
        s = s + cor.toString();
        s = s + posicao.toString();
        return s;
    }

    public void dimensoes(Scanner input) {

        do {
            System.out.println("Defina o valor da altura do Cone: ");
            altura = input.nextDouble();
            System.out.println("Defina o valor do raio da base do Cone: ");
            raio = input.nextDouble();

            if (altura < 0 || raio < 0) {
                System.out.println("Valor inválido. Introduza valores positivos.");
            } else {
                System.out.println("A altura do Cone terá valor de: " + altura);
                System.out.println("O raio da base do Cone terá valor de: " + raio);
            }
        } while (altura < 0 || raio < 0);
    }

    @Override
    public String toX3D() {
        String s = posicao.toX3D();
        s = s + "            <shape>\n";
        s = s + "                <appearance> \n";
        s = s + cor.toX3D();
        s = s + "                </appearance> \n";
        s = s + "                <cone bottomRadius='" + raio + "' height='" + altura + "'></cone> \n";

        s = s + "            </shape> \n";
        s = s + "            </transform> \n";
        return s;
    }
}