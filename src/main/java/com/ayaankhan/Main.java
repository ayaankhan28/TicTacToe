package com.ayaankhan;
import com.ayaankhan.controllers.GameControl;
import com.ayaankhan.exceptions.InvalidMoveException;
import com.ayaankhan.models.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidMoveException {

        Scanner scanner = new Scanner(System.in);
        GameControl gameController = new GameControl();

        int dimension = 3;
        List<Player> players = List.of(
                new Player("Ayaan", new Symbol('A'), PlayerType.HUMAN),
                new Bot("Ghost", new Symbol('G'), PlayerType.BOT, BotDifficultyLevel.EASY)
        );

        Game game = gameController.startGame(dimension, players);
        //gameController.printBoard(game);

        while (game.getGameState().equals(GameState.IN_PROGRESS)) {
            //1. print the board.
            gameController.printBoard(game);

            //2. Player's turn
            gameController.makeMove(game);
        }

        if (!gameController.checkState(game).equals(GameState.ENDED)) {
            game.setGameState(GameState.DRAW);
            System.out.println("DRAW");
        } else {
            gameController.printBoard(game);
            System.out.println("Player " + gameController.getWinner(game).getName() + " WON");
        }
    }
}