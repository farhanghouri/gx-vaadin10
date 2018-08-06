package com.afkghouri.vaadin;

import javax.annotation.PostConstruct;

import org.springframework.asm.Label;

import com.afkghouri.workshop.AbstractDashboardSetup;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public abstract class AbstractDashboardUI extends VerticalLayout{

	protected abstract AbstractDashboardSetup dashboardSetup();

	public AbstractDashboardUI() {
	}
	@PostConstruct
	protected void init() { 
		getStyle().set("background-color", "yellow"); 
		//add(dashboardSetup().loginComponent());
		add(new Text("MainUI"));
		add(dashboardSetup().defaultComponent());
	}
	
}
