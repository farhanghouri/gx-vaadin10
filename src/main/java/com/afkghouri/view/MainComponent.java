package com.afkghouri.view;

import com.afkghouri.vaadin.AbstractMainComponent;
import com.afkghouri.workshop.AbstractDashboardSetup;
import com.vaadin.flow.router.RoutePrefix;

/*
 * Dashboard MainView is a simple HorizontalLayout that wraps the menu on the
 * left and creates a simple container for the navigator on the right.
 */
@SuppressWarnings("serial") 
public class MainComponent extends AbstractMainComponent {

	private AbstractDashboardSetup dashboardSetup;

	public MainComponent(AbstractDashboardSetup dashboardSetup) {
		this.dashboardSetup = dashboardSetup;
	}

//	@Override
//	protected boolean isSpringComponent() {
//		return false;
//	}

	@Override
	protected AbstractDashboardSetup dashboardSetup() {
		return dashboardSetup;
	}

}
