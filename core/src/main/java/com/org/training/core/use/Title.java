package com.org.training.core.use;

import com.adobe.cq.sightly.WCMUsePojo;

public class Title extends WCMUsePojo {

	private String title;

	private String desc;

	private String concatenatedStr;

	@Override
	public void activate() throws Exception {
		// business logic
		title = get("title", String.class);
		desc = get("desc", String.class);
		concatenatedStr = title + desc;

	}

	public String getTitle() {
		return title;
	}

	public String getDesc() {
		return desc;
	}

	public String getConcatenatedStr() {
		return concatenatedStr;
	}

}
