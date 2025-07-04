package org.br.com.dio;

import org.br.com.dio.model.Board;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

        private final static Scanner scanner = new Scanner(System.in);

        private static Board board ;

        private final static  int BOARD_LIST =  0 ;

        public static  void main (String [] args) {
            final var positions = Stream.of(args)
                    .collect(toMap(
                            k -> k.split(";")[0],
                                  v -> v.split(";")[1]
                    ));
            var option = -1;
            while (true){
                System.out.println("Selecione uma das opções a seguir");
                System.out.println("1 - Iniciar um novo Jogo");
                System.out.println("2 - Colocar um novo número");
                System.out.println("3 - Remover um número");
                System.out.println("4 - Visualizar jogo atual");
                System.out.println("5 - Verificar status do jogo");
                System.out.println("6 - limpar jogo");
                System.out.println("7 - Finalizar jogo");
                System.out.println("8 - Sair");

                option = scanner.nextInt();

                switch (option){
                    case 1 -> startGame(positions);
                    case 2 -> inputNumber();
                    case 3 -> removeNumber();
                    case 4 -> showCurrentGame();
                    case 5 -> showGameStatus();
                    case 6 -> clearGame();
                    case 7 -> finishGame();
                    case 8 -> System.exit(0);
                    default -> System.out.println("Opção inválida, selecione uma das opções do menu");
                }
            }
        }

    private static void startGame(final Map<String, String> positions) {
        if (nonNull(board)){
            System.out.println("O jogo já foi iniciado");
            return;
        }


    }

    private static void inputNumber() {
        if (isNull(board)){
            System.out.println("O jogo ainda não foi iniciado iniciado");
            return;

        }
    }

    private static void removeNumber() {
            if (isNull(board)){
                System.out.println("O jogo ainda não foi iniciado");
                return;
            }
    }

    private static void showCurrentGame() {
            if (isNull(board)){
                System.out.println("O jogo ainda não foi iniciado ");
                return;
            }
    }

    private static void showGameStatus() {
            if (isNull(board)){
                System.out.println("O jogo ainda não foi iniciado");
                return;
            }
    }

    private static void clearGame() {
            if (isNull(board)){
                System.out.println("O jogo ainda não foi iniciado");
                return;
            }
    }


    private static void finishGame() {
        if (isNull(board)){
            System.out.println("O jogo ainda não foi iniciado iniciado");
            return;
        }

        if (board.gameIsFinished()){
            System.out.println("Parabéns você concluiu o jogo");
            showCurrentGame();
            board = null;
        } else if (board.hasErrors()) {
            System.out.println("Seu jogo conté, erros, verifique seu board e ajuste-o");
        } else {
            System.out.println("Você ainda precisa preenhcer algum espaço");
        }
    }
    private static int runUntilGetValidNumber(final int min, final int max){
        var current = scanner.nextInt();
        while (current < min || current > max){
            System.out.printf("Informe um número entre %s e %s\n", min, max);
            current = scanner.nextInt();
        }
        return current;
    }


}