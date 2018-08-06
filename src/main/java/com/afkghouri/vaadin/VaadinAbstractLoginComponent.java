package com.afkghouri.vaadin;

import javax.annotation.PostConstruct;

import com.afkghouri.workshop.AbstractDashboardSetup;
import com.vaadin.flow.component.Component; 
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox; 
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField; 
 

public abstract class VaadinAbstractLoginComponent extends LoginForm{

	private boolean isBuilt;

	public VaadinAbstractLoginComponent() {
		System.out.println("VaadinAbstractLoginComponent");
//		if (!isSpringComponent()) {
//			postConstruct();
//		}
	}

//	protected boolean isSpringComponent() {
//		return this.getClass().getAnnotation(SpringComponent.class) != null;
//	}

	@PostConstruct
	private void postConstruct() {
		postInitialize();
	}

	public Component build(TextField userNameField, PasswordField passwordField, Button loginButton) {
		VerticalLayout mainLayout = null;
		if (mainLayout == null) {
			mainLayout = new VerticalLayout();
			loginButton.addClickListener(listener->{
				dashboardSetup();
			});
			//mainLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
//			addLoginListener(listener -> {
//				UserLoginRequestedEvent userLoginRequestedEvent = new UserLoginRequestedEvent(listener.getLoginParameter("username"), listener.getLoginParameter("password"));
//				DashboardEventBus.sessionInstance().post(userLoginRequestedEvent);
//
//			});
		//	setSizeFull();
			Component loginForm = buildLoginForm(userNameField, passwordField, loginButton);
			mainLayout.setSizeFull();
			mainLayout.add(loginForm);
			postBuild();
		}
		return mainLayout;
	}

	protected void postBuild() {
	}

	private Component buildLoginForm(TextField userNameField, PasswordField passwordField, Button loginButton) {
		final VerticalLayout loginPanel = new VerticalLayout();
		loginPanel.setSizeUndefined();
		loginPanel.setSpacing(true);
		loginPanel.setMargin(false);
		//Responsive.makeResponsive(loginPanel);
		loginPanel.addClassName("login-panel");
		loginPanel.add(buildLabels());
		loginPanel.add(buildFields(userNameField, passwordField, loginButton));
		if (isRememberMeEnabled()) {
			loginPanel.add(new Checkbox("Remember me", true));
		}
		return loginPanel;
	}

	protected boolean isRememberMeEnabled() {
		return false;
	}

	private Component buildLabels() {
		FlexLayout labels = new FlexLayout();
		labels.addClassName("labels");

//		if (dashboardSetup().loginFormLogo() != null) {
//			Image logoImage = dashboardSetup().loginFormLogo();
//			logoImage.addStyleName("logo-image");
//			logoImage.setHeight(logoImageHeight());
//			labels.addComponent(logoImage);
//		} else {
			 Label welcome = new Label("Welcome");
			  welcome.setSizeUndefined();
			//welcome.addStyleName(ValoTheme.LABEL_H4);
			//welcome.addStyleName(ValoTheme.LABEL_COLORED);
			labels.add(welcome);
		//}
        //dashboardSetup().loginFormTitle() 
		Label title = new Label("Graphenee Workshop");
		title.setSizeUndefined();
		//title.addStyleName(ValoTheme.LABEL_H3);
		labels.add(title);
		return labels;
	}

	protected String logoImageHeight() {
		return "50px";
	}

	private Component buildFields(TextField userNameField, PasswordField passwordField, Button loginButton) {
		HorizontalLayout fields = new HorizontalLayout();
		fields.setSpacing(true);
		fields.addClassName("fields");

		//userNameField.setIcon(FontAwesome.USER);
		//userNameField.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);

		//passwordField.setIcon(FontAwesome.LOCK);
		//passwordField.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);

//		loginButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
//		loginButton.setClickShortcut(KeyCode.ENTER);
		

		fields.add(userNameField, passwordField, loginButton);
		//fields.setComponentAlignment(loginButton, Alignment.BOTTOM_LEFT);

		// signin.addClickListener(new ClickListener() {
		// @Override
		// public void buttonClick(final ClickEvent event) {
		// DashboardEventBus.sessionInstance().post(new
		// UserLoginRequestedEvent(username.getValue(), password.getValue()));
		// }
		// });
		return fields;
	}

	 
	
	@Override
	protected Component createContent(TextField userNameField, PasswordField passwordField, Button loginButton) {
		userNameField.setLabel("Username");
		passwordField.setLabel("Password");
		loginButton.setText("login");
		return build(userNameField, passwordField, loginButton);
	}


	protected Component createCustomLayout() {
		return null;
	}

//	@Override
//	public void setContent(Component content) {
//		Component c = createCustomLayout();
//		if (c == null) {
//			super.setContent(content);
//		} else {
//			super.setContent(c);
//		}
//	}

	protected abstract AbstractDashboardSetup dashboardSetup();

	protected void postInitialize() {
	}
	
}
