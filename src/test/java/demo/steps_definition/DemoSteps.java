package demo.steps_definition;

import demo.pages.test.Demo;
import io.cucumber.java8.En;
import org.junit.Assert;

public class DemoSteps implements En {
    Demo demo = new Demo();

    public DemoSteps() {
        Given("User click one of list product", () -> demo.clickProduct());

        When("^User add \"([^\"]*)\" product$", (Integer numberOfProduct) -> demo.clickAddProduct(numberOfProduct));

        And("User click add to cart button", () -> demo.clickAddToCartButton());

        And("User click cart menu", () -> demo.clickCartMenu());

        And("User click checkout button", () -> demo.clickCheckoutButton());

        And("User click autofill account", () -> demo.clickAutoFillAccount());

        And("User click login button", () -> demo.clickLoginButton());

        And("^User input fullname \"([^\"]*)\"$", (String fullname) -> demo.inputFullname(fullname));

        And("^User input address line 1 \"([^\"]*)\"$", (String address) -> demo.inputAddress(address));

        And("^User input city \"([^\"]*)\"$", (String city) -> demo.inputCity(city));

        And("^User input state/region \"([^\"]*)\"$", (String region) -> demo.inputRegion(region));

        And("^User input zip code \"([^\"]*)\"$", (String zipCode) -> demo.inputZipCode(zipCode));

        And("^User input country \"([^\"]*)\"$", (String country) -> demo.inputCountry(country));

        And("User click to payment button", () -> demo.clickToPayment());

        And("^User input card fullname \"([^\"]*)\"$", (String cardFullname) -> demo.inputCardFullname(cardFullname));

        And("^User input card number \"([^\"]*)\"$", (String cardNumber) -> demo.inputCardNumber(cardNumber));

        And("^User input expiration date \"([^\"]*)\"$", (String expirationDate) -> demo.inputExpirationDate(expirationDate));

        And("^User input security code \"([^\"]*)\"$", (String securityCode) -> demo.inputSecurityCode(securityCode));

        And("User click review order", () -> demo.clickButtonReviewOrder());

        And("User click place order button", () -> demo.clickPlaceOrder());

        And("User success order product", () -> Assert.assertTrue(demo.isSuccessOrder()));

        And("^User see alert \"([^\"]*)\"$", (String alert) -> Assert.assertTrue(demo.isAlert(alert)));
    }
}
