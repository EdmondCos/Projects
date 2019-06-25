import com.sda.Arbitru;
import com.sda.IPlayable;
import org.junit.Test;

public class GameShould {
    private IPlayable botPlayer = new BotPlayer();

    @Test
    public void finishWhenBotIsPlaying() {
        Arbitru arbitru = new Arbitru(4, botPlayer);
        arbitru.playGame();
    }
}

