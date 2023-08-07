import java.util.Scanner;

public class Cilindro extends FormaGeometrica {

    //atributos do objeto
    double altura, raio;

    public Cilindro() {
        this.tipo = Tipo.CILINDRO;

    }

    //construtor
    public Cilindro(double altura, double raio) {
        this.altura = altura;
        this.raio = raio;
        this.tipo = Tipo.CILINDRO;
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
        s = s + " Tipo: Cilindro";
        s = s + cor.toString();
        s = s + posicao.toString();
        return s;
    }

    public void dimensoes(Scanner input) {

        do {
            System.out.println("Defina o valor da altura do cilindro: ");
            altura = input.nextDouble();
            System.out.println("Defina o valor do raio da base do cilindro: ");
            raio = input.nextDouble();

            if (altura < 0 || raio < 0) {
                System.out.println("Valor inválido. Introduza valores positivos.");
            } else {
                System.out.println("A altura do cilindro terá valor de: " + altura);
                System.out.println("O raio da base do cilindro terá valor de: " + raio);
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
        s = s + "                <cylinder radius='" + raio + "' height='" + altura + "'></cylinder> \n";

        s = s + "            </shape> \n";
        s = s + "            </transform> \n";
        return s;
    }

}