import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    @Test
    public void getNameTest() {
        Bun bun = new Bun("Булка", 123.456F);
        Assert.assertEquals("Название не совпадает с эталоном", "Булка", bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("Булка", 123.456F);
        Assert.assertEquals("Цена не совпадает с эталоном", 123.456F, bun.getPrice(), 0);
    }
}
