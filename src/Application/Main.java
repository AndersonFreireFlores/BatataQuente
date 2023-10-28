package Application;

import Entities.Fila;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insira o numero de pessoas: ");
        int tamanho = Integer.parseInt(sc.nextLine());
        System.out.println("Insira o num de passadas até a batata explodir: ");
        int batataTimer = Integer.parseInt(sc.nextLine());
        Fila fila = new Fila(tamanho);
        for (int i = 0; i < tamanho; i++) {
            System.out.println("Digite um nome para ser adicionado: ");
            fila.enfileirar(sc.nextLine());
        }
        fila.jogo(batataTimer);

    }
}