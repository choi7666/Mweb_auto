package Cart;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TC8 {

    private static WebDriver driver;

    @Test
    public void TC8() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mk-mac-190/Documents/selenium/chromedriver");

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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto11");
        Thread.sleep(500);

        // 패스워드 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")).sendKeys("qawsedrf12");
        Thread.sleep(500);

        // 로그인 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")).click();
        Thread.sleep(1500);

        // 장바구니 아이콘 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div[2]/button[2]")).click();
        Thread.sleep(2000);


        // 정률상품 판매가격
        Assert.assertEquals("10,000원", driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li[2]/div/div/div/div/span/span[2]")).getText());
        System.out.println("정률상품 판매가격 노출 확인");
        Thread.sleep(500);

        // 정률상품 할인가격
        Assert.assertEquals("5,000원", driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li[2]/div/div/div/div/span/span[1]")).getText());
        System.out.println("정률상품 할인가격 노출 확인");
        Thread.sleep(1000);


        // after
        driver.close();


    }


}
