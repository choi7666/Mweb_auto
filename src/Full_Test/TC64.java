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

public class TC64 {

        private static WebDriver driver;

        @Test
        public void TC64() throws InterruptedException {

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
                driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto24");

                // 패스워드 입력
                WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
                pw_input.sendKeys("testtest00");



                // 로그인 버튼 클릭
                WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
                login_btn.click();
                Thread.sleep(500);

                // 장바구니  이동
                driver.get("https://www.stg.kurly.com/cart");
                Thread.sleep(2000);



                // 주문하기 버튼 선택
                WebElement order_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/footer/button")));
                order_btn.click();
                Thread.sleep(6000);

/* 컬리페이 오류팝업 닫기 ( 정상화 되면 삭제 필요 ! )
                WebElement buy11_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")));
                buy11_btn.click();

                Thread.sleep(1000);


 */

        // 적립금 입력 영역
        Assert.assertEquals("", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[11]/div[2]/div/div/input")).getText());
        System.out.println("적립금 입력영역 : 0 노출 확인");
        Thread.sleep(500);

        // 사용가능 적립금
        Assert.assertEquals("사용가능 적립금 10,000원", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[11]/div[3]")).getText());
        System.out.println("사용가능 적립금 노출 확인");
        Thread.sleep(500);

        // 적립금 모두사용 버튼 선택
                WebElement pointall_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[11]/div[2]/button")));
                pointall_btn.click();
                Thread.sleep(1500);



        // 적립금 적용 확인
        Assert.assertEquals("-10,000", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[14]/div[2]/div[7]/div[2]/span[1]")).getText());
        System.out.println("적립금 적용 확인");
        Thread.sleep(500);

        // 적립금 적용 제거
        WebElement pointdel_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"delete-input\"]")));
        pointdel_btn.click();
        Thread.sleep(1000);

        Assert.assertEquals("", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[11]/div[2]/div/div/input")).getText());
        System.out.println("적립금 입력영역 : 0 노출 확인");
        Thread.sleep(500);

        // 적립금 최대금액 이상 입력
        WebElement point_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[11]/div[2]/div/div/input")));
        point_input.sendKeys("100000000");
        Thread.sleep(500);

        //적립금 적용 확인
        Assert.assertEquals("-10,000", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[14]/div[2]/div[7]/div[2]/span[1]")).getText());
        System.out.println("보유적립금 최대금액 적용 확인");
        Thread.sleep(500);


        driver.quit();

    }


}
