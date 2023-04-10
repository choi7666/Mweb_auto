package Prd;


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

public class TC21 {

        private static WebDriver driver;

        @Test
        public void TC21() throws InterruptedException {

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
                driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto10");

                // 패스워드 입력
                WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
                pw_input.sendKeys("testtest00");


                // 로그인 버튼 클릭
                WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
                login_btn.click();

                Thread.sleep(2000);

                // 옵션 상품 이동
                driver.get("https://www.stg.kurly.com/goods/1000054429");

                // 구매하기 버튼 클릭
                WebElement buy_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/footer/button[2]")));
                buy_btn.click();


                // 옵션 상품 적용된 할인 확인
                WebElement buypopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div[2]/div[4]/div[2]/div[1]")));
                Assert.assertEquals("10,000원20,000원", driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div[2]/div[4]/div[2]/div[1]")).getText());
                System.out.println("옵션 상품 적용된 할인가 노출 확인");
                Thread.sleep(500);

        /*
        Assert.assertEquals("5,000원10,000원", driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]")).getText());
        System.out.println("옵션 상품 적용된 할인가 노출 확인");
        Thread.sleep(500);

         */

                for (int i = 0; i < 5; i++) {
                        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
                }

                // 옵션 상품 수량 선택
                WebElement optionpuls_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div[2]/div[4]/div[2]/div[2]/button[2]")));
                optionpuls_btn.click();
        /*
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[2]/div[2]/div[2]/div[2]/button[2]")).click();
        Thread.sleep(500);

         */

                // 바로구매 클릭
                WebElement cartadd_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[3]/button")));
                cartadd_btn.click();
/*
/html/body/div[2]/div[3]/div/div[3]/button

        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/button")).click();
        Thread.sleep(500);

 */


                // 주문서 확인
                WebElement buypage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/button[1]/span/span/div/div/span[1]")));
                Assert.assertEquals("[자동화] 멀티딜할인3", driver.findElement(By.xpath("//*[@id=\"__next\"]/button[1]/span/span/div/div/span[1]")).getText());
                Thread.sleep(500);
                buypage.click();

                Thread.sleep(500);

                // 장바구니 확인
                //driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[1]")).click();
                // Thread.sleep(1000);

                // 옵션 상품 확인
                WebElement buypage1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/ul/li/div/div[2]")));
                Assert.assertEquals("10,000원20,000원1개", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/ul/li/div/div[2]")).getText());
                System.out.println("주문서 옵션 상품 확인");

        /*Assert.assertEquals("레고상품1\n" +
                "레고상품3", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/ul/li/div/div[2]")).getText());
        System.out.println("주문서 옵션 상품 확인");
        Thread.sleep(700);

         */

                // after
                driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/button")).click();
                Thread.sleep(500);
                //driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/button")).click();
                //Thread.sleep(1000);


                driver.close();

        }


}