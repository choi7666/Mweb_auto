package Full_Test;


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
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class TC82_2 {

    private static WebDriver driver;
    private Instant wait;

    @Test
    public void TC82_2 () throws InterruptedException {

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
        driver.get("https://www.stg.kurly.com/");
        Thread.sleep(1500);

        // 최대 10초 동안 대기
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // 현재창 핸들
        String winHandleBefore = driver.getWindowHandle();


        // 검색창 이동
        driver.get("https://www.stg.kurly.com/search");



        // 키워드 입력
        WebElement keyword16_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div[3]/div/input")));
        keyword16_btn.click();
        WebElement keywordinput16_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")));
        keywordinput16_btn.sendKeys("[자동화] 성인인증");


        // 검색
        WebElement serch16_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")));
        serch16_btn.sendKeys(Keys.ENTER);

        Thread.sleep(1000);
        // 상품 진입
        WebElement prod1_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div[2]/a/div[1]/div/span/img")));
        prod1_btn.click();
        Thread.sleep(2000);

        // 로그인 팝업
        WebElement loginpop_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[1]")));
        Assert.assertEquals("로그인하셔야 본 서비스를 이용하실 수 있습니다.", driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[1]")).getText());
        System.out.println("로그인 팝업 확인");
        loginpop_btn.click();


        Thread.sleep(1000);

        WebElement loginpop1_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")));
        loginpop1_btn.click();
        Thread.sleep(1000);


        // 아이디 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[2]/div[1]/div/input")).sendKeys("jjongqa");
        Thread.sleep(500);

        // 패스워드 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[2]/div[2]/div/input")).sendKeys("whdrhks12!");
        Thread.sleep(500);

        // 로그인 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[4]/button[1]")).click();
        Thread.sleep(1200);

        //  성인인증 상품 상세
        Assert.assertEquals("[자동화] 성인인증", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/div[1]/div[2]/h2")).getText());
        System.out.println("로그인후 상품상세 진입 확인");
        Thread.sleep(1000);


        driver.quit();


    }


}
