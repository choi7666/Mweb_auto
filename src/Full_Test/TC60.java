package Full_Test;

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

public class TC60 {

        private static WebDriver driver;

        @Test
        public void TC60() throws InterruptedException {

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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto21");

        // 패스워드 입력
        WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
        pw_input.sendKeys("testtest00");



        // 로그인 버튼 클릭
        WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
        login_btn.click();
        Thread.sleep(500);

        // 장바구니  이동
        driver.get("https://www.stg.kurly.com/cart");
        Thread.sleep(4000);



        // 주문하기 버튼 선택
        WebElement order_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/footer/button")));
        order_btn.click();
        Thread.sleep(4000);




        // 주문 상품
        Assert.assertEquals("[자동화] 오토멀티딜1\n" +
                "외\n" +
                "2건", driver.findElement(By.xpath("//*[@id=\"__next\"]/button[1]/span/span/div/div")).getText());
        Thread.sleep(1000);
        System.out.println("상품명 한줄 노출 확인");

        // 주문 상품 펼침 버튼 선택
        WebElement ordername_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/button[1]/span/span/span")));
        ordername_btn.click();
        Thread.sleep(500);


        // 단품_상품명
        Assert.assertEquals("[자동화] 오토멀티딜1\n" +
                "[자동화] 오토멀티딜\n" +
                "15,000원1개\n" +
                "[자동화] 오토정률\n" +
                "18,000원20,000원1개\n" +
                "[자동화] 오토상온\n" +
                "20,000원1개" , driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/ul")).getText());
        System.out.println("단품/패지기/할인 상품명/수량/금액 노출 확인");
        Thread.sleep(1000);


        driver.quit();


    }

}
