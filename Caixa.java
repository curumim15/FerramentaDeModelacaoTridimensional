
import java.util.Scanner;
public class Caixa extends FormaGeometrica{
    //atributos da caixa
    double aresta;

    public Caixa() {
        this.tipo = Tipo.CAIXA;
    }

    //construtor
    public Caixa(double aresta) {
        this.aresta = aresta;
        this.tipo = Tipo.CAIXA;
    }

    public double getAresta() {
        return aresta;
    }

    public void setAresta(double aresta) {
        this.aresta = aresta;
    }

    @Override
    public String toString() {
        String s = "Objeto: ";
        s = s + " Tipo: Caixa";
        s = s + cor.toString();
        s = s + posicao.toString();
        return s;
    }

    public void dimensoes(Scanner input) {

        do {
            System.out.println("Defina o valor das medidas das arestas da caixa: ");
            aresta = input.nextDouble();

            if (aresta < 0) {
                System.out.println("Valor inválido. Introduza valores positivos.");
            } else {
                System.out.println("As arestas da caixa terão valor de: " + aresta);
            }
        } while (aresta < 0);

    }

    @Override
    public String toX3D() {
        String s = posicao.toX3D();
        s = s + "            <shape>\n";
        s = s + "                <appearance> \n";
        s = s + cor.toX3D();
        s = s + "                </appearance> \n";
        s = s + "                <box size='" + aresta + " " + aresta + " " + aresta + "'></box> \n";

        s = s + "            </shape> \n";
        s = s + "            </transform> \n";
        return s;

    }
}
