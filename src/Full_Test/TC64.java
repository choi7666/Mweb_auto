package Full_Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TC64 {

    private static WebDriver driver;

    @Test
    public void TC64() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mk-am14-030/Documents/selenium/chromedriver");

        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", "Samsung Galaxy S20 Ultra");

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);


        // stg 접속
        driver.get("https://www.stg.kurly.com/member/login?return_url=/mypage");
        Thread.sleep(1500);

        // 현재창 핸들
        String winHandleBefore = driver.getWindowHandle();

        // 아이디 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto2");
        Thread.sleep(500);

        // 패스워드 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")).sendKeys("qawsedrf12");
        Thread.sleep(500);

        // 로그인 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")).click();
        Thread.sleep(1500);

        // 장바구니 아이콘 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div[2]/button[2]")).click();
        Thread.sleep(3000);

        //주문하기 버튼 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/footer/button")).click();
        Thread.sleep(3000);

        // 적립금 입력 영역
        Assert.assertEquals("", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[7]/div[3]/div/div/input")).getText());
        System.out.println("적립금 입력영역 : 0 노출 확인");
        Thread.sleep(500);

        // 사용가능 적립금
        Assert.assertEquals("사용가능 적립금 10,000,000원", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[7]/div[4]")).getText());
        System.out.println("사용가능 적립금 노출 확인");
        Thread.sleep(500);

        // 적립금 모두사용 버튼 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[7]/div[3]/button")).click();
        Thread.sleep(500);

        // 적립금 적용 확인
        Assert.assertEquals("-6,580", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[9]/div[2]/div[6]/div[2]/span[1]")).getText());
        System.out.println("적립금 적용 확인");
        Thread.sleep(500);

        // 적립금 적용 제거
        driver.findElement(By.xpath("//*[@id=\"delete-input\"]")).click();
        Assert.assertEquals("", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[7]/div[3]/div/div/input")).getText());
        System.out.println("적립금 입력영역 : 0 노출 확인");
        Thread.sleep(500);

        // 적립금 최대금액 이상 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[7]/div[3]/div/div/input")).sendKeys("1000000");
        Thread.sleep(500);

        //적립금 적용 확인
        Assert.assertEquals("-6,580", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[9]/div[2]/div[6]/div[2]/span[1]")).getText());
        System.out.println("보유적립금 최대금액 적용 확인");
        Thread.sleep(500);


        driver.quit();

    }


}
