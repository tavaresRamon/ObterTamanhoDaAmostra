package GitHub1;

import java.util.Scanner;

public class TamanhoAmostra {
    public static final double NIVEL_CONFIANCA_90PORCENTO = 1.645;
    public static final double NIVEL_CONFIANCA_95PORCENTO = 1.96;
    public static final double NIVEL_CONFIANCA_98PORCENTO = 2.33;
    public static final double NIVEL_CONFIANCA_99PORCENTO = 2.58;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Irei criar um exemplo de amostragem e mostrarei como escolher o tamanho da amostra referente à população que pretendo estudar.
        do {
            System.out.println("Informe o tamanho da população:");
            //Exemplo: No meu instagram tenho 131 amigos: [População = 131]
            int populacao = scanner.nextInt();

            System.out.print("Informe qual a proporção: ");
            //Essa proporção se refere à percentagem que a gente pretende estudar sobre a população
            //Exemplo: Qual a probabilidade de 95% dos meus contatos (amigos) no instagram usarem o app(Instagram) menos de 3h por dia?
            //Daí a sua proporção é de 95%.
            double proporcao = scanner.nextDouble();
            if (proporcao >= 0 && proporcao < 100) {
                System.out.println("Proporção de " + proporcao + "% sobre a população de " + populacao);
                System.out.println("------------------------------------------------------------------------");
            } else {
                System.out.println("Digite valores dentre 0 e 99");
                return;
            }

            System.out.print("Informe o erro amostral: ");
            double erroAmostral = scanner.nextDouble();
            //Na parte do erro amostral informaremos a percentagem de erro que deseja aplicar na sua amostra.
            //Ex: Escolho 5% de erro. Ou seja, teremos 5% de erro na decisão do tamanho de amostra sobre a população em estudo.
            if (erroAmostral >= 0 && erroAmostral < 100) {
                System.out.println("Erro amostral de " + erroAmostral + "%");
                System.out.println("------------------------------------------------------------------------");
            } else {
                System.out.println("Digite um valor dentre 0 e 99");
                return;
            }

            double erroAmostralToleravel = erroAmostral / 100;
            //Existe uma tabela, chamada de tabela Z que nos informa os níveis de confiança e os respectivos valores. Logicamente que queremos uma alta confiabilidade nas nossas pesquisas por isso escolhei de 90 em diante.
            //Para o exemplo vou aplicar 98% de confiança na escolha do tamanho da minha amostra.
            System.out.println("Escolha um dos níveis de confiança: [90],[95],[98],[99]");
            int nivelDeSignificancia = scanner.nextInt();

            double proporcaoPercen = proporcao / 100;
            double nivel90 = Math.pow(NIVEL_CONFIANCA_90PORCENTO, 2);
            double nivel95 = Math.pow(NIVEL_CONFIANCA_95PORCENTO, 2);
            double nivel98 = Math.pow(NIVEL_CONFIANCA_98PORCENTO, 2);
            double nivel99 = Math.pow(NIVEL_CONFIANCA_99PORCENTO, 2);

            double formulaPara90 = (populacao * nivel90 * proporcaoPercen * (1 - proporcaoPercen)) / (((populacao - 1) * Math.pow(erroAmostralToleravel, 2)) + nivel90 * proporcaoPercen * (1 - proporcaoPercen));
            double formulaPara95 = (populacao * nivel95 * proporcaoPercen * (1 - proporcaoPercen)) / (((populacao - 1) * Math.pow(erroAmostralToleravel, 2)) + nivel95 * proporcaoPercen * (1 - proporcaoPercen));
            double formulaPara98 = (populacao * nivel98 * proporcaoPercen * (1 - proporcaoPercen)) / (((populacao - 1) * Math.pow(erroAmostralToleravel, 2)) + nivel98 * proporcaoPercen * (1 - proporcaoPercen));
            double formulaPara99 = (populacao * nivel99 * proporcaoPercen * (1 - proporcaoPercen)) / (((populacao - 1) * Math.pow(erroAmostralToleravel, 2)) + nivel99 * proporcaoPercen * (1 - proporcaoPercen));

            System.out.println("O Nível de confiança que se deseja obter é de " + nivelDeSignificancia + "%");
            System.out.println("------------------------------------------------------------------------");
            //Pronto com o exemplo citado acima obtive uma amostra de tamanho [58], ou seja, se eu quiser obter um relatório para saber se 95% dos
            //meus contatos  usam o app(Instagram) menos de 3h por dia, eu devo escolher 58 pessoas da minha população que contém 131.
            //Ou seja, conseguimos o tamanho da amostra de forma estratégica seguindo alguns passos estatísticos, aplicando os erros e os níveis de confiança.
            //Após saber o resultado da amostra, existe ainda vários métodos de amostragem para poder selecionar de forma correta essas 58 pessoas dentre os 131.
            //E com isso o nosso relatório será aplicado para uma amostra de 58 pessoas, o que nos dará uma base para responder sobre a população.
            //Vamos supor hipoteticamente que apenas 20 pessoas das 58 que apliquei o relatório, usam o Instagram menos de 3h por dia, eu poderia afirmar que 20 de 58 é aproximadamente 34%.
            //Ou seja, eu poderia responder pelo total populacional (131 Pessoas), afirmando que apenas 34% dos meus contatos usam o app menos de 3h por dia.


            //OBSERVAÇÃO: Esse exemplo é extremamente hipotético, para selecionarmos de forma precisa essas 58 pessoas(de um total de 131) para responder o relatório, devemos aplicar outros métodos de amostragem, não é apenas escolher 58 pessoas randomicamente e aplicar o relatório..Existe métodos mais eficientes com cálculos estatísticos estratégicos.
            //Esse método que desenvolvi é apenas para saber o  tamanho de uma amostra que devemos escolher para uma determinada população, tendo em vista níveis de confiança e de erros amostrais.

            switch (nivelDeSignificancia) {
                case 90 -> System.out.printf("Sua amostra é de tamanho [%.0f]", formulaPara90);
                case 95 -> System.out.printf("Sua amostra é de tamanho [%.0f]", formulaPara95);
                case 98 -> System.out.printf("Sua amostra é de tamanho [%.0f]", formulaPara98);
                case 99 -> System.out.printf("Sua amostra é de tamanho [%.0f] ", formulaPara99);
                default -> System.out.println("Digite um dos níveis de confiança - > [90],[95],[98],[99]");
            }
            System.out.println();
            System.out.println("------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Deseja coletar outro tamanho de amostra?\nDigite 's' para (Sim) ou 'n' para (Não)");
        }
        while (scanner.next().equalsIgnoreCase("s"));
    }
}