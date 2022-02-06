package pages;

public class TestSandBoxPage extends BasePage {

    private String categoryDropdown = "//select[@id='testingDropdown']";

    public TestSandBoxPage() {
        super(driver);
    }

    public void navigateToSandBox() {
        navigateTo("https://www.testandquiz.com/selenium/testing.html");
    }

    public void selectCategory(String category) {
        selectFromDropdownByValue(categoryDropdown, category);
    }

}
