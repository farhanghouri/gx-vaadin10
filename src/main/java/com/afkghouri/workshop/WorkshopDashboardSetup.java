package com.afkghouri.workshop;

import org.springframework.stereotype.Service;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.spring.annotation.UIScope;

@Service
//@UIScope
public class WorkshopDashboardSetup extends AbstractDashboardSetup {
 

	public WorkshopDashboardSetup() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String applicationTitle() {
		return "Graphenee Workshop";
	}

	@Override
	public Image applicationLogo() {
		return null;
	}

	@Override
	public String dashboardViewName() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	protected List<TRMenuItem> menuItems() {
//		List<TRMenuItem> menus = new ArrayList<>();
//		menus.add(TRSimpleMenuItem.createMenuItemForView(MetroStyleDashboardView.VIEW_NAME, "Home", FontAwesome.HOME));
//		TRSimpleMenuItem dmMenuItem = TRSimpleMenuItem.createMenuItem("Data Maintenance", FontAwesome.WRENCH);
//		dmMenuItem.addChild(TRSimpleMenuItem.createMenuItemForView(SystemView.VIEW_NAME, "System", FontAwesome.SERVER));
//		dmMenuItem.addChild(TRSimpleMenuItem.createMenuItemForView(LocalizationView.VIEW_NAME, "Localization", FontAwesome.GLOBE));
//		dmMenuItem.addChild(TRSimpleMenuItem.createMenuItemForView(SecurityView.VIEW_NAME, "Security", FontAwesome.USER_SECRET));
//		menus.add(dmMenuItem); 
//		 
//		return menus;
//	}

//	@Override
//	protected List<TRMenuItem> profileMenuItems() {
//		return null;
//	}

//	@Override
//	public String dashboardViewName() {
//		return MetroStyleDashboardView.VIEW_NAME;
//	}

//	@Override
//	public void registerViewProviders(Navigator navigator) {
//		navigator.addProvider(viewProvider);
//	}

//	@Override
//	public DashboardUser authenticate(UserLoginRequestedEvent event) throws AuthenticationFailedException {
//		return new MockUser();
//	}

}
