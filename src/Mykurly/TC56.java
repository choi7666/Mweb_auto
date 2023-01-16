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

public class TC56 {

    private static WebDriver driver;

    @Test
    public void T56() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mk-mac-190/Documents/selenium/chromedriver");

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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto4");
        Thread.sleep(500);

        // 패스워드 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")).sendKeys("qawsedrf12");
        Thread.sleep(500);

        // 로그인 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")).click();
        Thread.sleep(1200);


        // 개인정보수정 메뉴
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[4]/a[3]")).click();
        Thread.sleep(1000);

        // 비밀번호 입력
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("qawsedrf12");
        Thread.sleep(500);

        // 확인 버튼
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[2]/button")).click();
        Thread.sleep(1000);

        // 이름 변경
        driver.findElement(By.xpath("//*[@id=\"name\"]")).clear();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("webauto100");
        Thread.sleep(1000);

        // 회원정보수정
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[11]/div/button")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();
        Thread.sleep(2000);

        // 회원정보수정 적용 확인
        Assert.assertEquals("webauto100님", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[1]/div[2]/strong")).getText());
        System.out.println("회원정보수정 적용 확인");


        Thread.sleep(500);


        // after
        // 개인정보수정 메뉴
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[4]/a[3]")).click();
        Thread.sleep(1000);

        // 비밀번호 입력
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("qawsedrf12");
        Thread.sleep(500);

        // 확인 버튼
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[2]/button")).click();
        Thread.sleep(1000);

        // 이름 변경
        driver.findElement(By.xpath("//*[@id=\"name\"]")).clear();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("webauto4");
        Thread.sleep(1000);

        // 회원정보수정
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[11]/div/button")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();
        Thread.sleep(2000);


        driver.quit();


    }

}
