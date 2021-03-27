import org.junit.Test;
import org.junit.runner.RunWith;
import org.pac.Application;
import org.pac.CacheablePac;
import org.pac.Trader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author liq
 * @Date 2020/3/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CacheableTest {

    @Autowired
    private CacheablePac cacheablePac;

    @Test
    public void cachePacTest() {
        Trader hello1 = cacheablePac.getTrader(new Trader("hello", "NewYork"));
        Trader hello2 = cacheablePac.getTrader(new Trader("hello", "NewYork"));

    }

}
