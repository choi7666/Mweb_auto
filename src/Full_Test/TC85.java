package Prd_detail;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TC85 {

    private static WebDriver driver;

    @Test
    public void TC85() throws InterruptedException {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--disable-extensions");
        ops.addArguments("--disable-gpu");


        System.setProperty("webdriver.chrome.driver", "/Users/mk-am14-008/Documents/selenium/chromedriver");

        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", "Samsung Galaxy S20 Ultra");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);


        // stg 접속
        driver.get("https://www.stg.kurly.com/member/login?return_url=/mypage");

        // 최대 10초 동안 대기
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // id가 input 요소가 나타날 때까지 대기
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")));

        // 현재창 핸들
        String winHandleBefore = driver.getWindowHandle();

        // 아이디 입력
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto7");

        // 패스워드 입력
        WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
        pw_input.sendKeys("testtest00");


        // 로그인 버튼 클릭
        WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
        login_btn.click();

        Thread.sleep(2000);



        // 마켓 사이트 이동
        driver.get("https://www.stg.kurly.com/main");
        Thread.sleep(1000);

        //뷰티컬리 둥둥이 확인
        WebElement beautydungdung = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[4]/button/div")));
        Assert.assertEquals("뷰티컬리", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/button/div")).getText());
        System.out.println("뷰티컬리 둥둥이 확인");

        Thread.sleep(1000);



        /* 마켓컬리 버튼 활성화 여부 확인
        WebElement marketbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div/div[2]/label[1]")));
        String backgroundColor = marketbutton.getCssValue("background-color");

        if (!backgroundColor.equals("rgba(95, 0, 128") && !backgroundColor.equals("transparent")) {
            System.out.println("버튼이 활성화되었습니다.");
        } else {
            System.out.println("버튼이 비활성화되었습니다.");
        }
        Thread.sleep(1000);

         */


        // 뷰티 마켓 사이트 이동
        driver.get("https://www.stg.kurly.com/main/beauty");
        Thread.sleep(1000);

        //뷰티컬리 둥둥이 확인
        WebElement beautydungdung1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[4]/button/div")));
        Assert.assertEquals("마켓컬리", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/button/div")).getText());
        System.out.println("마켓컬리 둥둥이 확인");

        Thread.sleep(500);


        /* 뷰티컬리 버튼 활성화 여부 확인
        WebElement beautybutton = driver.findElement(By.id("//*[@id=\"__next\"]/div[1]/div[2]/div/div[2]/span"));
        String backgroundColor1 = beautybutton.getCssValue("background-color");

        if (!backgroundColor1.equals("rgba(95, 0, 128") && !backgroundColor1.equals("transparent")) {
            System.out.println("버튼이 활성화되었습니다.");
        } else {
            System.out.println("버튼이 비활성화되었습니다.");
        }
        Thread.sleep(1000);

         */


        driver.close();

    }
}