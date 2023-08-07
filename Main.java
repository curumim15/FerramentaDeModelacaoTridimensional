import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int maxObjetos = 10;
        int acao;
        //Array de 10 objetos
        FormaGeometrica[] objetos = new FormaGeometrica[maxObjetos];
        int numObjetos = 0; // numero de objetos nos arrays
        int obj;

        do {
            System.out.println("Ferramenta de modelação tridimensional: ");
            System.out.println("    1-Criar Objeto");
            System.out.println("    2-Alterar Objeto");
            System.out.println("    3-Apagar Objeto");
            System.out.println("    4-Listar Objetos");
            System.out.println("    5-Gerar o modelo em X3D");
            System.out.println("    0-Sair");
            acao = input.nextInt();

            if (acao < 0 || acao > 5) {
                System.out.println("Ação inexistente");
            } else if (acao == 1) {
                System.out.println("Criar um novo objeto.");
                if (numObjetos >= maxObjetos) {
                    System.out.println("Não é possivel criar mais objetos.");
                } else {
                    numObjetos++; // incrementar uma unidade, acrescentar mais um objeto

                    System.out.println("Novo objeto com número: " + numObjetos);

                    obj = numObjetos - 1; //objeto está na posiçao numObjetos - 1

                    objetos[obj] = FormaGeometrica.novoObjeto(input);

                }

            } else if (acao == 2) {
                System.out.println("Alterar objeto.");
                System.out.println("Qual o número do objeto a alterar? (numero de objetos = " + numObjetos + ").");
                obj = input.nextInt();

                if (obj < 1 || obj > numObjetos) {
                    System.out.println("Objeto inexistente.");
                } else { //pedir novos valores do objeto
                    System.out.println("Alteração do objeto número: " + obj);

                    objetos[obj - 1] = FormaGeometrica.novoObjeto(input);

                }

            } else if (acao == 3) {
                System.out.println("Apagar objeto.");
                System.out.println("Qual o número do objeto  a apagar? (numero de objetos = " + numObjetos + ").");
                obj = input.nextInt();

                if (obj < 1 || obj > numObjetos) {
                    System.out.println("Objeto inexistente.");
                } else { //apagar o objeto
                    System.out.println("Apagar o objeto número: " + obj);

                    System.out.println(objetos[obj - 1].toString());

                    for (int i = obj - 1; i < maxObjetos - 1; i++) {
                        //Puxar todas as posiçoes do array uma posiçao para tras
                        //O valor da posição i+1 passa para a posiçao i
                        objetos[i] = objetos[i + 1];

                    }

                    numObjetos--; //decrementar uma unidade, ou seja, temos menos um objeto
                }
            } else if (acao == 4) {
                System.out.println("Listagem dos objetos: ");

                if (numObjetos == 0) {
                    System.out.println("Não existem objetos");

                }

                for (int i = 0; i < numObjetos; i++) {
                    System.out.println(objetos[i].toString());
                }

            } else if (acao == 5) {
                System.out.println("Gerar modelo.");
                String s = "<html>\n";
                s = s + "    <head>\n";
                s = s + "        <title>IPVC</title> 			\n";
                s = s + "        <script type='text/javascript' src='http://www.x3dom.org/download/x3dom.js'> </script> \n";
                s = s + "        <link rel='stylesheet' type='text/css' href='http://www.x3dom.org/download/x3dom.css'></link> \n";
                s = s + "    </head> \n";
                s = s + "    <body> \n";
                s = s + "        <h1>Introdução à Programação - ECGM 2021/2022</h1> \n";
                s = s + "        <p> \n";
                s = s + "            Trabalho Prático - Editor de X3D (linguagem descritiva de mundos virtuais). \n";
                s = s + "        </p>\n\n"; // fim do html

                s = s + "        <x3d width='900px' height='600px'>\n"; // inicio do x3d
                s = s + "        <scene>\n";

                for (int i = 0; i < numObjetos; i++) {
                    s = s + objetos[i].toX3D();

                }

                s = s + "        </scene>\n";
                s = s + "        </x3d>\n";
                //fim do x3d
                s = s + "    </body> \n";
                s = s + "</html> \n";
                //fim do html

                //System.out.println(s);
                try {
                    Files.write(Paths.get("trabalho.html"), s.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        } while (acao != 0);

        System.out.println("Programa terminado");

    }
}
