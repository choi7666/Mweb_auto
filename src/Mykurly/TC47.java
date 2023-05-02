package Mykurly;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TC47 {

        private static WebDriver driver;

        @Test
        public void TC47() throws InterruptedException {

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
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                // id가 input 요소가 나타날 때까지 대기
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")));

                // 현재창 핸들
                String winHandleBefore = driver.getWindowHandle();

                // 아이디 입력
                driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto15");

                // 패스워드 입력
                WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
                pw_input.sendKeys("testtest00");
                Thread.sleep(500);


                // 로그인 버튼 클릭
                WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
                login_btn.click();
                Thread.sleep(2000);

                // 주문내역상세
                WebElement orderdetail_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[3]/a[1]/div[1]")));
                orderdetail_btn.click();
                Thread.sleep(500);

                // 주문내역 3년 정렬 후 진입
                WebElement orderdetail3year_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/button[4]")));
                orderdetail3year_btn.click();
                WebElement orderdetailclick_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/a/div[2]")));
                orderdetailclick_btn.click();

                Thread.sleep(300);
                // 주문내역 상세보기
                WebElement orderdetail2_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[2]/h1")));
                Assert.assertEquals("주문 내역 상세", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[2]/h1")).getText());
                System.out.println("주문 내역 상세 이동 확인");

                // 주문번호
                WebElement ordernumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/button[1]/span/h3")));

                Assert.assertEquals("주문번호 2301510510001", driver.findElement(By.xpath("//*[@id=\"__next\"]/button[1]/span/h3")).getText());
                System.out.println("주문번호 노출 확인");


                // 상품명
                WebElement ordername = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[1]/a")));
                Assert.assertEquals("[자동화] 오토냉장", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[1]/a")).getText());
                System.out.println("상품명 노출 확인");


                // 상품 금액
                WebElement ordercost = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[2]/span[1]")));
                Assert.assertEquals("15,000원", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[2]/span[1]")).getText());
                System.out.println("상품 금액 노출 확인");


                // 상품 갯수
                WebElement ordercount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[2]/span[3]")));
                Assert.assertEquals("1개", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[2]/span[3]")).getText());
                System.out.println("상품 갯수 노출 확인");


                // 배송 상태
                WebElement orderdelivery = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[3]/div[1]/span")));
                Assert.assertEquals("주문완료", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div/div/div[3]/div[1]/span")).getText());
                System.out.println("배송 상태 노출 확인");


                // 결제정보 선택
                WebElement orderinfo_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/button[2]/span/h3")));
                orderinfo_btn.click();


                // 결제정보의 결제 방법
                WebElement orderinfo1_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[7]/ul/li[6]/div")));
                Assert.assertEquals("전액 적립금", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[7]/ul/li[6]/div")).getText());
                System.out.println("결제방법 노출 확인");


                // 하드코딩 문구
                WebElement orderinfo22_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[12]/span")));
                Assert.assertEquals("주문취소는 [주문완료] 상태일 경우에만 가능합니다.", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[12]/span")).getText());
                System.out.println("주문내역상세 하드코딩 문구 확인");

                // 1:1문의하기 버튼
                WebElement ask_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[12]/button/div/span")));
                Assert.assertEquals("1:1 문의하기", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[12]/button/div/span")).getText());
                System.out.println("1:1 문의하기 버튼 확인");



                driver.close();

        }

}