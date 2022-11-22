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

public class TC68_1 {

    private static WebDriver driver;

    @Test
    public void TC68_1() throws InterruptedException {
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

        //장바구니 담기
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div[1]/div/div/button")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[3]/button[2]")).click();
        Thread.sleep(1000);

        // 장바구니 아이콘 클릭
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[1]")).click();
        Thread.sleep(3000);

        //전체 체크 해제
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[5]/div/label/img")).click();
        Thread.sleep(1000);

        //주문 상품 체크
        driver.findElement(By.xpath("//*[@id=\"__next\"]/ul[2]/li[1]/div/label/img")).click();
        Thread.sleep(1000);

        //주문하기 버튼 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/footer/button")).click();
        Thread.sleep(3000);

        // 적립금 모두사용
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[7]/div[3]/button")).click();
        Thread.sleep(5000);

        //driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);

        //개인정보 수집 동의 체크
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[11]/label/img")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);

        //결제하기 버튼 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[12]/button")).click();
        Thread.sleep(5000);

        //주문완료
        Assert.assertEquals("webauto님의 주문이 완료되었습니다.", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[1]/div/p[1]")).getText());
        System.out.println("주문완료 페이지 확인");
        Thread.sleep(1000);

        //주문완료페이지>주문 상세보기 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/footer/div/button[1]")).click();
        Thread.sleep(5000);

        //전체상품 주문 취소
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[13]/button")).click();
        Thread.sleep(3000);

        driver.switchTo().alert().accept();
        Thread.sleep(3000);

        //주문취소 페이지
        //주문취소 내역 동의
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[8]/label/img")).click();
        Thread.sleep(2000);

        //주문취소하기 버튼 클릭
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[8]/button")).click();
        Thread.sleep(2000);

        //주문취소 얼럿 확인
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[2]")).click();
        Thread.sleep(2000);


        driver.quit();

    }

}
