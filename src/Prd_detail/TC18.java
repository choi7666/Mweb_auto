package Prd_detail;

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

public class TC18 {

        private static WebDriver driver;

        @Test
        public void TC18() throws InterruptedException {

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
                driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto7");

                // 패스워드 입력
                WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
                pw_input.sendKeys("testtest00");


                // 로그인 버튼 클릭
                WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
                login_btn.click();

                Thread.sleep(2000);

                // 검색 탭
                WebElement serch_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[4]/a[3]")));
                serch_btn.click();


                // 키워드 입력

                WebElement keyword16_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div[3]/div/input")));
                keyword16_btn.click();
                WebElement keywordinput16_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")));
                keywordinput16_btn.sendKeys("[자동화] 오토상온");


                // 검색
                WebElement serch16_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")));
                serch16_btn.sendKeys(Keys.ENTER);

                //장바구니 담기
                WebElement cart18_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div[2]/a[1]/div[1]/div/div/button/img")));
                cart18_btn.click();
                WebElement cart18a_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[3]/button")));
                cart18a_btn.click();


                // 장바구니 이동

                driver.get("https://www.stg.kurly.com/cart");
                Thread.sleep(1000);

                // 상품 장바구니 담김 확인
                WebElement serch18 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/ul/li/div/div/a/p")));
                Assert.assertEquals("[자동화] 오토상온", driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li/div/div/a/p")).getText());
                System.out.println("상품 정상 담김 확인");

                //전체 체크 해제
                WebElement allcheck_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[5]/div/label/div")));
                allcheck_btn.click();

                //주문 상품 체크
                WebElement checkbox_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/ul/li/div/label/div")));
                checkbox_btn.click();

                //상품 삭제 버튼 클릭
                WebElement delbox_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[5]/div/button")));
                delbox_btn.click();

                //상품 삭제 얼럿 확인 클릭
                WebElement delconfirm_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[2]")));
                delconfirm_btn.click();

                driver.close();

        }
}