package com.afkghouri.vaadin;

import com.afkghouri.workshop.AbstractDashboardSetup; 


public class LoginComponent extends VaadinAbstractLoginComponent {

	private AbstractDashboardSetup dashboardSetup;

	public LoginComponent(AbstractDashboardSetup dashboardSetup) {
		this.dashboardSetup = dashboardSetup;
	}

//	@Override
//	protected boolean isSpringComponent() {
//		return false;
//	}

	@Override
	protected AbstractDashboardSetup dashboardSetup() {
		System.out.println(dashboardSetup);
		return dashboardSetup;
	}

}