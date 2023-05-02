package Event;


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

import java.sql.Driver;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TC80_2 {

    private static WebDriver driver;

    @Test
    public void TC80_2() throws InterruptedException {

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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto29");

        // 패스워드 입력
        WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
        pw_input.sendKeys("testtest00");


        // 로그인 버튼 클릭
        WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
        login_btn.click();

        Thread.sleep(2000);

        // 장바구니 이동
        driver.get("https://www.stg.kurly.com/cart");
        Thread.sleep(3000);

        // 다른상품 만원 이하 계정
        WebElement serchwin_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/footer/button/span")));
        serchwin_btn.click();

        Thread.sleep(2000);
        Assert.assertEquals("신규회원 이벤트 상품 외 다른 상품을 1만원 이상 담아주시면 구매 가능합니다.", driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[1]")).getText());
        System.out.println("신규회원 이벤트 상품 외 만원 이하 얼럿 확인");
        Thread.sleep(1000);





        driver.quit();

    }


}
