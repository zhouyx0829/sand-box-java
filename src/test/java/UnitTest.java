import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import vo.SkuItem;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        System.out.println(StringUtils.isNumeric("D2019021403595"));
    }

    @Test
    public void test4() {

        List<SkuItem> skuItems = Arrays.asList(SkuItem.builder()
            .num(1).skuCode("19062402339")
            .build());


        try {
            String json = "alipayshop|[{\"skuCode\":\"19062402339\",\"num\":1,\"singlePrice\":null}]";

            System.out.println(Stream.of(json.split(",")).collect(Collectors.toList()));
            String itemJson = json.split("[|]")[1];
            log.info("test4 json ->{}", itemJson);
            List<SkuItem> skuItems1;
            skuItems1 = JSON.parseObject(itemJson, new TypeReference<List<SkuItem>>() {
            });

        } catch (Exception e) {
            e.printStackTrace();
            log.error("test4 e->{}", e);
        }

    }

    @Test
    public void tset5() {

        log.info("tset51 -> {}", checkImage("https://shanhs-malls.oss-cn-shenzhen.aliyuncs.com/1/100/4788/1.jpg"));

        log.info("tset52 -> {}", checkImage("https://shanhs-malls.oss-cn-shenzhen.aliyuncs.com/1/110/4559/1.jpg"));

    }

    @Test
    public void tset6() {

        LocalDate createtm = new Timestamp(1563331319000L).toLocalDateTime().toLocalDate();
        LocalDate nowDate = LocalDate.now();
//        Long diff = 24L - ChronoUnit.SECONDS.between(createtm, nowDate);
        ;
        Long diff = (System.currentTimeMillis() - new Timestamp(1563451894000L).getTime()) / (60 * 60 * 1000L);
        Integer leftTime = (24 - diff.intValue()) > 0 ? (24 - diff.intValue()) : 0;
        log.info("tset6 diff->{}", leftTime);

    }

    private boolean checkImage(String imageUrl) {

        try {
            URL url = new URL(imageUrl);
            HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
            urlcon.setRequestMethod("GET");
            urlcon.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            return urlcon.getResponseCode() == HttpURLConnection.HTTP_OK;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Test
    public void test7() {

        System.out.println("test7->{}" + UUID.randomUUID().toString());
        System.out.println("test7->{}" + UUID.randomUUID().toString());
        System.out.println("test7->{}" + UUID.randomUUID().toString());
        System.out.println("test7->{}" + UUID.randomUUID().toString());
    }
}
