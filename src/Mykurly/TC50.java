package Mykurly;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TC50 {

    private static WebDriver driver;

    @Test
    public void T50() throws InterruptedException {
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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto6");
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

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/button[4]")).click();
        Thread.sleep(1000);

        // 구매가능 상품
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[4]/a/div[1]/span[2]")).click();
        Thread.sleep(1000);

        // 구매가능 상품 > 전체상품 담기
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/button")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();
        Thread.sleep(500);

        driver.navigate().back();
        Thread.sleep(1000);

        // 장바구니 > 구매가능 상품 확인
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div[3]/button")).click();
        Thread.sleep(1500);

        Assert.assertEquals("[켈로그] 첵스 초코", driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li/div/div/a/p")).getText());
        System.out.println("구매가능한 상품만 장바구니 담았을 경우 -> 구매가능 상품 장바구니 확인");
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li/div/button")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[2]")).click();
        Thread.sleep(500);

        driver.navigate().back();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/button[4]")).click();
        Thread.sleep(1000);

        // 구매가능 + 불가 상품
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[3]/a/div[1]/span[2]")).click();
        Thread.sleep(1000);

        // 구매가능 + 불가 상품 > 전체상품 담기
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/button")).click();
        Thread.sleep(1000);
        Assert.assertEquals("구매 불가능한 상품을 제외하고 1개 상품을 장바구니에 담았습니다.", driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[1]")).getText());
        System.out.println("구매 불가능한 상품 포함 된 경우 얼럿 노출 확인");
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();
        Thread.sleep(500);

        driver.navigate().back();
        Thread.sleep(1000);

        // 장바구니 > 구매가능 상품 확인
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div[3]/button")).click();
        Thread.sleep(1500);

        Assert.assertEquals("[켈로그] 첵스 초코", driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li/div/div/a/p")).getText());
        System.out.println("구매 불가 상품 포함 장바구니 담았을 경우 -> 구매가능 상품 장바구니 확인");
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li/div/button")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[2]")).click();
        Thread.sleep(500);

        driver.navigate().back();
        Thread.sleep(1000);


        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/button[4]")).click();
        Thread.sleep(1000);


        // 구매 불가능 상품
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/a/div[1]/span[2]")).click();
        Thread.sleep(1000);
        // 구매 불가능 상품 > 전체상품 담기
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/button")).click();
        Thread.sleep(1000);
        Assert.assertEquals("품절 등의 이유로 구매 불가능한 상품입니다.", driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[1]")).getText());
        System.out.println("구매 불가능한 상품 경우 얼럿 노출 확인");
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();
        Thread.sleep(500);

        driver.navigate().back();
        Thread.sleep(1000);

        // 장바구니 > 구매가능 상품 확인
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div[3]/button")).click();
        Thread.sleep(1500);

        Assert.assertEquals("장바구니에 담긴 상품이 없습니다", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]")).getText());
        System.out.println("구매 불가 상품 장바구니 담았을 경우 -> 장바구니 빈 리스트 노출 확인");
        Thread.sleep(2000);


        driver.close();

    }

}
