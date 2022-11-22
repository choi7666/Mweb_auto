package Full_Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TC60 {

    private static WebDriver driver;

    @Test
    public void TC60() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mk-am14-030/Documents/selenium/chromedriver");

        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", "Samsung Galaxy S20 Ultra");

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);


        // stg 접속
        driver.get("https://www.stg.kurly.com/member/login?return_url=/mypage");
        Thread.sleep(1500);

        // 현재창 핸들
        String winHandleBefore = driver.getWindowHandle();

        // 아이디 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto3");
        Thread.sleep(500);

        // 패스워드 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")).sendKeys("qawsedrf12");
        Thread.sleep(500);

        // 로그인 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")).click();
        Thread.sleep(1500);

        // 장바구니
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div[2]/button[2]")).click();
        Thread.sleep(3000);

        // 주문하기 버튼 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/footer/button")).click();
        Thread.sleep(3000);

        // 주문 상품
        Assert.assertEquals("[스타우브] 화이트 트러플 라이스 꼬꼬떼 12cm\n" +
                "외\n" +
                "2건", driver.findElement(By.xpath("//*[@id=\"__next\"]/button[1]/span/span/div")).getText());
        Thread.sleep(1000);
        System.out.println("상품명 한줄 노출 확인");

        // 주문 상품 펼침 버튼 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/button[1]")).click();
        Thread.sleep(1000);

        // 단품_상품명
        Assert.assertEquals("[켈로그] 첵스 초코", driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li[3]/div/div[1]/span")).getText());
        System.out.println("단품 상품명 노출 확인");
        Thread.sleep(1000);

        // 단품_수량
        Assert.assertEquals("1개", driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li[3]/div/div[2]/span[2]")).getText());
        System.out.println("단품 수량 노출 확인");
        Thread.sleep(1000);

        // 단품_합계
        Assert.assertEquals("3,580원", driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li[3]/div/div[2]/span[1]")).getText());
        System.out.println("단품 합계 노출 확인");
        Thread.sleep(1000);

        // 패키지_상품명
        Assert.assertEquals("[마더케이] 에코 아기 지퍼백 4종 패키지 대용량", driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li[2]/div/div[1]/span")).getText());
        System.out.println("패키지 상품명 노출 확인");
        Thread.sleep(1000);

        // 패키지_수량
        Assert.assertEquals("1개", driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li[2]/div/div[2]/span[2]")).getText());
        System.out.println("패키지 수량 노출 확인");
        Thread.sleep(1000);

        // 패키지_합계
        Assert.assertEquals("17,500원", driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li[2]/div/div[2]/span[1]")).getText());
        System.out.println("패키지 합계 노출 확인");
        Thread.sleep(1000);

        // 할인상품_판매가
        Assert.assertEquals("144,000원", driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li[1]/div/div[2]/span[2]")).getText());
        System.out.println("할인상품 판매가 노출 확인");
        Thread.sleep(1000);

        // 할인상품_할인가
        Assert.assertEquals("133,920원", driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li[1]/div/div[2]/span[1]")).getText());
        System.out.println("할인상품 할인가 노출 확인");
        Thread.sleep(1000);


        driver.quit();


    }

}
