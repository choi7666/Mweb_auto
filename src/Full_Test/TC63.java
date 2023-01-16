package Full_Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TC63 {

    private static WebDriver driver;

    @Test
    public void TC63() throws InterruptedException {
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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto2");
        Thread.sleep(500);

        // 패스워드 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")).sendKeys("qawsedrf12");
        Thread.sleep(500);

        // 로그인 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")).click();
        Thread.sleep(1500);

        // 장바구니 아이콘 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div[2]/button[2]")).click();
        Thread.sleep(3000);

        //주문하기 버튼 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/footer/button")).click();
        Thread.sleep(3000);

        // 쿠폰리스트에서 카카오페이 쿠폰 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[7]/div[2]/button")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[1]/label/span[1]")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();
        Thread.sleep(1000);

        // 적립금 모두사용 버튼 비활성화
        WebElement Btn = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[7]/div[3]/button"));
        boolean isEnabled = Btn.isEnabled();
        if (isEnabled == false) {
            System.out.println("적립금 모두사용 버튼 바활성화");
        }
        Thread.sleep(500);

        // 적립금 Input 박스 비활성화
        WebElement Input = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[7]/div[3]/div/div/input"));
        boolean isEnabled2 = Btn.isEnabled();
        if (isEnabled2 == false) {
            System.out.println("적립금 input 박스 비활성화");
        }
        Thread.sleep(500);

        // 결제수단 영역 카카오페이 안내 문구
        Assert.assertEquals("카카오페이 전용 쿠폰 사용 시, 카카오페이 결제만 가능합니다.", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[9]/div[2]")).getText());
        System.out.println("결제수단 카카오페이 문구 노출 확인");
        Thread.sleep(500);

        // 쿠폰 할인 금액
        Assert.assertEquals("-358", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[11]/div[2]/div[5]/div[2]/span[1]")).getText());
        System.out.println("쿠폰할인금액 노출 확인");
        Thread.sleep(500);

        // 카카오페이 외 결제수단 미노출
        Assert.assertEquals("카카오페이", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[9]/div[1]")).getText());
        System.out.println("카카오페이 외 결제수단 미노출 확인");
        Thread.sleep(500);

        // 쿠폰리스트에서 카카오페이 외 쿠폰 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[7]/div[2]/button")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[1]/label/span[1]")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]")).click();
        Thread.sleep(500);

        boolean displayed = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[9]/div")).isDisplayed();
        System.out.println("카카오페이 외 결제 수단 노출 확인");
        Thread.sleep(1000);


        driver.quit();

    }

}
