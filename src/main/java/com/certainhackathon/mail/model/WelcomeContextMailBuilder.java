package com.certainhackathon.mail.model;

import java.util.Map;

import org.springframework.context.i18n.LocaleContextHolder;
import org.thymeleaf.context.Context;

public class WelcomeContextMailBuilder implements MailContextBuilder {

	private Context context;
	
	public Context build(MailInfo info) {
		context = new Context(LocaleContextHolder.getLocale());
		@SuppressWarnings("unchecked")
		Map<String, Object> data = (Map<String, Object>)info.getData();
		
		context.setVariable(NAME, info.getRecipientName());
		context.setVariable(ACTIVATE_LINK_URL, data.get(ACTIVATE_LINK_URL));
		context.setVariable(USER, data.get(USER));
		return context;
	}
	
}
