package repository.configuration;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.MySQLContainer;

public class MySQLContainerProperties implements BeforeAllCallback {
    private MySQLContainer<?> MySQL;
    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        MySQL = new MySQLContainer<>("mysql:latest")
                .withDatabaseName("students_test")
                .withUsername("test")
                .withPassword("pass")
                .withInitScript("migration/tables.sql");

        MySQL.start();

        System.setProperty("hibernate.driver", MySQL.getDriverClassName());
        System.setProperty("hibernate.url", MySQL.getJdbcUrl());
        System.setProperty("hibernate.username", MySQL.getUsername());
        System.setProperty("hibernate.password", MySQL.getPassword());
    }
}
