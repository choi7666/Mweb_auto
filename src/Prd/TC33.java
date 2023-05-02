package Prd;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TC33 {

    private static WebDriver driver;

    @Test
    public void TC33() throws InterruptedException {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--disable-extensions");
        ops.addArguments("--disable-gpu");


        System.setProperty("webdriver.chrome.driver", "/Users/mk-am14-008/Documents/selenium/chromedriver");

        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", "Samsung Galaxy S20 Ultra");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);


        // stg 접속
        driver.get("https://www.stg.kurly.com/member/login?return_url=/mypage");

        // 최대 10초 동안 대기
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // id가 input 요소가 나타날 때까지 대기
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")));

        // 현재창 핸들
        String winHandleBefore = driver.getWindowHandle();

        // 아이디 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto14");

        // 패스워드 입력
        WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
        pw_input.sendKeys("testtest00");


        // 로그인 버튼 클릭
        WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
        login_btn.click();

        Thread.sleep(2000);

        // 예약상품 이동
        driver.get("https://www.stg.kurly.com/goods/1000054503");

        //주문하기
        WebElement order_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/footer/button[2]")));
        order_btn.click();

        // 바로구매 팝업
        WebElement orderpop_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[3]/button")));
        orderpop_btn.click();
        Thread.sleep(2000);


        //주문서 페이지 확인
        WebElement orderpordname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/button[1]/span/span/div/div/span[1]")));
        Assert.assertEquals("[자동화] 오토예약", driver.findElement(By.xpath("//*[@id=\"__next\"]/button[1]/span/span/div/div/span[1]")).getText());
        System.out.println("예약상품 -> 주문서 이동 확인");
        Thread.sleep(1000);

//*[@id="__next"]/button[1]/span/span/div/div/span[1]

        driver.close();

    }

}
