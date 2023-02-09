package edu.prahlad.springbasics;

import edu.prahlad.springbasics.game.GameRunner;
import edu.prahlad.springbasics.game.Mario;

public class App01GamingBasicJava {
    public static void main(String[] args) {
//        var game = new edu.prahlad.springbasics.game.PacMan();
        var game = new Mario();
        //1. Object Creation
        var gameRunner = new GameRunner(game);
        //2. Object Creation + Wiring of dependencies
        //game is a dependency of edu.prahlad.springbasics.game.GameRunner
        gameRunner.run();
    }
}
