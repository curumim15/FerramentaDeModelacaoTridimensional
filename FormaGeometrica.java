

import java.util.Scanner;
public class FormaGeometrica {
    //atributos deste objeto
    Cor cor;
    Posicao posicao;

    public enum Tipo {
        CAIXA, CONE, CILINDRO, ESFERA, DESCONHECIDO;
    }

    Tipo tipo;

    //construtor
    public FormaGeometrica() {
        this.cor = null;
        this.posicao = null;
        this.tipo = Tipo.DESCONHECIDO;
    }

    public FormaGeometrica(Cor cor, Posicao posicao) {
        this.cor = cor;
        this.posicao = posicao;
        this.tipo = Tipo.DESCONHECIDO;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "FormaGeometrica{" + "cor=" + cor + ", posicao=" + posicao + '}';
    }

    public static Tipo inputTipo(Scanner input) {
        int tipo;
        Tipo resultado = Tipo.DESCONHECIDO;
        do {
            System.out.println("Qual o tipo de objeto que pertende modelar?");
            System.out.println("    1-Caixa");
            System.out.println("    2-Cone");
            System.out.println("    3-Cilindro");
            System.out.println("    4-Esfera");
            tipo = input.nextInt();

            switch (tipo) {
                case 1:
                    resultado = Tipo.CAIXA;
                    break;
                case 2:
                    resultado = Tipo.CONE;
                    break;
                case 3:
                    resultado = Tipo.CILINDRO;
                    break;
                case 4:
                    resultado = Tipo.ESFERA;
                    break;
                default:
                    System.out.println("Objeto inexistente");

            }

            System.out.println("Escolheu o objeto do tipo " + tipo);

        } while (tipo < 0 || tipo > 4);

        return resultado;
    }

    public String toX3D() {
        return "";
    }

    public static FormaGeometrica novoObjeto(Scanner input) {
        FormaGeometrica resultado = null;
        Tipo tipo = FormaGeometrica.inputTipo(input); //Ler o tipo de objeto
        switch (tipo) {
            case CAIXA:
                Caixa caixa = new Caixa(); // cria o objeto caixa
                caixa.dimensoes(input); // pede as dimensoes
                Cor corCaixa = Cor.inputCor(input); //ler a cor
                caixa.setCor(corCaixa); //guarda a cor
                Posicao posicaoCaixa = Posicao.inputPosicao(input); // ler a posiçao
                caixa.setPosicao(posicaoCaixa); //guarda a posicao
                resultado = caixa;
                break;
            case CONE:
                Cone cone = new Cone(); // cria o objeto cone
                cone.dimensoes(input); // pede as dimensoes
                Cor corCone = Cor.inputCor(input); //ler a cor
                cone.setCor(corCone);
                Posicao posicaoCone = Posicao.inputPosicao(input); // ler a posiçao
                cone.setPosicao(posicaoCone);
                resultado = cone;
                break;
            case CILINDRO:
                Cilindro cilindro = new Cilindro(); // cria o objeto cilindro
                cilindro.dimensoes(input); // pede as dimensoes
                Cor corCilindro = Cor.inputCor(input); //ler a cor
                cilindro.setCor(corCilindro);
                Posicao posicaoCilindro = Posicao.inputPosicao(input); // ler a posiçao
                cilindro.setPosicao(posicaoCilindro);
                resultado = cilindro;
                break;
            case ESFERA:
                Esfera esfera = new Esfera(); // cria o objeto esfera
                esfera.dimensoes(input); // pede as dimensoes
                Cor corEsfera = Cor.inputCor(input); //ler a cor
                esfera.setCor(corEsfera);
                Posicao posicaoEsfera = Posicao.inputPosicao(input); // ler a posiçao
                esfera.setPosicao(posicaoEsfera);
                resultado = esfera;
                break;
        }
        return resultado;
    }
}
