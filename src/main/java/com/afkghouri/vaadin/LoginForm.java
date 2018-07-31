package com.afkghouri.vaadin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button; 
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

 
public class LoginForm extends VerticalLayout{
    TextField userNameField;
    PasswordField passwordField;
    Button loginButton;
    
    public LoginForm() { 
    	System.out.println("LoginForm");
		userNameField = new TextField("",""); 
		passwordField = new PasswordField("", "");
		loginButton = new Button("");
		loginButton.addClassName("my");
		postConstruct(); 
	}
    private void postConstruct(){
    	
    	add(createContent(userNameField, passwordField, loginButton));
    }
    protected Component createContent(TextField userNameField,
            PasswordField passwordField, Button loginButton) {
        VerticalLayout layout = new VerticalLayout();
        layout.setSpacing(true);
        layout.setMargin(true);
        layout.add(userNameField);
        layout.add(passwordField);
        layout.add(loginButton);
        return layout;
    }
}
