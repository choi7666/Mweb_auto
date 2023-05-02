package Mykurly;

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

public class TC50_2 {

        private static WebDriver driver;

        @Test
        public void TC50_2() throws InterruptedException {

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
                driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto18");

                // 패스워드 입력
                WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
                pw_input.sendKeys("testtest00");



                // 로그인 버튼 클릭
                WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
                login_btn.click();
                Thread.sleep(500);

                // 주문내역 이동
                driver.get("https://www.stg.kurly.com/mypage/order");
                Thread.sleep(1500);

        // 주문내역상세 3년
        WebElement orderdetail_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/button[4]")));
        orderdetail_btn.click();
        Thread.sleep(500);

        // 주문 상세
        WebElement orderdetail1_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/a/div[1]/span[2]")));
        orderdetail1_btn.click();
        Thread.sleep(500);

        //전체 상품 다시 담기
        WebElement orderdetail2_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/button/span")));
        Assert.assertEquals("전체 상품 다시 담기", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/button/span")).getText());
        orderdetail2_btn.click();
        Thread.sleep(500);


        // 장바구니 팝업
        WebElement orderpop_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[1]")));
        Assert.assertEquals("구매 불가능한 상품을 제외하고 1개 상품을 장바구니에 담았습니다.", driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[1]")).getText());
        orderpop_btn.click();
                System.out.println("구매 불가 제외전체상품 다시 담기 확인");
        Thread.sleep(500);

        WebElement orderpop1_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")));
       orderpop1_btn.click();
        Thread.sleep(500);


        driver.navigate().back();
        Thread.sleep(1000);


        // 장바구니 수량 확인
        WebElement cartcount_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[3]/button/span[2]")));
        Assert.assertEquals("1", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[3]/button/span[2]")).getText());
        cartcount_btn.click();
                System.out.println("장바구니 아이콘 수량 확인");
        Thread.sleep(500);


        // 장바구니 페이지 수량 확인
        WebElement cartcount1_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[5]/div/label/span")));
        Assert.assertEquals("전체선택 (1/1)", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]/div/label/span")).getText());
        cartcount1_btn.click();
                System.out.println("장바구니화면 수량 확인");
        Thread.sleep(2000);


        //장바구니 삭제
                WebElement dele0_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[5]/div/label/span")));
                dele0_btn.click();
                Thread.sleep(1500);

                
                WebElement dele_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[5]/div/button")));
                dele_btn.click();
                Thread.sleep(500);
                WebElement dele1_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[2]")));
                dele1_btn.click();
                Thread.sleep(500);


        driver.close();

    }

}
