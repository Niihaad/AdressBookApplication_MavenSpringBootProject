package org.example.addressbookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.component.page.AppShellConfigurator;

@SpringBootApplication
@Theme("my-theme")
public class AddressBookAppApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(AddressBookAppApplication.class, args);
    }
}
