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

public class TC7 {

    private static WebDriver driver;

    @Test
    public void TC7() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mk-am14-008/Documents/selenium/chromedriver");

        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", "Samsung Galaxy S20 Ultra");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);


        /* stg 접속
        driver.get("https://www.stg.kurly.com/member/login?return_url=/mypage");
        Thread.sleep(1500);

        // 현재창 핸들
        String winHandleBefore = driver.getWindowHandle();

        // 아이디 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto2");
        Thread.sleep(500);

        // 패스워드 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")).sendKeys("testtest00");
        Thread.sleep(500);

        // 로그인 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")).click();
        Thread.sleep(1500);

        // 장바구니 아이콘 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div[2]/button[2]")).click();
        Thread.sleep(2000); */

        // stg 접속
        driver.get("https://www.stg.kurly.com/member/login?return_url=/mypage");

        // 최대 10초 동안 대기
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // id가 input 요소가 나타날 때까지 대기
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")));

        // 현재창 핸들
        String winHandleBefore = driver.getWindowHandle();

        // 아이디 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto2");

        // 패스워드 입력
        WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
        pw_input.sendKeys("testtest00");

        // 로그인 버튼 클릭
        WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
        login_btn.click();

        // 장바구니 아이콘 클릭
        WebElement cart_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div[2]/button[2]")));
        cart_btn.click();

        // 스텝퍼 + 선택시 금액 증가

        WebElement puls_btn1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/ul[1]/li/div/div/div/div/div/button[2]")));
        puls_btn1.click();
        Assert.assertEquals("150,000원", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[13]/div[1]/span[2]")).getText());
        System.out.println("+시 금액 증가");


        //스텝퍼 - 선택시 금액 감소
        WebElement minus_btn1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/ul[1]/li/div/div/div/div/div/button[1]")));
        minus_btn1.click();
       // driver.findElement(By.xpath("//*[@id=\"__next\"]/ul[1]/li/div/div/div/div/div/button[1]")).click();
        Assert.assertEquals("135,000원", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[13]/div[1]/span[2]")).getText());
        System.out.println("-시 금액 감소");

        //최소구매 수량 얼럿
       // driver.findElement(By.xpath("//*[@id=\"__next\"]/ul[2]/li/div/div/div/div/div/button[1]")).click();
       // Thread.sleep(1000);

        WebElement minimum_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/ul[2]/li[2]/div/div/div/div/div/button[1]")));
        minimum_btn.click();

        Assert.assertEquals("[자동화] 오토최소구매 상품의 최소 구매 수량은 3개 입니다.", driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[1]")).getText());
        System.out.println("최소구매 수량 얼럿 확인");
       // Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();

        //최대구매 수량 얼럿
       // driver.findElement(By.xpath("//*[@id=\"__next\"]/ul[2]/li/div/div/div/div/div/button[2]")).click();
        //Thread.sleep(1000);

        WebElement maximum_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/ul[2]/li[1]/div/div/div/div/div/button[2]")));
        maximum_btn.click();

        Assert.assertEquals("[자동화] 오토최대구매 상품의 최대 구매 수량은 3개 입니다.", driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[1]")).getText());
        System.out.println("최대구매 수량 얼럿 확인");
        //Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();


        // after
        driver.close();


    }


}
