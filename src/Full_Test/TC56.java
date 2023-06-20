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

import java.security.Key;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TC56 {

        private static WebDriver driver;

        @Test
        public void TC56() throws InterruptedException {

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
                driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[1]/div/input")).sendKeys("webauto20");

                // 패스워드 입력
                WebElement pw_input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[1]/div[2]/div/input")));
                pw_input.sendKeys("testtest00");


                // 로그인 버튼 클릭
                WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[3]/button[1]")));
                login_btn.click();
                Thread.sleep(1000);

                // 개인정보수정 메뉴
                driver.get("https://www.stg.kurly.com/mypage/info");
                Thread.sleep(2000);


                // 비밀번호 입력
                driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("testtest00");
                Thread.sleep(1000);

                // 확인 버튼
                driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[2]/button")).click();
                Thread.sleep(1000);

                // 이름 변경
                WebElement namechange_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"name\"]")));

                namechange_btn.click();
                namechange_btn.clear();


                        Thread.sleep(1000);
                        namechange_btn.sendKeys("webauto200");
                        Thread.sleep(1000);

                        // 회원정보수정
                        WebElement change_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[11]/div/button/span")));
                        change_btn.click();
                        Thread.sleep(1000);

                        WebElement changeok_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")));
                        changeok_btn.click();

                        Thread.sleep(2000);

                        // 회원정보수정 적용 확인
                        WebElement changed_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[1]/div[2]/strong")));

                        Assert.assertEquals("webauto200님", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[1]/div[1]/div[2]/strong")).getText());
                        System.out.println("회원정보수정 적용 확인");


                        Thread.sleep(1000);


                        // after
                        // 개인정보수정 메뉴
                        driver.get("https://www.stg.kurly.com/mypage/info");
                        Thread.sleep(2500);

                        // 비밀번호 입력
                        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("testtest00");
                        Thread.sleep(1500);

                        // 확인 버튼
                        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[2]/button/span")).click();
                        Thread.sleep(1500);

                        // 이름 변경
                        WebElement namechange1_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"name\"]")));
                        namechange1_btn.click();
                        namechange1_btn.clear();
                        //driver.findElement(By.xpath("//*[@id=\"name\"]")).clear();
                        Thread.sleep(500);
                        namechange1_btn.sendKeys("webauto20");
                        //driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("webauto100");
                        Thread.sleep(1500);

                        // 회원정보수정
                        WebElement change1_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[3]/form/div[11]/div/button/span")));
                        change1_btn.click();
                        Thread.sleep(1500);

                        WebElement changeok1_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"swal2-content\"]/div[2]/button")));
                        changeok1_btn.click();

                        Thread.sleep(2000);

                        driver.quit();


                }

        }
