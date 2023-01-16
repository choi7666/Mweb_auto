package Cart;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TC4 {


    private static WebDriver driver;

    @Test
    public void TC4() throws InterruptedException {
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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("mwauto");
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

        // 배송지 변경 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/span")).click();
        Thread.sleep(500);

        // 새창 핸들
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(500);

        // 배송지창 타이틀 확인
        Assert.assertEquals("배송지에 따라 상품정보 및 배송유형이 달라질 수 있습니다.", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/p")).getText());
        System.out.println("1.배송지관리페이지 노출");
        Thread.sleep(500);

        // 다른배송지 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div/div[2]/label/img")).click();
        Thread.sleep(1000);

        // 기존창 전환
        driver.switchTo().window(winHandleBefore);

        // 상품정보 업데이트 얼럿
        Assert.assertEquals("배송지 변경으로 상품 정보가 업데이트됩니다.", driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[1]")).getText());
        System.out.println("1-1.상품정보 업데이트 얼럿 노출");
        Thread.sleep(500);

        // 얼럿 확인
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();


        // after

        // 배송지 변경 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/span")).click();
        Thread.sleep(500);

        // 새창 핸들
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(500);

        // 다른배송지 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div/div[2]/label/img")).click();
        Thread.sleep(1000);

        // 기존창 전환
        driver.switchTo().window(winHandleBefore);


        driver.close();


    }


}
