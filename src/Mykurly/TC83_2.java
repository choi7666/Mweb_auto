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
import java.util.Random;

public class TC83_2 {

    private static WebDriver driver;

    @Test
    public void T83_1() throws InterruptedException {
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

        // 회원가입 버튼
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[2]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"memberId\"]")).click();


        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        int length = 8;
        String values = Capital_chars + Small_chars + numbers;
        Random randomGenerator = new Random();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < length; i++) {

            // 임의의 번호 생성
            int index = randomGenerator.nextInt(values.length());

            // 문자 가져오기
            char randomChar = values.charAt(index);

            // 문자 랜덤 추가
            id.append(randomChar);

        }

        System.out.println("아이디 = " + id.toString());

        driver.findElement(By.xpath("//*[@id=\"memberId\"]")).sendKeys(id.toString());
        Thread.sleep(500);

        // 아이디 중복확인
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[1]/div[2]/div[2]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();
        Thread.sleep(1000);


        // 비밀번호 입력
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("qawsedrf12");
        Thread.sleep(1000);

        // 비밀번호 입력 확인
        driver.findElement(By.xpath("//*[@id=\"passwordConfirm\"]")).sendKeys("qawsedrf12");
        Thread.sleep(1000);

        // 이름
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("auto");
        Thread.sleep(1000);

        // 이메일 입력
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(id.toString(), "@kurlycorp.com");
        Thread.sleep(1000);

        // 이메일 중복 확인
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[5]/div[2]/div[2]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();
        Thread.sleep(1000);

        // 휴대폰
        driver.findElement(By.xpath("//*[@id=\"mobileNumber\"]")).sendKeys("01000000000");
        Thread.sleep(1000);

        // 인증번호 받기
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[6]/div[2]/div[2]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();
        Thread.sleep(1000);

        // 인증번호 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[7]/div[2]/div[1]/div/div/input")).sendKeys("111111");
        Thread.sleep(1000);

        // 인증번호 확인
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[7]/div[2]/div[2]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();
        Thread.sleep(1000);

        // 주소검색
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[7]/div[2]/div/div/div/input")).click();
        Thread.sleep(5000);

        // 새창 핸들
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(5000);

        // frame 전환
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"__daum__layer_1\"]/iframe")));
        Thread.sleep(500);

        // 하위 frame
        driver.switchTo().frame("__daum__viewerFrame_1");
        Thread.sleep(500);

        // 주소 입력
        driver.findElement(By.xpath("//*[@id=\"region_name\"]")).sendKeys("역삼역");
        Thread.sleep(1000);

        // 주소 검색
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/fieldset/div/button[2]")).click();
        Thread.sleep(1000);

        // 주소 선택
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/ul/li[1]/dl/dd[1]/span/button")).click();
        Thread.sleep(1000);

        // frame 벗어나기
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();

        // 나머지 주소 입력
        driver.findElement(By.xpath("//*[@id=\"addressDetail\"]")).sendKeys("123");
        Thread.sleep(1000);

        // 저장
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/button")).click();
        Thread.sleep(1000);

        // 기존창 전환
        driver.switchTo().window(winHandleBefore);

        // 약관 전체 동의
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[4]/div/div[2]/div/div[1]/label/img")).click();
        Thread.sleep(1000);

        // 가입하기
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[5]/button")).click();
        Thread.sleep(2500);
        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();
        Thread.sleep(1500);

        // 가입완료 페이지
        Assert.assertEquals("회원가입이 완료되었습니다.", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/p")).getText());
        System.out.println("회원가입 완료");


        driver.quit();


    }

}
