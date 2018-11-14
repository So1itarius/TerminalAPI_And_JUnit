import junit.framework.Assert;
import org.junit.Test;


public class TerminalTest {
    private void Table(){
        Terminal.setPrice("Молоко", 70);
        Terminal.setPrice("Шампунь", 200);
        Terminal.setPrice("Чипсы", 40);
        Terminal.setPrice("Шоколад", 50);
        Terminal.setPrice("Кола", 89);

        Terminal.setDiscount("Молоко", 3,179);
        Terminal.setDiscount("Чипсы", 4,129);
        Terminal.setDiscount("Кола", 2,139);
    }

    @Test
    public void testCalculate1() {
        Table();
        Terminal.ClearBasket();
        Terminal.purchase("Молоко");
        Terminal.purchase("Шампунь");
        Terminal.purchase("Чипсы");
        Terminal.purchase("Шоколад");
        Terminal.purchase("Кола");
        Terminal.purchase("Молоко");
        Terminal.purchase("Кола");
        Terminal.purchase("Молоко");

        int Expected_Output=608;
        Assert.assertEquals(Terminal.calculate(), Expected_Output);
    }
    @Test
    public void testCalculate2() {
        Table();
        Terminal.ClearBasket();
        Terminal.purchase("Шампунь");
        Terminal.purchase("Шампунь");
        Terminal.purchase("Шампунь");
        Terminal.purchase("Шампунь");
        Terminal.purchase("Шампунь");

        int Expected_Output=1000;
        Assert.assertEquals(Terminal.calculate(), Expected_Output);
    }
    @Test
    public void testCalculate3() {
        Table();
        Terminal.ClearBasket();
        Terminal.purchase("Молоко");
        Terminal.purchase("Шампунь");
        Terminal.purchase("Чипсы");
        Terminal.purchase("Шоколад");
        Terminal.purchase("Кола");

        int Expected_Output=449;
        Assert.assertEquals(Terminal.calculate(), Expected_Output);
    }

}