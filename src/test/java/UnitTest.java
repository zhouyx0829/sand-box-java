import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.sql.Timestamp;

/**
 * @author yx.zhou
 * @version 2019/2/15
 */

@Slf4j
public class UnitTest {

    @Test
    public void testDate(){
        log.info("now->{}",System.currentTimeMillis());
        log.info("now->{}",new Timestamp(473634945L));
        log.info("now->{}",new Timestamp(1261440000000L));

        log.info("now->{}",new Timestamp(473634946L));

    }
}
