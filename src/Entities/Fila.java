package Entities;

import java.util.ArrayList;
import java.util.List;

public class Fila {
    private int tamanho;
    private int frente;
    private int traseira;

    private int batataTimer;


    public Fila(int tamanho, int batataTimer) {
        this.tamanho = tamanho;
        this.frente = 1;
        this.traseira = -1;
        this.batataTimer = batataTimer;

    }

    ArrayList<String> fila = new ArrayList<>(this.tamanho);

    public boolean estaVazia() {
        return frente == -1 && traseira == -1;
    }

    public boolean estaCheia() {
        return (traseira + 1) % tamanho == frente;
    }

    public void enfileirar(String elemento) {
        traseira = (traseira + 1) % tamanho;
        fila.add(elemento);
        System.out.println(elemento + " foi adicionado");
    }

    public void desenfileirar() {
        if (estaVazia()) {
            System.out.println("A fila está vazia. Não é possível desenfileirar elementos.");
        } else if (frente == traseira) {
            System.out.println("Vencedor = " + fila.get(frente));
            frente = -1;
            traseira = -1;
        } else {
            System.out.println("Eliminado = " + fila.get(frente));
            frente = (frente + 1) % tamanho;
        }
    }

    public void mostrarFila() {
        if (estaVazia()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("Elementos na fila: ");
            for (int i = frente; i != traseira; i = (i + 1) % tamanho) {
                System.out.print(fila.get(i) + " ");
            }
            System.out.println(fila.get(traseira));
        }
    }

    public void jogo() {
        while (!estaVazia()) {
            for (int i = 0; i < batataTimer; i++) {
                System.out.println(fila.get(i) + " esta com a batata!!!");
            }
            desenfileirar();
            if (!estaVazia()) {
                mostrarFila();
            }
        }
    }
}
