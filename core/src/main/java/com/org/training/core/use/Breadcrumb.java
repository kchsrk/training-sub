package com.org.training.core.use;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.wcm.api.Page;

public class Breadcrumb extends WCMUsePojo {

	private static final Logger LOG = LoggerFactory.getLogger(Breadcrumb.class);

	private List<Page> breadcrumbList = new ArrayList<Page>();

	private boolean parentFlag = true;

	@Override
	public void activate() throws Exception {
		LOG.info("I am from Breadcrumb class");
		Page currentPage = getCurrentPage();
		Page rootPage = currentPage.getAbsoluteParent(2);

		breadcrumbList.add(currentPage);
		
		LOG.info("Root Page Path :: {}", rootPage.getPath());
		// parent, parent, parent .. en (2)
		while (parentFlag) {
			LOG.info("I am from loop");
			Page page = currentPage.getParent();
			if (page.getPath().equals(rootPage.getPath())) {
				LOG.info("I am from if");
				parentFlag = false;
			} else {
				breadcrumbList.add(page);
				LOG.info("Page path :: {}", page.getPath());
			}
		}

	}

	public List<Page> getBreadcrumbList() {
		return breadcrumbList;
	}

}
