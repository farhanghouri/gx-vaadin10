package com.afkghouri.vaadin;

import javax.annotation.PostConstruct;

import com.afkghouri.view.DashboardMenu;
import com.afkghouri.workshop.AbstractDashboardSetup;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/*
 * Dashboard MainView is a simple HorizontalLayout that wraps the menu on the
 * left and creates a simple container for the navigator on the right.
 */
@SuppressWarnings("serial")
public abstract class AbstractMainComponent extends HorizontalLayout {

//	private ComponentContainer componentContainer;
	private DashboardMenu dashboardMenu;
	private boolean isBuilt;
	//private MVerticalLayout headerLayout;

	public AbstractMainComponent() {
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

	public AbstractMainComponent build() {
		if (!isBuilt) {
			setSizeFull();
			//addStyleName("mainview");
            System.out.println("AbstractMainComponent");
            getStyle().set("background-color", "green"); 
			add(dashboardMenu());
//			HorizontalLayout mainLayout = new HorizontalLayout();
//			mainLayout.setSizeFull();
//			if (leftComponent() != null) {
//				mainLayout.addComponent(leftComponent());
//			}
//			MVerticalLayout rightComponent = new MVerticalLayout().withMargin(false).withSpacing(false).withFullWidth().withFullHeight();
//			headerLayout = new MVerticalLayout().withFullWidth().withVisible(shouldShowHeaderLayout());
//
//			ComponentContainer content = new CssLayout();
//			content.addStyleName("view-content");
//			content.setSizeFull();
//
//			rightComponent.add(headerLayout);
//			rightComponent.add(content);
//			rightComponent.setExpandRatio(content, 1);
//			mainLayout.addComponent(rightComponent);
//			mainLayout.setExpandRatio(rightComponent, 1);
//			addComponent(mainLayout);
//			setExpandRatio(mainLayout, 1.0f);
//
//			componentContainer = content;
//			Navigator navigator = new DashboardNavigator(componentContainer);
//			dashboardSetup().registerViewProviders(navigator);
//			navigator.addViewChangeListener(new ViewChangeListener() {
//				@Override
//				public boolean beforeViewChange(final ViewChangeEvent event) {
//					return dashboardSetup().shouldAccessView(event.getViewName());
//				}
//
//				@Override
//				public void afterViewChange(final ViewChangeEvent event) {
//					DashboardEventBus dashboardEventBus = DashboardEventBus.sessionInstance();
//					dashboardEventBus.post(new PostViewChangeEvent(event.getViewName(), event.getParameters()));
//					// dashboardEventBus.post(new BrowserResizeEvent(-1, -1));
//					dashboardEventBus.post(new CloseOpenWindowsEvent());
//				}
//			});
//			UI.getCurrent().setNavigator(navigator);
//			postBuild();
//			isBuilt = true;
		}
		return this;
	}

	protected void postBuild() {
	}

	protected Component dashboardMenu() {
		return dashboardSetup().dashboardMenu();
	}

	protected abstract AbstractDashboardSetup dashboardSetup();

	protected void postInitialize() {
	}

//	public MVerticalLayout getHeaderLayout() {
//		return headerLayout;
//	}

	protected boolean shouldShowHeaderLayout() {
		return false;
	}

	protected Component leftComponent() {
		return null;
	}

}
