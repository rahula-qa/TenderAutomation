public class AIResultsPage {
    private WebDriver driver;

    @FindBy(id = "aiScore")
    private WebElement aiScore;

    @FindBy(id = "remarks")
    private WebElement remarks;

    public AIResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getAIScore() {
        return aiScore.getText();
    }

    public String getRemarks() {
        return remarks.getText();
    }
}
