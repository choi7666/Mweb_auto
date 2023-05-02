package Mykurly;

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

public class TC55 {

    private static WebDriver driver;

    @Test
    public void TC55() throws InterruptedException {

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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto20");

        // 패스워드 입력
        WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
        pw_input.sendKeys("testtest00");



        // 로그인 버튼 클릭
        WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
        login_btn.click();
        Thread.sleep(500);

        // 배송지 관리 이동
        driver.get("https://www.stg.kurly.com/mypage/address");
        Thread.sleep(2000);


        // 타이틀
        WebElement title_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/main/div[3]")));
        Assert.assertEquals("배송지에 따라 상품정보 및 배송유형이 달라질 수 있습니다.", driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[3]")).getText());
        System.out.println("배송지 관리 타이틀 확인");
        Thread.sleep(1000);

        // 배송지 추가 버튼
        WebElement add_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/main/div[1]/div[3]/div[3]/button")));
        Assert.assertEquals("추가", driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[1]/div[3]/div[3]/button")).getText());
        System.out.println("배송지 추가 버튼 확인");
        Thread.sleep(1000);


        // 배송지 리스트
        WebElement address = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/main/ul/li/div[2]")));
        Assert.assertEquals("기본 배송지\n" +
                "대전 서구 둔산로 100 (대전광역시청) 123\n" +
                "샛별배송", driver.findElement(By.xpath("//*[@id=\"__next\"]/main/ul/li/div[2]")).getText());
        System.out.println("배송지 리스트 노출 확인");

        Thread.sleep(500);

        driver.quit();
    }


}
