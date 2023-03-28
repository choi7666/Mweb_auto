package Mykurly;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TC85 {

    private static WebDriver driver;

    @Test
    public void T85() throws InterruptedException {
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


        // 비밀번호 찾기
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[4]/a[2]")).click();
        Thread.sleep(3000);

        // 이메일 인증 탭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/button[2]")).click();
        Thread.sleep(2000);

        // 이름 입력
        driver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys("webauto");
        Thread.sleep(2000);

        // 이메일 입력
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("webauto@kurlycorp.com");
        Thread.sleep(1000);

        // 확인 버튼 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/form/div[3]/button")).click();
        Thread.sleep(3000);

        // 이메일 재설정 메일 발송
        Assert.assertEquals("webauto@kurlycorp.com으로\n" +
                "비밀번호 재설정 메일이 발송되었어요.", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/p[1]")).getText());
        System.out.println("비밀번호 이메일 재설정 메일 발송 확인");
        Thread.sleep(500);


        driver.quit();


    }


}
