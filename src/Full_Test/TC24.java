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
import java.util.HashMap;
import java.util.Map;

public class TC24 {

    private static WebDriver driver;

    @Test
    public void TC24() throws InterruptedException {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--disable-extensions");
        ops.addArguments("--disable-gpu");


        System.setProperty("webdriver.chrome.driver", "/Users//mk-am14-008/Documents/selenium/chromedriver");

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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto7");

        // 패스워드 입력
        WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
        pw_input.sendKeys("testtest00");


        // 로그인 버튼 클릭
        WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
        login_btn.click();

        Thread.sleep(2000);

        // 검색 탭
        WebElement serch_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[4]/a[3]")));
        serch_btn.click();


        // 키워드 입력
        WebElement keyword16_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div[3]/div/input")));
        keyword16_btn.click();
        WebElement keywordinput16_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")));
        keywordinput16_btn.sendKeys("[자동화] 3단상품");


        // 검색
        WebElement serch16_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")));
        serch16_btn.sendKeys(Keys.ENTER);

        //상품 확인
        WebElement ser_resolt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div[2]/a/div[2]")));
        Assert.assertEquals("샛별배송\n" +
                "[자동화] 3단상품\n" + "55%9,000원\n" + "20,000원", driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div[2]/a/div[2]")).getText());
        System.out.println("상품 목록 할인 확인");



        // 상품 장바구니 팝업
        WebElement Cart_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div[2]/a/div[1]/div/div/button")));
        Cart_btn.click();


        // 장바구니 팝업 대표가
        WebElement Cart_popup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[1]")));
        Assert.assertEquals("9,000원20,000원", driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[1]")).getText());
        System.out.println("장바구니팝업 (3단) 확인");



        driver.close();

    }


}
