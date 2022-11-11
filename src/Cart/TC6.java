package Cart;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TC6 {

    private static WebDriver driver;

    @Test
    public void TC6() throws InterruptedException {
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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto8");
        Thread.sleep(500);

        // 패스워드 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")).sendKeys("qawsedrf12");
        Thread.sleep(500);

        // 로그인 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")).click();
        Thread.sleep(1500);

        // 장바구니 아이콘 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div[2]/button[2]")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);

        // 상품금액
        Assert.assertEquals("21,500원" , driver.findElement(By.xpath("//*[@id=\"__next\"]/div[19]/div[1]/span[2]")).getText());
        Thread.sleep(500);
        System.out.println("상품금액 합계 확인");

        // 상품할인금액
        Assert.assertEquals("-110원" , driver.findElement(By.xpath("//*[@id=\"__next\"]/div[19]/div[2]/span[2]")).getText());
        Thread.sleep(500);
        System.out.println("상품할인금액 확인");

        // 배송비
        Assert.assertEquals("+3,000원" , driver.findElement(By.xpath("//*[@id=\"__next\"]/div[19]/div[3]/span[2]")).getText());
        Thread.sleep(500);
        Assert.assertEquals("18,610원 추가주문 시, 무료배송" , driver.findElement(By.xpath("//*[@id=\"__next\"]/div[19]/p")).getText());
        System.out.println("배송비 확인");
        Thread.sleep(500);

        // 결제예정금액
        Assert.assertEquals("24,390원" , driver.findElement(By.xpath("//*[@id=\"__next\"]/div[19]/div[4]/span[2]")).getText());
        System.out.println("결제예정금액 확인");


        // after
        driver.close();


    }

}
