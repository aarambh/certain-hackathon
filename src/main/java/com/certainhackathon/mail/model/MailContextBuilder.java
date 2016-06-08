package com.certainhackathon.mail.model;

import org.thymeleaf.context.Context;

public interface MailContextBuilder {
	String NAME = "name";
	String USER = "user";
	String USER_ID = "userId";
	String FORGOT_LINK = "forgotLink";
	String FORGOT_LINK_URL = "forgotLinkUrl";
	String ACTIVATE_LINK_URL = "activateLinkUrl";
	String FILE_NAME = "fileName";
	String ERROR_MESSAGE = "errorMessage";
	public Context build(MailInfo info);
}
