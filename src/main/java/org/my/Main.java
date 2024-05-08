package org.my;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:/selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

               driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                try {

                    driver.get("https://chercher.tech/practice/popups");
                    driver.manage().window().maximize();
                    WebElement alert = driver.findElement(By.name("alert"));
                    alert.click();

                    String alertMessage = driver.switchTo().alert().getText();
                    System.out.println(alertMessage);
                    driver.switchTo().alert().accept();
                    WebElement confirm = driver.findElement(By.name("confirmation"));
                    confirm.click();

                    String alertMessage2 = driver.switchTo().alert().getText();
                    System.out.println(alertMessage2);
                    driver.switchTo().alert().accept();

                    WebElement prompt = driver.findElement(By.name("prompt"));
                    prompt.click();
                    String alertMessage3 = driver.switchTo().alert().getText();
                    System.out.println(alertMessage3);
                    driver.switchTo().alert().accept();

                    WebElement sub = driver.findElement(By.id("sub-menu"));
                    sub.click();
                    driver.findElement(By.id("link2")).click();
                    driver.navigate().back();

                    // Двойное нажатие

                    Actions actions = new Actions(driver);
                    actions.doubleClick(driver.findElement(By.xpath("//input[@id='double-click']"))).click().perform();
                    String alertMessage4 = driver.switchTo().alert().getText();
                    System.out.println(alertMessage4);
                    driver.switchTo().alert().accept();

                    WebElement link = driver.findElement(By.xpath("//a[contains(text(),'I am broken link')]"));
                    link.click();
                    driver.navigate().back();

                    WebElement newWindow = driver.findElement(By.id("two-window"));
                    newWindow.click();

                    String MainWindow = driver.getWindowHandle();
                    driver.switchTo().window(MainWindow);

                    WebElement multipleWindows = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/a[2]/input[1]"));
                    multipleWindows.click();

                    String MainWindows = driver.getWindowHandle();
                    driver.switchTo().window(MainWindows);

                    // Запонение пустых строк

                    driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/input[1]")).sendKeys("111");
                    driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/input[2]")).sendKeys("222");
                    driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/input[3]")).sendKeys("333");

                    // Выпадающее меню

                    WebElement dropDown = driver.findElement(By.xpath("//select[@id='first']"));
                    Select select = new Select(dropDown);
                    select.selectByVisibleText("Yahoo");

                    WebElement checkBox = driver.findElement(By.id("checkbox"));
                    checkBox.click();

                    WebElement radioButton = driver.findElement(By.xpath("//input[@id='radio']"));
                    radioButton.click();

                    Thread.sleep(2000);

                } catch (InterruptedException e) {

                    throw new RuntimeException(e);

                } finally {

                    driver.quit();
                }

            }
        }


