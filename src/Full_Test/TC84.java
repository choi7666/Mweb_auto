package Full_Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TC84 {

    private static WebDriver driver;

    @Test
    public void T84() throws InterruptedException {
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


        // 아이디 찾기
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[4]/a[1]")).click();
        Thread.sleep(2000);

        // 휴대폰 인증 이름 플레이스 홀더 문구
        driver.findElement(By.xpath("//*[@id=\"name\"]")).getAttribute("이름을 입력해 주세요");
        System.out.println("이름 플레이스 홀더 문구 확인");

        // 휴대폰 인증 휴대폰 번호 플레이스 홀더 문구
        driver.findElement(By.xpath("//*[@id=\"phone\"]")).getAttribute("휴대폰 번호를 입력해 주세요");
        System.out.println("휴대폰 번호 플레이스 홀더 문구 확인");
        Thread.sleep(1000);


        // 이메일 인증 탭 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/button[2]")).click();
        Thread.sleep(2000);

        // 이름 입력
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("webauto");
        Thread.sleep(2000);

        // 이메일 입력
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("webauto@kurlycorp.com");
        Thread.sleep(1000);

        // 확인 버튼 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/form/div[3]/button")).click();
        Thread.sleep(3000);

        // 아이디 찾기 완료 페이지
        Assert.assertEquals("아이디 확인 후 로그인해 주세요.", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div")).getText());
        Thread.sleep(1000);

        Assert.assertEquals("weba***", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/ul/li/div/div[1]")).getText());
        Thread.sleep(1000);

        System.out.println("아이디 찾기 완료");
        Thread.sleep(1000);

        // 아이디 전체보기
        driver.findElement(By.xpath("//*[@id=\"__next\"]/footer/div/button[1]")).click();
        Thread.sleep(2000);

        Assert.assertEquals("가입하신 이메일로 아이디가 발송되었습니다. 메일을 받지 못하셨다면 스팸함을 확인해 보세요.\n" +
                "\n" + "* 휴대폰 인증으로 아이디 찾기 시에도 전체 아이디 확인이 가능해요.", driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[1]")).getText());
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")).click();

        System.out.println("아이디 전체보기 동작 확인");
        Thread.sleep(1000);


        // 로그인 버튼 선택
        driver.findElement(By.xpath("//*[@id=\"__next\"]/footer/div/button[2]")).click();
        Thread.sleep(1000);

        Assert.assertEquals("로그인", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div[2]/h1")).getText());
        Thread.sleep(1000);

        System.out.println("로그인페이지 이동 확인");


        Thread.sleep(500);


        driver.quit();


    }

}
