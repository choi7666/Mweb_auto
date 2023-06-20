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

public class TC49 {

    private static WebDriver driver;

    @Test
    public void TC49() throws InterruptedException {

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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto16");

        // 패스워드 입력
        WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
        pw_input.sendKeys("testtest00");



        // 로그인 버튼 클릭
        WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
        login_btn.click();
        Thread.sleep(500);

        // 상품 이동
        driver.get("https://www.stg.kurly.com/goods/1000052762");
        Thread.sleep(500);

        // 구매하기
        WebElement buy_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/footer/button[2]")));
        buy_btn.click();
        Thread.sleep(200);
        WebElement buy1_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[3]/button/span")));
        buy1_btn.click();
        Thread.sleep(200);
        WebElement buy2_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[1]/span")));
        buy2_btn.click();
        Thread.sleep(200);

        // 장바구니 주문하기
        WebElement buy3_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/footer/button/span")));
        buy3_btn.click();
        Thread.sleep(2000);

/* 컬리페이 오류팝업 닫기 ( 정상화 되면 삭제 필요 ! )
        WebElement buy11_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")));
        buy11_btn.click();

 */


        // 적립금 모두 사용
        WebElement point_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //*[@id=\"__next\"]/div[13]/div[2]/button")));
        point_btn.click();


        for (int i = 0; i < 13; i++) {
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        }



        // 0원 결제 하기
        WebElement pointbuy_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[18]/button")));
        pointbuy_btn.click();
        Thread.sleep(5000);

        // 주문완료 페이지 확인
        WebElement pointbuy1_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div/footer/div/button[1]/span")));
        Assert.assertEquals("주문 상세보기", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/footer/div/button[1]/span")).getText());
        pointbuy1_btn.click();
        Thread.sleep(1500);

        // 주문 상품 주문 취소
        WebElement selfcancel_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[12]/button")));
        Assert.assertEquals("전체 상품 주문 취소", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[12]/button")).getText());
        selfcancel_btn.click();
        Thread.sleep(1500);
        WebElement selfcancelok_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[2]")));
        selfcancelok_btn.click();
        Thread.sleep(1000);

        // 주문취소 사유
        for (int i = 0; i < 15; i++) {
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        }

        Thread.sleep(2000);
        WebElement selfcancelbox_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[8]/label/span")));
        selfcancelbox_btn.click();
        Thread.sleep(500);

        WebElement selfcancelok2_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[8]/button/span")));
        selfcancelok2_btn.click();

        WebElement selfcancelok3_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[2]")));
        selfcancelok3_btn.click();
        Thread.sleep(2000);
        //주문 취소 완료 페이지
        WebElement canaft = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[2]/h1")));
        Assert.assertEquals("주문 취소 완료", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[2]/h1")).getText());
        System.out.println("주문 취소 완료 페이지 확인");
        WebElement canaftok = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div/button/span")));
        canaftok.click();



        driver.close();

    }

}
