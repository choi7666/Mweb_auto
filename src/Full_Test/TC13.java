package Full_Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TC13 {

    private static WebDriver driver;

    @Test
    public void T13() throws InterruptedException {
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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto11");
        Thread.sleep(500);

        // 패스워드 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")).sendKeys("qawsedrf12");
        Thread.sleep(500);

        // 로그인 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")).click();
        Thread.sleep(1200);

        // 장바구니 아이콘 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div[2]/button[2]")).click();
        Thread.sleep(3000);

        // URL 배너 상품 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li[2]/div/div/div/a/span")).click();
        Thread.sleep(1500);

        // URL 배너 확인
        Assert.assertEquals("url연결 배너", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/button")).getText());
        Thread.sleep(500);
        System.out.println("URL 배너 노출 확인");

        // URL 배너 선택 후 뒤로가기
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/button")).click();
        Thread.sleep(1500);
        System.out.println("URL 링크 이동");
        driver.navigate().back();
        Thread.sleep(1500);
        Assert.assertEquals("url연결 배너", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/button")).getText());
        Thread.sleep(500);
        System.out.println("뒤로가기 시 상품상세페이지 복귀 확인");


        driver.close();


    }

}
