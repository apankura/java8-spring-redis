package com.katarilab.java8aircraft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.session.Session;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpSession;

@Component
public class SpringSessionTemplateResolver implements SessionTemplate {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringSessionTemplateResolver.class);

	private final HttpSession session;

	public SpringSessionTemplateResolver(HttpSession session) {
		this.session = session;
		LOGGER.debug("Use template Spring implementation");
		LOGGER.info("======================= " +  session.getClass().getCanonicalName());
	}

	@Override
	public Object getAttribute(String name) {
		return this.session.getAttribute(name);
	}

	@Override
	public void setAttribute(String name, Object value) {
		this.session.setAttribute(name, value);
	}

	@Override
	public void removeAttribute(String name) {
		this.session.removeAttribute(name);
	}
}
