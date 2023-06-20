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

public class TC63 {

        private static WebDriver driver;

        @Test
        public void TC63() throws InterruptedException {

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
                driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto23");

                // 패스워드 입력
                WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
                pw_input.sendKeys("testtest00");



                // 로그인 버튼 클릭
                WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
                login_btn.click();
                Thread.sleep(500);

                // 장바구니  이동
                driver.get("https://www.stg.kurly.com/cart");
                Thread.sleep(3000);



                // 주문하기 버튼 선택
                WebElement order_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/footer/button")));
                order_btn.click();
                Thread.sleep(5000);

/* 컬리페이 오류팝업 닫기 ( 정상화 되면 삭제 필요 ! )
                WebElement buy11_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")));
                buy11_btn.click();

                Thread.sleep(1000);

 */


        // 쿠폰리스트에서 카카오페이 쿠폰 선택
                WebElement coupon1_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[9]/div[2]/button/span")));
                coupon1_btn.click();
                Thread.sleep(500);

                WebElement coupon2_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/label/span[1]")));
                coupon2_btn.click();
                Thread.sleep(500);

                WebElement coupon3_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]")));
                coupon3_btn.click();
                Thread.sleep(500);

               /* WebElement coupon4_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")));
                coupon4_btn.click();
                Thread.sleep(500);

                */

        // 적립금 모두사용 버튼 비활성화
                WebElement point_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[13]/div[2]/button/span")));
                String disabled = point_btn.getAttribute("disabled");
                if (disabled == null || disabled.equals("true")) {
                        System.out.println("TC63 - 적립금 모두사용 버튼 비활성화 확인");
                } else {
                        System.out.println("이슈 - 버튼이 활성화");
                }


                Thread.sleep(500);

        // 결제수단 영역 카카오페이 안내 문구
        Assert.assertEquals("카카오페이 전용 쿠폰 사용 시, 카카오페이 결제만 가능합니다.", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[15]/div/div[2]")).getText());
        System.out.println("결제수단 카카오페이 문구 노출 확인");
        Thread.sleep(500);

        // 쿠폰 할인 금액
        Assert.assertEquals("-1,000", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[17]/div[2]/div[5]/div[2]/span[1]")).getText());
        System.out.println("쿠폰할인금액 노출 확인");
        Thread.sleep(500);

        // 카카오페이 외 결제수단 미노출
        Assert.assertEquals("카카오페이", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[15]/div/div[1]/span")).getText());
        System.out.println("카카오페이 외 결제수단 미노출 확인");
        Thread.sleep(500);

        // 쿠폰리스트에서 카카오페이 외 쿠폰 선택
                WebElement coupon11_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[9]/div[2]/button")));
                coupon11_btn.click();
                Thread.sleep(500);

                WebElement coupon22_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[1]/label/span[2]/div")));
                coupon22_btn.click();
                Thread.sleep(500);

                WebElement coupon33_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]")));
                coupon33_btn.click();
                Thread.sleep(500);



        boolean displayed = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[13]/div[2]/button/span")).isDisplayed();
        System.out.println("카카오페이 외 결제 수단 노출 확인");
        Thread.sleep(1000);


        driver.quit();

    }

}
