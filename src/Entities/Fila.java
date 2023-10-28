package Entities;

import java.util.Arrays;

public class Fila {
    private int tamanhoMaximo;
    private String[] fila ;
    private int frente;
    private int traseira;
    private int tamanhoAtual;

    public Fila(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.fila = new String[tamanhoMaximo];
        this.frente = 0;
        this.traseira = -1;
        this.tamanhoAtual = 0;
    }

    public boolean estaVazia() {
        return tamanhoAtual == 0;
    }

    public boolean estaCheia() {
        return tamanhoAtual == tamanhoMaximo;
    }

    public void enfileirar(String elemento) {
        if (estaCheia()) {
            System.out.println("Fila está cheia. Não é possível enfileirar mais elementos.");
        } else {
            traseira = (traseira + 1) % tamanhoMaximo;
            fila[traseira] = elemento;
            tamanhoAtual++;
        }
    }

    public String desenfileirar() {
        if (estaVazia()) {
            System.out.println("Fila está vazia. Não é possível desenfileirar elementos.");
            return null; // Valor de retorno inválido se a fila estiver vazia
        } else {

            String elementoDesenfileirado = fila[frente];
            frente = (frente + 1) % tamanhoMaximo;
            tamanhoAtual--;
            return elementoDesenfileirado;
        }
    }
    public void jogo (int batataTimer){
        //for para repetição do jogo
        for (int i = 0; i < tamanhoMaximo; i++) {
            //for do print de quem esta com a batata
            for (int j = 0; j < batataTimer; j++) {
                System.out.println(Arrays.toString(fila));
                System.out.println(frente + " esta com a batata!");
            }
            //eliminação|vitoria
            if (tamanhoAtual > 1) {
                String eliminado = desenfileirar();
                System.out.println(eliminado + " esta eliminado!");
            }
            else {
                String eliminado = desenfileirar();
                System.out.println(eliminado + " é o vencedor!");
            }
        }
    }
}

