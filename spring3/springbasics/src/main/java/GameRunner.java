public class GameRunner {
    private PacMan game;
    public GameRunner(PacMan game) {
        this.game = game;
    }


    public void run() {
        System.out.println("Running game: "+ game);
    }
}
