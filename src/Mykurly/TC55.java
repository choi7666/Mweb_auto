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

public class TC55 {

    private static WebDriver driver;

    @Test
    public void T55() throws InterruptedException {
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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto4");
        Thread.sleep(500);

        // 패스워드 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")).sendKeys("qawsedrf12");
        Thread.sleep(500);

        // 로그인 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")).click();
        Thread.sleep(1200);

        // 배송지 관리 메뉴
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[4]/a[1]")).click();
        Thread.sleep(1000);

        Thread.sleep(1000);

        // 타이틀
        Assert.assertEquals("배송지에 따라 상품정보 및 배송유형이 달라질 수 있습니다.", driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[3]")).getText());
        System.out.println("배송지 관리 타이틀 확인");
        Thread.sleep(1000);

        // 배송지 추가 버튼
        Assert.assertEquals("추가", driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[1]/div/div[3]/button")).getText());
        System.out.println("배송지 추가 버튼 확인");
        Thread.sleep(1000);


        // 배송지 리스트
        Assert.assertEquals("기본 배송지\n" +
                "서울 강남구 강남대로 328 (강남역 쉐르빌) 123\n" +
                "샛별배송", driver.findElement(By.xpath("//*[@id=\"__next\"]/main/ul/li/div[2]")).getText());
        System.out.println("배송지 리스트 노출 확인");

        Thread.sleep(500);

        driver.quit();
    }


}
