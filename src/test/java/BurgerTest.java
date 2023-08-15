import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bunMock;

    @Mock
    Ingredient ingredientMock;

    @Mock
    Ingredient ingredientMock2;

    @Mock
    List<Ingredient> expectedIngredientsMock;

    @Test
    public void setBunsTest() {
        bunMock.name = "Булка";
        bunMock.price = 123.456F;

        Burger burger = new Burger();
        burger.setBuns(bunMock);
        Assert.assertEquals("Булочка не совпадает с эталоном", bunMock, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        ingredientMock.type = IngredientType.FILLING;
        ingredientMock.name = "Рыба";
        ingredientMock.price = 123.456F;

        expectedIngredientsMock = Arrays.asList(ingredientMock);

        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        Assert.assertEquals("Список не совпадает с эталоном", expectedIngredientsMock, burger.ingredients);
    }

    @Test
    public void removeIngredientTest() {
        ingredientMock.type = IngredientType.FILLING;
        ingredientMock.name = "Рыба";
        ingredientMock.price = 123.456F;

        expectedIngredientsMock = new ArrayList<>();

        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        burger.removeIngredient(0);
        Assert.assertEquals("Список не совпадает с эталоном", expectedIngredientsMock, burger.ingredients);
    }

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
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Список не совпадает с эталоном", expectedIngredientsMock, burger.ingredients);
    }

    @Test
    public void getPriceTest() {
        bunMock.name = "Булка";
        bunMock.price = 123.456F;

        ingredientMock.type = IngredientType.FILLING;
        ingredientMock.name = "Рыба";
        ingredientMock.price = 123.456F;

        ingredientMock2.type = IngredientType.SAUCE;
        ingredientMock2.name = "Соус";
        ingredientMock2.price = 456.123F;

        Mockito.when(ingredientMock.getPrice()).thenReturn(123.456F);
        Mockito.when(ingredientMock2.getPrice()).thenReturn(456.123F);
        Mockito.when(bunMock.getPrice()).thenReturn(123.456F);

        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock2);
        Assert.assertEquals("Цена не совпадает с эталоном", 826.49097F, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        bunMock.name = "Булка";
        bunMock.price = 123.456F;

        ingredientMock.type = IngredientType.FILLING;
        ingredientMock.name = "Рыба";
        ingredientMock.price = 123.456F;

        ingredientMock2.type = IngredientType.SAUCE;
        ingredientMock2.name = "Соус";
        ingredientMock2.price = 456.123F;

        Mockito.when(bunMock.getName()).thenReturn("Булка");

        Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientMock2.getType()).thenReturn(IngredientType.SAUCE);

        Mockito.when(ingredientMock.getName()).thenReturn("Рыба");
        Mockito.when(ingredientMock2.getName()).thenReturn("Соус");

        Mockito.when(ingredientMock.getPrice()).thenReturn(123.456F);
        Mockito.when(ingredientMock2.getPrice()).thenReturn(456.123F);
        Mockito.when(bunMock.getPrice()).thenReturn(123.456F);

        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock2);
        StringBuilder expected = new StringBuilder(String.format("(==== Булка ====)%n" +
                "= filling Рыба =%n" +
                "= sauce Соус =%n" +
                "(==== Булка ====)%n" +
                "%n" +
                "Price: 826,490967" +
                "%n"));
        System.out.println(burger.getReceipt());
        Assert.assertEquals("Рецепт не совпадает с эталоном", expected.toString(), burger.getReceipt());
    }
}
