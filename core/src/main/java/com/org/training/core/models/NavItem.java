package com.org.training.core.models;

import java.util.ArrayList;
import java.util.Iterator;

import com.day.cq.wcm.api.Page;

public class NavItem {

	String title;

	String link;

	boolean hasChildPages = false;

	private Page navPage;

	private ArrayList<NavItem> childLinks = new ArrayList<NavItem>();

	public Page getNavPage() {
		return navPage;
	}

	public void setNavPage(Page navPage) {
		this.navPage = navPage;
	}

	public String getTitle() {
		return getNavTitle();
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return this.getNavPage().getPath();
	}

	public void setLink(String link) {
		this.link = link;
	}

	public boolean isHasChildPages() {
		Iterator<Page> pItr = this.getNavPage().listChildren();
		return pItr.hasNext();
	}

	public void setChildLinks(ArrayList<NavItem> childLinks) {
		this.childLinks = childLinks;
	}

	public ArrayList<NavItem> getChildLinks() {

		Iterator<Page> pItr = this.getNavPage().listChildren();
		NavItem childNav;

		while (pItr.hasNext()) {
			Page child = pItr.next();
			if (!child.isHideInNav()) {
				childNav = new NavItem();
				childNav.setNavPage(child);
				childLinks.add(childNav);
			}
		}

		return childLinks;
	}

	private String getNavTitle() {
		String title = this.getNavPage().getNavigationTitle();
		if (title == null)
			title = this.getNavPage().getPageTitle();
		if (title == null)
			title = this.getNavPage().getTitle();
		return title;
	}

}
