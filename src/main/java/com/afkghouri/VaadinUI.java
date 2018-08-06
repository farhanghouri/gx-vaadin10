package com.afkghouri;

 
import org.springframework.beans.factory.annotation.Autowired;

import com.afkghouri.vaadin.AbstractDashboardUI; 
import com.afkghouri.workshop.AbstractDashboardSetup;
import com.afkghouri.workshop.WorkshopDashboardSetup;
import com.vaadin.flow.component.dependency.HtmlImport; 
import com.vaadin.flow.router.Route; 
 

@Route("")

@HtmlImport("VAADIN/themes/graphenee/views/login.html")
public class VaadinUI extends AbstractDashboardUI {
 

	@Autowired
	WorkshopDashboardSetup dashboardSetup;

	@Override
	protected AbstractDashboardSetup dashboardSetup() { 
		return dashboardSetup;
	}
}
