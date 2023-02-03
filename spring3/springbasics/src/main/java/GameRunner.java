public class GameRunner {
//    private PacMan game;
    private Mario game;
    public GameRunner(Mario game) {
        this.game = game;
    }


    public void run() {
        System.out.println("Running game: "+ game);
    }
}
