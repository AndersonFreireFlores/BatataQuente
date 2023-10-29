package Application;

import Entities.Fila;
import ParteGrafica.MyFrame;
import ParteGrafica.MyLabel;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insira o numero de pessoas: ");
        int tamanho = Integer.parseInt(sc.nextLine());
        System.out.println("Insira o num de passadas até a batata explodir: ");
        int batataTimer = Integer.parseInt(sc.nextLine());
        Fila fila = new Fila();

        for (int i = 0; i < tamanho; i++) {
            System.out.println("Digite um nome para ser adicionado: ");
            String nome = sc.nextLine();
            fila.adicionarJogador(nome);

        }

        String vencedor = fila.jogo(batataTimer);
        System.out.println("O vencedor é: " + vencedor);

    }
}