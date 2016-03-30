package net.clickwifi.cloud.auth;

public class BeilianAuth implements AuthProvider {

    public void login() {
        System.out.println("Beilian Login");
    }

    public void logout() {
        System.out.println("Beilian Logout");
    }
}
