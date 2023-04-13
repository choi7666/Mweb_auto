package Search;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TC81 {

    private static WebDriver driver;

    @Test
    public void TC81() throws InterruptedException {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--disable-extensions");
        ops.addArguments("--disable-gpu");


        System.setProperty("webdriver.chrome.driver", "/Users/mk-am14-008/Documents/selenium/chromedriver");
//mk-am14-008

        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", "Samsung Galaxy S20 Ultra");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);

        // stg 접속
        driver.get("https://www.stg.kurly.com/search");

        // 최대 5초 동안 대기
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // 현재창 핸들
        String winHandleBefore = driver.getWindowHandle();


        Thread.sleep(2000);

        // 검색 탭
        WebElement serch_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div[3]/div/input")));
        serch_btn.click();



        // 키워드 입력
        WebElement keywordinput16_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")));
        keywordinput16_btn.sendKeys("[자동화] 성인인증");


        // 검색
        WebElement serch16_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")));
        serch16_btn.sendKeys(Keys.ENTER);

        // 성인인증 상품선택
        WebElement prd_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div[2]/a/div[1]/div/span/img")));
        prd_btn.click();

        // 로그인페이지 팝업
        WebElement prd1pop_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[1]")));
        Assert.assertEquals("로그인하셔야 본 서비스를 이용하실 수 있습니다.", driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[1]")).getText());

        // 로그인페이지 팝업확인
        WebElement prd1pop1_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")));
        prd1pop1_btn.click();


        // 로그인페이지 성인 문구 확인
        WebElement prdadult1_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]")));
        Assert.assertEquals("본 상품은 만 19세 미만의 청소년이 이용할 수 없습니다.", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]")).getText());
        System.out.println("로그인페이지 성인 문구 확인 확인");
        Thread.sleep(500);


        driver.close();

    }

}
