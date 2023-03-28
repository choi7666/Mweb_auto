package Full_Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TC30 {

    private static WebDriver driver;

    @Test
    public void T30() throws InterruptedException {
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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto15");
        Thread.sleep(500);

        // 패스워드 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")).sendKeys("qawsedrf12");
        Thread.sleep(500);

        // 로그인 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")).click();
        Thread.sleep(1200);

        // 장바구니
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div[2]/button[2]")).click();
        Thread.sleep(1500);

        // 배송지 변경 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/span")).click();
        Thread.sleep(1000);

        // 새창 핸들
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        // 1CC 배송지 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div/div[2]/label/img")).click();
        Thread.sleep(1500);

        // 기존창 전환
        driver.switchTo().window(winHandleBefore);
        Thread.sleep(500);

        // 상품정보 업데이트 얼럿 확인
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();
        Thread.sleep(1000);

        // 1CC 할인 미적용
        Assert.assertEquals("10,000원", driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li/div/div/div/div/span")).getText());
        System.out.println("1CC 할인 미적용 확인");
        Thread.sleep(1200);


        // after
        // 배송지 변경 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/span")).click();
        Thread.sleep(1000);

        // 새창 핸들
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        // 1CC 배송지 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div/div[2]/label/img")).click();
        Thread.sleep(1500);

        // 기존창 전환
        driver.switchTo().window(winHandleBefore);
        Thread.sleep(500);

        // 상품정보 업데이트 얼럿 확인
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();
        Thread.sleep(1000);


        Thread.sleep(1000);

        driver.close();

    }

}
