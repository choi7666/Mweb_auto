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

public class TC54 {

        private static WebDriver driver;

        @Test
        public void TC54() throws InterruptedException {

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
                driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto20");

                // 패스워드 입력
                WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
                pw_input.sendKeys("testtest00");



                // 로그인 버튼 클릭
                WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
                login_btn.click();
                Thread.sleep(500);

                // 찜하기 이동
                driver.get("https://www.stg.kurly.com/mypage/pick/list");
                Thread.sleep(1500);



        // 찜한상품 수
        WebElement zzim = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]")));
        Assert.assertEquals("전체 3개", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]")).getText());
        System.out.println("찜한 상품 수 확인");
        Thread.sleep(1000);

        // 썸네일 선택 시 상품 상세 이동
        WebElement zzim1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[1]/a/span/span/img")));
        zzim1.click();
        Thread.sleep(1000);
        WebElement prodetail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/div[1]/div[2]/h2")));
        Assert.assertEquals("[자동화] 오토예약", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/div[1]/div[2]/h2")).getText());
        Thread.sleep(1000);
        System.out.println("썸네일 -> 상품 상세 이동 확인");

        driver.navigate().back();
        Thread.sleep(1000);


        // 상품명
        WebElement proname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[1]/div/div[1]/div[1]/a")));
        Assert.assertEquals("[자동화] 오토예약", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[1]/div/div[1]/div[1]/a")).getText());
        WebElement proname2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[2]/div/div[1]/div[1]/a")));
        Assert.assertEquals("[자동화] 오토정률", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[2]/div/div[1]/div[1]/a")).getText());
        WebElement proname3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[3]/div/div[1]/div[1]/a")));
        Assert.assertEquals("[자동화] 오토냉장", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[3]/div/div[1]/div[1]/a")).getText());

        System.out.println("상품명(3개) 노출 확인");
        Thread.sleep(1000);

        // 상품명 선택 시 상품 상세 이동
        WebElement proname11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[1]/div/div[1]/div[1]/a")));
        proname11.click();
                WebElement prodetail11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/div[1]/div[2]/h2")));
                Assert.assertEquals("[자동화] 오토예약", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/div[1]/div[2]/h2")).getText());
                Thread.sleep(1000);
                driver.navigate().back();
                Thread.sleep(1000);

        WebElement proname22 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[2]/div/div[1]/div[1]/a")));
                proname22.click();
                WebElement prodetail222 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/div[1]/div[2]/h2")));
                Assert.assertEquals("[자동화] 오토정률", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/div[1]/div[2]/h2")).getText());
                Thread.sleep(1000);
                driver.navigate().back();
                Thread.sleep(1000);

        WebElement proname33 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[3]/div/div[1]/div[1]/a")));
                proname33.click();
                WebElement prodetail333 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/div[1]/div[2]/h2")));
                Assert.assertEquals("[자동화] 오토냉장", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/div[1]/div[2]/h2")).getText());
                Thread.sleep(1000);
                driver.navigate().back();
                Thread.sleep(1000);


        System.out.println("상품명 3개-> 상품 상세 이동 확인");


        // 할인상품 할인
        WebElement costdiscount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[2]/div/div[1]/div[2]/span[1]")));
        Assert.assertEquals("10%", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[2]/div/div[1]/div[2]/span[1]")).getText());
        System.out.println("할인율 확인");
        Thread.sleep(500);

        // 할인상품 할인가
                WebElement costdiscount1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[2]/div/div[1]/div[2]/span[2]")));

        Assert.assertEquals("18,000원", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[2]/div/div[1]/div[2]/span[2]")).getText());
        System.out.println("할인가 확인");
        Thread.sleep(500);

        // 일반상품 버튼
        WebElement nomalprod = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[3]/div/div[2]/button[1]/span")));
        Assert.assertEquals("삭제", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[3]/div/div[2]/button[1]/span")).getText());
        System.out.println("삭제 버튼 확인");
        Thread.sleep(500);

        WebElement nomalprod1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[3]/div/div[2]/button[2]/span")));
        Assert.assertEquals("담기", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[3]/div/div[2]/button[2]/span")).getText());
        System.out.println("담기 버튼 확인");
        Thread.sleep(500);

        // 예약상품 버튼
        WebElement reserprod = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[1]/div/div[2]/button[2]/span")));

                Assert.assertEquals("바로 구매", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[1]/div/div[2]/button[2]/span")).getText());
        System.out.println("바로구매 버튼 확인");
        Thread.sleep(500);

        driver.quit();

    }
}