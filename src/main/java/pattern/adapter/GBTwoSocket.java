package pattern.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * 国标二相插座
 *
 * @author yx.zhou
 * @version 2019/2/11
 */
@Slf4j
public class GBTwoSocket {

    public void powerByTwo() {
        log.info("使用二相电流供电");
    }
}
