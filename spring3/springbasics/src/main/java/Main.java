public class Main {
    public static void main(String[] args) {
//        var game = new PacMan();
        var game = new Mario();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
