// package com.katarilab.java8aircraft;

// import org.springframework.stereotype.Component;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import javax.servlet.http.HttpSession;

// @Component
// public class DefaultSessionTemplateResolver implements SessionTemplate {

// 	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultSessionTemplateResolver.class);

// 	private HttpSession httpSession;

// 	public DefaultSessionTemplateResolver(HttpSession httpSession) {
// 		this.httpSession = httpSession;
// 		LOGGER.debug("Use template default implementation");
// 	}

// 	@Override
// 	public Object getAttribute(String name) {
// 		return this.httpSession.getAttribute(name);
// 	}

// 	@Override
// 	public void setAttribute(String name, Object value) {
// 		this.httpSession.setAttribute(name, value);
// 	}

// 	@Override
// 	public void removeAttribute(String name) {
// 		this.httpSession.removeAttribute(name);
// 	}

// }
