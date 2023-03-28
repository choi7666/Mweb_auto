
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TC4 {
    private static WebDriver driver;

    @Before
    public void before() throws InterruptedException {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--disable-extensions");
        ops.addArguments("--disable-gpu");


        System.setProperty("webdriver.chrome.driver", "/Users/mk-am14-008/Documents/selenium/chromedriver");
        driver = new ChromeDriver(ops);


        Dimension dimension = new Dimension(1920, 1080);
        driver.manage().window().setSize(dimension);

        // 최대 10초 동안 대기
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // stg 접속
        driver.get("https://www.stg.kurly.com/mypage/order");

        // 팝업 확인
        WebElement popup = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")));
        popup.click();

        // 아이디 입력
        WebElement id_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/form/div[1]/div[1]/div/input")));
        id_input.sendKeys("webauto1");

        // 패스워드 입력
        WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/form/div[1]/div[2]/div/input")));
        pw_input.sendKeys("testtest00");

        // 로그인 버튼 클릭
        WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/form/div[3]/button[1]")));
        login_btn.click();

    }

    @Test
    public void TC4() throws InterruptedException {

        // 현재창 핸들
        String winHandleBefore = driver.getWindowHandle();

        // 최대 10초 동안 대기
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 장바구니 아이콘 클릭
        WebElement cart_icon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/div[2]/div[3]/div/div[2]/button")));
        cart_icon.click();

        // 배송지 변경 버튼 클릭
        WebElement change_address_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[2]/div/div[1]/div/button")));
        change_address_btn.click();

        // 새창 핸들
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        // 배송지창 타이틀 확인
        WebElement address_title = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[1]/h2")));
        Assert.assertEquals("배송지배송지에 따라 상품정보 및 배송유형이 달라질 수 있습니다.", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/h2")).getText());
        System.out.println("1.배송지관리페이지 노출");

        // 다른배송지 선택
        WebElement other_address = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[1]/label/div")));
        other_address.click();

        // 기존창 전환
        driver.switchTo().window(winHandleBefore);

        // 상품정보 업데이트 얼럿
        WebElement update_alert = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"swal2-content\"]/div[1]")));
        Assert.assertEquals("배송지 변경으로 상품 정보가 업데이트됩니다.", driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[1]")).getText());
        System.out.println("1-1.상품정보 업데이트 얼럿 노출");

        // 얼럿 확인
        WebElement udate_alert_confirm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")));
        udate_alert_confirm.click();

    }


    @After
    public void after() throws Exception {

        // 최대 10초 동안 대기
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 현재창 핸들
        String winHandleBefore = driver.getWindowHandle();

        // 배송지 변경 버튼 클릭
        WebElement change_address_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div[2]/div/div[1]/div/button")));
        change_address_btn.click();

        // 새창 핸들
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        // 다른배송지 선택
        WebElement other_address = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[1]/label/div")));
        other_address.click();

        // 기존창 전환
        driver.switchTo().window(winHandleBefore);

        // 상품정보 업데이트 얼럿
        WebElement udate_alert_confirm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")));
        udate_alert_confirm.click();

        driver.quit();
    }


}