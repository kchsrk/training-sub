package com.org.training.core.use;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.wcm.api.Page;
import com.org.training.core.models.NavItem;

public class Navigation extends WCMUsePojo {

	private static final Logger LOG = LoggerFactory.getLogger(Navigation.class);

	private String title;
	
	private List<NavItem> navList = new ArrayList<NavItem>();
	
	@Override
	public void activate() throws Exception {
		LOG.info("I am from Navigation Use Pojo");
		
		Page rootPage = getCurrentPage().getAbsoluteParent(2);
		title = rootPage.getTitle();
		
		LOG.info("Parent page path :: {}", getCurrentPage().getAbsoluteParent(2).getPath());
		LOG.info("Parent page title :: {}", rootPage.getTitle());
		
		Iterator<Page> childPageIter = rootPage.listChildren();
		
		NavItem navItem;
		
		while (childPageIter.hasNext()) {
			Page childPage = childPageIter.next();
			navItem = new NavItem();
			navItem.setNavPage(childPage);
			LOG.info("Child page path :: {}", childPage.getPath());
			navList.add(navItem);
			LOG.info("Child page path :: {}", navItem.getLink());
		}
	}

	public String getTitle() {
		return title;
	}

	public List<NavItem> getNavList() {
		return navList;
	}
	
}
