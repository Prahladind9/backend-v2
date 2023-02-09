package edu.prahlad.springbasics.game2;

public class GameRunner {
    private GameConsole game;
    public GameRunner(GameConsole game) {
        this.game = game;
    }


    public void run() {
        System.out.println("Running game: "+ game);
    }
}
