import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.Random;

/**
 * @author yx.zhou
 * @version 2019/2/15
 */

@Slf4j
public class UnitTest {

    @Test
    public void testDate() {
        log.info("now->{}", System.currentTimeMillis());
        log.info("now->{}", new Timestamp(1551779425));

        log.info("now->{}", new Timestamp(1261440000000L));

        log.info("now->{}", new Timestamp(473634946L));

        Random rd = new Random();
        String[] radmon = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        // for(int j = 0; j < 100; j++) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 11; i++) {
            String s = radmon[rd.nextInt(10)];
            sb.append(s);
        }
        System.out.println(sb);
        System.out.println((int) ((Math.random() * 10000000000L + 1)));

        long end = System.currentTimeMillis();
//        System.out.println(end - start + ";start:" + start + ";end:" + end);
        System.exit(0);

    }

    @Test
    public void test2() {
        String requestStr = "start=1551369600000&end=1551974400000&urlStr=http://boss-shanhs.oss-cn-shenzhen.aliyuncs.com/test%281%29.xlsx";
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<String> formEntity = new HttpEntity<>(requestStr, headers);
        log.info("test2 formEntity->{} requestUrl->{}", formEntity);
        RestTemplate restTemplate = new RestTemplate();
        String response = new RestTemplate().postForObject("http://192.168.11.112:8890/nb-express-price-log/compare-infostart", formEntity, String.class);
        log.info("azoooHttpRequest response->{} formEntity->{} requestUrl->{}", response, formEntity);
    }

    @Test
    public void test3() {

        log.info(RandomStringUtils.random(11, "0123456789"));
    }
}
