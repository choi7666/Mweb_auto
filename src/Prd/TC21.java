package Prd;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TC21 {

    private static WebDriver driver;

    @Test
    public void T21() throws InterruptedException {
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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto12");
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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")).sendKeys("레고상품3");
        Thread.sleep(1300);

        // 검색
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        // 상품 선택
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div")).click();
        Thread.sleep(1500);

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[@id=\"__next\"]/footer/button[2]")).click();
        Thread.sleep(500);

        // 옵션 상품 적용된 할인 확인
        Assert.assertEquals("5,000원10,000원", driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]")).getText());
        System.out.println("옵션 상품 적용된 할인가 노출 확인");
        Thread.sleep(500);

        // 옵션 상품 수량 선택
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[2]/div[2]/div[2]/div[2]/button[2]")).click();
        Thread.sleep(500);

        // 장바구니 담기
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/button")).click();
        Thread.sleep(500);

        // 장바구니 확인
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[1]")).click();
        Thread.sleep(1000);

        // 옵션 상품 확인
        Assert.assertEquals("레고상품1\n" +
                "레고상품3", driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li[1]/div/div/a")).getText());
        System.out.println("장바구니 옵션 상품 확인");
        Thread.sleep(700);

        // after
        driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li[1]/div/button")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[2]")).click();
        Thread.sleep(1000);


        driver.close();

    }


}
