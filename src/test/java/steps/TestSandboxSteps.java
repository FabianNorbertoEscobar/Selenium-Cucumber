package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.TestSandBoxPage;

public class TestSandboxSteps {

    TestSandBoxPage sandBox = new TestSandBoxPage();

    @Given("^I navigate to the sandbox page$")
    public void navigateToTheSandboxSite() {
        sandBox.navigateToSandBox();
    }

    @And("^select a value from the dropdown$")
    public void selectState() {
        sandBox.selectCategory("Manual");
    }
}
