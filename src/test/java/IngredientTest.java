import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Рыба", 123.456F);
        Assert.assertEquals("Цена не совпадает с эталоном", 123.456F, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Рыба", 123.456F);
        Assert.assertEquals("Название не совпадает с эталоном", "Рыба", ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Рыба", 123.456F);
        Assert.assertEquals("Тип не совпадает с эталоном", IngredientType.FILLING, ingredient.getType());
    }
}
