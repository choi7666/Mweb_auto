package Cart;

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

public class TC6 {

    private static WebDriver driver;

    @Test
    public void TC6() throws InterruptedException {
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // id가 input 요소가 나타날 때까지 대기
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")));

        // 현재창 핸들
        String winHandleBefore = driver.getWindowHandle();

        // 아이디 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto1");

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


        // 장바구니 아이콘 클릭
        WebElement cart_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div[2]/button[2]")));
        cart_btn.click();


        // 상품금액
        //Assert.assertEquals("45,000원", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[19]/div[1]")).getText());
       // Thread.sleep(500);
        //System.out.println("상품금액 합계 확인");


        WebElement product_cost = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[19]/div[1]/span[2]")));
        Assert.assertEquals("45,000원", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[19]/div[1]/span[2]")).getText());
        System.out.println("상품금액 합계 확인");


        // 상품할인금액
        Assert.assertEquals("0원", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[19]/div[2]/span[2]")).getText());
        Thread.sleep(500);
        System.out.println("상품할인금액 확인");



        // 배송비
        Assert.assertEquals("0원", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[19]/div[3]/span[2]")).getText());
        Thread.sleep(500);
        //Assert.assertEquals("18,610원 추가주문 시, 무료배송", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[19]/p")).getText());
        System.out.println("배송비 확인");
        Thread.sleep(500);

        // 결제예정금액
        Assert.assertEquals("45,000원", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[19]/div[4]/span[2]")).getText());
        System.out.println("결제예정금액 확인");

//*[@id="__next"]/footer/button/span

        // after
        driver.close();


    }

}
