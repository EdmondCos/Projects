import java.util.Random;

public class BotPlayer implements IPlayer {

    private Random random = new Random();

    @Override
    public char guessLetter() {
        return (char) (random.nextInt(26) + 'a');
    }
}
