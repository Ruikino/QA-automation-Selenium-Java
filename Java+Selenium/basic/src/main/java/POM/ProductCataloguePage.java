package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ComponentUtilities.abstractComponents;

import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.By;

public class ProductCataloguePage extends abstractComponents {
    WebDriver driver;

    public ProductCataloguePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".mb-3")
    private List<WebElement> products;

    @FindBy(css = ".ng-animating")
    private WebElement spinner;

    By productsBy = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");
    By shoppingCart = By.cssSelector("button[routerlink='/dashboard/cart']");
    By spinnerOverlay = By.cssSelector(".ngx-spinner-overlay");

    public List<WebElement> getProductsList() {
        waitForElementToAppear(productsBy);
        return products;
    }

    public WebElement getProductByName(String productName) {
        WebElement prod = getProductsList().stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
    }

    public void addProductToCart(String productName) {
        WebElement prod = getProductByName(productName);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        waitForElementToAppear(toastMessage);
        waitForElementToDisappear(spinner);
    }

    public ShoppingCartPage goToCart() {
        waitForElementToDisappear();
        driver.findElement(shoppingCart).click();
        ShoppingCartPage cartPage = new ShoppingCartPage(driver);
        return cartPage;
    }
}
