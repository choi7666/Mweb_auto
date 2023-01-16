package Full_Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TC82_2 {

    private static WebDriver driver;

    @Test
    public void TC82_2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mk-mac-190/Documents/selenium/chromedriver");

        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", "Samsung Galaxy S20 Ultra");

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);


        // stg 접속
        driver.get("https://www.stg.kurly.com/goods/1000034205");
        Thread.sleep(1500);

        // 현재창 핸들
        String winHandleBefore = driver.getWindowHandle();

        // 로그인 유도 얼럿 확인
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();
        Thread.sleep(500);

        // 아이디 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[2]/div[1]/div/input")).sendKeys("jjongqa");
        Thread.sleep(500);

        // 패스워드 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[2]/div[2]/div/input")).sendKeys("whdrhks12!");
        Thread.sleep(500);

        // 로그인 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[4]/button[1]")).click();
        Thread.sleep(1200);


        //주류상품 상세
        Assert.assertEquals("[테스트] 주류", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[2]/div[1]/div[2]/h2")).getText());
        System.out.println("성인인증 계정 -> 주류상품 상세 이동 확인");
        Thread.sleep(1000);


        driver.quit();


    }


}
