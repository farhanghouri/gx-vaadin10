package com.afkghouri.vaadin;

import java.awt.MenuBar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.afkghouri.workshop.AbstractDashboardSetup;
import com.afkghouri.workshop.SystemView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RoutePrefix;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;

 

/**
 * A responsive menu component providing user information and the controls for
 * primary navigation between the views.
 */
@SuppressWarnings({ "serial", "unchecked" })

public abstract class AbstractDashboardMenu extends VerticalLayout {

	public static final String ID = "dashboard-menu";
	public static final String REPORTS_BADGE_ID = "dashboard-menu-reports-badge";
	public static final String NOTIFICATIONS_BADGE_ID = "dashboard-menu-notifications-badge";
	private static final String STYLE_VISIBLE = "valo-menu-visible";
	private Label notificationsBadge;
	private Label reportsBadge;
	//private MenuItem userMenuItem;
	private List<Component> menuItems;
	//private Map<TRMenuItem, ValoMenuItemButton> menuItemValoMenuItemButtonMap = new HashMap<>();
	private boolean isBuilt;

	public AbstractDashboardMenu() {
//		if (!isSpringComponent()) {
//			postConstruct();
//		}
	}

	public AbstractDashboardMenu(List<Component> menuItems) {
		this.menuItems = menuItems;
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

	public AbstractDashboardMenu build() {
		if (!isBuilt) {
//			setPrimaryStyleName("valo-menu");
//			setId(ID);
//			setSizeUndefined();
			// There's only one DashboardMenu per UI so this doesn't need to be
			// unregistered from the UI-scoped DashboardEventBus.
			//DashboardEventBus.sessionInstance().register(this);
			add(buildContent());
			postBuild();
			isBuilt = true;
		}
		return this;
	}

	protected void postBuild() {
	}

	private Component buildContent() {
		getStyle().set("background-color", "blue"); 
		final FlexLayout menuContent = new FlexLayout();
		menuContent.getStyle().set("background-color", "red"); 
		menuContent.getStyle().set("position", "absolute"); 
		menuContent.getStyle().set("top", "0"); 
		menuContent.getStyle().set("left", "0");  
//		menuContent.addStyleName("sidebar");
//		menuContent.addStyleName(ValoTheme.MENU_PART);
//		menuContent.addStyleName("no-vertical-drag-hints");
//		menuContent.addStyleName("no-horizontal-drag-hints");
		menuContent.setWidth(null);
		menuContent.setHeight("100%"); 
		
		
		
		RouterLink r = new RouterLink("System",SystemView.class);
		menuContent.add(buildTitle());
		menuContent.add(r); 
//		menuContent.add(buildUserMenu());
//		menuContent.add(buildToggleButton());
//		menuContent.add(buildMenuItems());

		return menuContent;
	}

	private Component buildTitle() {
		VerticalLayout layout = new VerticalLayout();
		Image logo = dashboardSetup().dashboardLogo();
		if (logo != null) {
			//layout.setStyleName("valo-menu-title-with-image");
			logo.setHeight("80px");
			layout.add(logo);
		}
		Label title = new Label(dashboardSetup().dashboardTitle());
		HorizontalLayout titleWrapper = new HorizontalLayout(title);
		//titleWrapper.setComponentAlignment(title, Alignment.CENTER);
		//titleWrapper.addStyleName("valo-menu-title");
		title.getStyle().set("background-color", "black");
		title.getStyle().set("color", "white");
		layout.add(titleWrapper);
		return layout;

	}

	protected abstract AbstractDashboardSetup dashboardSetup();

//	private DashboardUser getCurrentUser() {
//		return (DashboardUser) VaadinSession.getCurrent().getAttribute(DashboardUser.class.getName());
//	}

//	private Component buildUserMenu() {
//		final MenuBar userMenu = new MenuBar();
//		//userMenu.addStyleName("user-menu");
//		final DashboardUser user = getCurrentUser();
//		userMenuItem = userMenu.addItem("", user.getProfilePhoto(), null);
//		updateUserName(null);
//		boolean shouldAddSeparator = false;
//		if (dashboardSetup().profileComponent() != null) {
//			shouldAddSeparator = true;
//			userMenuItem.addItem("Edit Profile", new Command() {
//				@Override
//				public void menuSelected(final MenuItem selectedItem) {
//					AbstractComponent profileComponent = dashboardSetup().profileComponent();
//					if (profileComponent instanceof TRAbstractForm<?>) {
//						TRAbstractForm<?> form = (TRAbstractForm<?>) profileComponent;
//						form.openInModalPopup();
//					} else {
//						Window window = new Window("Profile", profileComponent);
//						window.setModal(true);
//						UI.getCurrent().addWindow(window);
//						window.focus();
//					}
//				}
//			});
//		}
//		if (dashboardSetup().preferencesComponent() != null) {
//			shouldAddSeparator = true;
//			userMenuItem.addItem("Preferences", new Command() {
//				@Override
//				public void menuSelected(final MenuItem selectedItem) {
//					AbstractComponent preferencesComponent = dashboardSetup().preferencesComponent();
//					if (preferencesComponent instanceof TRAbstractForm<?>) {
//						TRAbstractForm<?> form = (TRAbstractForm<?>) preferencesComponent;
//						form.openInModalPopup();
//					} else {
//						Window window = new Window("Preferences", preferencesComponent);
//						window.setModal(true);
//						UI.getCurrent().addWindow(window);
//						window.focus();
//					}
//				}
//			});
//		}
//		if (shouldAddSeparator) {
//			userMenuItem.addSeparator();
//		}
//		if (userMenuItems() != null && !userMenuItems().isEmpty()) {
//			for (TRMenuItem menuItem : userMenuItems()) {
//				userMenuItem.addItem(menuItem.caption(), menuItem.icon(), menuItem.command());
//			}
//		}
//		userMenuItem.addItem("Sign Out", new Command() {
//			@Override
//			public void menuSelected(final MenuItem selectedItem) {
//				DashboardEventBus.sessionInstance().post(new UserLoggedOutEvent());
//			}
//		});
//		return userMenu;
//	}

//	private Component buildToggleButton() {
//		Button valoMenuToggleButton = new Button("Menu", new ClickListener() {
//			@Override
//			public void buttonClick(final ClickEvent event) {
//				if (getCompositionRoot().getStyleName().contains(STYLE_VISIBLE)) {
//					getCompositionRoot().removeStyleName(STYLE_VISIBLE);
//				} else {
//					getCompositionRoot().addStyleName(STYLE_VISIBLE);
//				}
//			}
//		});
//		valoMenuToggleButton.setIcon(FontAwesome.LIST);
//		valoMenuToggleButton.addStyleName("valo-menu-toggle");
//		valoMenuToggleButton.addStyleName(ValoTheme.BUTTON_BORDERLESS);
//		valoMenuToggleButton.addStyleName(ValoTheme.BUTTON_SMALL);
//		return valoMenuToggleButton;
//	}

//	private Component buildMenuItems() {
//		CssLayout menuItemsLayout = new CssLayout();
//		menuItemsLayout.addStyleName("valo-menuitems");
//		Collection<TRMenuItem> items = menuItems();
//		generateValoMenuItemButtons(menuItemsLayout, items);
//		items.forEach(item -> {
//			ValoMenuItemButton valoMenuItemButton = menuItemValoMenuItemButtonMap.get(item);
//			valoMenuItemButton.addStyleName("show");
//		});
//		return menuItemsLayout;
//
//	}

//	private void generateValoMenuItemButtons(CssLayout menuItemsLayout, Collection<TRMenuItem> items) {
//		if (items != null && !items.isEmpty()) {
//			for (TRMenuItem menuItem : items) {
//				if (menuItem.hasChildren()) {
//					ValoMenuItemButton valoMenuItemButton = new ValoMenuItemButton(menuItem.caption(), menuItem.icon()).withListener(event -> {
//						ValoMenuItemButton backButton = new ValoMenuItemButton("Back", GrapheneeTheme.BACK_ICON).withListener(event2 -> {
//							menuItemsLayout.removeComponent(menuItemsLayout.getComponent(0));
//							menuItemValoMenuItemButtonMap.values().forEach(item -> {
//								item.removeStyleName("show");
//							});
//							if (menuItem.getParent() != null) {
//								menuItem.getParent().getChildren().forEach(item -> {
//									ValoMenuItemButton valoMenuItemButton2 = menuItemValoMenuItemButtonMap.get(item);
//									if (valoMenuItemButton2 != null)
//										valoMenuItemButton2.addStyleName("show");
//								});
//							} else {
//								menuItems().forEach(item -> {
//									ValoMenuItemButton valoMenuItemButton2 = menuItemValoMenuItemButtonMap.get(item);
//									if (valoMenuItemButton2 != null)
//										valoMenuItemButton2.addStyleName("show");
//								});
//							}
//						});
//						menuItemsLayout.addComponent(backButton, 0);
//						menuItemValoMenuItemButtonMap.values().forEach(item -> {
//							item.removeStyleName("show");
//						});
//						menuItem.getChildren().forEach(item -> {
//							ValoMenuItemButton valoMenuItemButton2 = menuItemValoMenuItemButtonMap.get(item);
//							if (valoMenuItemButton2 != null)
//								valoMenuItemButton2.addStyleName("show");
//						});
//					});
//					valoMenuItemButton.addStyleName("hide");
//					menuItemValoMenuItemButtonMap.put(menuItem, valoMenuItemButton);
//					menuItemsLayout.addComponent(valoMenuItemButton);
//					generateValoMenuItemButtons(menuItemsLayout, menuItem.getChildren());
//				} else {
//					ValoMenuItemButton valoMenuItemButton = new ValoMenuItemButton(menuItem.viewName(), menuItem.caption(), menuItem.icon()).withListener(event -> {
//						UI.getCurrent().getNavigator().navigateTo(menuItem.viewName());
//					});
//					menuItemsLayout.addComponent(valoMenuItemButton);
//					valoMenuItemButton.addStyleName("hide");
//					menuItemValoMenuItemButtonMap.put(menuItem, valoMenuItemButton);
//				}
//			}
//		}
//	}

//	protected List<TRMenuItem> menuItems() {
//		return dashboardSetup().menuItems();
//	}
//
//	protected List<TRMenuItem> userMenuItems() {
//		return dashboardSetup().profileMenuItems();
//	}
//
//	private Component buildBadgeWrapper(final Component menuItemButton, final Component badgeLabel) {
//		CssLayout dashboardWrapper = new CssLayout(menuItemButton);
//		dashboardWrapper.addStyleName("badgewrapper");
//		dashboardWrapper.addStyleName(ValoTheme.MENU_ITEM);
//		badgeLabel.addStyleName(ValoTheme.MENU_BADGE);
//		badgeLabel.setWidthUndefined();
//		badgeLabel.setVisible(false);
//		dashboardWrapper.addComponent(badgeLabel);
//		return dashboardWrapper;
//	}

	protected void postInitialize() {
	}
//
//	@Override
//	public void attach() {
//		super.attach();
//		updateNotificationsCount(null);
//	}
//
//	@Subscribe
//	public void postViewChange(final PostViewChangeEvent event) {
//		// After a successful view change the menu can be hidden in mobile view.
//		getCompositionRoot().removeStyleName(STYLE_VISIBLE);
//	}
//
//	@Subscribe
//	public void updateNotificationsCount(final NotificationsCountUpdatedEvent event) {
//		if (notificationsBadge != null) {
//			int unreadNotificationsCount = 0; // AbstractDashboardUI.getDataProvider().getUnreadNotificationsCount();
//			notificationsBadge.setValue(String.valueOf(unreadNotificationsCount));
//			notificationsBadge.setVisible(unreadNotificationsCount > 0);
//		}
//	}
//
//	@Subscribe
//	public void updateReportsCount(final ReportsCountUpdatedEvent event) {
//		reportsBadge.setValue(String.valueOf(event.getCount()));
//		reportsBadge.setVisible(event.getCount() > 0);
//	}
//
//	@Subscribe
//	public void updateUserName(final ProfileUpdatedEvent event) {
//		DashboardUser user = getCurrentUser();
//		String userFullName = user.getFirstNameLastName();
//		userMenuItem.setText(userFullName);
//		userMenuItem.setIcon(user.getProfilePhoto());
//	}

//	public static class ValoMenuItemButton extends Button {
//
//		private static final String STYLE_SELECTED = "selected";
//
//		private final String viewName;
//
//		public ValoMenuItemButton(String title, Resource icon) {
//			this(null, title, icon, null);
//		}
//
//		public ValoMenuItemButton(String title, Resource icon, ClickListener listener) {
//			this(null, title, icon);
//			if (listener != null) {
//				addClickListener(listener);
//			}
//		}
//
//		public ValoMenuItemButton(String viewName, String title, Resource icon) {
//			this(viewName, title, icon, null);
//		}
//
//		public ValoMenuItemButton(String viewName, String title, Resource icon, ClickListener listener) {
//			this.viewName = viewName;
//			setPrimaryStyleName("valo-menu-item");
//			setIcon(icon);
//			setCaption(title);
//			DashboardEventBus.sessionInstance().register(this);
//			withListener(listener);
//		}
//
//		public ValoMenuItemButton withListener(ClickListener listener) {
//			if (listener != null) {
//				addClickListener(listener);
//			}
//			return this;
//		}
//
//		@Subscribe
//		public void postViewChange(final PostViewChangeEvent event) {
//			removeStyleName(STYLE_SELECTED);
//			if (viewName != null) {
//				if (viewName.equals(event.getViewName() + "/" + event.getParameters()))
//					addStyleName(STYLE_SELECTED);
//				else if (viewName.equals(event.getViewName()) && event.getParameters().equalsIgnoreCase(""))
//					addStyleName(STYLE_SELECTED);
//			}
//		}
//	}

}
