import jdk.jfr.Description;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class PraktikumTest {

        private final String firstParameter;
        private final boolean expected;


    public PraktikumTest(String firstParameter, boolean expected) {
        this.firstParameter = firstParameter;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getAccountData() {
        return new Object[][]{
                {"", false},                        // 1.
                {" ", false},                       // 2.
                {" name", false},                   // 3.
                {"name ", false},                   // 4.
                {"namename", false},                // 5.
                {"name name", true},                // 6.
        };
    }

    @Test
    @DisplayName("Проверка соблюдения требований к имени и фамилии держателя карты.")
    @Description("Тест: можно ли напечатать строку на карте. Например, «Тимоти Шаламе» — можно, а «ТимотейШевроле» — нет.")
    public void shouldBeEmbossed() {
        Account account = new Account("Тимоти Шаламе");
        boolean actual = account.checkNameToEmboss(firstParameter);
        assertEquals(expected, actual);
    }
}