import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class BurgerParametrizedTest {
    private final int start;
    private final int end;

    public BurgerParametrizedTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Parameterized.Parameters
    public static Object[][] testCases() { //чтобы было
        return new Object[][] {
                { 0, 1 },
                { 1, 0 },
        };
    }

    Ingredient ingredientMock = Mockito.mock(Ingredient.class);
    Ingredient ingredientMock2 = Mockito.mock(Ingredient.class);
    List<Ingredient> expectedIngredientsMock = List.of(ingredientMock, ingredientMock2);

    @Test
    public void moveIngredientTest() {
        ingredientMock.type = IngredientType.FILLING;
        ingredientMock.name = "Рыба";
        ingredientMock.price = 123.456F;

        ingredientMock2.type = IngredientType.SAUCE;
        ingredientMock2.name = "Соус";
        ingredientMock2.price = 456.123F;

        expectedIngredientsMock = Arrays.asList(ingredientMock, ingredientMock2);

        Burger burger = new Burger();
        burger.addIngredient(ingredientMock2);
        burger.addIngredient(ingredientMock);
        burger.moveIngredient(start, end);
        Assert.assertEquals("Список не совпадает с эталоном", expectedIngredientsMock, burger.ingredients);
    }
}
