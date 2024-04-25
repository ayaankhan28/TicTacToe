package com.ayaankhan.controllers;

import com.ayaankhan.models.Player;

import java.util.List;
import com.ayaankhan.models.Game;
import com.ayaankhan.models.GameState;
import com.ayaankhan.exceptions.InvalidMoveException;
public class GameControl {
    public Game startGame(int dimension, List<Player> players) {
        //TODO
        //If 2 players have same symbol, throw some exception.
        return new Game(dimension, players);
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public GameState checkState(Game game) {
        return game.getGameState();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }
}