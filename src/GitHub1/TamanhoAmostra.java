package GitHub1;

import java.util.Scanner;

public class TamanhoAmostra {
    public static final double 
    NIVEL_CONFIANCA_90PORCENTO = 1.645,
    NIVEL_CONFIANCA_95PORCENTO = 1.96,
    NIVEL_CONFIANCA_98PORCENTO = 2.33, 
    NIVEL_CONFIANCA_99PORCENTO = 2.58;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.println("Informe o tamanho da população:");
            
            int populacao = scanner.nextInt();

            System.out.print("Informe qual a proporção: ");
            
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
            
            if (erroAmostral >= 0 && erroAmostral < 100) {
                System.out.println("Erro amostral de " + erroAmostral + "%");
                System.out.println("------------------------------------------------------------------------");
            } else {
                System.out.println("Digite um valor dentre 0 e 99");
                return;
            }

            double erroAmostralToleravel = erroAmostral / 100;
           
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
