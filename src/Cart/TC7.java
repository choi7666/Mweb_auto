package Cart;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TC7 {

    private static WebDriver driver;

    @Test
    public void TC7() throws InterruptedException {
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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto");
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


        // 스텝퍼 + 선택시 금액 증가
        driver.findElement(By.xpath("//*[@id=\"__next\"]/ul[1]/li/div/div/div/div/div/button[2]")).click();
        Assert.assertEquals("35,760원", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[13]/div[1]/span[2]")).getText());
        System.out.println("+시 금액 증가");
        Thread.sleep(1000);

        //스텝퍼 - 선택시 금액 감소
        driver.findElement(By.xpath("//*[@id=\"__next\"]/ul[1]/li/div/div/div/div/div/button[1]")).click();
        Assert.assertEquals("22,780원", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[13]/div[1]/span[2]")).getText());
        System.out.println("-시 금액 감소");
        Thread.sleep(1000);

        //최소구매 수량 얼럿
        driver.findElement(By.xpath("//*[@id=\"__next\"]/ul[2]/li/div/div/div/div/div/button[1]")).click();
        Thread.sleep(1000);

        Assert.assertEquals("[라아부엘라니에베스] 스페인 수제 감자칩 상품의 최소 구매 수량은 2개 입니다.", driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[1]")).getText());
        System.out.println("최소구매 수량 얼럿 확인");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();

        //최대구매 수량 얼럿
        driver.findElement(By.xpath("//*[@id=\"__next\"]/ul[2]/li/div/div/div/div/div/button[2]")).click();
        Thread.sleep(1000);

        Assert.assertEquals("[라아부엘라니에베스] 스페인 수제 감자칩 상품의 최대 구매 수량은 2개 입니다.", driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[1]")).getText());
        System.out.println("최대구매 수량 얼럿 확인");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();


        // after
        driver.close();


    }


}
