package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.desktop.OpenFilesEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

public class MetodoCantoNoroeste {
    public static void main(String[] args) throws IOException {

        System.out.println("\n********* METODO CANTO NOROESTE ********\n*");

        Scanner scanner = new Scanner(new File("dados.txt"));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] oferta = new int[n];
        int[] demanda = new int[m];
        int[][] custos = new int[n][m];
        for (int i = 0; i < n; i++) {
            oferta[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            demanda[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                custos[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        // Verificar se o problema está balanceado
        int somaOferta = Arrays.stream(oferta).sum();
        int somaDemanda = Arrays.stream(demanda).sum();
        if (somaOferta != somaDemanda) {
            System.err.println("O problema não está balanceado.");
            return;
        }else {
            System.out.println("Está balanceado !\n");
        }

        // Resolver o problema usando o método do canto noroeste
        int[][] alocacao = new int[n][m];
        cantoNoroeste(oferta, demanda, custos, alocacao);

        System.out.println("Matriz final:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(alocacao[i][j] + " ");
            }
            System.out.println();
        }

        // Calcular e imprimir o custo total
        int custoTotal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                custoTotal += alocacao[i][j] * custos[i][j];
            }
        }
        System.out.println("\nSolução otima (Z) = " + custoTotal);

        /******************************************** teste ******************************************
        BufferedImage img = ImageIO.read(new File("exemplo.jpeg"));
        ImageIcon icon = new ImageIcon(img);
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        JLabel lbl = new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/

    }

    public static void cantoNoroeste(int[] oferta, int[] demanda, int[][] custos, int[][] alocacao) {
        int i = 0;
        int j = 0;

        while (i < oferta.length && j < demanda.length) {
            int min = Math.min(oferta[i], demanda[j]);
            alocacao[i][j] = min;
            oferta[i] -= min;
            demanda[j] -= min;

            if (oferta[i] == 0) {
                i++;
            } else {
                j++;
            }
        }
    }
}
