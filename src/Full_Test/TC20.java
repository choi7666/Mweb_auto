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

public class TC20 {

        private static WebDriver driver;

        @Test
        public void TC20() throws InterruptedException {

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
                driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto9");

                // 패스워드 입력
                WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
                pw_input.sendKeys("testtest00");


                // 로그인 버튼 클릭
                WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
                login_btn.click();

                Thread.sleep(2000);

                // 정액상품 이동
                driver.get("https://www.stg.kurly.com/goods/1000052863");


                // 정액 상품 선택
                WebElement prd_detail = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/div[2]")));
                Assert.assertEquals("25%15,000원", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/div[2]")).getText());
                System.out.println("TC19 - 정액 할인가 노출 확인");
            //    Thread.sleep(1000);

                Assert.assertEquals("20,000원", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/div[3]/span")).getText());
                System.out.println("판매가 노출 확인");
                Thread.sleep(1000);

                // 장바구니 담기
                WebElement cart_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/footer/button[2]")));
                cart_btn.click();
                Thread.sleep(2000);

                WebElement cart1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[1]/span[1]")));
                Assert.assertEquals("15,000원", driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[1]/span[1]")).getText());
                System.out.println("장바구니팝업 할인가 노출 확인");
                //Thread.sleep(1000);
                Assert.assertEquals("20,000원", driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[1]/span[2]")).getText());
                System.out.println("장바구니팝업 판매가 노출 확인");
                //Thread.sleep(1000);

                WebElement carta_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[3]/button")));
                carta_btn.click();

                // 장바구니 확인
                WebElement cartb_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[1]/span")));
                cartb_btn.click();


                // 정액 상품 확인
                //Thread.sleep(2500);
                WebElement product2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/ul/li/div/div/a/p")));
                Assert.assertEquals("[자동화] 오토정액", driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li/div/div/a/p")).getText());
                System.out.println("장바구니 정액할인 상품 확인");
                Thread.sleep(700);

                // after
                driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li[1]/div/button")).click();
                Thread.sleep(500);
                driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[2]")).click();
                Thread.sleep(1000);


                driver.close();

        }

}