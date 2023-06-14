
import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    @Test
    public void getElementAfterFour() {
        int[] test = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] checkResult = {1,7};
        int[] result = Main.getElementAfterFour(test);
        Assert.assertEquals(checkResult,result);

        int[] test1 = {1, 2, 4, 4, 2, 3, 4, 1, 8, 9};
        int[] checkResult1 = {1,8,9};
        int[] result1 = Main.getElementAfterFour(test);
        Assert.assertEquals(checkResult,result);

        int[] test2 = {1, 2, 4, 4, 2, 3, 4, 0};
        int[] checkResult2 = {0};
        int[] result2 = Main.getElementAfterFour(test);
        Assert.assertEquals(checkResult,result);
    }
    @Test
    public void checkArrayOneAndFour() {
        int[] test = {1,1,1,1,1};
        Assert.assertEquals(false, test);

        int[] test2 = {4,1,1,1,1};
        Assert.assertEquals(true, test);

        int[] test3 = {4,4,41,1,1};
        Assert.assertEquals(false, test);
    }
}
