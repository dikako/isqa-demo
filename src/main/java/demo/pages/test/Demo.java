package demo.pages.test;

import demo.pages.base.BasePageObject;

public class Demo extends BasePageObject {
    public void clickProduct() {
        tap("LIST_PRODUCT");
    }

    public void clickAddProduct(int numberOfProduct) {
        for (int i = 0; i < numberOfProduct; i++) {
            tap("BUTTON_PLUS");
        }
    }

    public void clickAddToCartButton() {
        tap("BUTTON_ADD_TO_CART");
    }

    public void clickCartMenu() {
        tap("BUTTON_CART_MENU");
    }

    public void clickCheckoutButton() {
        tap("BUTTON_CHECKOUT");
    }

    public void clickAutoFillAccount() {
        tap("AUTOFILL_ACCOUNT");
    }

    public void clickLoginButton() {
        tap("BUTTON_LOGIN");
    }

    public void inputFullname(String fullname) {
        typeOn("FIELD_FULLNAME", fullname);
        hideKeyboard();
    }

    public void inputAddress(String address) {
        typeOn("FIELD_ADDRESS", address);
        hideKeyboard();
    }

    public void inputCity(String city) {
        typeOn("FIELD_CITY", city);
        hideKeyboard();
    }

    public void inputRegion(String region) {
        typeOn("FIELD_REGION", region);
        hideKeyboard();
    }

    public void inputZipCode(String zipCode) {
        typeOn("FIELD_ZIP_CODE", zipCode);
        hideKeyboard();
    }

    public void inputCountry(String country) {
        typeOn("FIELD_COUNTRY", country);
        hideKeyboard();
    }

    public void clickToPayment() {
        tap("BUTTON_TO_PAYMENT");
    }

    public void inputCardFullname(String cardFullname) {
        typeOn("FIELD_FULLNAME_CARD", cardFullname);
        hideKeyboard();
    }

    public void inputCardNumber(String cardNumber) {
        typeOn("FIELD_CARD_NUMBER", cardNumber);
        hideKeyboard();
    }

    public void inputExpirationDate(String expirationDate) {
        typeOn("FIELD_EXPIRATION_DATE", expirationDate);
        hideKeyboard();
    }

    public void inputSecurityCode(String securityCode) {
        typeOn("FIELD_SECURITY_CODE", securityCode);
        hideKeyboard();
    }

    public void clickButtonReviewOrder() {
        tap("BUTTON_REVIEW_ORDER");
    }

    public void clickPlaceOrder() {
        swipeUpScreen();
        tap("BUTTON_PLACE_ORDER");
    }

    public boolean isSuccessOrder() {
        return isPresent("TEXT_SUCCESS_ORDER") && isPresent("BUTTON_CONTINUE_ORDER");
    }

    public boolean isAlert(String alert) {
        return isPresent("ALERT", alert);
    }

}
