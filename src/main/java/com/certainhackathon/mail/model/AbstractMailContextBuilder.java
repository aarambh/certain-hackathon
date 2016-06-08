package com.certainhackathon.mail.model;

import java.util.Map;

import org.springframework.context.i18n.LocaleContextHolder;
import org.thymeleaf.context.Context;

public abstract class AbstractMailContextBuilder implements MailContextBuilder {
	
	protected Context context;

	public Context buildError(MailInfo info, String errorMessage) {
		context = new Context(LocaleContextHolder.getLocale());
		@SuppressWarnings("unchecked")
		Map<String, Object> data = (Map<String, Object>)info.getData();
		
		context.setVariable(NAME, info.getRecipientName());
	    context.setVariable(ERROR_MESSAGE, errorMessage);
		context.setVariable(MailContextBuilder.USER, data.get(MailContextBuilder.USER));
		context.setVariable(MailContextBuilder.USER_ID, data.get(MailContextBuilder.USER_ID));
		
		return context;
	}

}
