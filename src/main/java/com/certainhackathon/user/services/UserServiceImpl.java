package com.certainhackathon.user.services;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.certainhackathon.common.repositories.AbstractRepository;
import com.certainhackathon.common.services.AbstractServiceImpl;
import com.certainhackathon.mail.model.MailContextBuilder;
import com.certainhackathon.mail.model.MailInfo;
import com.certainhackathon.mail.model.WelcomeContextMailBuilder;
import com.certainhackathon.mail.services.EmailService;
import com.certainhackathon.user.model.User;
import com.certainhackathon.user.repositories.UserRepository;

@Service
public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EmailService emailService;
	
	private static final String ACTIVATE_ACCOUNT_SUBJECT = "Activate your account";
	
	@Override
	public AbstractRepository<User> getRepository() {
		return userRepository;
	}
	
	@Override
	public User create(User dto) {
		validateUserRequest(dto);
		dto.setActivationLink(UUID.randomUUID().toString());
		MailInfo info = buildMailInfo(dto);
		try {
			emailService.sendSimpleMail(info , new WelcomeContextMailBuilder().build(info));
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return userRepository.save(dto);
	}

	@Override
	public User update(User dto) {
		return userRepository.save(dto);
	}
	


	@Override
	public void activateAccount(String activationLink) {
		User user = userRepository.findByActivationLink(activationLink);
		user.setEnabled(true);
		userRepository.save(user);
	}
	
	
	private void validateUserRequest(User dto) {
		
	}

	private MailInfo buildMailInfo(User user){
		HttpServletRequest curRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		MailInfo info = new MailInfo();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put(MailContextBuilder.ACTIVATE_LINK_URL, curRequest.getScheme() + "://" + curRequest.getServerName() + "/user/activate/"+user.getActivationLink());
		info.setData(data);
		info.setRecipient(user.getUsername());
		info.setSubject(ACTIVATE_ACCOUNT_SUBJECT);
		info.setRecipientName(user.getName());		
		info.setTemplate("welcome.html");
		return info;
	}
	
}
