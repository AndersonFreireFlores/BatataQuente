package Entities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Fila {


    private ArrayList<String> jogadores = new ArrayList<>();

    public void adicionarJogador(String jogador) {
        jogadores.add(jogador);
    }

    public String moverJogador() {
        String jogador = jogadores.remove(0);
        if (jogadores.isEmpty()){
            jogadores.add(0,jogador);
        }else {
            jogadores.add(jogadores.size(),jogador);
        }
        return jogador;
    }

    public String jogo(int batataTimer) {
       int contador = 0;
       while (contador < jogadores.size()+(batataTimer)) {
           for (int i = 0; i < batataTimer - 1; i++) {
               String jogadorAtual = moverJogador();
               System.out.println(jogadorAtual + " está com a batata quente!");
           }
           String jogadormovido = moverJogador();
           if (jogadores.size() == 1){
               return jogadores.get(0);
           }
           System.out.println("A batata estorou na mão do jogador: "+jogadormovido);
           System.out.println(jogadormovido + " foi removido da roda.");
           jogadores.remove(jogadormovido);
           contador ++;
       }
        return jogadores.get(0);
    }
}

