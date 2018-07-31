package com.afkghouri;

 
import com.afkghouri.vaadin.LoginComponent; 
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")

@HtmlImport("VAADIN/themes/graphenee/views/login.html")
public class VaadinUI extends VerticalLayout {

	public VaadinUI() { 
		add(new LoginComponent()); 
	     
	}
}
