package com.afkghouri.workshop;

import java.io.Serializable;

import com.afkghouri.vaadin.AbstractDashboardMenu;
import com.afkghouri.vaadin.AbstractMainComponent;
import com.afkghouri.vaadin.LoginComponent;
import com.afkghouri.view.DashboardMenu;
import com.afkghouri.view.MainComponent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image; 

public abstract class AbstractDashboardSetup implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract String applicationTitle();

	public String dashboardTitle() {
		return applicationTitle();
	}

	public String loginFormTitle() {
		return applicationTitle();
	}

	public abstract Image applicationLogo();

	public Image dashboardLogo() {
		return applicationLogo();
	}

	public Image loginFormLogo() {
		return applicationLogo();
	}

	//protected abstract List<TRMenuItem> menuItems();

	//protected abstract List<TRMenuItem> profileMenuItems();

	public abstract String dashboardViewName();

	public Component loginComponent() {
		return new LoginComponent(this);
	}

	public Component defaultComponent() {
		return new MainComponent(this).build();
	}
//
	public AbstractDashboardMenu dashboardMenu() {
		return new DashboardMenu(this).build();
	}
//
//	public AbstractComponent profileComponent() {
//		return null;
//	}
//
//	public AbstractComponent preferencesComponent() {
//		return null;
//	}
//
//	public AbstractComponent leftComponent() {
//		return null;
//	}
//
//	public abstract void registerViewProviders(Navigator navigator);
//
//	public abstract DashboardUser authenticate(UserLoginRequestedEvent event) throws AuthenticationFailedException;
//
//	public List<GxSupportedLocaleBean> supportedLocales() {
//		return null;
//	}
//
//	public LocalizerService localizer() {
//		return null;
//	}

	protected boolean shouldLocalize() {
		return false;
	}

	public boolean shouldAccessView(String viewName) {
		return true;
	}

	public boolean shouldShowPoweredByGraphenee() {
		return true;
	}

}
