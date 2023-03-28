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

public class TC49 {

    private static WebDriver driver;

    @Test
    public void T49() throws InterruptedException {
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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto5");
        Thread.sleep(500);

        // 패스워드 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")).sendKeys("qawsedrf12");
        Thread.sleep(500);

        // 로그인 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")).click();
        Thread.sleep(1200);

        // 주문내역상세
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[3]/a[1]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/a/div[1]/span[2]")).click();
        Thread.sleep(1000);

        // 배송완료_전체 상품 주문 취소
        WebElement cancel1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[13]/button"));
        Boolean isEnable1 = cancel1.isEnabled();
        if (isEnable1 == false) {
            System.out.println("배송완료 -> 전체 상품 주문 취소 버튼 비활성화");
        } else {
            System.out.println("배송완료 -> Fail Fail Fail Fail Fail");
        }
        Thread.sleep(1000);

        driver.navigate().back();

        Thread.sleep(1000);

        // 배송중_전체 상품 주문 취소
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[3]/a/div[1]/span[2]")).click();
        Thread.sleep(1000);

        WebElement cancel2 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[13]/button"));
        Boolean isEnable2 = cancel2.isEnabled();
        if (isEnable2 == false) {
            System.out.println("배송중 -> 전체 상품 주문 취소 버튼 비활성화");
        } else {
            System.out.println("배송중 -> Fail Fail Fail Fail Fail");
        }
        Thread.sleep(1000);

        driver.navigate().back();

        Thread.sleep(1000);

        // 배송 준비중_전체 상품 주문 취소
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[4]/a/div[1]/span[2]")).click();
        Thread.sleep(1000);

        WebElement cancel3 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[13]/button"));
        Boolean isEnable3 = cancel3.isEnabled();
        if (isEnable3 == false) {
            System.out.println("배송 준비중 -> 전체 상품 주문 취소 버튼 비활성화");
        } else {
            System.out.println("배송 준비중 -> Fail Fail Fail Fail Fail");
        }
        Thread.sleep(1000);

        driver.navigate().back();

        Thread.sleep(1000);

        // 주문완료_전체 상품 주문 취소
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[5]/a/div[1]/span[2]")).click();
        Thread.sleep(1000);

        WebElement cancel4 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[13]/button"));
        Boolean isEnable4 = cancel4.isEnabled();
        if (isEnable4 == true) {
            System.out.println("주문완료 -> 전체 상품 주문 취소 버튼 활성화");
        } else {
            System.out.println("주문완료 -> Fail Fail Fail Fail Fail");
        }
        Thread.sleep(1000);


        driver.close();

    }

}
