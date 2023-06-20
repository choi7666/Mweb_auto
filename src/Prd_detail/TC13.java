package Prd_detail;

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

public class TC13 {

    private static WebDriver driver;

    @Test
    public void TC13() throws InterruptedException {

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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto4");

        // 패스워드 입력
        WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
        pw_input.sendKeys("testtest00");


        /* 카카카오 문구 확인
        WebElement kakao = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[5]/p")));
        Assert.assertEquals("카카오로 간편하게 시작하세요", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[5]/p")).getText());
        System.out.println("카카오 문구 확인"); */


        // 로그인 버튼 클릭
        WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
        login_btn.click();

        Thread.sleep(2000);
        // 장바구니 아이콘 클릭
        WebElement cart_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div[2]/button[2]")));
        cart_btn.click();
        Thread.sleep(1000);

        // URL 배너 상품 선택
        WebElement urlbaner_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/ul/li[2]/div/div/div/a/span")));
        urlbaner_btn.click();

        // URL 배너 확인
        WebElement urlbaner = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/div[1]/div[2]/h2")));
        Assert.assertEquals("[자동화] url배너", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/div[1]/div[2]/h2")).getText());
        Thread.sleep(500);
        System.out.println("URL 배너 노출 확인");


        for (int i = 0; i < 5; i++) {
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        }

        Thread.sleep(500);

        // URL 배너 선택 후 뒤로가기
        WebElement urlbane_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/div[3]/div")));
        urlbane_btn.click();
        System.out.println("URL 링크 이동");


        // 브라우저 뒤로가기
        driver.navigate().back();

        // url 배너 상품 복귀
        WebElement url_banner3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/div[1]/div[2]/h2")));
        Assert.assertEquals("[자동화] url배너", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/div[1]/div[2]/h2")).getText());


        driver.close();


    }

}
