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

public class TC31 {

        private static WebDriver driver;

        @Test
        public void TC31() throws InterruptedException {

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
                driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto13");

                // 패스워드 입력
                WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
                pw_input.sendKeys("testtest00");

                // 로그인 버튼 클릭
                WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
                login_btn.click();

                Thread.sleep(2000);

                // 검색 탭
                WebElement serch_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[4]/a[3]")));
                serch_btn.click();

                // 키워드 입력
                WebElement keyword16_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div[3]/div/input")));
                keyword16_btn.click();
                WebElement keywordinput16_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")));
                keywordinput16_btn.sendKeys("[자동화] 오토멀티딜");

                // 검색
                WebElement serch16_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div/input")));
                serch16_btn.sendKeys(Keys.ENTER);

                // 정율 상품 장바구니 팝업
                WebElement selectpro_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div[2]/a/div[1]/div/div/button")));
                selectpro_btn.click();

                for (int i = 0; i < 5; i++) {
                        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
                }
                // 스탭퍼 수량 증가
                WebElement puls_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[2]/button[2]")));
                puls_btn.click();
                WebElement puls1_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div[2]/div[2]/div[2]/div[2]/button[2]")));
                puls1_btn.click();
                WebElement puls2_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div[2]/div[3]/div[2]/div[2]/button[2]")));
                puls2_btn.click();

                WebElement popupcart_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[2]")));
                Assert.assertEquals("[자동화] 오토멀티딜\n" +
                        "[자동화] 오토멀티딜\n" +
                        "[자동화] 오토멀티딜3\n" +
                        "15,000원\n" +
                        "1\n" +
                        "[자동화] 오토멀티딜2\n" +
                        "13,500원15,000원\n" +
                        "1\n" +
                        "[자동화] 오토멀티딜1\n" +
                        "15,000원\n" +
                        "1\n" +
                        "적립\n" +
                        "구매 시 2,175원 적립", driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]")).getText());
                System.out.println("정률 상품 장바구니 팝업 정보 확인");
                Thread.sleep(1000);

                // 장바구니 담기
                WebElement cartadd_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/div/div[3]/button")));
                cartadd_btn.click();
                //driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[3]/button[2]")).click();
                Thread.sleep(700);

                // 장바구니 담기 확인
                WebElement cartok_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[1]")));
                cartok_btn.click();

                // 장바구니
                WebElement cartcost_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[10]/div[4]/span[2]")));


                Assert.assertEquals("43,500원", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[10]/div[4]/span[2]")).getText());
                System.out.println("장바구니 정률할인포함 금액확인");

                // after
                // 장바구니 상품 삭제
                WebElement cartdel_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[5]/div/button")));
                cartdel_btn.click();
               // driver.findElement(By.xpath("//*[@id=\"__next\"]/ul/li[1]/div/button")).click();
                Thread.sleep(1000);
                WebElement cartdelok_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[2]")));
                cartdelok_btn.click();
                //driver.findElement(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button[2]")).click();
                Thread.sleep(1000);

                driver.close();

        }

}

