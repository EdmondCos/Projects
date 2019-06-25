import com.sda.TicTacToe;
import org.junit.Test;

public class TestXO {
    @Test
    public void testXsiO() {
        BotPlayer botPlayer = new BotPlayer();
        TicTacToe ticTacToe = new TicTacToe(botPlayer);
        ticTacToe.playGame();
    }
}
