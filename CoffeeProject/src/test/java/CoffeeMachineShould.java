import com.sda.Coffee;
import com.sda.CoffeeMachine;
import org.junit.Test;

import static com.sda.ECoffeeType.*;
import static org.junit.Assert.assertTrue;

public class CoffeeMachineShould {
    private CoffeeMachine m = new CoffeeMachine();

    @Test
    public void brewEspressoWhenStockAvailable() {
        Coffee c = m.brew(ESPRESSO);
        assertTrue(c.isMyCoffee(ESPRESSO));
    }

    @Test
    public void brewCappuccinoWhenStockAvailable() {
        Coffee c = m.brew(CAPPUCCINO);
        assertTrue(c.isMyCoffee(CAPPUCCINO));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionAfterBrewingMultipleEspresso() {
        for (int i = 0; i < 15; i++) {
            Coffee c = m.brew(ESPRESSO);
        }
    }

    @Test
    public void brewEspressoWithoutStockAfterRestock() {
        Coffee c = null;
        int counter = 0;
        for (int i = 0; i < 100; i++) {
            try {
                c = m.brew(ESPRESSO);
            } catch (IllegalArgumentException exception) {
                m.restock();
                counter++;
            }
        }
        System.out.println(counter);
        assertTrue(c.isMyCoffee(ESPRESSO));
    }

}

