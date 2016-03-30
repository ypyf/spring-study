package net.clickwifi.cloud.auth;

public class CloudAuth {
    private AuthProvider ap;

    public CloudAuth(AuthProvider ap) {
        this.ap = ap;
    }

    public void login() {
        ap.login();
    }

    public void logout() {
        ap.logout();
    }
}
