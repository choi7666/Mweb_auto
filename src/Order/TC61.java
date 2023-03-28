package Order;

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

public class TC61 {

    private static WebDriver driver;

    @Test
    public void TC61() throws InterruptedException {
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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto");
        Thread.sleep(500);

        // 패스워드 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")).sendKeys("qawsedrf12");
        Thread.sleep(500);

        // 로그인 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")).click();
        Thread.sleep(1500);

        // 장바구니
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div[2]/button[2]")).click();
        Thread.sleep(3000);

        // 주문하기 버튼 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/footer/button")).click();
        Thread.sleep(3000);

        // 배송지 확인
        Assert.assertEquals("기본배송지", driver.findElement(By.xpath("//*[@id=\"shipping-container\"]/div[2]/div[1]/span[1]")).getText());
        Assert.assertEquals("대전 서구 둔산로 100 (대전광역시청) 123", driver.findElement(By.xpath("//*[@id=\"shipping-container\"]/div[2]/div[1]/span[2]")).getText());
        System.out.println("배송지 노출 확인");
        Thread.sleep(1000);

        // 상세정보 확인
        Assert.assertEquals("webauto, 010-0000-0000", driver.findElement(By.xpath("//*[@id=\"checkout-shipping-details\"]/div[1]")).getText());
        System.out.println("받으실분 / 휴대폰 노출 확인");
        Thread.sleep(1000);

        Assert.assertEquals("문 앞", driver.findElement(By.xpath("//*[@id=\"checkout-shipping-details\"]/div[2]/span[1]")).getText());
        Assert.assertEquals("자유 출입 가능", driver.findElement(By.xpath("//*[@id=\"checkout-shipping-details\"]/div[2]/span[2]")).getText());
        System.out.println("받으실 장소 노출 확인");
        Thread.sleep(1000);

        Assert.assertEquals("배송완료 메시지", driver.findElement(By.xpath("//*[@id=\"checkout-shipping-details\"]/div[3]/span[1]")).getText());
        Assert.assertEquals("배송 직후", driver.findElement(By.xpath("//*[@id=\"checkout-shipping-details\"]/div[3]/span[2]")).getText());
        System.out.println("배송완료 메시지 / 메시지 발송 시점 노출 확인");
        Thread.sleep(1000);

        Assert.assertEquals("수정", driver.findElement(By.xpath("//*[@id=\"shipping-container\"]/div[2]/div[2]/button")).getText());
        System.out.println("수정 버튼 노출 확인");
        Thread.sleep(1000);

        // 배송지 변경 안내 영역
        Assert.assertEquals("배송지 변경 안내", driver.findElement(By.xpath("//*[@id=\"shipping-container\"]/div[1]/div/a")).getText());
        driver.findElement(By.xpath("//*[@id=\"shipping-container\"]/div[1]/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"shipping-container\"]/div[1]/div")).click();
        Thread.sleep(1000);

        Assert.assertEquals("장바구니, 홈에서\n" +
                "배송지를 변경할 수 있어요", driver.findElement(By.xpath("//*[@id=\"shipping-container\"]/div[1]/div/div/div")).getText());
        System.out.println("배송지 변경 안내 영역 선택 시 튤팁 노출 확인");


        Thread.sleep(1000);


        driver.quit();

    }
}