package Mykurly;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TC54 {

    private static WebDriver driver;

    @Test
    public void T54() throws InterruptedException {
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

        // 찜한상품 메뉴
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[3]/a[3]")).click();
        Thread.sleep(1000);


        // 찜한상품 수
        Assert.assertEquals("전체 3개", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]")).getText());
        System.out.println("찜한 상품 수 확인");
        Thread.sleep(1000);

        // 썸네일 선택 시 상품 상세 이동
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[3]/a/span/span/img")).click();
        Thread.sleep(3000);
        Assert.assertEquals("[켈로그] 첵스 초코", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div[2]/h1")).getText());
        Thread.sleep(1000);
        System.out.println("썸네일 -> 상품 상세 이동 확인");

        driver.navigate().back();
        Thread.sleep(1000);


        // 상품명
        Assert.assertEquals("[켈로그] 첵스 초코", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[3]/div/div[1]/div[1]/a")).getText());
        System.out.println("상품명 노출 확인");
        Thread.sleep(1000);

        // 상품명 선택 시 상품 상세 이동
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[3]/div/div[1]/div[1]/a")).click();
        Thread.sleep(3000);
        Assert.assertEquals("[켈로그] 첵스 초코", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div[2]/h1")).getText());
        Thread.sleep(1000);
        System.out.println("상품명 -> 상품 상세 이동 확인");
        driver.navigate().back();
        Thread.sleep(1000);

        // 할인상품 할인
        Assert.assertEquals("8%", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[1]/div/div[1]/div[2]/span[1]")).getText());
        System.out.println("할인율 확인");
        Thread.sleep(500);

        // 할인상품 할인가
        Assert.assertEquals("551,540원", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[1]/div/div[1]/div[2]/span[2]")).getText());
        System.out.println("할인가 확인");
        Thread.sleep(500);

        // 일반상품 버튼
        Assert.assertEquals("삭제", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[3]/div/div[2]/button[1]")).getText());
        System.out.println("삭제 버튼 확인");
        Thread.sleep(500);

        Assert.assertEquals("담기", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[3]/div/div[2]/button[2]")).getText());
        System.out.println("담기 버튼 확인");
        Thread.sleep(500);

        // 예약상품 버튼
        Assert.assertEquals("바로 구매", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[1]/div/div[2]/button[2]")).getText());
        System.out.println("바로구매 버튼 확인");
        Thread.sleep(500);

        driver.quit();

    }
}