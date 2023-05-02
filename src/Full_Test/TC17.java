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

public class TC17 {

        private static WebDriver driver;

        @Test
        public void TC17() throws InterruptedException {

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
                driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto6");

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
                Thread.sleep(1000);

                // 키워드 입력

                WebElement keyword16_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div[3]/div/input")));
                keyword16_btn.click();
                WebElement keywordinput16_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")));
                keywordinput16_btn.sendKeys("[자동화] 솔드아웃");
                Thread.sleep(1000);

                // 검색
                WebElement serch16_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")));
                serch16_btn.sendKeys(Keys.ENTER);


                // 목록 > 품절 문구
                WebElement serch16a = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div[2]/a/div[1]/div/div[1]")));
                Assert.assertEquals("Sold Out\n" +
                        "솔드아웃", driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div[2]/a/div[1]/div/div[1]")).getText());
                System.out.println("목록 > 품절 문구 노출 확인");
                Thread.sleep(1000);


                // 상세 > 품절 문구
                WebElement product16_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div[2]/a/div[2]")));
                product16_btn.click();

                WebElement product16n = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/dl[2]/dd/p")));
                Assert.assertEquals("솔드아웃", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/dl[2]/dd/p")).getText());
                System.out.println("상세 > 품절 문구 노출 확인");


                driver.navigate().back();
                Thread.sleep(1000);

                // 키워드 제거

                WebElement keyworddel_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"delete-search-keyword\"]")));
                keyworddel_btn.click();



                // 키워드 입력
                WebElement keyword17_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div[3]/div/input")));
                keyword17_btn.click();
                WebElement keywordinput17_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")));
                keywordinput17_btn.sendKeys("[자동화] 솔드x");

                // 검색

                WebElement serch17_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")));
                serch17_btn.sendKeys(Keys.ENTER);


                // 품절 문구 미노출
                Thread.sleep(1000);
                WebElement commingsoon2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div[2]/a/div[1]/div/div[1]")));
                Assert.assertEquals("Sold Out", driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div[2]/a/div[1]/div/div[1]/strong")).getText());
                System.out.println("TC16 - 문구 미입력 시 품절 문구 미노출 확인");



                // 장바구니 > 품절 문구

                Thread.sleep(500);

                driver.get("https://www.stg.kurly.com/cart");
                Thread.sleep(800);
                WebElement cart16a_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/ul/li[1]/div/div/div[1]/p[2]")));
                Assert.assertEquals("솔드아웃", driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li[1]/div/div/div[1]/p[2]")).getText());
                System.out.println("장바구니 품절 문구 노출 확인");



                driver.close();


        }

}