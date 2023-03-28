package Full_Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TC17 {

    private static WebDriver driver;

    @Test
    public void T17() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mk-am14-008/Documents/selenium/chromedriver");

        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", "Samsung Galaxy S20 Ultra");

        ChromeOptions chromeOptions = new ChromeOptions();
chromeOptions.addArguments("--remote-allow-origins=*");

        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);


        // stg 접속
        driver.get("https://www.stg.kurly.com/member/login?return_url=/mypage");
        Thread.sleep(1500);

        // 현재창 핸들
        String winHandleBefore = driver.getWindowHandle();

        // 아이디 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto9");
        Thread.sleep(500);

        // 패스워드 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")).sendKeys("qawsedrf12");
        Thread.sleep(500);

        // 로그인 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")).click();
        Thread.sleep(1200);

        // 검색 탭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/a[3]")).click();
        Thread.sleep(500);

        // 키워드 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div[3]/div/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")).sendKeys("[에델코첸] 온첵 텀블러 430mL 3종");
        Thread.sleep(1300);

        // 검색
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        // 목록 > 품절 문구
        Assert.assertEquals("Sold Out\n" +
                "종관 테스트", driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div/div[1]")).getText());
        System.out.println("목록 > 품절 문구 노출 확인");
        Thread.sleep(1000);

        // 상세 > 품절 문구
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);

        Assert.assertEquals("종관 테스트", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/dl[3]/dd/p")).getText());
        System.out.println("상세 > 품절 문구 노출 확인");
        Thread.sleep(700);

        driver.navigate().back();
        Thread.sleep(1000);

        // 키워드 제거
        driver.findElement(By.xpath("//*[@id=\"delete-search-keyword\"]")).click();
        Thread.sleep(500);

        // 키워드 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")).sendKeys("[에델코첸] 온첵 원터치형 텀블러 500mL 2종");
        Thread.sleep(1300);

        // 검색
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        // 품절 문구 미노출
        Assert.assertEquals("Sold Out", driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div/div[1]")).getText());
        System.out.println("문구 미입력 시 품절 문구 미노출 확인");
        Thread.sleep(1000);

        // 장바구니 > 품절 문구
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div[2]/button[2]")).click();
        Thread.sleep(2000);
        Assert.assertEquals("종관 테스트", driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li[4]/div/div/div[1]/p[2]")).getText());
        System.out.println("장바구니 품절 문구 노출 확인");
        Thread.sleep(1000);

        driver.close();


    }

}
