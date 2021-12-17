package GitHub1;

import java.util.ArrayList;
import java.util.List;

public class MinimosQUadrados {
    public static void main(String[] args) {
        List<Double> varx = new ArrayList<>(List.of(907.0, 926.0, 506.0, 741.0, 789.0, 889.0, 874.0, 510.0, 529.0, 420.0));
        List<Double> vary = new ArrayList<>(List.of(11.2, 11.05, 6.84, 9.21, 9.42, 10.08, 9.45, 6.73, 7.24, 6.12));
        double somadeX = varx.stream().mapToDouble(Double::doubleValue).sum();
        System.out.printf("soma de x [%.3f]%n", somadeX);
        double somadeY = vary.stream().mapToDouble(Double::doubleValue).sum();
        System.out.printf("soma de y [%.3f]%n", somadeY);
        double mediaX = somadeX / varx.size();
        System.out.printf("medias de x [%.3f]%n", mediaX);
        double mediaY = somadeY / vary.size();
        System.out.printf("medias de Y [%.3f]%n", mediaY);

        ArrayList<Double> subDex = new ArrayList<>();
        for (Double aDouble : varx) {
            double subXi = aDouble - mediaX;
            subDex.add(subXi);
        }
        for (Double dex : subDex) {
            System.out.printf("Todos os valores de (Xi - Media) = [%.3f]%n", dex);
        }
        double subDeXi = subDex.stream().filter(n -> n > 0 ? n.isNaN() : n == 0).mapToDouble(Double::doubleValue).sum();
        double mediaDeXi = subDeXi / subDex.size();
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.printf("soma  de (xi - media): [%.2f]%n", subDeXi);
        System.out.printf("media 0 de (xi - media): [%.2f]%n", mediaDeXi);
        System.out.println("-----------------------------------------------------------------------------------------------------");


        ArrayList<Double> xAoQuadrado = new ArrayList<>();
        for (int i = 0; i < varx.size(); i++) {
            double pow = Math.pow(subDex.get(i), 2);
            xAoQuadrado.add(pow);
        }
        for (Double aDouble : xAoQuadrado) {

            System.out.printf("Valores totais de (xi - media)²: [%.3f]%n ", aDouble);
        }
        double somaXAoQuadrado = xAoQuadrado.stream().mapToDouble(Double::doubleValue).sum();
        double mediaXAoQuadrado = somaXAoQuadrado / xAoQuadrado.size();
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.printf("Soma total dos valores de (x-media)²: [%.3f]%n", somaXAoQuadrado);
        System.out.printf("Media dos valores de (x-media)²: [%.3f]%n", mediaXAoQuadrado);
        System.out.println("-----------------------------------------------------------------------------------------------------");


        ArrayList<Double> subDey = new ArrayList<>();
        for (Double yis : vary) {
            double subYi = yis - mediaY;
            subDey.add(subYi);
        }
        for (Double aDouble : subDey) {

            System.out.printf("Todos os valores de de (Yi - média) : [%.3f]%n", aDouble);
        }
        double somaYzero = subDey.stream().filter(n -> n > 0 ? n.isNaN() : n == 0).mapToDouble(Double::doubleValue).sum();
        double mediaYzero = somaYzero / subDey.size();
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.printf("soma da dubtração de y com a média: [%.4f]%n", somaYzero);
        System.out.printf("media  da subtração de y com a média: [%.4f]%n", mediaYzero);
        System.out.println("-----------------------------------------------------------------------------------------------------");


        ArrayList<Double> produtoSubXeY = new ArrayList<>();
        for (int i = 0; i < vary.size(); i++) {
            double produtoFinal = subDex.get(i) * subDey.get(i);
            produtoSubXeY.add(produtoFinal);
        }
        for (Double aDouble : produtoSubXeY) {

            System.out.printf("Todos os valores do produto de (xi-media)(yi-media): [%.3f]%n", aDouble);
        }
        double somaXY = produtoSubXeY.stream().mapToDouble(Double::doubleValue).sum();
        double mediaXY = somaXY / produtoSubXeY.size();
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.printf("Soma total do produto de (xi-media)(yi-media): [%.3f]%n", somaXY);
        System.out.printf("Media do somatorio do produto de (xi-media(yi-media): [%.3f]%n", mediaXY);
        System.out.println("-----------------------------------------------------------------------------------------------------");


     //ESTIMAÇÃO DOS PARÂMETROS VIA MÉTODO DOS MÍNIMOS QUADRADOS
        double parametroB1 = (somaXY / somaXAoQuadrado);
        double parametroB0 = mediaY - (parametroB1 * mediaX);
        System.out.printf("Resultado do parâmetro B0: [%.5f]%n", parametroB0);
        System.out.printf("Resultado do parâmetro B1: [%.5f]%n", parametroB1);

    }
}

