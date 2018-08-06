package com.afkghouri.view;

import com.afkghouri.vaadin.AbstractDashboardMenu;
import com.afkghouri.workshop.AbstractDashboardSetup;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.RouterLayout;

/**
 * A responsive menu component providing user information and the controls for
 * primary navigation between the views.
 */
@SuppressWarnings({ "serial" }) 
public class DashboardMenu extends AbstractDashboardMenu implements RouterLayout{

	private AbstractDashboardSetup dashboardSetup;

	public DashboardMenu(AbstractDashboardSetup dashboardSetup) {
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