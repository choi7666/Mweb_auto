package Full_Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TC25 {

    private static WebDriver driver;

    @Test
    public void T25() throws InterruptedException {
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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto12");
        Thread.sleep(500);

        // 패스워드 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")).sendKeys("qawsedrf12");
        Thread.sleep(500);

        // 로그인 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")).click();
        Thread.sleep(1200);

        // 검색 탭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/a[3]")).click();
        Thread.sleep(500);

        // 키워드 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div[3]/div/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")).sendKeys("레고상품1");
        Thread.sleep(1300);

        // 검색
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        // 정율 상품 선택
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]")).click();
        Thread.sleep(1500);

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(500);

        Assert.assertEquals("50%5,000원", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/div[2]")).getText());
        System.out.println("정률 할인가 노출 확인");
        Thread.sleep(1000);


        driver.close();

    }

}
