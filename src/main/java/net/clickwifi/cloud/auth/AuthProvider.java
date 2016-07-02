package net.clickwifi.cloud.auth;

interface AuthProvider {
    boolean login();
    boolean logout();
}
