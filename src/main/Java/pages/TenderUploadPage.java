public class TenderUploadPage {
    private WebDriver driver;

    @FindBy(id = "uploadTenderBtn")
    private WebElement uploadTenderBtn;

    @FindBy(id = "browseFile")
    private WebElement browseFileInput;

    @FindBy(id = "submitTender")
    private WebElement submitTenderBtn;

    public TenderUploadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void uploadTender(String filePath) {
        uploadTenderBtn.click();
        browseFileInput.sendKeys(filePath);
        submitTenderBtn.click();
    }
}