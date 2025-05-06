public class DashboardPage {
    private WebDriver driver;

    @FindBy(xpath = "//h1[text()='Dashboard']")
    private WebElement dashboardHeader;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isDashboardLoaded() {
        return dashboardHeader.isDisplayed();
    }
}
