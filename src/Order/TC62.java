package Order;

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

public class TC62 {

        private static WebDriver driver;

        @Test
        public void TC62() throws InterruptedException {

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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto22");

        // 패스워드 입력
        WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
        pw_input.sendKeys("testtest00");



        // 로그인 버튼 클릭
        WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
        login_btn.click();
        Thread.sleep(500);


        // 상품상세 이동
        driver.get("https://www.stg.kurly.com/goods/1000054587");
                Thread.sleep(5000);



        // 구매하기
                WebElement buy_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/footer/button[2]/span")));
                buy_btn.click();
                Thread.sleep(500);
                WebElement buy1_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[3]/button/span")));
                buy1_btn.click();
                Thread.sleep(2500);


/* 컬리페이 오류팝업 닫기 ( 정상화 되면 삭제 필요 ! )
        WebElement buy11_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")));
        buy11_btn.click();

        Thread.sleep(1000);

 */



        // 배송지 확인
        Assert.assertEquals("기본배송지", driver.findElement(By.xpath("//*[@id=\"shipping-container\"]/div[2]/div[1]/span[1]")).getText());
        Assert.assertEquals("인천 강화군 불은면 중앙로 638 123", driver.findElement(By.xpath("//*[@id=\"shipping-container\"]/div[2]/div[1]/span[2]")).getText());
        System.out.println("배송지 노출 확인");
        Thread.sleep(1000);

        // 상세정보 확인
        Assert.assertEquals("webauto22, 010-1111-1111", driver.findElement(By.xpath("//*[@id=\"checkout-shipping-details\"]/div[1]")).getText());
        System.out.println("받으실분 / 휴대폰 노출 확인");
        Thread.sleep(1000);

        Assert.assertEquals("수정", driver.findElement(By.xpath("//*[@id=\"shipping-container\"]/div/div/button")).getText());
        System.out.println("수정 버튼 노출 확인");
        Thread.sleep(1000);

        // 배송지 변경 안내 영역
        Assert.assertEquals("배송지 변경 안내", driver.findElement(By.xpath("//*[@id=\"shipping-container\"]/div[1]/div/a")).getText());
        driver.findElement(By.xpath("//*[@id=\"shipping-container\"]/div[1]/div")).click();
        Thread.sleep(1000);


        Assert.assertEquals("장바구니, 홈에서\n" +
                "배송지를 변경할 수 있어요", driver.findElement(By.xpath("//*[@id=\"shipping-container\"]/div[1]/div/div/div")).getText());
        System.out.println("배송지 변경 안내 영역 선택 시 튤팁 노출 확인");


        Thread.sleep(1000);


        driver.quit();

    }

}
