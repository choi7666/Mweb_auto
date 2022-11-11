package Full_Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TC5 {

    private static WebDriver driver;

    @Test
    public void TC5() throws InterruptedException {
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
        Thread.sleep(1500);

        // 냉장>냉동>상온>구매 불가 순
        Assert.assertEquals("냉장 상품", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[8]/div/div/span")).getText());
        Thread.sleep(500);
        Assert.assertEquals("냉동 상품", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[11]/div/div/span")).getText());
        Thread.sleep(500);
        Assert.assertEquals("상온 상품", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[14]/div/div/span")).getText());
        Thread.sleep(500);
        Assert.assertEquals("구매불가 상품", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[17]/div/h4/div/span")).getText());
        Thread.sleep(500);
        System.out.println("냉장>냉동>상온>구매불가 순 노출");




        // after
        driver.close();


    }


}


