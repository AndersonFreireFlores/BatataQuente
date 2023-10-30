package Entities;

import java.util.ArrayList;

public class Fila {

    private ArrayList<String> jogadores = new ArrayList<>();

    public void adicionarJogador(String jogador) {
        jogadores.add(jogador);
    }

    //metodo responsavel pela circularidade
    public String moverJogador() {
        String jogador = jogadores.remove(0);
        if (jogadores.isEmpty()){
            jogadores.add(0,jogador);
        }else {
            jogadores.add(jogadores.size(),jogador);
        }
        return jogador;
    }

    //metodo do jogo em si
    public String jogo(int batataTimer) {
       int contador = 0;
       //repete até ter so uma pessoa na fila, o vencedor
       while (contador < jogadores.size()*5) {
           //print de quem esta com a batata
           for (int i = 0; i < batataTimer - 1; i++) {
               String jogadorAtual = moverJogador();
               System.out.println(jogadorAtual + " está com a batata quente!");
           }
           //aqui que a fila circular é usada!
           String jogadormovido = moverJogador();
           //if que gera o ganhador
           if (jogadores.size() == 1){
               return jogadores.get(0);
           }
           //eliminação:
           System.out.println("A batata estorou na mão do jogador: "+jogadormovido);
           System.out.println(jogadormovido + " foi removido da roda.");
           jogadores.remove(jogadormovido);
           contador ++;
       }
        return jogadores.get(0);
    }
}

