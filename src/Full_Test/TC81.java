package Full_Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;


public class TC81 {

    private static WebDriver driver;

    @Test
    public void TC81() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mk-am14-030/Documents/selenium/chromedriver");

        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", "Samsung Galaxy S20 Ultra");

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);


        // stg 접속
        driver.get("https://www.stg.kurly.com/goods/1000034205");
        Thread.sleep(1500);

        // 현재창 핸들
        String winHandleBefore = driver.getWindowHandle();

        // 로그인 유도 얼럿 확인
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();
        Thread.sleep(2000);

        // 로그인페이지 성인 문구 확인
        Assert.assertEquals("본 상품은 만 19세 미만의 청소년이 이용할 수 없습니다.", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]")).getText());
        System.out.println("로그인페이지 성인 문구 확인 확인");
        Thread.sleep(500);


        driver.close();

    }

}
