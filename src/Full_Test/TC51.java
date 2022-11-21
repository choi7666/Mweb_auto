package Full_Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TC51 {

    private static WebDriver driver;

    @Test
    public void TC51() throws InterruptedException {
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
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto7");
        Thread.sleep(500);

        // 패스워드 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")).sendKeys("qawsedrf12");
        Thread.sleep(500);

        // 로그인 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")).click();
        Thread.sleep(1500);

        // 검색 탭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/a[3]")).click();
        Thread.sleep(500);

        // 키워드 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div[3]/div/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")).sendKeys("첵스");
        Thread.sleep(1300);

        // 검색
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        // 상품 선택
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]")).click();
        Thread.sleep(2000);

        // 구매하기
        driver.findElement(By.xpath("//*[@id=\"__next\"]/footer/button[2]")).click();
        Thread.sleep(700);

        // 장바구니 담기
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/button")).click();
        Thread.sleep(1000);

        // 장바구니 확인 버튼
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[1]")).click();
        Thread.sleep(3000);

        // 주문하기
        driver.findElement(By.xpath("//*[@id=\"__next\"]/footer/button")).click();
        Thread.sleep(5000);

        // 적립금 모두사용
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[7]/div[3]/button")).click();
        Thread.sleep(1000);

        // 약관 전체 동의
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[11]/label/img")).click();
        Thread.sleep(1000);

        // 결제하기 버튼 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[12]/button")).click();
        Thread.sleep(2500);

        //주문완료페이지>주문 상세보기 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/footer/div/button[1]")).click();
        Thread.sleep(1500);

        //전체상품 주문 취소
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[13]/button")).click();
        Thread.sleep(1000);

        driver.switchTo().alert().accept();
        Thread.sleep(1500);

        //주문취소 내역 동의
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[8]/label/img")).click();
        Thread.sleep(1000);

        //주문취소하기 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[8]/button")).click();
        Thread.sleep(1000);

        //주문취소 얼럿 확인
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[2]")).click();
        Thread.sleep(3000);
        System.out.println("주문 취소 완료");
//*[@id="__next"]/div[3]/div/button
        //*[@id="__next"]/div[1]/div/div[1]/button
        //*[@id="__next"]/div/div[1]/div/div[1]/button

        // 취소 상품 다시 담기
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/button")).click();
        Thread.sleep(2000);

        // 취소 상품 다시 담기 얼럿
        Assert.assertEquals("1개 상품을 장바구니에 담았습니다.", driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[1]")).getText());
        Thread.sleep(1000);
        System.out.println("구매 가능한 상품만 있는 경우 얼럿 노출 확인");
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();
        Thread.sleep(1000);

        // x버튼 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div[1]/button")).click();
        Thread.sleep(1500);

        // 상품 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/img")).click();
        Thread.sleep(2000);

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

        driver.quit();


    }

}