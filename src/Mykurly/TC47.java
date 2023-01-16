package Mykurly;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TC47 {

    private static WebDriver driver;

    @Test
    public void T47() throws InterruptedException {
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
        Thread.sleep(500);

        // 주문내역 상세보기
        Assert.assertEquals("주문 내역 상세", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div[2]/h1")).getText());
        Thread.sleep(500);
        System.out.println("주문 내역 상세 이동 확인");

        // 주문번호
        Assert.assertEquals("주문번호 2284710310001", driver.findElement(By.xpath("//*[@id=\"__next\"]/button[1]/span/h3")).getText());
        System.out.println("주문번호 노출 확인");
        Thread.sleep(500);

        // 상품명
        Assert.assertEquals("[켈로그] 첵스 초코", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div/div[1]/a")).getText());
        System.out.println("상품명 노출 확인");
        Thread.sleep(500);

        // 상품 금액
        Assert.assertEquals("3,580원", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div/div[2]/span[1]")).getText());
        System.out.println("상품 금액 노출 확인");
        Thread.sleep(500);

        // 상품 갯수
        Assert.assertEquals("1개", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div/div[2]/span[3]")).getText());
        System.out.println("상품 갯수 노출 확인");
        Thread.sleep(500);

        // 배송 상태
        Assert.assertEquals("배송완료", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div/div[3]/div[1]/span")).getText());
        System.out.println("배송 상태 노출 확인");
        Thread.sleep(500);

        // 결제정보 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/button[2]")).click();
        Thread.sleep(500);

        // 결제정보의 결제 방법
        Assert.assertEquals("전액 적립금", driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li[5]/span[2]")).getText());
        System.out.println("결제방법 노출 확인");
        Thread.sleep(500);

        // 하드코딩 문구
        Assert.assertEquals("주문취소는 [주문완료] 상태일 경우에만 가능합니다.", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[12]/span")).getText());
        System.out.println("주문내역상세 하드코딩 문구 확인");
        Thread.sleep(500);

        // 1:1문의하기 버튼
        Assert.assertEquals("1:1 문의하기", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[12]/div/span")).getText());
        System.out.println("1:1 문의하기 버튼 확인");
        Thread.sleep(500);


        driver.close();

    }

}
