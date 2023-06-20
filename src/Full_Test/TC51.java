package Full_Test;

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

public class TC51 {

        private static WebDriver driver;

        @Test
        public void TC51() throws InterruptedException {

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
                driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto16");

                // 패스워드 입력
                WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
                pw_input.sendKeys("testtest00");


                // 로그인 버튼 클릭
                WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
                login_btn.click();

                Thread.sleep(2000);

                // 정액상품 이동
                driver.get("https://www.stg.kurly.com/goods/1000052863");

                Thread.sleep(500);

                // 장바구니 담기
                WebElement cart_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/footer/button[2]")));
                cart_btn.click();
                Thread.sleep(2000);


                WebElement carta_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[3]/button")));
                carta_btn.click();

                // 장바구니 확인
                WebElement cartb_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[1]/span")));
                cartb_btn.click();
                Thread.sleep(1500);


        // 주문하기
                WebElement order_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/footer/button/span")));
                order_btn.click();
                Thread.sleep(1000);

        /* 컬리페이 오류팝업 닫기 ( 정상화 되면 삭제 필요 ! )
        WebElement buy11_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")));
        buy11_btn.click();
        Thread.sleep(1000);

         */

        // 적립금 모두사용

        WebElement pointuse_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[11]/div[2]/button")));
        pointuse_btn.click();
        Thread.sleep(1000);


                for (int i = 0; i < 15; i++) {
                        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
                }


        // 약관 전체 동의
       // driver.findElement(By.xpath("//*[@id=\"__next\"]/div[11]/label/img")).click();
      //  Thread.sleep(1000);

        // 결제하기 버튼 선택

                WebElement pointbuy_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[18]/button")));
                pointbuy_btn.click();
                Thread.sleep(6000);




        //주문완료페이지>주문 상세보기 버튼 클릭
                WebElement orderdetail_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div/footer/div/button[1]/span")));
                orderdetail_btn.click();
                Thread.sleep(1500);



        //전체상품 주문 취소
                WebElement ordercancle_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[12]/button/span")));
                ordercancle_btn.click();
                Thread.sleep(2000);
                WebElement ordercancle1_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[2]")));
                ordercancle1_btn.click();
                Thread.sleep(1500);
//*[@id="__next"]/div[12]/button/span

       // driver.switchTo().alert().accept();
        //Thread.sleep(1500);

        //주문취소 내역 동의
              //  WebElement ordercanclecon_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[2]")));
              //  ordercanclecon_btn.click();
             //   Thread.sleep(1500);


                // 주문취소 사유
                for (int i = 0; i < 15; i++) {
                        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
                }

                Thread.sleep(2000);
                WebElement selfcancelbox_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[8]/label/span")));
                selfcancelbox_btn.click();
                Thread.sleep(500);

                WebElement selfcancelok2_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[8]/button/span")));
                selfcancelok2_btn.click();

                WebElement selfcancelok3_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[2]")));
                selfcancelok3_btn.click();
                Thread.sleep(1000);

                //주문 취소 완료 페이지
                WebElement canaft = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[2]/h1")));
                Assert.assertEquals("주문 취소 완료", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[2]/h1")).getText());
                System.out.println("주문 취소 완료 페이지 확인");
               // WebElement canaftok = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div/button/span")));
                //canaftok.click();

                Thread.sleep(3000);

        // 취소 상품 다시 담기
                WebElement reorder_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/button")));
                reorder_btn.click();
                Thread.sleep(2000);

                // 취소 상품 다시 담기 얼럿
                Assert.assertEquals("1개 상품을 장바구니에 담았습니다.", driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[1]")).getText());
                Thread.sleep(1000);
                System.out.println("구매 가능한 상품만 있는 경우 얼럿 노출 확인");
                WebElement reorderpop_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")));
                reorderpop_btn.click();
                Thread.sleep(2000);

                // x버튼 선택
                //WebElement x_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/button")));
                //x_btn.click();
                //Thread.sleep(2000);

         // 장바구니 이동
                driver.get("https://www.stg.kurly.com/cart");
                Thread.sleep(2000);

                // 장바구니 상품 확인
                WebElement cart1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/ul/li/div/div/a/p")));
                Assert.assertEquals("[자동화] 오토정액", driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li/div/div/a/p")).getText());
                System.out.println("장바구님 재담기 확인");
                WebElement cartdel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[5]/div/button")));
                cartdel.click();
                Thread.sleep(500);
                WebElement cartdelok = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[2]")));
                cartdelok.click();
                Thread.sleep(500);

        driver.quit();


    }

}