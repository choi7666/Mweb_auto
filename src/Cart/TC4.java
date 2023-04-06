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


public class TC4 {


    private static WebDriver driver;

    @Test
    public void TC4() throws InterruptedException {
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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto1");

        // 패스워드 입력
        WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
        pw_input.sendKeys("testtest00");

        // 로그인 버튼 클릭
        WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
        login_btn.click();

        // 장바구니 아이콘 클릭
        WebElement cart_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div[2]/button[2]")));
        cart_btn.click();

        //배송지 변경 버튼 클릭
        WebElement delivery_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/span")));
        delivery_btn.click();


        // 새창 핸들
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        // 배송지창 타이틀 확인
        WebElement deriveryadmin = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/p")));
        Assert.assertEquals("배송지에 따라 상품정보 및 배송유형이 달라질 수 있습니다.", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/p")).getText());
        System.out.println("1.배송지관리페이지 노출");



        // 다른배송지 선택
        WebElement delivery2_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div/div[2]/label/div")));
        delivery2_btn.click();


        // 기존창 전환
        driver.switchTo().window(winHandleBefore);

        // 상품정보 업데이트 얼럿
        WebElement deriverychangepopup = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"swal2-content\"]/div[1]")));
        Assert.assertEquals("배송지 변경으로 상품 정보가 업데이트됩니다.", driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[1]")).getText());
        System.out.println("1-1.상품정보 업데이트 얼럿 노출");



        // 얼럿 확인
        WebElement OK_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")));
        OK_btn.click();

        // after

        // 배송지 변경 버튼 클릭
        WebElement delivery1_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/span")));
        delivery1_btn.click();

        // 새창 핸들
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        // 다른배송지 선택
        WebElement delivery3_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div/div[2]/label/div")));
        delivery3_btn.click();


        // 기존창 전환
        driver.switchTo().window(winHandleBefore);


        driver.close();


    }


}
