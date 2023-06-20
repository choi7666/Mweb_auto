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

public class TC14 {

    private static WebDriver driver;

    @Test
    public void TC14() throws InterruptedException {

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

        // 쿠폰다운로드 배너 상품 선택
        WebElement couponbaner_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/ul/li[1]/div/div/div/a/span")));
        couponbaner_btn.click();
        Thread.sleep(1000);

        // 쿠폰다운로드 배너 확인
        WebElement couponbaner = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/div[1]/div[2]/h2")));
        Assert.assertEquals("[자동화] 쿠폰배너", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/div[1]/div[2]/h2")).getText());
        Thread.sleep(100);
        System.out.println("쿠폰다운로드배너 노출 확인");


        for (int i = 0; i < 5; i++) {
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        }

        Thread.sleep(500);


        // 쿠폰다운도드 배너 정보
       // Thread.sleep(5000);
        WebElement couponbaner1_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/button")));
        couponbaner1_btn.click();

        WebElement couponbaner2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div")));
        Assert.assertEquals("이미 발급된 쿠폰입니다.\n" +
                "10%\n" +
                "종관 카페쿠폰\n" +
                "기간제한 없음\n" +
                "100원 이상 주문 시 최대 1,000원 할인\n" +
                "카카오페이 결제시\n" +
                "확인", driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div")).getText());
        System.out.println("쿠폰다운도드 배너 정보");
        Thread.sleep(1000);



        driver.close();


    }


}
