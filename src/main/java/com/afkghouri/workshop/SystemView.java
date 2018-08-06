package com.afkghouri.workshop;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

import com.afkghouri.vaadin.AbstractDashboardMenu;
import com.afkghouri.view.DashboardMenu;
import com.afkghouri.view.MainComponent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;

@Route(value = "Home", layout = DashboardMenu.class)
public class SystemView  extends VerticalLayout{

	     

//		@Override
//		public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
//
//	        setText(String.format("Hello"));
//			
//		}
	public SystemView() {
		// TODO Auto-generated constructor stub
		add(new Text("SystemView"));
	}

		 
}
