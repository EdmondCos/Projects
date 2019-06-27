import org.junit.Test;

public class TestHangman {
    private IPlayer player = new BotPlayer();
    private Hangman hangman = new Hangman(player);

    @Test
    public void testBotPlayer() {
        hangman.playGame();
    }
}
