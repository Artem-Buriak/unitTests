
import org.junit.Assert;
import org.junit.Test;

public class SimpleMathLibraryTest {
    @Test
    public void add() {
        double result = SimpleMathLibrary.add(2, 3);
        Assert.assertEquals(5.0, result,0.0001);
    }
    @Test
    public void minus() {
        double result = SimpleMathLibrary.minus(6, 3);
        Assert.assertEquals(3.0, result,0.0001);
    }

}
