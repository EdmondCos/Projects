import com.sda.IPlayable;

import java.util.Random;

public class BotPlayer implements IPlayable {
    @Override
    public int[] getCoordonates() {
        Random random = new Random();
        return new int[]{random.nextInt(4), random.nextInt(4)};
    }
}
